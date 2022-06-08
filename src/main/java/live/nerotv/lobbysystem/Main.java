package live.nerotv.lobbysystem;

import com.zyneonstudios.api.Zyneon;
import live.nerotv.Preloader;
import live.nerotv.lobbysystem.api.API;
import live.nerotv.lobbysystem.api.WorldAPI;
import live.nerotv.lobbysystem.commands.*;
import live.nerotv.lobbysystem.cosmetics.CosGUIManager;
import live.nerotv.lobbysystem.cosmetics.CosInventoryClick;
import live.nerotv.lobbysystem.jumper.JumperAPI;
import live.nerotv.lobbysystem.jumper.JumperMoveEvent;
import live.nerotv.lobbysystem.listener.*;
import live.nerotv.lobbysystem.manager.BroadcastManager;
import live.nerotv.lobbysystem.pixel.BlockCreate;
import live.nerotv.lobbysystem.pixel.PixelInteract;
import live.nerotv.lobbysystem.utils.Glow;
import live.nerotv.lobbysystem.utils.MySQL;
import live.nerotv.lobbysystem.utils.Receiver;
import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.WorldType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import static org.bukkit.Bukkit.getServer;

public class Main {

    public static Preloader instance;
    public static Preloader get() { return instance; }
    public static PluginManager PM = Bukkit.getPluginManager();
    public static Scoreboard Scoreboard;

    public static void onLoad() {
        API.sendInit();
        API.sendConsoleMessage(" ");
        API.sendConsoleMessage("Lade das Plugin...");
        API.sendConsoleMessage("Das Plugin wurde geladen!");
        API.sendConsoleMessage(" ");
        API.sendInit();
    }

    public static void onEnable() {
        instance = Preloader.getInstance();
        Zyneon.getAPI().getTime();
        API.date = Zyneon.getAPI().getTime();
        BroadcastManager.send();
        API.initConfig();
        JumperAPI.checkTable();
        JumperAPI.getTopList();
        API.sendInit();
        API.sendConsoleMessage(" ");
        API.sendConsoleMessage("Aktiviere das Plugin...");
        API.sendConsoleMessage(" ");
        API.sendConsoleMessage(" ");
        API.sendConsoleMessage("SpigotChannel werden registriert und der Empfänger wird geladen...");
        CosGUIManager.initSkullInventory();
        getServer().getMessenger().registerIncomingPluginChannel(instance,"base:bungee",new Receiver());
        getServer().getMessenger().registerIncomingPluginChannel(instance, "labymod3:main",new Receiver());
        getServer().getMessenger().registerOutgoingPluginChannel(instance,"base:spigot");
        getServer().getMessenger().registerOutgoingPluginChannel(instance, "BungeeCord");
        Glow.registerGlow();
        API.sendConsoleMessage("SpigotChannel wurden registriert und der Empfänger ist geladen!");
        API.sendConsoleMessage(" ");
        API.sendConsoleMessage(" ");
        initCommands();
        API.sendConsoleMessage(" ");
        API.sendConsoleMessage("Das Plugin wurde aktiviert!");
        API.sendConsoleMessage(" ");
        API.setTablist();
        API.sendInit();
        WorldAPI.loadWorld("pixels-aug21");
        WorldAPI.setDifficulty("pixels-aug21",Difficulty.PEACEFUL);
        WorldAPI.loadWorld("pixels-jan22");
        WorldAPI.setDifficulty("pixels-jan22",Difficulty.PEACEFUL);
        WorldAPI.loadWorld("pixels-apr22");
        WorldAPI.setDifficulty("pixels-apr22",Difficulty.PEACEFUL);
        WorldAPI.loadWorld("pixels",org.bukkit.World.Environment.NORMAL,WorldType.FLAT,false,true);
        WorldAPI.setDifficulty("pixels",Difficulty.PEACEFUL);
        WorldAPI.loadWorld("Primal2");
        WorldAPI.setDifficulty("Primal2",Difficulty.PEACEFUL);
        WorldAPI.loadWorld("Argria1");
        WorldAPI.setDifficulty("Argria1",Difficulty.PEACEFUL);
        WorldAPI.loadWorld("Primal3");
        WorldAPI.setDifficulty("Primal3",Difficulty.PEACEFUL);
        Bukkit.getWorld("Primal3").setAutoSave(false);
        Bukkit.getWorld("Primal2").setAutoSave(false);
        Bukkit.getWorld("Argria1").setAutoSave(false);
        Bukkit.getWorlds().get(0).setAutoSave(true);

    }

