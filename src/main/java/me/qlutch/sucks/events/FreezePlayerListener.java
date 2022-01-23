/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.Listener
 *  org.bukkit.event.block.BlockBreakEvent
 *  org.bukkit.event.block.BlockPlaceEvent
 *  org.bukkit.event.player.PlayerJoinEvent
 *  org.bukkit.event.player.PlayerMoveEvent
 *  org.bukkit.event.player.PlayerTeleportEvent
 *  org.bukkit.event.player.PlayerTeleportEvent$TeleportCause
 */
package me.qlutch.sucks.events;

import me.qlutch.sucks.Core;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class FreezePlayerListener
implements Listener {
    private static final Core INSTANCE = Core.getPlugin(Core.class);

    @EventHandler
    public void onMove(PlayerMoveEvent q2) {
        Player p2 = q2.getPlayer();
        if (FreezePlayerListener.INSTANCE.frozenPlayers.contains(p2.getName())) {
            q2.setTo(q2.getFrom());
        }
    }

    @EventHandler
    public void onMove(PlayerTeleportEvent e2) {
        Player p2 = e2.getPlayer();
        if (FreezePlayerListener.INSTANCE.frozenPlayers.contains(p2.getName()) && e2.getCause() == PlayerTeleportEvent.TeleportCause.ENDER_PEARL) {
            e2.setCancelled(true);
        }
    }

    @EventHandler
    public void onMove(PlayerJoinEvent q2) {
        Player p2 = q2.getPlayer();
        if (FreezePlayerListener.INSTANCE.frozen) {
            if (!FreezePlayerListener.INSTANCE.frozenPlayers.contains(p2.getName()) && !FreezePlayerListener.INSTANCE.lite.contains(p2.getName())) {
                FreezePlayerListener.INSTANCE.frozenPlayers.add(p2.getName());
            }
        } else if (FreezePlayerListener.INSTANCE.frozenPlayers.contains(p2.getName())) {
            FreezePlayerListener.INSTANCE.frozenPlayers.remove(p2.getName());
        }
    }

    @EventHandler
    public void onMove(BlockBreakEvent q2) {
        Player p2 = q2.getPlayer();
        if (FreezePlayerListener.INSTANCE.frozenPlayers.contains(p2.getName())) {
            q2.setCancelled(true);
        }
    }

    @EventHandler
    public void onMove(BlockPlaceEvent q2) {
        Player p2 = q2.getPlayer();
        if (FreezePlayerListener.INSTANCE.frozenPlayers.contains(p2.getName())) {
            q2.setCancelled(true);
        }
    }
}

