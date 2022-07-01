package live.nerotv.lobbysystem.pixel;

import live.nerotv.lobbysystem.api.API;
import live.nerotv.lobbysystem.manager.ItemManager;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PixelInteract implements Listener {

    @EventHandler
    public void onPixelInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if(p.getWorld().getName().equals("pixels")) {
            if (!API.canPlayerBuild(p)) {
                if (e.getItem() != null) {
                    ItemStack item = e.getItem();
                    if (item.getItemMeta() != null) {
                        if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                            e.setCancelled(true);
                            if(item.getItemMeta().getDisplayName().equals(ItemManager.slimeLobby.getItemMeta().getDisplayName())) {
                                return;
                            }
                            if (e.getClickedBlock() != null) {
                                if(e.getClickedBlock().getY()==2) {
                                    Material existingBlock = e.getClickedBlock().getType();
                                    Material placedBlock = item.getType();
                                    if (!existingBlock.equals(Material.BARRIER)) {
                                        if (placedBlock == existingBlock) {
                                            API.beleidigeUser(p);
                                        } else {
                                            e.getClickedBlock().setType(placedBlock);
                                            p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG,100,100);
                                        }
                                    }
                                } else if(e.getClickedBlock().getY()>2) {
                                    if(!e.getClickedBlock().getType().equals(Material.BARRIER)) {
                                        e.getClickedBlock().setType(Material.AIR);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}