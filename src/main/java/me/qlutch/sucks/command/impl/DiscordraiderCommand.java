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

public class DiscordraiderCommand extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        int maxPages = 1;
        if (args.length <= 1) {
            p2.sendMessage(Settings.USAGE("discordraider <1-" + maxPages + ">"));
        } else if (args[1].equalsIgnoreCase("1")) {
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&8&m----------------------------------"));
            p2.sendMessage("         " + Settings.DARK_RED + Settings.NAME + " by " + Settings.AUTHOR);
            p2.sendMessage("");
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7settoken &8l &fSet bots token and logins to bot"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7setguild &8l &fSet guild ID"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7delchannels &8l &fDeletes all channels in the guild"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7createvc &8l &fCreates a voice channel"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7createtc &8l &fCreates a text channel"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7spamdiscord &8l &fSpams all channels"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7dmall &8l &fPrivate messages all users"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7kickusers &8l &fKicks all users from the guild"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7banusers &8l &fBans all users from the guild"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7setstatus &8l &fSets the bots playing status"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7showtoken &8l &fShows the token of the discord bot"));
            p2.sendMessage("");
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)("&8(" + Settings.DARK_RED + "Tip&8) l &7" + Tips.getTip())));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&8&m----------------------------------"));
        }
    }
}

