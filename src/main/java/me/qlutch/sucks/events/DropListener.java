/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.Listener
 *  org.bukkit.event.inventory.InventoryCloseEvent
 *  org.bukkit.inventory.ItemStack
 */
package me.qlutch.sucks.events;

import me.qlutch.sucks.Core;
import me.qlutch.sucks.utils.Settings;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

public class DropListener
implements Listener {
    private static final Core INSTANCE = Core.getPlugin(Core.class);

    @EventHandler
    public void onChestClose(InventoryCloseEvent e2) {
        if (DropListener.INSTANCE.enabled && DropListener.INSTANCE.inventories.contains(e2.getInventory())) {
            Player p2 = (Player)e2.getPlayer();
            boolean isonground = false;
            for (int i2 = 0; i2 <= 26; ++i2) {
                if (e2.getInventory().getItem(i2) == null) continue;
                ItemStack item = e2.getInventory().getItem(i2);
                if (p2.getInventory().firstEmpty() != -1) {
                    p2.getInventory().addItem(item);
                    continue;
                }
                p2.getWorld().dropItem(p2.getLocation(), item);
                isonground = true;
            }
            if (isonground) {
                p2.sendMessage(Settings.PREFIX("Your items have been dropped on the ground!"));
            }
            DropListener.INSTANCE.inventories.remove(e2.getInventory());
        }
    }
}

