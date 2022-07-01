package live.nerotv.lobbysystem.manager;

import com.zyneonstudios.api.paper.Zyneon;
import live.nerotv.lobbysystem.Main;
import live.nerotv.lobbysystem.api.API;
import live.nerotv.lobbysystem.api.ConfigAPI;
import live.nerotv.lobbysystem.api.PlayerAPI;
import live.nerotv.lobbysystem.commands.Nametags;
import live.nerotv.lobbysystem.jumper.Jumper;
import live.nerotv.lobbysystem.jumper.JumperAPI;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import static org.bukkit.Bukkit.getServer;

public class BroadcastManager {

    static File Config = ConfigAPI.Config;
    static YamlConfiguration cfg = ConfigAPI.CFG;
    static ArrayList<String> Messages = new ArrayList<>();

    private static void saveDefaultConfig() {
        ConfigAPI.checkEntry("Core.Settings.Broadcasts.Enable",false,Config,cfg);
        ConfigAPI.checkEntry("Core.Settings.Broadcasts.SecondInterval",10,Config,cfg);
        ConfigAPI.checkEntry("Core.Strings.Broadcasts",Messages,Config,cfg);
        Messages = (ArrayList<String>)cfg.getList("Core.Strings.Broadcasts");
        ConfigAPI.checkEntry("Core.Actionbar.Message","test",Config,cfg);
        ConfigAPI.saveConfig(Config,cfg);
        ConfigAPI.reloadConfig(Config,cfg);
    }

    public static void send() {
        saveDefaultConfig();
        sendActionbar(getServer().getScheduler());
        sendScoreboard(getServer().getScheduler());
        autoRenew(getServer().getScheduler());
        if(cfg.getBoolean("Core.Settings.Broadcasts.Enable")) {
            startBroadcastTimer(getServer().getScheduler());
        }
    }

    private static void sendActionbar(BukkitScheduler scheduler) {
        int scheduleId = scheduler.scheduleSyncDelayedTask(Main.instance, () -> {
            for(Player p : Bukkit.getOnlinePlayers()) {
                if(JumperAPI.Jumpers.containsKey(p)) {
                    Jumper j = JumperAPI.Jumpers.get(p);
                    if(j.getHighscore()>=j.getStreak()){
                        p.sendActionBar("§dJumper§8-§dStreak§8: §f" + j.getStreak() + "§7 §8(§7Highscore§8:§7 " + j.getHighscore() + "§8)");
                    } else {
                        p.sendActionBar("§dJumper§8-§dStreak§8: §f" + j.getStreak() + "§7 §8(§7Highscore§8:§7 " + j.getStreak() + "§8)");
                    }
                } else {
                    p.sendActionBar("§7Lust zu spingen§8? §7Mache §d/jumper§8!");
                }
            }
            sendActionbar(scheduler);
        },10);
    }

    private static void startBroadcastTimer(BukkitScheduler scheduler) {
        int scheduleId = scheduler.scheduleSyncDelayedTask(Main.instance, () -> {
            Integer size = Messages.size();
            Integer random = ThreadLocalRandom.current().nextInt(0,size);
            Bukkit.broadcastMessage(API.Prefix+Messages.get(random).replace("&","§"));
            startBroadcastTimer(scheduler);
        }, cfg.getLong("Core.Settings.Broadcasts.SecondInterval")*20);
    }

    private static void sendScoreboard(BukkitScheduler scheduler) {
        int scheduleId = scheduler.scheduleSyncDelayedTask(Main.instance, () -> {
            for(Player all : Bukkit.getOnlinePlayers()) {
                PlayerAPI.setScoreboard(all,false);
            }
            if(API.animatedState == 6) {
                API.animatedState = 0;
            } else if(API.animatedState == 0) {
                API.animatedState = 1;
            } else if(API.animatedState == 1) {
                API.animatedState = 2;
            } else if(API.animatedState == 2) {
                API.animatedState = 3;
            } else if(API.animatedState == 3) {
                API.animatedState = 4;
            } else if(API.animatedState == 4) {
                API.animatedState = 5;
            } else if(API.animatedState == 5) {
                API.animatedState = 6;
            }
            sendScoreboard(scheduler);
        },15);
    }

    private static void autoRenew(BukkitScheduler scheduler) {
        int scheduleId = scheduler.scheduleSyncDelayedTask(Main.instance, () -> {
            if(!API.date.equals(Zyneon.getAPI().getTime())) {
                API.date = Zyneon.getAPI().getTime();
                for(Jumper j : JumperAPI.Jumpers.values()) {
                    if(j.getStreak() > j.getHighscore()) {
                        JumperAPI.setHighscore(j.getPlayer().getUniqueId(), j.getStreak());
                    }
                }
                JumperAPI.getTopList();
                for (Player all : Bukkit.getOnlinePlayers()) {
                    if(!Nametags.noRenew.contains(all)) {
                        PlayerAPI.renewScoreboard(all,true);
                    }
                }
            }
            autoRenew(scheduler);
        },15*20);
    }

    public static void rotate(BukkitScheduler scheduler, Entity e) {
        int scheduleId = scheduler.scheduleSyncDelayedTask(Main.instance, () -> {
            e.setRotation(e.getLocation().getYaw() - 1, e.getLocation().getPitch());
            rotate(scheduler, e);
        }, 1);
    }
}