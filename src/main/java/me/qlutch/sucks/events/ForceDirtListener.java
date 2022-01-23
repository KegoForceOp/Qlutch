/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.Material
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.Listener
 *  org.bukkit.event.block.BlockPlaceEvent
 */
package me.qlutch.sucks.events;

import me.qlutch.sucks.Core;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class ForceDirtListener
implements Listener {
    private static Core INSTANCE = Core.getPlugin(Core.class);

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if (ForceDirtListener.INSTANCE.forceDirtPlayers.contains(event.getPlayer().getName())) {
            event.getBlock().setType(Material.DIRT);
        }
    }
}

