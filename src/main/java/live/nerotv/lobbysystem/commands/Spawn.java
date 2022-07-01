package live.nerotv.lobbysystem.commands;

import live.nerotv.lobbysystem.api.PlayerAPI;
import live.nerotv.lobbysystem.api.WarpAPI;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Spawn implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("spawn")) {
            if(s instanceof Player) {
                Player p = (Player)s;
                p.teleport(WarpAPI.getWarp("Spawn"));
                p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG,100,100);
            } else {
                s.sendMessage("§cDazu §4musst§c du ein Spieler sein§4!");
            }
        }
        return false;
    }
}