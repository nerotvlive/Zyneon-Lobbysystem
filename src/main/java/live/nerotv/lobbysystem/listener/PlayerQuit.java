package live.nerotv.lobbysystem.listener;

import live.nerotv.lobbysystem.Main;
import live.nerotv.lobbysystem.jumper.Jumper;
import live.nerotv.lobbysystem.jumper.JumperAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        for(Player all : Bukkit.getOnlinePlayers()) {
            Main.setPrefix(all);
        }
        if(JumperAPI.Jumpers.containsKey(p)) {
            Jumper j = JumperAPI.Jumpers.get(p);
            j.fail();
        }
        p.setPlayerListHeader("§0");
        p.setPlayerListFooter("§0");
        e.setQuitMessage("§8« §c"+p.getName());
    }
}