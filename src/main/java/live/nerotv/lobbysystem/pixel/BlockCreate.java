package live.nerotv.lobbysystem.pixel;

import live.nerotv.lobbysystem.api.API;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockCreate implements Listener {

    @EventHandler
    public void playerBlockEvent(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if(!API.canPlayerBuild(p)) {
            e.setCancelled(true);
            e.getBlockPlaced().setType(Material.AIR);
        }
    }
}