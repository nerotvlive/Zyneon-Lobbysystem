package live.nerotv.lobbysystem.jumper;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class JumperMoveEvent implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        if(JumperAPI.Jumpers.containsKey(e.getPlayer())) {
            Player p = e.getPlayer();
            Jumper j = JumperAPI.Jumpers.get(p);
            if(j.isActive()) {
                Location current = j.getCurrentLocation();
                Location next = j.getNextLocation();
                if (p.getLocation().getBlockY() < current.getBlockY()) {
                    j.fail();
                }
                Location goal = new Location(next.getWorld(), next.getBlockX(), next.getBlockY() + 1, next.getBlockZ());
                Location playerCurrent = new Location(p.getWorld(), p.getLocation().getBlockX(), p.getLocation().getBlockY(), p.getLocation().getBlockZ());
                if (goal.equals(playerCurrent)) {
                    j.increaseStreak();
                    p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG,50,50);
                    p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP,50,50);
                    current = next;
                    next = JumperAPI.nextLoc(current);
                    current.getBlock().setType(j.getCurrentBlock());
                    next.getBlock().setType(j.getNextBlock());
                    j.setNextLocation(next);
                }
            }
        }
    }

    @EventHandler
    public void onWorldChange(PlayerChangedWorldEvent e) {
        if(JumperAPI.Jumpers.containsKey(e.getPlayer())) {
            JumperAPI.Jumpers.get(e.getPlayer()).fail();
        }
    }
}