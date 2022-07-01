package live.nerotv.lobbysystem.listener;

import live.nerotv.lobbysystem.api.API;
import live.nerotv.lobbysystem.api.PlayerAPI;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

import java.util.concurrent.ThreadLocalRandom;

public class PlayerFishing implements Listener {

    @EventHandler
    public void onFish(PlayerFishEvent e) {
        if(e.getCaught()!=null) {
            if(!(e.getCaught() instanceof Player)) {
                Player p = e.getPlayer();
                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP,100,100);
                int i = ThreadLocalRandom.current().nextInt(2, 12 + 1);
                API.sendMessage(p, "§7Du hast einen Fisch gefangen§8! §d+" + i + " Angelscore");
                PlayerAPI.updateFishingCount(p, i);
                e.getCaught().remove();
                PlayerAPI.renewScoreboard(p,false);
            }
        }
    }
}