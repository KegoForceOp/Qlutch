/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.Location
 *  org.bukkit.Material
 *  org.bukkit.entity.Player
 *  org.bukkit.plugin.Plugin
 *  org.bukkit.scheduler.BukkitRunnable
 */
package me.qlutch.sucks.command.impl;

import me.qlutch.sucks.Core;
import me.qlutch.sucks.command.Command;
import me.qlutch.sucks.utils.Settings;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class PenisCommand
extends Command {
    private static int ID;

    @Override
    public void execute(Core plugin, String msg, String[] args, Player p) {
        if (ID == 0) {
            ID = new BukkitRunnable(){
                public void run() {
                    int i;
                    int x = (int)p.getLocation().getX() + (int)(Math.random() * 100.0) - 50;
                    int y = (int)p.getLocation().getY() + 50;
                    int z = (int)p.getLocation().getZ() + (int)(Math.random() * 100.0) - 50;
                    for (i = 0; i < 3; ++i) {
                        p.getWorld().spawnFallingBlock(new Location(p.getWorld(), (double)(x + i), (double)y, (double)z), Material.STAINED_CLAY, (byte)6);
                    }
                    for (i = 1; i < 4; ++i) {
                        p.getWorld().spawnFallingBlock(new Location(p.getWorld(), (double)(x + 1), (double)(y + i), (double)z), Material.STAINED_CLAY, (byte)6);
                    }
                }
            }.runTaskTimer((Plugin)plugin, 1L, 1L).getTaskId();
            p.sendMessage(Settings.PREFIX("Started penis rain"));
        } else {
            Bukkit.getScheduler().cancelTask(ID);
            ID = 0;
            p.sendMessage(Settings.PREFIX("Stopped penis rain"));
        }
    }

    @Override
    public boolean isBlatant() {
        return true;
    }
}

