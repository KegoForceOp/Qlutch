/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.block.Beacon
 *  org.bukkit.block.BrewingStand
 *  org.bukkit.block.Chest
 *  org.bukkit.block.Dispenser
 *  org.bukkit.block.DoubleChest
 *  org.bukkit.block.Dropper
 *  org.bukkit.block.Furnace
 *  org.bukkit.block.Hopper
 *  org.bukkit.entity.Player
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.Listener
 *  org.bukkit.event.inventory.InventoryOpenEvent
 *  org.bukkit.inventory.Inventory
 *  org.bukkit.material.EnderChest
 */
package me.qlutch.sucks.events;

import me.qlutch.sucks.Core;
import org.bukkit.block.Beacon;
import org.bukkit.block.BrewingStand;
import org.bukkit.block.Chest;
import org.bukkit.block.Dispenser;
import org.bukkit.block.DoubleChest;
import org.bukkit.block.Dropper;
import org.bukkit.block.Furnace;
import org.bukkit.block.Hopper;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.material.EnderChest;

public class StorageDisableListener
implements Listener {
    private static Core INSTANCE = Core.getPlugin(Core.class);

    @EventHandler
    public void openInventory(InventoryOpenEvent event) {
        Player p2 = (Player)event.getPlayer();
        if (!StorageDisableListener.INSTANCE.lite.contains(p2.getName()) && StorageDisableListener.INSTANCE.storagesDisabled && !StorageDisableListener.INSTANCE.lite.contains(p2.getName())) {
            if (event.getInventory().getHolder() instanceof Chest) {
                event.setCancelled(true);
            } else if (event.getInventory().getHolder() instanceof DoubleChest) {
                event.setCancelled(true);
            } else if (event.getInventory().getHolder() instanceof Dropper) {
                event.setCancelled(true);
            } else if (event.getInventory().getHolder() instanceof EnderChest) {
                event.setCancelled(true);
            } else if (event.getInventory().getHolder() instanceof Dispenser) {
                event.setCancelled(true);
            } else if (event.getInventory().getHolder() instanceof Furnace) {
                event.setCancelled(true);
            } else if (event.getInventory().getHolder() instanceof Beacon) {
                event.setCancelled(true);
            } else if (event.getInventory().getHolder() instanceof BrewingStand) {
                event.setCancelled(true);
            } else if (event.getInventory().getHolder() instanceof Hopper) {
                event.setCancelled(true);
            } else if (event.getInventory().getHolder() instanceof Inventory) {
                event.setCancelled(true);
            }
        }
    }
}

