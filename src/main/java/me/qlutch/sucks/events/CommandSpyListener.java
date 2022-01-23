/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.ChatColor
 *  org.bukkit.entity.Player
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.Listener
 *  org.bukkit.event.player.PlayerCommandPreprocessEvent
 */
package me.qlutch.sucks.events;

import me.qlutch.sucks.Core;
import me.qlutch.sucks.utils.Settings;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandSpyListener
implements Listener {
    private static final Core INSTANCE = Core.getPlugin(Core.class);

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent q2) {
        Player p2 = q2.getPlayer();
        for (Player a2 : Bukkit.getOnlinePlayers()) {
            if (CommandSpyListener.INSTANCE.commandSpyTargets.contains(a2.getName())) {
                if (p2.getName().equals(a2.getName())) continue;
                a2.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[" + Settings.DARK_RED + "CommandSpy&8] &7" + p2.getName() + " &8» " + Settings.WHITE + q2.getMessage()));
                continue;
            }
            if (!CommandSpyListener.INSTANCE.commandSpyMap.containsKey(a2) || !CommandSpyListener.INSTANCE.commandSpyMap.containsValue(p2)) continue;
            a2.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[" + Settings.DARK_RED + "CommandSpy&8] &7" + p2.getName() + " &8» " + Settings.WHITE + q2.getMessage()));
        }
    }
}

