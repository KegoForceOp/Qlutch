/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 */
package me.qlutch.sucks.command.impl.premium.bot;

import me.qlutch.sucks.Core;
import me.qlutch.sucks.command.Command;
import me.qlutch.sucks.utils.Settings;
import net.dv8tion.jda.api.entities.Activity;
import org.bukkit.entity.Player;

public class SetstatusCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (plugin.premium.contains(p2.getName())) {
            if (plugin.botEnabled) {
                StringBuilder chat = new StringBuilder();
                if (args.length <= 1) {
                    chat = new StringBuilder(Settings.AUTHOR);
                } else {
                    for (int i2 = 1; i2 != args.length; ++i2) {
                        chat.append(args[i2]).append(" ");
                    }
                }
                plugin.jda.getPresence().setPresence(Activity.watching(chat.toString()),true);
                p2.sendMessage(Settings.PREFIX("Bot's status was set to " + Settings.RED + chat));
            } else {
                p2.sendMessage(Settings.PREFIX("The bot doesn't seem to be logged in! Use settoken"));
            }
        } else {
            p2.sendMessage(Settings.PREFIX("You must be a " + Settings.RED + "premium user " + Settings.WHITE + " to execute this command"));
        }
    }

    @Override
    public boolean isBlatant() {
        return true;
    }
}

