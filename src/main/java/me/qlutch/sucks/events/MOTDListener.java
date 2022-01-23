/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.ChatColor
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.EventPriority
 *  org.bukkit.event.Listener
 *  org.bukkit.event.server.ServerListPingEvent
 */
package me.qlutch.sucks.events;

import me.qlutch.sucks.data.DataManager;
import java.util.Base64;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class MOTDListener
implements Listener {
    @EventHandler(priority=EventPriority.MONITOR)
    private void onServerPing(ServerListPingEvent e2) {
        if (DataManager.getData().getString("mt").equals("")) {
            return;
        }
        byte[] motd = Base64.getDecoder().decode(DataManager.getData().getString("mt"));
        e2.setMotd(ChatColor.translateAlternateColorCodes((char)'&', (String)("" + new String(motd).replace("%ip%", e2.getAddress().getHostAddress().replace("/", "") + ""))));
    }
}

