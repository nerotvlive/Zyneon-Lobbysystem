package live.nerotv.lobbysystem.commands;

import live.nerotv.lobbysystem.manager.GUIManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Back implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("back")) {
            if(s instanceof Player) {
                Player p = (Player)s;
                if(p.getWorld().getName().equalsIgnoreCase("pixels")) {
                    GUIManager.openBackToLobbyInventory(p);
                } else {
                    p.performCommand("neino");
                }
            } else {
                s.sendMessage("§cDazu §4musst§c du ein Spieler sein§4!");
            }
        }
        return false;
    }
}
