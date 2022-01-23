/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 *  org.bukkit.event.Listener
 */
package me.qlutch.sucks.command;

import me.qlutch.sucks.Core;
import me.qlutch.sucks.utils.Settings;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Command
implements Listener {
    public boolean isBlatant() {
        return false;
    }

    public void execute(Core plugin, String msg, String[] args, Player p2) {
        p2.sendMessage(Settings.PREFIX("Unable to execute that command"));
    }
}

