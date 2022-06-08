package live.nerotv.lobbysystem.manager.bedrock;

import live.nerotv.lobbysystem.api.ConfigAPI;
import live.nerotv.lobbysystem.api.PlayerAPI;
import live.nerotv.lobbysystem.manager.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.WeatherType;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import java.io.File;

public class SettingsManager {

    public static void changeAnimationState(Player player) {
        File TempFile = new File("plugins/Lobbysystem/temp/"+player.getUniqueId().toString()+"_lobbysettings.temp");
        YamlConfiguration TF = YamlConfiguration.loadConfiguration(TempFile);
        if(TempFile.exists()) {
            if(TF.contains("Settings.Animations")) {
                if(TF.getBoolean("Settings.Animations")) {
                    TF.set("Settings.Animations",false);
                } else {
                    TF.set("Settings.Animations",true);
                }
            } else {
                TF.set("Settings.Animations",false);
            }
        } else {
            TF.set("Settings.Animations",false);
        }
        ConfigAPI.saveConfig(TempFile,TF);
        ConfigAPI.reloadConfig(TempFile,TF);
    }

    public static void changeScoreboardState(Player player) {
        File TempFile = new File("plugins/Lobbysystem/temp/"+player.getUniqueId().toString()+"_lobbysettings.temp");
        YamlConfiguration TF = YamlConfiguration.loadConfiguration(TempFile);
        String board = "Settings.Scoreboard";
        if(TempFile.exists()) {
            if(TF.contains("Settings.Scoreboard")) {
                if(TF.getBoolean("Settings.Scoreboard")) {
                    TF.set("Settings.Scoreboard",false);
                    Scoreboard sboard = Bukkit.getScoreboardManager().getNewScoreboard();
                    player.setScoreboard(sboard);
                } else {
                    TF.set("Settings.Scoreboard",true);
                }
            } else {
                TF.set("Settings.Scoreboard",false);
                Scoreboard sboard = Bukkit.getScoreboardManager().getNewScoreboard();
                player.setScoreboard(sboard);
            }
        } else {
            TF.set("Settings.Scoreboard",false);
            Scoreboard sboard = Bukkit.getScoreboardManager().getNewScoreboard();
            player.setScoreboard(sboard);
        }
        ConfigAPI.saveConfig(TempFile,TF);
        ConfigAPI.reloadConfig(TempFile,TF);
        PlayerAPI.renewScoreboard(player,false);
    }

    public static void changeTimeState(Player player) {
        File TempFile = new File("plugins/Lobbysystem/temp/"+player.getUniqueId().toString()+"_lobbysettings.temp");
        YamlConfiguration TF = YamlConfiguration.loadConfiguration(TempFile);
        String Time = "Settings.timeItem";
        if(TF.contains(Time)) {
            if(TF.getInt(Time)==0) {
                TF.set(Time,1);
                player.resetPlayerTime();
                player.setPlayerTime(16000, false);
            } else if(TF.getInt(Time)==1) {
                TF.set(Time,2);
                player.resetPlayerTime();
                player.setPlayerTime(500,false);
            } else if(TF.getInt(Time)==2) {
                TF.set(Time,0);
                player.resetPlayerTime();
            } else {
                TF.set(Time,1);
                player.resetPlayerTime();
                player.setPlayerTime(16000, false);
            }
        } else {
            TF.set(Time,1);
            player.resetPlayerTime();
            player.setPlayerTime(16000, false);
        }
        ConfigAPI.saveConfig(TempFile,TF);
    }

    public static void changeRainState(Player player) {
        File TempFile = new File("plugins/Lobbysystem/temp/"+player.getUniqueId().toString()+"_lobbysettings.temp");
        YamlConfiguration TF = YamlConfiguration.loadConfiguration(TempFile);
        String Rain = "Settings.weatherItem";
        if(TF.contains(Rain)) {
            if(TF.getInt(Rain)==1) {
                TF.set(Rain,0);
                player.resetPlayerWeather();
            } else {
                TF.set(Rain,1);
                player.resetPlayerWeather();
                player.setPlayerWeather(WeatherType.DOWNFALL);
            }
        } else {
            TF.set(Rain,1);
            player.resetPlayerWeather();
            player.setPlayerWeather(WeatherType.DOWNFALL);
        }
        ConfigAPI.saveConfig(TempFile,TF);
    }

    public static void changeFlightState(Player player) {
        if(player.getAllowFlight()) {
            player.setFlying(false);
            player.setAllowFlight(false);
        } else {
            player.setAllowFlight(true);
            player.setFlying(true);
        }
    }

    public static void changeBedrockState(Player player) {
        File TempFile = new File("plugins/Lobbysystem/temp/"+player.getUniqueId().toString()+"_lobbysettings.temp");
        YamlConfiguration TF = YamlConfiguration.loadConfiguration(TempFile);
        String State = "Settings.BedrockMode";
        if(TF.contains(State)) {
            if(TF.getBoolean(State)) {
                TF.set(State,false);
            } else {
                TF.set(State,true);
            }
        } else {
            TF.set(State,false);
        }
        ConfigAPI.saveConfig(TempFile,TF);
        ItemManager.giveItems(player);
    }

    public static void changeBedrockState(Player player,Boolean state) {
        File TempFile = new File("plugins/Lobbysystem/temp/"+player.getUniqueId().toString()+"_lobbysettings.temp");
        YamlConfiguration TF = YamlConfiguration.loadConfiguration(TempFile);
        String State = "Settings.BedrockMode";
        TF.set(State,state);
        ConfigAPI.saveConfig(TempFile,TF);
        ItemManager.giveItems(player);
    }
}