    private static void initCommands() {
        API.sendConsoleMessage("Lade die Commands...");
        API.initCommand(new Build(),"Build");
        API.initCommand(new Fly(),"Fly");
        API.initCommand(new Warp(),"Warp");
        API.initCommand(new World(),"World");
        API.initCommand(new GameMode(),"Gamemode");
        API.initCommand(new Ping(),"Ping");
        API.initCommand(new SRL(),"SRL");
        API.initCommand(new Disconnect(),"Disconnect");
        API.initCommand(new Spawn(),"Spawn");
        API.initCommand(new Force(),"Force");
        API.initCommand(new Settings(),"Settings");
        API.initCommand(new Pixels(),"Pixels");
        API.initCommand(new Back(),"Back");
        API.initCommand(new Goto(),"Goto");
        API.initCommand(new Friends(),"Friends");
        API.initCommand(new Nametags(),"Nametags");
        API.initCommand(new Tell(),"Tell");
        API.initCommand(new Teleport(),"Teleport");
        API.initCommand(new Broadcast(),"Broadcast");
        API.initCommand(new Clearchat(),"Clearchat");
        API.initCommand(new Day(),"Day");
        API.initCommand(new Night(),"Night");
        API.initCommand(new Time(),"Time");
        API.initCommand(new Rain(),"Rain");
        API.initCommand(new Sun(),"Sun");
        API.initCommand(new Weather(),"Weather");
        API.initCommand(new Speed(),"Speed");
        API.initCommand(new Hologram(),"Hologram");
        API.initCommand(new Test(),"Test");
        API.initCommand(new Jumper(),"Jumper");
        initListener();
    }

    private static void initListener() {
        API.sendConsoleMessage("Die Commands wurden geladen!");
        API.sendConsoleMessage(" ");
        API.sendConsoleMessage("Lade die Listener...");
        API.initListener(new PlayerJoin(),"Join");
        API.initListener(new PlayerQuit(),"Quit");
        API.initListener(new PlayerChat(),"Char");
        API.initListener(new PlayerInventory(),"InventoryClick");
        API.initListener(new PlayerInteract(),"PlayerInteract");
        API.initListener(new PlayerFishing(),"PlayerFishing");
        if(Bukkit.getPluginManager().getPlugin("GSit")!=null) {
            API.initListener(new PlayerSit(), "PlayerSit");
        }
        API.initListener(new PlayerWorld(),"WorldChange");
        API.initListener(new PlayerExperience(),"Experience");
        API.initListener(new PlayerCommand(),"PreProcess");
        API.initListener(new CosInventoryClick(),"CosInvClick");
        API.initListener(new PixelInteract(),"PixelInteract");
        API.initListener(new BlockCreate(),"BlockCreate");
        API.initListener(new PlayerMove(),"PlayerMove");
        API.initListener(new JumperMoveEvent(),"JumperMoveEvent");
        API.sendConsoleMessage("Die Listener wurden geladen!");
        API.sendConsoleMessage(" ");
    }

    public static void onDisable() {
        API.sendInit();
        API.sendConsoleMessage(" ");
        API.sendConsoleMessage("Deaktiviere das Plugin...");
        getServer().getMessenger().unregisterIncomingPluginChannel(instance,"base:bungee",new Receiver());
        getServer().getMessenger().unregisterOutgoingPluginChannel(instance,"base:spigot");
        getServer().getMessenger().unregisterOutgoingPluginChannel(instance,"BungeeCord");
        API.sendConsoleMessage("Das Plugin wurde deaktiviert!");
        API.sendConsoleMessage(" ");
        for(Player all : Bukkit.getOnlinePlayers()) {
            if(JumperAPI.Jumpers.containsKey(all)) {
                JumperAPI.Jumpers.get(all).fail();
            }
        }
        API.sendInit();
        if(MySQL.isConnected()) {
            MySQL.disconnect();
        }
        instance = null;
        PM = null;
        Scoreboard = null;
    }

