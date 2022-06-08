package live.nerotv.lobbysystem.commands;

import live.nerotv.lobbysystem.Main;
import live.nerotv.lobbysystem.api.API;
import live.nerotv.lobbysystem.api.PlayerAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Nametags implements CommandExecutor {

    public static ArrayList<Player> noRenew = new ArrayList<>();

    @Override
    public boolean onCommand(@NotNull CommandSender s, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if(cmd.getName().equalsIgnoreCase("Nametags")) {
            if(s instanceof Player) {
                Player p = (Player)s;
                if(p.hasPermission("zyneon.leading")) {
                    if(API.showNametags) {
                        API.showNametags = false;
                        for(Player all : Bukkit.getOnlinePlayers()) {
                            Main.setPrefix(all);
                            PlayerAPI.renewScoreboard(all,false);
                            if(!noRenew.contains(all)) {
                                noRenew.add(all);
                            }
                            Scoreboard Scoreboard = all.getScoreboard();
                            Scoreboard.getTeam("00000Team").setOption(Team.Option.NAME_TAG_VISIBILITY, Team.OptionStatus.NEVER);
                            Scoreboard.getTeam("01Creator").setOption(Team.Option.NAME_TAG_VISIBILITY, Team.OptionStatus.NEVER);
                            Scoreboard.getTeam("02Premium").setOption(Team.Option.NAME_TAG_VISIBILITY, Team.OptionStatus.NEVER);
                            Scoreboard.getTeam("03Spieler").setOption(Team.Option.NAME_TAG_VISIBILITY, Team.OptionStatus.NEVER);
                        }
                    } else {
                        API.showNametags = true;
                        for(Player all : Bukkit.getOnlinePlayers()) {
                            Main.setPrefix(all);
                            PlayerAPI.renewScoreboard(all,false);
                            Scoreboard Scoreboard = all.getScoreboard();
                            Scoreboard.getTeam("00000Team").setOption(Team.Option.NAME_TAG_VISIBILITY, Team.OptionStatus.ALWAYS);
                            Scoreboard.getTeam("01Creator").setOption(Team.Option.NAME_TAG_VISIBILITY, Team.OptionStatus.ALWAYS);
                            Scoreboard.getTeam("02Premium").setOption(Team.Option.NAME_TAG_VISIBILITY, Team.OptionStatus.ALWAYS);
                            Scoreboard.getTeam("03Spieler").setOption(Team.Option.NAME_TAG_VISIBILITY, Team.OptionStatus.ALWAYS);
                            if(noRenew.contains(all)) {
                                noRenew.remove(all);
                            }
                        }
                    }
                    API.sendMessage(p,"§7Die §aNametag-Sichtbarkeit§7 steht nun auf§8: §e"+API.showNametags);
                } else {
                    API.sendErrorMessage(p,API.noPerms);
                }
            } else {
                API.sendErrorMessage(s,"§cDazu §4musst§c du ein Spieler sein!");
            }
        }
        return false;
    }
}