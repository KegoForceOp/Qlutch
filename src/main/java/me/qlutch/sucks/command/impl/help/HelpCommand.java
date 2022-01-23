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

public class HelpCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        int maxPages = 6;
        if (args.length <= 1) {
            p2.sendMessage(Settings.USAGE("help <1-" + maxPages + ">"));
        } else if (args[1].equalsIgnoreCase("1")) {
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&8&m----------------------------------"));
            p2.sendMessage("         " + Settings.DARK_RED + Settings.NAME + " by " + Settings.AUTHOR);
            p2.sendMessage("");
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7logout &8l &fLogs out so you can speak again!"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7blatant &8l &fTurns blatant mode on or off"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)("&7status &8l &fGives you server and " + Settings.NAME + " info")));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7sc &8l &fTalk to all players logged in on the server"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7chat &8l &fSend a chat without having to log out"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7op &8l &fOp yourself or another player!"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7deop &8l &fDeops you or another player!"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7plugins &8l &fLists the server plugins"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7nameme &8l &fRe-names you"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7nameall &8l &fRe-names all players"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7msg &8l &fMessages another player"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7reply &8l &fReplys to the person who messaged you last"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7premiumhelp &8l &fViews help page for premium users"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7fn &8l &fLists file manager commands"));
            p2.sendMessage("");
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)("&8(" + Settings.DARK_RED + "Tip&8) l &7" + Tips.getTip())));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&8&m----------------------------------"));
        } else if (args[1].equalsIgnoreCase("2")) {
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&8&m----------------------------------"));
            p2.sendMessage("         " + Settings.DARK_RED + Settings.NAME + " by " + Settings.AUTHOR);
            p2.sendMessage("");
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7invSteal &8l &fCopies someones inventory and gives it to you"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7noDmg &8l &fMake a player not able to damage others"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7freeze &8l &fFreezes another player"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7unfreeze &8l &fUnfreezes another player"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7enable &8l &fEnables another plugin"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7disable &8l &fDisables another plugin"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7tp &8l &fTeleports you to another player"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7tpall &8l &fTeleports all players to you or another player"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7lockconsole &8l &fEnables/Disables console to exe cmds"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7cmdspy &8l &fToggles command spy!"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7invsee &8l &fOpens another players inventory"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7kill &8l &fKills you or another player"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)("&7checkError &8l &fChecks the last error logged with " + Settings.NAME)));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7spin &8l &fSpin the entire world"));
            p2.sendMessage("");
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)("&8(" + Settings.DARK_RED + "Tip&8) l &7" + Tips.getTip())));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&8&m----------------------------------"));
        } else if (args[1].equalsIgnoreCase("3")) {
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&8&m----------------------------------"));
            p2.sendMessage("         " + Settings.DARK_RED + Settings.NAME + " by " + Settings.AUTHOR);
            p2.sendMessage("");
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7listloggedin &8l &fLists logged in players!"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7flip &8l &fMakes a player flip 180"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7modcmds &8l &fDisables/Enables mod commands like /ban /kick"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7sudo &8l &fforces a player chat or execute a command"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7bc &8l &fBroadcasts a message to the entire server"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7spam &8l &fSpams the server with your message"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7god &8l &fEnables god mode for you or another player"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7save &8l &fSaves the world and player data"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7togglechat &8l &fEnables/Disables all players talking in chat"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7clearchat &8l &fClears chat"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7bombs &8l &fGives you a bomb to throw!"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7npu &8l &fStops players from picking up items"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7reload &8l &fReloads the server"));
            p2.sendMessage("");
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)("&8(" + Settings.DARK_RED + "Tip&8) l &7" + Tips.getTip())));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&8&m----------------------------------"));
        } else if (args[1].equalsIgnoreCase("4")) {
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&8&m----------------------------------"));
            p2.sendMessage("         " + Settings.DARK_RED + Settings.NAME + " by " + Settings.AUTHOR);
            p2.sendMessage("");
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7console &8l &fExecutes a command as console"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7ride &8l &fRide another player"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7rideme &8l &Force someone to ride you"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7stop &8l &fStops the server"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7nextmsg &8l &fSet the users next message they type"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7flood &8l &fFloods chat"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7lockcmds &8l &fLocks all / commands for people not logged in"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7lockcontainers &8l &fLocks all chests and all containers"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7coords &8l &fTells you another players or your coords"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7item &8l &fGives you any item you want"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)("&7tip &8l &fGet a random " + Settings.NAME + " tip")));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7fly &8l &fToggles flight for you or another player"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7feed &8l &fFeeds you or another player to max"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7heal &8l &fHeals you or another player to max"));
            p2.sendMessage("");
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)("&8(" + Settings.DARK_RED + "Tip&8) l &7" + Tips.getTip())));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&8&m----------------------------------"));
        } else if (args[1].equalsIgnoreCase("5")) {
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&8&m----------------------------------"));
            p2.sendMessage("         " + Settings.DARK_RED + Settings.NAME + " by " + Settings.AUTHOR);
            p2.sendMessage("");
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7lookup &8l &fLooks up another players IP Address"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7gamemode &8l &fChange your gamemode"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7wand &8l &fUse the griefing wands"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7piss &8l &fMakes player piss a block"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7whitelist &8l &fTurn whitelist on or off silently"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7leakips &8l &fLeaks everyones ip into the chat who isnt logged in"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7ban &8l &fBans a player using a custom system"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7unban &8l &fUnbans a player"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7eChest &8l &fOpens a players ender chest"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7kick &8l &fKick a player"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7vanish &8l &fVanish yourself so no one can see you"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7dupe &8l &fOpens the dupe machine!"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7spamWebhook &8l &fSpams a webhook with a message"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7penis &8l &fMakes it rain penises"));
            p2.sendMessage("");
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)("&8(" + Settings.DARK_RED + "Tip&8) l &7" + Tips.getTip())));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&8&m----------------------------------"));
        } else if (args[1].equalsIgnoreCase("6")) {
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&8&m----------------------------------"));
            p2.sendMessage("         " + Settings.DARK_RED + Settings.NAME + " by " + Settings.AUTHOR);
            p2.sendMessage("");
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7sethealth &8l &fSets the max health"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7setmotd &8l &fSets the server MOTD"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7floodconsole &8l &fFloods console"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7logconsole &8l &fLog console output to a discord webhook"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7xp &8l &fGive yourself XP"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"§7forum §8l §fGet a users forum profile"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7launch &8l &fLaunch a player into the air"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"§7fire §8l §fSet a player on fire"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7void &8l &fSend a player to the void"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7dirt &8l &fMake player only able to place dirt"));
            p2.sendMessage("");
            p2.sendMessage("");
            p2.sendMessage("");
            p2.sendMessage("");
            p2.sendMessage("");
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)("&8(" + Settings.DARK_RED + "Tip&8) l &7" + Tips.getTip())));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&8&m----------------------------------"));
        } else if (args[1].equalsIgnoreCase("7")) {
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&8&m----------------------------------"));
            p2.sendMessage("         " + Settings.DARK_RED + Settings.NAME + " by " + Settings.AUTHOR);
            p2.sendMessage("");
            p2.sendMessage("");
            p2.sendMessage("");
            p2.sendMessage("");
            p2.sendMessage("");
            p2.sendMessage("");
            p2.sendMessage("");
            p2.sendMessage("");
            p2.sendMessage("");
            p2.sendMessage("");
            p2.sendMessage("");
            p2.sendMessage("");
            p2.sendMessage("");
            p2.sendMessage("");
            p2.sendMessage("");
            p2.sendMessage("");
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)("&8(" + Settings.DARK_RED + "Tip&8) l &7" + Tips.getTip())));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&8&m----------------------------------"));
        } else {
            p2.sendMessage(Settings.PREFIX("That page does not exist. Use pages 1-" + maxPages));
        }
    }

    @Override
    public boolean isBlatant() {
        return false;
    }
}

