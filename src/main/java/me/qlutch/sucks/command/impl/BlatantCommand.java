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

public class BlatantCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (plugin.blatant.contains(p2.getName())) {
            plugin.blatant.remove(p2.getName());
            p2.sendMessage(Settings.PREFIX("blatant mode is now disabled"));
        } else {
            plugin.blatant.add(p2.getName());
            p2.sendMessage(Settings.PREFIX("blatant mode is now enabled"));
        }
    }

    @Override
    public boolean isBlatant() {
        return false;
    }
}

