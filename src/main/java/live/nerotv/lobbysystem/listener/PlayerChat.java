package live.nerotv.lobbysystem.listener;

import live.nerotv.lobbysystem.Main;
import live.nerotv.lobbysystem.api.API;
import live.nerotv.lobbysystem.api.PlayerAPI;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChat implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        Main.setPrefix(p);
        String Name;
        if(p.hasPermission("zyneon.team")) {
            Name = "§9Team §8● §f" + p.getName();
        } else if(p.hasPermission("zyneon.creator")) {
            Name = "§9Creator §8● §f" + p.getName();
        } else if(p.hasPermission("zyneon.premium")) {
            Name = "§9Premium §8● §f"+p.getName();
        } else {
            Name = "§9User §8● §f"+p.getName();
        }
        String MSG;
        if(p.hasPermission("zyneon.team")) {
            MSG = e.getMessage().replace("&","§");
        } else {
            MSG = e.getMessage();
        }
        MSG = MSG.replace("%","%%");
        if(API.isStringBlocked(MSG)) {
            e.setCancelled(true);
            p.sendMessage("§4Achtung:§c Achte auf deine Wortwahl, oder es wird eine Strafe mit sich führen.");
            p.playSound(p.getLocation(), Sound.ENTITY_BAT_DEATH,100,100);
            p.playSound(p.getLocation(), Sound.ENTITY_BLAZE_DEATH,100,100);
            p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK,100,100);
            API.sendConsoleMessage("§4"+p.getName()+"§c hat versucht §4\""+MSG+"§4\"§c zu schreiben, die Nachricht wurde aber blockiert!");
        } else {
            e.setFormat("%name%§8 » §7%msg%".replace("%name%", Name).replace("%msg%", MSG));
        }
    }
}