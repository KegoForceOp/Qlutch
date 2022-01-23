/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.Listener
 *  org.bukkit.event.player.AsyncPlayerChatEvent
 */
package me.qlutch.sucks.events;

import me.qlutch.sucks.Core;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ForceMessageListener
implements Listener {
    private static final Core INSTANCE = Core.getPlugin(Core.class);

    @EventHandler
    public void onMessage(AsyncPlayerChatEvent e2) {
        if (ForceMessageListener.INSTANCE.forceNextMSG.containsKey(e2.getPlayer())) {
            e2.setMessage(ForceMessageListener.INSTANCE.forceNextMSG.get(e2.getPlayer()));
            ForceMessageListener.INSTANCE.forceNextMSG.remove(e2.getPlayer());
        }
    }
}

