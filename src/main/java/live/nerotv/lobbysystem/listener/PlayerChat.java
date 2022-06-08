package live.nerotv.lobbysystem.listener;

import live.nerotv.lobbysystem.Main;
import live.nerotv.lobbysystem.api.API;
import live.nerotv.lobbysystem.api.NewSound;
import live.nerotv.lobbysystem.api.PlayerAPI;
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
            Name = "§5Team §8● §f" + p.getName();
        } else if(p.hasPermission("zyneon.creator")) {
            Name = "§5Creator §8● §f" + p.getName();
        } else if(p.hasPermission("zyneon.premium")) {
            Name = "§dPremium §8● §f"+p.getName();
        } else {
            Name = "§dUser §8● §f"+p.getName();
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
            PlayerAPI.playNewSound(p,NewSound.ENTITY_BAT_DEATH);
            PlayerAPI.playNewSound(p,NewSound.ENTITY_BLAZE_DEATH);
            PlayerAPI.playNewSound(p, NewSound.BLOCK_ANVIL_BREAK);
            API.sendConsoleMessage("§4"+p.getName()+"§c hat versucht §4\""+MSG+"§4\"§c zu schreiben, die Nachricht wurde aber blockiert!");
        } else {
            e.setFormat("%name%§8 » §7%msg%".replace("%name%", Name).replace("%msg%", MSG));
        }
    }
}