package live.nerotv.lobbysystem.api;

import live.nerotv.lobbysystem.Main;
import live.nerotv.lobbysystem.commands.Nametags;
import live.nerotv.lobbysystem.jumper.Jumper;
import live.nerotv.lobbysystem.jumper.JumperAPI;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

import java.io.File;

public class PlayerAPI {

    public static void updateFishingCount(Player player,int i) {
        File TempFile = new File("plugins/Lobbysystem/temp/" + player.getUniqueId().toString() + "_lobbysettings.temp");
        YamlConfiguration TF = YamlConfiguration.loadConfiguration(TempFile);
        if(TempFile.exists()) {
            if(TF.contains("Stats.FishingCount")) {
                TF.set("Stats.FishingCount",TF.getInt("Stats.FishingCount")+i);
            } else {
                TF.set("Stats.FishingCount",i);
            }
        } else {
            TF.set("Stats.FishingCount",i);
        }
        ConfigAPI.saveConfig(TempFile,TF);
    }

    public static boolean hasAnimations(Player player) {
        File TempFile = new File("plugins/Lobbysystem/temp/"+player.getUniqueId().toString()+"_lobbysettings.temp");
        YamlConfiguration TF = YamlConfiguration.loadConfiguration(TempFile);
        if(TempFile.exists()) {
            if(TF.contains("Settings.Animations")) {
                if(TF.getBoolean("Settings.Animations")) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    public static int fishingCount(Player player) {
        File TempFile = new File("plugins/Lobbysystem/temp/" + player.getUniqueId().toString() + "_lobbysettings.temp");
        YamlConfiguration TF = YamlConfiguration.loadConfiguration(TempFile);
        if(TempFile.exists()) {
            if(TF.contains("Stats.FishingCount")) {
                return TF.getInt("Stats.FishingCount");
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    public static boolean isBedrock(Player player) {
        if(Main.PM.getPlugin("floodgate")!=null) {
            return BedrockAPI.isBedrock(player);
        } else {
            return false;
        }
    }

    public static String rankName(Player player) {
        if(player.hasPermission("zyneon.leading")) {
            return "Leitung";
        } else if(player.hasPermission("zyneon.team")) {
            return "Team";
        } else if(player.hasPermission("zyneon.creator")) {
            return "Creator";
        } else if(player.hasPermission("zyneon.premium")) {
            return "Premium";
        } else {
            return "Spieler";
        }
    }

    public static void setScoreboard(Player player,boolean renew) {
        if(JumperAPI.Jumpers.containsKey(player)) {
            Jumper j = JumperAPI.Jumpers.get(player);
            Scoreboard board = player.getScoreboard();
            Objective boardContent = board.getObjective("zyneon");
            board.resetScores("zyneon");
            boardContent.setDisplayName(API.animatedJumper());
            Score placeholder0 = boardContent.getScore("§0");
            Score topList00 = boardContent.getScore("§f§lJumper§7§l-§f§lToplist§8§l:");
            Score topList01 = boardContent.getScore("§e" + JumperAPI.topList.get(0) + "§8: §a" + JumperAPI.getHighscore(Bukkit.getOfflinePlayer(JumperAPI.topList.get(0)).getUniqueId()));
            Score topList02 = boardContent.getScore("§e" + JumperAPI.topList.get(1) + "§8: §a" + JumperAPI.getHighscore(Bukkit.getOfflinePlayer(JumperAPI.topList.get(1)).getUniqueId()));
            Score topList03 = boardContent.getScore("§e" + JumperAPI.topList.get(2) + "§8: §a" + JumperAPI.getHighscore(Bukkit.getOfflinePlayer(JumperAPI.topList.get(2)).getUniqueId()));
            Score topList04 = boardContent.getScore("§e" + JumperAPI.topList.get(3) + "§8: §a" + JumperAPI.getHighscore(Bukkit.getOfflinePlayer(JumperAPI.topList.get(3)).getUniqueId()));
            Score topList05 = boardContent.getScore("§e" + JumperAPI.topList.get(4) + "§8: §a" + JumperAPI.getHighscore(Bukkit.getOfflinePlayer(JumperAPI.topList.get(4)).getUniqueId()));
            Score topList06 = boardContent.getScore("§e" + JumperAPI.topList.get(5) + "§8: §a" + JumperAPI.getHighscore(Bukkit.getOfflinePlayer(JumperAPI.topList.get(5)).getUniqueId()));
            Score topList07 = boardContent.getScore("§7[§8...§7]§");
            Score placeholder1 = boardContent.getScore("§1");
            Score highscoreTitle = boardContent.getScore("§f§lJumper§7§l-§f§lHighscore§8§l:");
            Score highscore = boardContent.getScore("§e"+j.getHighscore());
            Score placeholder2 = boardContent.getScore("§2");
            Score streakTitle = boardContent.getScore("§f§lServer§7§l-§f§lIP§8§l:");
            Score streak = boardContent.getScore("§ezyneonstudios.com");

            placeholder0.setScore(15);
            topList00.setScore(14);
            if(!topList01.isScoreSet()) {
                topList01.setScore(13);
            }
            if(!topList02.isScoreSet()) {
                topList02.setScore(12);
            }
            if(!topList03.isScoreSet()) {
                topList03.setScore(11);
            }
            if(!topList04.isScoreSet()) {
                topList04.setScore(10);
            }
            if(!topList05.isScoreSet()) {
                topList05.setScore(9);
            }
            if(!topList06.isScoreSet()) {
                topList06.setScore(8);
            }
            topList07.setScore(7);
            placeholder1.setScore(6);
            highscoreTitle.setScore(5);
            highscore.setScore(4);
            placeholder2.setScore(3);
            streakTitle.setScore(2);
            streak.setScore(1);

            Main.setPrefix(player);
        } else {
            if (!Nametags.noRenew.contains(player)) {
                Scoreboard board = player.getScoreboard();
                boolean hasScoreboard = true;
                File TempFile = new File("plugins/Lobbysystem/temp/" + player.getUniqueId().toString() + "_lobbysettings.temp");
                YamlConfiguration TF = YamlConfiguration.loadConfiguration(TempFile);
                if (TempFile.exists()) {
                    if (TF.contains("Settings.Scoreboard")) {
                        hasScoreboard = TF.getBoolean("Settings.Scoreboard");
                    }
                }
                if (hasScoreboard) {
                    Objective boardContent = board.getObjective("zyneon");
                    board.resetScores("zyneon");
                    Score zyneon = boardContent.getScore("§fServer§7-§fIP§8:");
                    boardContent.setDisplayName(API.animatedString());
                    Score zyneonContent = boardContent.getScore("§ezyneonstudios.com");
                    Score placeholder0 = boardContent.getScore("§0");
                    Score placeholder1 = boardContent.getScore("§1");
                    Score placeholder2 = boardContent.getScore("§2");
                    Score placeholder3 = boardContent.getScore("§3");
                    Score placeholder4 = boardContent.getScore("§4");
                    Score project = boardContent.getScore("§fProjekt§8:");
                    Score projectContent = boardContent.getScore("§e" + ConfigAPI.CFG.getString("Core.Compass.Names.Item01".replace("&", "§")));
                    Score rank = boardContent.getScore("§fRang§8:");
                    Score rankContent = boardContent.getScore("§e" + rankName(player));
                    Score time = boardContent.getScore("§fZeit§8:");
                    Score timeContent = boardContent.getScore("§e" + API.date);

                    Score jumperCount = boardContent.getScore("§fJumper§7-§fScore§8:");
                    Score jumperContent = boardContent.getScore("§e" + JumperAPI.getHighscore(player.getUniqueId()));
                    Score fishingCount = boardContent.getScore("§fAngel§7-§fScore§8:");
                    Score fishingContent = boardContent.getScore("§e" + PlayerAPI.fishingCount(player));

                    placeholder4.setScore(15);
                    if(API.showJumper) {
                        jumperCount.setScore(14);
                        jumperContent.setScore(13);
                        fishingCount.setScore(0);
                        fishingContent.setScore(0);
                    } else {
                        fishingCount.setScore(14);
                        fishingContent.setScore(13);
                        jumperCount.setScore(0);
                        jumperContent.setScore(0);
                    }
                    placeholder0.setScore(12);
                    time.setScore(11);
                    timeContent.setScore(10);
                    placeholder1.setScore(9);
                    project.setScore(8);
                    projectContent.setScore(7);
                    placeholder2.setScore(6);
                    rank.setScore(5);
                    rankContent.setScore(4);
                    placeholder3.setScore(3);
                    zyneon.setScore(2);
                    zyneonContent.setScore(1);
                }
            }
            Main.setPrefix(player);
        }
    }

    public static void renewScoreboard(Player player,boolean switchScore) {
        if(switchScore) {
            API.showJumper = !API.showJumper;
        }
        ScoreboardManager sm = Bukkit.getScoreboardManager();
        player.setScoreboard(sm.getNewScoreboard());
        boolean hasScoreboard = true;
        File TempFile = new File("plugins/Lobbysystem/temp/" + player.getUniqueId().toString() + "_lobbysettings.temp");
        YamlConfiguration TF = YamlConfiguration.loadConfiguration(TempFile);
        if(TempFile.exists()) {
            if(TF.contains("Settings.Scoreboard")) {
                hasScoreboard = TF.getBoolean("Settings.Scoreboard");
            }
        }
        Scoreboard board = player.getScoreboard();
        if(hasScoreboard&&!Nametags.noRenew.contains(player)) {
            if (board.getObjective("zyneon") == null) {
                board.registerNewObjective("zyneon", "zyneon");
            }
            Objective boardContent = board.getObjective("zyneon");
            boardContent.setDisplaySlot(DisplaySlot.SIDEBAR);
        }
        setScoreboard(player,true);
    }
}