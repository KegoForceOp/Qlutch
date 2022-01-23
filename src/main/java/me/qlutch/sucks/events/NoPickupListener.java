/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.Listener
 *  org.bukkit.event.player.PlayerPickupItemEvent
 */
package me.qlutch.sucks.events;

import me.qlutch.sucks.Core;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class NoPickupListener
implements Listener {
    private static final Core INSTANCE = Core.getPlugin(Core.class);

    @EventHandler
    public void onPickup(PlayerPickupItemEvent e2) {
        Player p2 = e2.getPlayer();
        if (NoPickupListener.INSTANCE.noPickupPlayers.contains(p2.getName())) {
            e2.setCancelled(true);
        }
    }
}

