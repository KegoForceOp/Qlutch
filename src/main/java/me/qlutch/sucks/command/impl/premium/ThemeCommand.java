/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.ChatColor
 *  org.bukkit.entity.Player
 */
package me.qlutch.sucks.command.impl.premium;

import me.qlutch.sucks.Core;
import me.qlutch.sucks.command.Command;
import me.qlutch.sucks.utils.Settings;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ThemeCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (plugin.premium.contains(p2.getName())) {
            if (args.length <= 1) {
                p2.sendMessage(Settings.USAGE("theme <blue | green | red | gold | purple>"));
            } else {
                String colour = args[1];
                if (colour.equalsIgnoreCase("red")) {
                    Settings.RED = ChatColor.translateAlternateColorCodes((char)'&', (String)"&c");
                    Settings.DARK_RED = ChatColor.translateAlternateColorCodes((char)'&', (String)"&4");
                    p2.sendMessage(Settings.PREFIX("Colour theme has been set to " + Settings.RED + "RED"));
                } else if (colour.equalsIgnoreCase("blue")) {
                    Settings.DARK_RED = ChatColor.translateAlternateColorCodes((char)'&', (String)"&9");
                    Settings.RED = ChatColor.translateAlternateColorCodes((char)'&', (String)"&b");
                    p2.sendMessage(Settings.PREFIX("Colour theme has been set to " + Settings.RED + "BLUE"));
                } else if (colour.equalsIgnoreCase("green")) {
                    Settings.DARK_RED = ChatColor.translateAlternateColorCodes((char)'&', (String)"&2");
                    Settings.RED = ChatColor.translateAlternateColorCodes((char)'&', (String)"&a");
                    p2.sendMessage(Settings.PREFIX("Colour theme has been set to " + Settings.RED + "GREEN"));
                } else if (colour.equalsIgnoreCase("gold")) {
                    Settings.DARK_RED = ChatColor.translateAlternateColorCodes((char)'&', (String)"&6");
                    Settings.RED = ChatColor.translateAlternateColorCodes((char)'&', (String)"&e");
                    p2.sendMessage(Settings.PREFIX("Colour theme has been set to " + Settings.RED + "GOLD"));
                } else if (colour.equalsIgnoreCase("purple")) {
                    Settings.DARK_RED = ChatColor.translateAlternateColorCodes((char)'&', (String)"&5");
                    Settings.RED = ChatColor.translateAlternateColorCodes((char)'&', (String)"&d");
                    p2.sendMessage(Settings.PREFIX("Colour theme has been set to " + Settings.RED + "PURPLE"));
                } else if (colour.equalsIgnoreCase("white")) {
                    Settings.DARK_RED = ChatColor.translateAlternateColorCodes((char)'&', (String)"&f");
                    Settings.RED = ChatColor.translateAlternateColorCodes((char)'&', (String)"&7");
                    p2.sendMessage(Settings.PREFIX("Colour theme has been set to " + Settings.RED + "WHITE"));
                } else {
                    p2.sendMessage(Settings.USAGE("theme <blue | green | red | gold | purple>"));
                }
            }
        } else {
            p2.sendMessage(Settings.PREFIX("You must be a " + Settings.RED + "premium user " + Settings.WHITE + " to execute this command"));
        }
    }

    @Override
    public boolean isBlatant() {
        return false;
    }
}

