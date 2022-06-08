package live.nerotv.lobbysystem.commands;

import live.nerotv.lobbysystem.manager.GUIManager;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Settings implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if(s instanceof Player) {
            Player p = (Player)s;
            GUIManager.openSettingsInventory(p);
            p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG,100,100);
        }
        return false;
    }
}
