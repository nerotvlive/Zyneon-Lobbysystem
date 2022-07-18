package live.nerotv.lobbysystem.commands;

import live.nerotv.lobbysystem.api.API;
import live.nerotv.lobbysystem.api.PlayerAPI;
import live.nerotv.lobbysystem.jumper.JumperAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Jumper implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender s, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if(cmd.getName().equalsIgnoreCase("Jumper")) {
            if(s instanceof Player p) {
                if(JumperAPI.Jumpers.containsKey(p)) {
                    API.sendErrorMessage(p,"§cDu spielst bereits einen Jumper§8!");
                } else {
                    API.sendMessage(p,"§7Viel Spaß beim Spielen von §9Jumper§8!");
                    new live.nerotv.lobbysystem.jumper.Jumper(p);
                    PlayerAPI.renewScoreboard(p,false);
                }
            } else {
                API.sendErrorMessage(s,"§cDazu §4musst§c du ein §4Spieler§c sein§8!");
            }
        }
        return false;
    }
}