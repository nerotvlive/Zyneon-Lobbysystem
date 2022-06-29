package live.nerotv.lobbysystem.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Pixels implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("pixels")) {
            if(s instanceof Player) {
                Player p = (Player)s;
                p.teleport(Bukkit.getServer().getWorld("pixels").getSpawnLocation());
                p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 100, 100);
            } else {
                s.sendMessage("§cDazu §4musst§c du ein Spieler sein§4!");
            }
        }
        return false;
    }
}
