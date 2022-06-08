package live.nerotv.lobbysystem.commands;

import live.nerotv.lobbysystem.api.NewSound;
import live.nerotv.lobbysystem.api.PlayerAPI;
import live.nerotv.lobbysystem.api.WarpAPI;
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
                PlayerAPI.playNewSound(p,NewSound.ENTITY_CHICKEN_EGG);
            } else {
                s.sendMessage("§cDazu §4musst§c du ein Spieler sein§4!");
            }
        }
        return false;
    }
}