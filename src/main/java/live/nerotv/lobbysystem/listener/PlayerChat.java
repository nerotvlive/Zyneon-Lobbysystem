package live.nerotv.lobbysystem.listener;

import com.zyneonstudios.api.paper.events.ZyneonChatEvent;
import live.nerotv.lobbysystem.api.API;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerChat implements Listener {

    @EventHandler
    public void onChat(ZyneonChatEvent e) {
        if(API.isStringBlocked(e.getMessage())) {
            e.setCancelled(true);
            Player p = e.getPlayer();
            p.sendMessage("§4Achtung:§c Achte auf deine Wortwahl, oder es wird eine Strafe mit sich führen.");
            p.playSound(p.getLocation(), Sound.ENTITY_BAT_DEATH,100,100);
            p.playSound(p.getLocation(), Sound.ENTITY_BLAZE_DEATH,100,100);
            p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK,100,100);
            API.sendConsoleMessage("§4"+p.getName()+"§c hat versucht §4\""+e.getMessage()+"§4\"§c zu schreiben, die Nachricht wurde aber blockiert!");
        }
    }
}