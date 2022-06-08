package live.nerotv.lobbysystem.commands;

import live.nerotv.lobbysystem.api.API;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Friends implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("Friends")) {
            if(s instanceof Player) {
                Player p = (Player)s;
                if(args.length == 1) {
                    if(args[0].equalsIgnoreCase("hide")) {
                        API.sendErrorMessage(p,"§cDas §4Spieler-Verstecken§c Tool funktioniert leider zurzeit nicht§8! §cWir arbeiten an einer neuen Oberfläche und einem neuen Freundesystem§8, §cwomit auch dieses Tool wiederkommen wird§8!");
                        return false;
                    }
                }
                API.sendErrorMessage(p,"§cNutze bitte den §4/friends §cBefehl§8,§c wir arbeiten bereits an einer neuen Oberfläche mit einem komplett neuen §4Freundesystem§8.");
            } else {
                API.sendErrorMessage(s,"§cDazu §4musst§c du ein Spieler sein§8!");
            }
        }
        return false;
    }
}