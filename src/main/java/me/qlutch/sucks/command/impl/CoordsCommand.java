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

public class CoordsCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (args.length <= 1) {
            p2.sendMessage(Settings.PREFIX("Your coords are: " + Settings.RED + p2.getLocation().getX() + ", " + p2.getLocation().getY() + ", " + p2.getLocation().getZ()));
        } else {
            Player target = Bukkit.getServer().getPlayer(args[1]);
            if (target == null) {
                p2.sendMessage(Settings.PREFIX("The player " + Settings.RED + args[1] + Settings.WHITE + " is not online."));
            } else {
                p2.sendMessage(Settings.PREFIX(target.getName() + "'s coords are: " + Settings.RED + target.getLocation().getX() + ", " + target.getLocation().getY() + ", " + target.getLocation().getZ()));
            }
        }
    }

    @Override
    public boolean isBlatant() {
        return false;
    }
}