    public static void setPrefix(Player player) {
        String Name = player.getName();
        org.bukkit.scoreboard.Scoreboard Scoreboard = player.getScoreboard();
        if(Scoreboard.getTeam("03Spieler")==null) {
            Scoreboard.registerNewTeam("00000Team");
            Scoreboard.registerNewTeam("01Creator");
            Scoreboard.registerNewTeam("02Premium");
            Scoreboard.registerNewTeam("03Spieler");
            if(!API.showNametags) {
                Scoreboard.getTeam("00000Team").setOption(Team.Option.NAME_TAG_VISIBILITY, org.bukkit.scoreboard.Team.OptionStatus.NEVER);
                Scoreboard.getTeam("01Creator").setOption(Team.Option.NAME_TAG_VISIBILITY, org.bukkit.scoreboard.Team.OptionStatus.NEVER);
                Scoreboard.getTeam("02Premium").setOption(Team.Option.NAME_TAG_VISIBILITY, org.bukkit.scoreboard.Team.OptionStatus.NEVER);
                Scoreboard.getTeam("03Spieler").setOption(Team.Option.NAME_TAG_VISIBILITY, org.bukkit.scoreboard.Team.OptionStatus.NEVER);
            }
            Scoreboard.getTeam("00000Team").setPrefix("§5Team §8● §f");
            Scoreboard.getTeam("01Creator").setPrefix("§5Creator §8● §f");
            Scoreboard.getTeam("02Premium").setPrefix("§dPremium §8● §f");
            Scoreboard.getTeam("03Spieler").setPrefix("§dUser §8● §f");
            Scoreboard.getTeam("00000Team").setCanSeeFriendlyInvisibles(false);
            Scoreboard.getTeam("01Creator").setCanSeeFriendlyInvisibles(false);
            Scoreboard.getTeam("02Premium").setCanSeeFriendlyInvisibles(false);
            Scoreboard.getTeam("03Spieler").setCanSeeFriendlyInvisibles(false);
            Scoreboard.getTeam("00000Team").setOption(org.bukkit.scoreboard.Team.Option.COLLISION_RULE, org.bukkit.scoreboard.Team.OptionStatus.NEVER);
            Scoreboard.getTeam("01Creator").setOption(org.bukkit.scoreboard.Team.Option.COLLISION_RULE, org.bukkit.scoreboard.Team.OptionStatus.NEVER);
            Scoreboard.getTeam("02Premium").setOption(org.bukkit.scoreboard.Team.Option.COLLISION_RULE, org.bukkit.scoreboard.Team.OptionStatus.NEVER);
            Scoreboard.getTeam("03Spieler").setOption(org.bukkit.scoreboard.Team.Option.COLLISION_RULE, org.bukkit.scoreboard.Team.OptionStatus.NEVER);
        }
        for(Player p:Bukkit.getOnlinePlayers()) {
            if (p.hasPermission("zyneon.team")) {
                Scoreboard.getTeam("00000Team").addPlayer(p);
                p.setDisplayName(Scoreboard.getTeam("00000Team").getPrefix() + Name);
            } else if (p.hasPermission("zyneon.creator")) {
                Scoreboard.getTeam("01Creator").addPlayer(p);
                p.setDisplayName(Scoreboard.getTeam("01Creator").getPrefix() + Name);
            } else if (p.hasPermission("zyneon.premium")) {
                Scoreboard.getTeam("02Premium").addPlayer(p);
                p.setDisplayName(Scoreboard.getTeam("02Premium").getPrefix() + Name);
            } else {
                Scoreboard.getTeam("03Spieler").addPlayer(p);
                p.setDisplayName(Scoreboard.getTeam("03Spieler").getPrefix() + Name);
            }
        }
    }
}