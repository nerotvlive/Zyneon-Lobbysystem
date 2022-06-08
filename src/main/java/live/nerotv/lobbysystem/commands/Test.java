package live.nerotv.lobbysystem.commands;

import live.nerotv.lobbysystem.api.API;
import live.nerotv.lobbysystem.jumper.JumperAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ThreadLocalRandom;

public class Test implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender s, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        API.sendErrorMessage(s,"§cZurzeit gibt es nichts zum testen§8!");
        if(s instanceof Player p) {
            if(p.getName().equalsIgnoreCase("nerotvlive")) {
                int i = ThreadLocalRandom.current().nextInt(3,17);
                JumperAPI.getTopList();
                JumperAPI.setHighscore(p.getUniqueId(),JumperAPI.getHighscore(Bukkit.getOfflinePlayer(JumperAPI.topList.get(0)).getUniqueId())+i);
            }
        }
        return false;
    }
}