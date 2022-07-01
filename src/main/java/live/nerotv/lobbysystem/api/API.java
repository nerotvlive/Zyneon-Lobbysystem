package live.nerotv.lobbysystem.api;

import com.zyneonstudios.api.paper.Zyneon;
import com.zyneonstudios.api.paper.utils.user.User;
import com.zyneonstudios.api.utils.Strings;
import live.nerotv.lobbysystem.Main;
import live.nerotv.lobbysystem.commands.Fly;
import live.nerotv.lobbysystem.manager.ItemManager;
import live.nerotv.lobbysystem.pixel.PixelAPI;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class API {

    public static PluginManager PM = Bukkit.getPluginManager();
    public static String noPerms = Strings.noPerms();
    public static String noPlayer = Strings.playerNotFound();

    public static ArrayList<String> SubtitleLD = new ArrayList<String>();
    public static ArrayList<String> SubtitleAD = new ArrayList<String>();
    public static ArrayList<String> SubtitleCM = new ArrayList<String>();
    public static ArrayList<String> SubtitleMD = new ArrayList<String>();
    public static ArrayList<String> SubtitleBD = new ArrayList<String>();
    public static ArrayList<String> UserBeleidigungen = new ArrayList<String>();

    public static boolean showNametags = true;
    public static String date;
    public static boolean isStopping=false;

    private static File Config = ConfigAPI.Config;
    private static YamlConfiguration cfg = ConfigAPI.CFG;

    public static void initConfig() {
        //INIT
        ConfigAPI.checkEntry("Core.Init.Line01","§5█§5█§5█§5█§5█§5█§5█§8╗§5█§5█§8╗§8░§8░§8░§5█§5█§8╗§5█§5█§5█§8╗§8░§8░§5█§5█§8╗§5█§5█§5█§5█§5█§5█§5█§8╗§8░§5█§5█§5█§5█§5█§8╗§8░§5█§5█§5█§8╗§8░§8░§5█§5█§8╗",Config,cfg);
        ConfigAPI.checkEntry("Core.Init.Line02","§8╚§8═§8═§8═§8═§5█§5█§8║§8╚§5█§5█§8╗§8░§5█§5█§8╔§8╝§5█§5█§5█§5█§8╗§8░§5█§5█§8║§5█§5█§8╔§8═§8═§8═§8═§8╝§5█§5█§8╔§8═§8═§5█§5█§8╗§5█§5█§5█§5█§8╗§8░§5█§5█§8║",Config,cfg);
        ConfigAPI.checkEntry("Core.Init.Line03","§8░§8░§5█§5█§5█§8╔§8═§8╝§8░§8╚§5█§5█§5█§5█§8╔§8╝§8░§5█§5█§8╔§5█§5█§8╗§5█§5█§8║§5█§5█§5█§5█§5█§8╗§8░§8░§5█§5█§8║§8░§8░§5█§5█§8║§5█§5█§8╔§5█§5█§8╗§5█§5█§8║",Config,cfg);
        ConfigAPI.checkEntry("Core.Init.Line04","§5█§5█§8╔§8═§8═§8╝§8░§8░§8░§8░§8╚§5█§5█§8╔§8╝§8░§8░§5█§5█§8║§8╚§5█§5█§5█§5█§8║§5█§5█§8╔§8═§8═§8╝§8░§8░§5█§5█§8║§8░§8░§5█§5█§8║§5█§5█§8║§8╚§5█§5█§5█§5█§8║",Config,cfg);
        ConfigAPI.checkEntry("Core.Init.Line05","§5█§5█§5█§5█§5█§5█§5█§8╗§8░§8░§8░§5█§5█§8║§8░§8░§8░§5█§5█§8║§8░§8╚§5█§5█§5█§8║§5█§5█§5█§5█§5█§5█§5█§8╗§8╚§5█§5█§5█§5█§5█§8╔§8╝§5█§5█§8║§8░§8╚§5█§5█§5█§8║",Config,cfg);
        ConfigAPI.checkEntry("Core.Init.Line06","§8╚§8═§8═§8═§8═§8═§8═§8╝§8░§8░§8░§8╚§8═§8╝§8░§8░§8░§8╚§8═§8╝§8░§8░§8╚§8═§8═§8╝§8╚§8═§8═§8═§8═§8═§8═§8╝§8░§8╚§8═§8═§8═§8═§8╝§8░§8╚§8═§8╝§8░§8░§8╚§8═§8═§8╝",Config,cfg);

        //MYSQL
        ConfigAPI.checkEntry("Core.Settings.MySQL.host","host",ConfigAPI.Config,ConfigAPI.CFG);
        ConfigAPI.checkEntry("Core.Settings.MySQL.port","port",ConfigAPI.Config,ConfigAPI.CFG);
        ConfigAPI.checkEntry("Core.Settings.MySQL.database","datenbank",ConfigAPI.Config,ConfigAPI.CFG);
        ConfigAPI.checkEntry("Core.Settings.MySQL.username","benutzer",ConfigAPI.Config,ConfigAPI.CFG);
        ConfigAPI.checkEntry("Core.Settings.MySQL.password","passwort",ConfigAPI.Config,ConfigAPI.CFG);

        //COMPASS
        ConfigAPI.checkEntry("Core.Compass.Items.Item01","BARRIER",Config,cfg);
        ConfigAPI.checkEntry("Core.Compass.Items.Item02","BARRIER",Config,cfg);
        ConfigAPI.checkEntry("Core.Compass.Items.Item03","BARRIER",Config,cfg);
        ConfigAPI.checkEntry("Core.Compass.Items.Item04","BARRIER",Config,cfg);
        ConfigAPI.checkEntry("Core.Compass.Items.Item05","BARRIER",Config,cfg);
        ConfigAPI.checkEntry("Core.Compass.Items.Item06","BARRIER",Config,cfg);
        ConfigAPI.checkEntry("Core.Compass.Items.Item07","BARRIER",Config,cfg);

        ConfigAPI.checkEntry("Core.Compass.Names.Item01","§cFrei...§4",Config,cfg);
        ConfigAPI.checkEntry("Core.Compass.Names.Item02","§cFrei...§4",Config,cfg);
        ConfigAPI.checkEntry("Core.Compass.Names.Item03","§cFrei...§4",Config,cfg);
        ConfigAPI.checkEntry("Core.Compass.Names.Item04","§cFrei...§4",Config,cfg);
        ConfigAPI.checkEntry("Core.Compass.Names.Item05","§cFrei...§4",Config,cfg);
        ConfigAPI.checkEntry("Core.Compass.Names.Item06","§cFrei...§4",Config,cfg);
        ConfigAPI.checkEntry("Core.Compass.Names.Item07","§cFrei...§4",Config,cfg);
        //MINIGAMES
        ConfigAPI.checkEntry("Core.Minigames.Command","minigames",Config,cfg);

        //SUBTITLE-ARRAYS
        ConfigAPI.checkEntry("Core.Arrays.Subtitle.Leader",SubtitleLD,Config,cfg);
        SubtitleLD = (ArrayList<String>)ConfigAPI.CFG.getList("Core.Arrays.Subtitle.Leader");
        ConfigAPI.checkEntry("Core.Arrays.Subtitle.Admin",SubtitleAD,Config,cfg);
        SubtitleAD = (ArrayList<String>)ConfigAPI.CFG.getList("Core.Arrays.Subtitle.Admin");
        ConfigAPI.checkEntry("Core.Arrays.Subtitle.CommunityManager",SubtitleCM,Config,cfg);
        SubtitleCM = (ArrayList<String>)ConfigAPI.CFG.getList("Core.Arrays.Subtitle.CommunityManager");
        ConfigAPI.checkEntry("Core.Arrays.Subtitle.Moderator",SubtitleMD,Config,cfg);
        SubtitleMD = (ArrayList<String>)ConfigAPI.CFG.getList("Core.Arrays.Subtitle.Moderator");
        ConfigAPI.checkEntry("Core.Arrays.Subtitle.Builder",SubtitleBD,Config,cfg);
        SubtitleBD = (ArrayList<String>)ConfigAPI.CFG.getList("Core.Arrays.Subtitle.Builder");
        if(!UserBeleidigungen.contains("§cFühl dich beleidigt, da du die selbe Farbe, wie die, die schon existiert, genutzt hast.")) {
            UserBeleidigungen.add("§cFühl dich beleidigt, da du die selbe Farbe, wie die, die schon existiert, genutzt hast.");
        }
        ConfigAPI.checkEntry("Core.Arrays.Pixels.Beleidigungen",UserBeleidigungen,Config,cfg);
        UserBeleidigungen = (ArrayList<String>)ConfigAPI.CFG.getList("Core.Arrays.Pixels.Beleidigungen");

        //TABLIST
        ConfigAPI.checkEntry("Core.Tablist.Image","https://nerotv.live/zyneon.png",Config,cfg);
        ConfigAPI.checkEntry("Core.Tablist.Header"," \n §5zyneonstudios.com §8● §7Minecraft - aber mehr \n ",Config,cfg);
        ConfigAPI.checkEntry("Core.Tablist.Footer"," \n §9https://www.zyneonstudios.com \n §7sponsored by §ftube-hosting.de \n ",Config,cfg);
    }

    public static String getTablistImage() {
        if(ConfigAPI.CFG.contains("Core.Tablist.Image")) {
            return ConfigAPI.CFG.getString("Core.Tablist.Image");
        } else {
            return "https://nerotv.live/zyneon.png";
        }
    }

    public static void setTablist() {
        for(Player all : Bukkit.getOnlinePlayers()) {
            all.setPlayerListHeader(cfg.getString("Core.Tablist.Header").replace("&", "§"));
            all.setPlayerListFooter(cfg.getString("Core.Tablist.Footer").replace("&", "§"));
            Main.setPrefix(all);
            all.setLevel(Zyneon.getAPI().getYear());
            all.setExp((float)0.00273224043*Zyneon.getAPI().getYearDay());
        }
    }

    public static boolean rotate = false;
    public static void checkRotating() {
        /*if(!rotate) {
            BroadcastManager.rotate(Bukkit.getScheduler(),Bukkit.getEntity(UUID.fromString("c3df452e-2621-4fcf-9b5d-58e1b8960b49")));
            BroadcastManager.rotate(Bukkit.getScheduler(),Bukkit.getEntity(UUID.fromString("8b275180-cfa6-41c6-9e0e-e58bdf30a540")));
            BroadcastManager.rotate(Bukkit.getScheduler(),Bukkit.getEntity(UUID.fromString("4cff53e1-48f7-4fb8-a6ea-61af2cc88c5c")));
            rotate = true;
        }*/
    }

    public static void sendActionBar(Player player, String message) {
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR,TextComponent.fromLegacyText(message.replace("&","§")));
    }

    public static void initCommand(CommandExecutor command,String commandName) {
        initCommand(command,commandName,false);
    }

    public static void initCommand(CommandExecutor command,String commandName,Boolean tab) {
        Bukkit.getConsoleSender().sendMessage("§f  -> §7Lade Kommandoklasse §e"+commandName);
        Main.instance.getCommand(commandName).setExecutor(command);
        if(tab) {
            Main.instance.getCommand(commandName).setTabCompleter((TabCompleter) command);
        }
    }

    public static void initListener(Listener listener, String listenerName) {
        Zyneon.getAPI().initListenerClass(PM,listener,Main.get());
    }

    public static String getGameMode(Player p) {
        String GameMode;
        if (p.getGameMode().toString().equalsIgnoreCase("SURVIVAL")) {
            GameMode = "Überlebensmodus";
        } else if (p.getGameMode().toString().equalsIgnoreCase("CREATIVE")) {
            GameMode = "Kreativmodus";
        } else if (p.getGameMode().toString().equalsIgnoreCase("ADVENTURE")) {
            GameMode = "Abenteuermodus";
        } else if (p.getGameMode().toString().equalsIgnoreCase("SPECTATOR")) {
            GameMode = "Zuschauermodus";
        } else {
            GameMode = "null";
        }
        return GameMode;
    }

    public static boolean isStringBlocked(String DYM) {
        String string = DYM.toLowerCase();
        if(string.contains("nigga")) {
            return true;
        } else if(string.contains("niga")) {
            return true;
        } else if(string.contains("nega")) {
            if(string.contains("negativ")) {
                if(string.contains("ohne")) {
                    if(string.contains("tiv")) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return true;
            }
        } else if(string.contains("neger")) {
            return true;
        } else if(string.contains("nigger")) {
            return true;
        } else if(string.contains("niger")) {
            if(string.contains("weniger")) {
                return false;
            } else {
                return true;
            }
        } else if(string.contains("nazi")) {
            return true;
        } else if(string.contains("hitler")) {
            return true;
        } else if(string.contains("hure")) {
            return true;
        } else if(string.contains("fotze")) {
            return true;
        } else if(string.contains("vergewalti")) {
            return true;
        } else if(string.contains("misgeburt")) {
            return true;
        } else if(string.contains("mistgeburt")) {
            return true;
        } else if(string.contains("missgeburt")) {
            return true;
        } else if(string.contains("misstgeburt")) {
            return true;
        } else if(string.contains("misset")) {
            return true;
        } else if(string.contains("miset")) {
            return true;
        } else if(string.contains("missed")) {
            return true;
        } else if(string.contains("mised")) {
            return true;
        } else if(string.contains("faggot")) {
            return true;
        } else if(string.contains("schwuchtel")) {
            return true;
        } else if(string.contains("spast")) {
            return true;
        } else if(string.contains("spasst")) {
            return true;
        } else if(string.contains("cancer")) {
            return true;
        } else if(string.contains("krebs")) {
            return true;
        } else if(string.contains("corona")) {
            return true;
        } else if(string.contains("corinski")) {
            return true;
        } else if(string.contains("atilla")) {
            return true;
        } else if(string.contains("hildmann")) {
            return true;
        } else if(string.contains("hildman")) {
            return true;
        } else if(string.contains("atila")) {
            return true;
        } else {
            return false;
        }
    }

    public static String getGamemode(final Player p) {
        String GameMode = "";
        if (p != null) {
            if (p.getGameMode().toString().equals("SURVIVAL")) {
                GameMode = "§aÜberlebensmodus";
            }
            else if (p.getGameMode().toString().equals("CREATIVE")) {
                GameMode = "§aKreativmodus";
            }
            else if (p.getGameMode().toString().equals("ADVENTURE")) {
                GameMode = "§aAbenteuermodus";
            }
            else if (p.getGameMode().toString().equals("SPECTATOR")) {
                GameMode = "§aZuschauermodus";
            }
            else {
                GameMode = "Nothing";
            }
        }
        else {
            GameMode = "Nothing";
        }
        return GameMode;
    }

    public static void changeGamemode(final Player p, final String GameMode) {
        if (GameMode.equalsIgnoreCase("0")) {
            p.setGameMode(org.bukkit.GameMode.SURVIVAL);
            p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100.0f, 100.0f);
            p.sendMessage("Du bist nun im " + getGamemode(p) + "§7!");
        }
        else if (GameMode.equalsIgnoreCase("1")) {
            p.setGameMode(org.bukkit.GameMode.CREATIVE);
            p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100.0f, 100.0f);
            p.sendMessage("Du bist nun im " + getGamemode(p) + "§7!");
        }
        else if (GameMode.equalsIgnoreCase("2")) {
            p.setGameMode(org.bukkit.GameMode.ADVENTURE);
            p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100.0f, 100.0f);
            p.sendMessage("Du bist nun im " + getGamemode(p) + "§7!");
        }
        else if (GameMode.equalsIgnoreCase("3")) {
            p.setGameMode(org.bukkit.GameMode.SPECTATOR);
            p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100.0f, 100.0f);
            p.sendMessage("Du bist nun im " + getGamemode(p) + "§7!");
        }
        else if (GameMode.equalsIgnoreCase("SURVIVAL")) {
            p.setGameMode(org.bukkit.GameMode.SURVIVAL);
            p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100.0f, 100.0f);
            p.sendMessage("Du bist nun im " + getGamemode(p) + "§7!");
        }
        else if (GameMode.equalsIgnoreCase("CREATIVE")) {
            p.setGameMode(org.bukkit.GameMode.CREATIVE);
            p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100.0f, 100.0f);
            p.sendMessage("Du bist nun im " + getGamemode(p) + "§7!");
        }
        else if (GameMode.equalsIgnoreCase("ADVENTURE")) {
            p.setGameMode(org.bukkit.GameMode.ADVENTURE);
            p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100.0f, 100.0f);
            p.sendMessage("Du bist nun im " + getGamemode(p) + "§7!");
        }
        else if (GameMode.equalsIgnoreCase("SPECTATOR")) {
            p.setGameMode(org.bukkit.GameMode.SPECTATOR);
            p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100.0f, 100.0f);
            p.sendMessage("Du bist nun im " + getGamemode(p) + "§7!");
        }
    }

    public static void sendInit() {
        if(cfg.contains("Core.Init.Line01")&&cfg.contains("Core.Init.Line02")&&cfg.contains("Core.Init.Line03")&&cfg.contains("Core.Init.Line04")&&cfg.contains("Core.Init.Line05")&&cfg.contains("Core.Init.Line06")) {
            ConfigAPI.reloadConfig(Config, cfg);
            sendConsoleMessage(cfg.getString("Core.Init.Line01"));
            sendConsoleMessage(cfg.getString("Core.Init.Line02"));
            sendConsoleMessage(cfg.getString("Core.Init.Line03"));
            sendConsoleMessage(cfg.getString("Core.Init.Line04"));
            sendConsoleMessage(cfg.getString("Core.Init.Line05"));
            sendConsoleMessage(cfg.getString("Core.Init.Line06"));
            sendConsoleMessage("§fPlugin by §cnerotvlive§f!");
        } else {
            sendConsoleMessage("§5Lobbysystem init... §7couldn't find bigfont...");
            sendConsoleMessage("§dLobbysystem init... §7couldn't find bigfont...");
            sendConsoleMessage("§5Lobbysystem init... §7couldn't find bigfont...");
            sendConsoleMessage("§dLobbysystem init... §7couldn't find bigfont...");
            sendConsoleMessage("§5Lobbysystem init... §7couldn't find bigfont...");
            sendConsoleMessage("§dLobbysystem init... §7couldn't find bigfont...");
            sendConsoleMessage("§fPlugin by §cnerotvlive§f!");
        }
    }

    public static int getPing(Player p) {
        String v = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
        if (!p.getClass().getName().equals("org.bukkit.craftbukkit." + v + ".entity.CraftPlayer")) {
            p = Bukkit.getPlayer(p.getUniqueId());
        }
        try {
            return p.getPing();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void sendCommandInit(String Command) {
        sendConsoleMessage("§0  §f-> §7Der Command \"§e"+Command+"§7\" wird geladen...");
    }

    public static void sendListenerInit(String Listener) {
        sendConsoleMessage("§0  §f-> §7Der Listener \"§e"+Listener+"§7\" wird geladen...");
    }

    public static boolean canPlayerBuild(Player p) {
        File BuildFile = new File("/plugins/temp/"+p.getUniqueId().toString()+".buildfile");
        if(BuildFile.exists()) {
            return true;
        } else {
            return false;
        }
    }

    public static void setBuildMode(Player p,boolean state) {
        File BuildFile = new File("/plugins/temp/"+p.getUniqueId().toString()+".buildfile");
        YamlConfiguration BF = YamlConfiguration.loadConfiguration(BuildFile);
        if(state) {
            BF.set("canBuild",true);
            p.setGameMode(GameMode.CREATIVE);
            ConfigAPI.saveConfig(BuildFile,BF);
            p.getInventory().clear();
        } else {
            BuildFile.delete();
            p.setGameMode(GameMode.ADVENTURE);
            p.getInventory().clear();
            ItemManager.giveItems(p);
        }
    }

    public static void toggleBuildMode(Player p) {
        File BuildFile = new File("/plugins/temp/"+p.getUniqueId().toString()+".buildfile");
        YamlConfiguration BF = YamlConfiguration.loadConfiguration(BuildFile);
        if(BuildFile.exists()) {
            setBuildMode(p,false);
            if(p.getWorld().getName().equals("pixels")) {
                PixelAPI.givePixelItems(p);
                p.setAllowFlight(true);
                Fly.flyPlayers.add(p);
            }
        } else {
            setBuildMode(p,true);
        }
    }

    public static void sendConsoleMessage(String message) {
        Bukkit.getConsoleSender().sendMessage(Strings.prefix()+message.replace("&","§"));
    }

    public static void getPlayerTime(Player player) {
        File TempFile = new File("plugins/Lobbysystem/temp/"+player.getUniqueId().toString()+"_lobbysettings.temp");
        YamlConfiguration TF = YamlConfiguration.loadConfiguration(TempFile);
        player.resetPlayerTime();
        if(TempFile.exists()) {
            if(TF.contains("Settings.timeItem")) {
                if(TF.getInt("Settings.timeItem") == 1) {
                    player.setPlayerTime(16000,false);
                } else if(TF.getInt("Settings.timeItem") == 2) {
                    player.setPlayerTime(500,false);
                }
            }
        }
    }

    public static void switchServer(Player player, String serverName) {
        try {
            ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
            DataOutputStream out = new DataOutputStream(byteArray);
            out.writeUTF("Connect");
            out.writeUTF(serverName);
            player.sendPluginMessage(Main.get(), "BungeeCord", byteArray.toByteArray());
        } catch (Exception ignore) {}
    }

    public static void getPlayerWeather(Player player) {
        File TempFile = new File("plugins/Lobbysystem/temp/"+player.getUniqueId().toString()+"_lobbysettings.temp");
        YamlConfiguration TF = YamlConfiguration.loadConfiguration(TempFile);
        player.resetPlayerWeather();
        if(TempFile.exists()) {
            if(TF.contains("Settings.weatherItem")) {
                if(TF.getInt("Settings.weatherItem") == 1) {
                    player.setPlayerWeather(WeatherType.DOWNFALL);
                } else {
                    player.setPlayerWeather(WeatherType.CLEAR);
                }
            }
        }
    }

    public static void fixPlayer(Player p) {
        p.getInventory().setHelmet(null);
        p.getInventory().setChestplate(null);
        p.getInventory().setLeggings(null);
        p.getInventory().setBoots(null);
    }

    public static void beleidigeUser(Player player) {
        User u = Zyneon.getAPI().getOnlineUser(player.getUniqueId());
        u.sendErrorMessage(UserBeleidigungen.get(ThreadLocalRandom.current().nextInt(0,UserBeleidigungen.size())));
    }

    public static void clearPlayerChat(Player p) {
        for(int i= 0; i < 150; i++){
            p.sendMessage("§0");
        }
    }

    public static void sendMessage(CommandSender s, String message) {
        if(s instanceof Player p) {
            User u = Zyneon.getAPI().getOnlineUser(p.getUniqueId());
            u.sendMessage(message);
        } else {
            Zyneon.getZyneonServer().sendMessage(message);
        }
    }

    public static void sendWarnMessage(CommandSender s, String message) {
        if(s instanceof Player p) {
            User u = Zyneon.getAPI().getOnlineUser(p.getUniqueId());
            u.sendWarnMessage(message);
        } else {
            Zyneon.getZyneonServer().sendWarnMessage(message);
        }
    }

    public static void sendErrorMessage(CommandSender s, String message) {
        if(s instanceof Player p) {
            User u = Zyneon.getAPI().getOnlineUser(p.getUniqueId());
            u.sendErrorMessage(message);
        } else {
            Zyneon.getZyneonServer().sendErrorMessage(message);
        }
    }

    public static boolean isBedrock(CommandSender sender) {
        if(sender instanceof Player) {
            return PlayerAPI.isBedrock((Player)sender);
        } else {
            return false;
        }
    }

    public static boolean isNumericPart(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static boolean isNumeric(String Check) {
        if(isNumericPart(Check)) {
            return !(Double.parseDouble(Check) > 999999998);
        } else {
            return false;
        }
    }

    public static void doCompassWarp(Player player,int warp) {
        String warpName = cfg.getString("Core.Compass.Names.Item0"+warp);
        if(cfg.contains("Core.Compass.Servers.Server0"+warp)) {
            switchServer(player,cfg.getString("Core.Compass.Servers.Server0"+warp));
        } else {
            if(WarpAPI.isWarpEnabled("GUI_0"+warp)) {
                player.teleport(WarpAPI.getWarp("GUI_0"+warp));
                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 100, 100);
                player.playSound(player.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100, 100);
            } else {
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_BREAK, 100, 100);
            }
        }
    }

    public static boolean showJumper = false;
    public static int animatedState;
    public static String animatedString() {
        int state = animatedState;
        String string = "§fZYNEON";
        if(state == 1) {
            string = "§5Z§fYNEON";
        } else if(state == 2) {
            string = "§fZ§5Y§fNEON";
        } else if(state == 3) {
            string = "§fZY§5N§fEON";
        } else if(state == 4) {
            string = "§fZYN§5E§fON";
        } else if(state == 5) {
            string = "§fZYNE§5O§fN";
        } else if(state == 6) {
            string = "§fZYNEO§5N";
        }
        return string;
    }

    public static String animatedJumper() {
        int state = animatedState;
        String string = "§f§lJUMPER";
        if(state == 1) {
            string = "§9§lJ§f§lUMPER";
        } else if(state == 2) {
            string = "§f§lJ§9§lU§f§lMPER";
        } else if(state == 3) {
            string = "§f§lJU§9§lM§f§lPER";
        } else if(state == 4) {
            string = "§f§lJUM§9§lP§f§lER";
        } else if(state == 5) {
            string = "§f§lJUMP§9§lE§f§lR";
        } else if(state == 6) {
            string = "§f§lJUMPE§9§lR";
        }
        return string;
    }
}