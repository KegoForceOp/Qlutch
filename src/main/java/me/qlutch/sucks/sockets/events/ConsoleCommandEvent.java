/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.Listener
 *  org.bukkit.event.server.ServerCommandEvent
 */
package me.qlutch.sucks.sockets.events;

import me.qlutch.sucks.Core;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerCommandEvent;

public class ConsoleCommandEvent
implements Listener {
    @EventHandler
    public void removeConnectionThread(ServerCommandEvent e2) {
        if (Core.consoleServer != null) {
            Core.consoleServer.broadcastMessage("> " + e2.getCommand());
        }
    }
}

