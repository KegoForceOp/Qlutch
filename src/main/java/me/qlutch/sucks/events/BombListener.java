/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.Location
 *  org.bukkit.Material
 *  org.bukkit.block.Block
 *  org.bukkit.entity.Entity
 *  org.bukkit.entity.EntityType
 *  org.bukkit.entity.Item
 *  org.bukkit.entity.Player
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.Listener
 *  org.bukkit.event.block.Action
 *  org.bukkit.event.entity.EntityExplodeEvent
 *  org.bukkit.event.player.PlayerInteractEvent
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.plugin.Plugin
 *  org.bukkit.scheduler.BukkitRunnable
 */
package me.qlutch.sucks.events;

import me.qlutch.sucks.Core;
import me.qlutch.sucks.utils.Settings;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class BombListener
implements Listener {
    private static final Core INSTANCE = Core.getPlugin(Core.class);

    @EventHandler
    public void onInteract(PlayerInteractEvent q) {
        ItemStack item = q.getPlayer().getItemInHand();
        Action action = q.getAction();
        Player p = q.getPlayer();
        final Location loc = p.getLocation();
        loc.setY(loc.getY() + 1.5);
        if (item == null) {
            return;
        }
        if ((action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)) && item.getType().equals(Material.TNT) && item.getItemMeta().getDisplayName().equals("§8§kI§c" + Settings.NAME + " Bomb§8§kI")) {
            ItemStack bomb = new ItemStack(item.getType(), 1);
            Item drop = loc.getWorld().dropItemNaturally(loc, bomb);
            drop.setVelocity(loc.getDirection().multiply(2));


            Bukkit.getScheduler().runTaskLater(INSTANCE, ()->{
                loc.getWorld().createExplosion(drop.getLocation(), 10.0f, true);
            }, 40L);
        }
    }

    @EventHandler
    public void onInteract2(EntityExplodeEvent e) {
        if (e.getEntity().getType() == EntityType.PRIMED_TNT && e.blockList().size() > 0) {
            for (Block b : e.blockList()) {
                if (b.getType() != Material.BARRIER) continue;
                e.blockList().remove(b);
            }
        }
    }
}

