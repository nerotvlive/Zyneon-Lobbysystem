package live.nerotv.lobbysystem.commands;

import com.zyneonstudios.api.paper.Zyneon;
import com.zyneonstudios.api.paper.utils.user.User;
import com.zyneonstudios.api.utils.Strings;
import live.nerotv.lobbysystem.api.API;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Broadcast implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("Broadcast")) {
            if(!(s instanceof Player p)) {
                if(args.length == 0) {
                    s.sendMessage("§4Fehler: §c/broadcast [Nachricht]");
                } else {
                    String m="";
                    for(int i=0;i<args.length;i++) {
                        m=m+args[i]+" ";
                    }
                    for(Player all:Bukkit.getOnlinePlayers()) {
                        all.playSound(all.getLocation(),Sound.ENTITY_CHICKEN_EGG,100,100);
                        all.sendMessage("§cWichtig §8| §f"+m.replace("&","§"));
                    }
                    Bukkit.getConsoleSender().sendMessage("§cWichtig §8| §f"+m.replace("&","§"));
                }
            } else {
                User u = Zyneon.getAPI().getOnlineUser(p.getUniqueId());
                if(p.hasPermission("zyneon.team")) {
                    if(args.length == 0) {
                        p.sendMessage("§4Fehler: §c/broadcast [Nachricht]");
                        p.playSound(p.getLocation(),Sound.BLOCK_ANVIL_BREAK,100,100);
                    } else {
                        String m="";
                        for(int i=0;i<args.length;i++) {
                            m=m+args[i]+" ";
                        }
                        for(Player all:Bukkit.getOnlinePlayers()) {
                            all.playSound(all.getLocation(),Sound.ENTITY_CHICKEN_EGG,100,100);
                            all.sendMessage("§cWichtig §8| §f"+m.replace("&","§"));
                        }
                        Bukkit.getConsoleSender().sendMessage("§cWichtig §8| §f"+m.replace("&","§"));
                    }
                } else {
                    u.sendErrorMessage(Strings.noPerms());
                }
            }
        }
        return false;
    }
}