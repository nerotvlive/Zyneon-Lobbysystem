package live.nerotv.lobbysystem.listener;

import dev.geco.gsit.api.event.PlayerGetUpSitEvent;
import dev.geco.gsit.api.event.PlayerSitEvent;
import live.nerotv.lobbysystem.api.API;
import live.nerotv.lobbysystem.cosmetics.CosItemManager;
import live.nerotv.lobbysystem.manager.ItemManager;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.UUID;

public class PlayerSit implements Listener {

    @EventHandler
    public void onSit(PlayerSitEvent e) {
        Player p = e.getPlayer();
        Location loc = e.getSeat().getLocation();
        loc = new Location(loc.getWorld(),loc.getBlockX(),loc.getBlockY(),loc.getBlockZ());
        ArrayList<Location> locs = new ArrayList<>();
        locs.add(new Location(p.getWorld(),117,15,-110));
        locs.add(new Location(p.getWorld(),-677,63,-558));
        locs.add(new Location(p.getWorld(),-3060, 63, -633));
        locs.add(new Location(p.getWorld(),-969727,67,-969708));
        locs.add(new Location(p.getWorld(),30429,64,-10129));
        locs.add(new Location(p.getWorld(),-109,63,-327));
        locs.add(new Location(p.getWorld(),-59,64,-363));
        locs.add(new Location(p.getWorld(),-61,64,-363));
        locs.add(new Location(p.getWorld(),151,13,-60));
        locs.add(new Location(p.getWorld(),192,13,-172));
        locs.add(new Location(p.getWorld(),-234,3,237));
        locs.add(new Location(p.getWorld(),-195,3,156));
        locs.add(new Location(p.getWorld(),-238,3,217));
        locs.add(new Location(p.getWorld(),-200,3,158));
        if(locs.contains(loc)) {
            doFishEvent(p);
        }
    }

    private void doFishEvent(Player p) {
        p.getInventory().clear(0);
        p.getInventory().clear(1);
        p.getInventory().clear(2);
        p.getInventory().clear(3);
        p.getInventory().clear(4);
        p.getInventory().clear(5);
        p.getInventory().clear(6);
        p.getInventory().clear(7);
        p.getInventory().clear(8);
        ItemStack rod = new ItemStack(Material.FISHING_ROD);
        ItemMeta rodMeta = rod.getItemMeta();
        rodMeta.setUnbreakable(true);
        if(p.getUniqueId().equals(UUID.fromString("b9e0e4fa-69a1-49fe-93a6-05afe249639d"))) {
            rodMeta.setDisplayName("angeltvlive");
            rodMeta.setCustomModelData(2);
            rod.setItemMeta(rodMeta);
            p.getInventory().setItem(4, rod);
            p.getInventory().setHeldItemSlot(4);
        } else if(p.getUniqueId().equals(UUID.fromString("6447757f-59fe-4206-ae3f-dc68ff2bb6f0"))||p.getUniqueId().equals(UUID.fromString("30763b46-76ad-488c-b53a-0f71d402e9be"))) {
            rodMeta.setDisplayName("angeltastico");
            rodMeta.setCustomModelData(1);
            rod.setItemMeta(rodMeta);
            p.getInventory().setItem(4, rod);
            p.getInventory().setHeldItemSlot(4);
        } else {
            rod.setItemMeta(rodMeta);
            p.getInventory().setItem(4, CosItemManager.getGlowStack(rod));
            p.getInventory().setHeldItemSlot(4);
        }
    }

    @EventHandler
    public void onExit(PlayerGetUpSitEvent e) {
        Player p = e.getPlayer();
        ItemManager.giveItems(p);
    }
}