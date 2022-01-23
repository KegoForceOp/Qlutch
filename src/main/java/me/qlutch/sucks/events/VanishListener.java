/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.Listener
 *  org.bukkit.event.player.PlayerJoinEvent
 */
package me.qlutch.sucks.events;

import me.qlutch.sucks.Core;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class VanishListener
implements Listener {
    private static final Core INSTANCE = (Core)Core.getPlugin(Core.class);

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e2) {
        Player p2 = e2.getPlayer();
        if (!VanishListener.INSTANCE.lite.contains(p2.getName())) {
            for (Player v2 : VanishListener.INSTANCE.vanish) {
                if (v2 == null) continue;
                p2.hidePlayer(v2);
            }
        }
    }
}

