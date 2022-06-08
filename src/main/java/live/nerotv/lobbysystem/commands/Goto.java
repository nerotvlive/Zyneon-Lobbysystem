package live.nerotv.lobbysystem.commands;

import live.nerotv.lobbysystem.api.API;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Goto implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("goto")) {
            if(s instanceof Player) {
                Player p = (Player)s;
                if(p.hasPermission("zyneon.team")) {
                    if (args.length == 0) {
                        API.sendErrorMessage(p, "§4Fehler:§c /goto [Server]");
                    } else {
                        API.switchServer(p, args[0]);
                    }
                }
            } else {
                s.sendMessage("§cDazu §4musst§c du ein Spieler sein§4!");
            }
        }
        return false;
    }
}
