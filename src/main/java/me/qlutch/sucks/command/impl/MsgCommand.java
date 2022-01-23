/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.ChatColor
 *  org.bukkit.entity.Player
 */
package me.qlutch.sucks.command.impl;

import me.qlutch.sucks.Core;
import me.qlutch.sucks.command.Command;
import me.qlutch.sucks.utils.Settings;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class MsgCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (args.length < 3) {
            p2.sendMessage(Settings.USAGE("msg <player> <message>"));
        } else {
            Player target = Bukkit.getPlayerExact((String)args[1]);
            if (target == null) {
                p2.sendMessage(Settings.PREFIX("The player " + Settings.RED + args[1] + Settings.WHITE + " is not online"));
            } else {
                StringBuilder message = new StringBuilder();
                for (int i2 = 2; i2 != args.length; ++i2) {
                    message.append(args[i2]).append(" ");
                }
                plugin.lastMsg.put(target, p2);
                p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)("&8[" + Settings.WHITE + "You to " + Settings.DARK_RED + Bukkit.getPlayer((String)args[1]).getName() + "&8] &7" + message)));
                target.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)("&8[" + Settings.DARK_RED + p2.getName() + Settings.WHITE + " to you&8] &7" + message)));
            }
        }
    }

    @Override
    public boolean isBlatant() {
        return false;
    }
}

