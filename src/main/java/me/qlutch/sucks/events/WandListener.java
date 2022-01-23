/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.Material
 *  org.bukkit.block.Block
 *  org.bukkit.entity.Player
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.Listener
 *  org.bukkit.event.block.Action
 *  org.bukkit.event.player.PlayerInteractEvent
 *  org.bukkit.inventory.ItemStack
 */
package me.qlutch.sucks.events;

import me.qlutch.sucks.Core;
import me.qlutch.sucks.utils.Settings;
import java.util.Set;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class WandListener
implements Listener {
    private static final Core INSTANCE = Core.getPlugin(Core.class);

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        ItemStack item = event.getPlayer().getItemInHand();
        Action action = event.getAction();
        Player p2 = event.getPlayer();
        if (item == null) {
            return;
        }
        if (WandListener.INSTANCE.lite.contains(p2.getName()) && (action.equals((Object)Action.RIGHT_CLICK_AIR) || action.equals((Object)Action.RIGHT_CLICK_BLOCK)) && item.getType().equals((Object)Material.DIAMOND_AXE)) {
            String[] result = item.getItemMeta().getDisplayName().split(Settings.RED);
            Material wandMaterial = Material.valueOf((String)result[result.length - 1].toUpperCase());
            if (item.getItemMeta().getDisplayName().contains(wandMaterial.toString())) {
                String[] loreResult = item.getItemMeta().getLore().toString().replace("]", "").split(Settings.RED);
                int wandRadius = Integer.parseInt(loreResult[loreResult.length - 1]);
                int startx = p2.getTargetBlock((Set)null, 100).getX();
                int starty = p2.getTargetBlock((Set)null, 100).getY();
                int startz = p2.getTargetBlock((Set)null, 100).getZ();
                int endx = p2.getTargetBlock((Set)null, 100).getX() + wandRadius;
                int endy = p2.getTargetBlock((Set)null, 100).getY() + wandRadius;
                int endz = p2.getTargetBlock((Set)null, 100).getZ() + wandRadius;
                for (int x2 = startx; x2 < endx; ++x2) {
                    for (int y2 = starty; y2 < endy; ++y2) {
                        for (int z2 = startz; z2 < endz; ++z2) {
                            Block block = p2.getWorld().getBlockAt(x2, y2, z2);
                            block.setType(wandMaterial);
                        }
                    }
                }
            }
        }
    }
}

