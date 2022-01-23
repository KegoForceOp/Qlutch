/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.Material
 *  org.bukkit.entity.Player
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.Listener
 *  org.bukkit.event.player.PlayerMoveEvent
 *  org.bukkit.util.Vector
 */
package me.qlutch.sucks.events;

import me.qlutch.sucks.Core;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class ScaffoldListener
implements Listener {
    private static final Core INSTANCE = Core.getPlugin(Core.class);

    @EventHandler
    public void onMove(PlayerMoveEvent e2) {
        Player p2 = e2.getPlayer();
        if (ScaffoldListener.INSTANCE.scaffoldingPlayers.contains(p2.getName())) {
            p2.setVelocity(new Vector(0.0, 0.3, 0.0));
            Material mat = ScaffoldListener.INSTANCE.scaffoldMaterialMap.get(p2);
            p2.getWorld().spawnFallingBlock(p2.getLocation(), mat, (byte)0);
        }
    }
}

