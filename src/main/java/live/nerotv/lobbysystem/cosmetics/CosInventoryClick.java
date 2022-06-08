package live.nerotv.lobbysystem.cosmetics;

import live.nerotv.lobbysystem.api.API;
import live.nerotv.lobbysystem.manager.ItemManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CosInventoryClick implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onInventoryClick(InventoryClickEvent e) {
        Player p = (Player)e.getWhoClicked();
        if(e.getCurrentItem()!=null) {
            ItemStack item = e.getCurrentItem();
            if(item.getItemMeta()!=null) {
                ItemMeta itemMeta = item.getItemMeta();
                String itemName = itemMeta.getDisplayName();
                if(itemName.equals(ItemManager.Cosmetics.getItemMeta().getDisplayName())) {
                    e.setCancelled(true);
                    p.closeInventory();
                    CosGUIManager.openCosmeticsInventory(p);
                } else if(itemName.equals(CosItemManager.hats.getItemMeta().getDisplayName())) {
                    e.setCancelled(true);
                    p.closeInventory();
                    CosGUIManager.openSkullInventory(p);
                } else if(itemName.equals("§anerotvlive§8'§as §7Kopf")) {
                    e.setCancelled(true);
                    ItemManager.giveItems(p);
                    if(!p.hasPermission("zyneon.cosmetics.skull.nerotvlive")) {
                        API.sendErrorMessage(p,API.noPerms);
                    } else {
                        p.getInventory().setHelmet(CosItemManager.nerotvliveSkull(true));
                        API.sendMessage(p, "Du trägst nun den Kopf von §anerotvlive§8.");
                        p.closeInventory();
                    }
                } else if(itemName.equals("§aFantasticoTV§8'§as §7Kopf")) {
                    e.setCancelled(true);
                    ItemManager.giveItems(p);
                    if(!p.hasPermission("zyneon.cosmetics.skull.fantasticotv")) {
                        API.sendErrorMessage(p,API.noPerms);
                    } else {
                        p.getInventory().setHelmet(CosItemManager.fantasticotvSkull(true));
                        API.sendMessage(p, "Du trägst nun den Kopf von §aFantasticoTV§8.");
                        p.closeInventory();
                    }
                } else if(itemName.equals("§aadd_West§8'§as §7Kopf")) {
                    e.setCancelled(true);
                    ItemManager.giveItems(p);
                    if(!p.hasPermission("zyneon.cosmetics.skull.add_west")) {
                        API.sendErrorMessage(p,API.noPerms);
                    } else {
                        p.getInventory().setHelmet(CosItemManager.add_westSkull(true));
                        API.sendMessage(p, "Du trägst nun den Kopf von §aadd_West§8.");
                        p.closeInventory();
                    }
                } else if(itemName.equals("§aideallauch§8'§as §7Kopf")) {
                    e.setCancelled(true);
                    ItemManager.giveItems(p);
                    if(!p.hasPermission("zyneon.cosmetics.skull.ideallauch")) {
                        API.sendErrorMessage(p,API.noPerms);
                    } else {
                        p.getInventory().setHelmet(CosItemManager.ideallauchSkull(true));
                        API.sendMessage(p, "Du trägst nun den Kopf von §aideallauch§8.");
                        p.closeInventory();
                    }
                } else if(itemName.equals("§aSchleimerHD§8'§as §7Kopf")) {
                    e.setCancelled(true);
                    ItemManager.giveItems(p);
                    if(!p.hasPermission("zyneon.cosmetics.skull.schleimerhd")) {
                        API.sendErrorMessage(p,API.noPerms);
                    } else {
                        p.getInventory().setHelmet(CosItemManager.schleimerSkull(true));
                        API.sendMessage(p, "Du trägst nun den Kopf von §aSchleimerHD§8.");
                        p.closeInventory();
                    }
                } else if(itemName.equals("§aAttisander§8'§as §7Kopf")) {
                    e.setCancelled(true);
                    ItemManager.giveItems(p);
                    p.getInventory().setHelmet(CosItemManager.attisanderSkull(true));
                    API.sendMessage(p, "Du trägst nun den Kopf von §aAttisander§8.");
                    p.closeInventory();
                } else if(itemName.equals("§aungespielt§8'§as §7Kopf")) {
                    e.setCancelled(true);
                    ItemManager.giveItems(p);
                    if(!p.hasPermission("zyneon.cosmetics.skull.ungespielt")) {
                        API.sendErrorMessage(p,API.noPerms);
                    } else {
                        p.getInventory().setHelmet(CosItemManager.ungeSkull(true));
                        API.sendMessage(p, "Du trägst nun den Kopf von §aungespielt§8.");
                        p.closeInventory();
                    }
                } else if(itemName.equals("§aMercy21718§8'§as §7Kopf")) {
                    e.setCancelled(true);
                    ItemManager.giveItems(p);
                    if(!p.hasPermission("zyneon.cosmetics.skull.Mercy21718")) {
                        API.sendErrorMessage(p,API.noPerms);
                    } else {
                        p.getInventory().setHelmet(CosItemManager.mercySkull(true));
                        API.sendMessage(p, "Du trägst nun den Kopf von §aMercy21718§8.");
                        p.closeInventory();
                    }
                } else if(itemName.equals("§aHerrBergmann§8'§as §7Kopf")) {
                    e.setCancelled(true);
                    ItemManager.giveItems(p);
                    if(!p.hasPermission("zyneon.cosmetics.skull.herrbergmann")) {
                        API.sendErrorMessage(p,API.noPerms);
                    } else {
                        p.getInventory().setHelmet(CosItemManager.herrbergmannSkull(true));
                        API.sendMessage(p, "Du trägst nun den Kopf von §aHerrBergmann§8.");
                        p.closeInventory();
                    }
                } else if(itemName.equals("§aMaxi15122§8'§as §7Kopf")) {
                    e.setCancelled(true);
                    ItemManager.giveItems(p);
                    if(!p.hasPermission("zyneon.cosmetics.skull.Maxi15122")) {
                        API.sendErrorMessage(p,API.noPerms);
                    } else {
                        p.getInventory().setHelmet(CosItemManager.pauulSkull(true));
                        API.sendMessage(p, "Du trägst nun den Kopf von §aMaxi15122§8.");
                        p.closeInventory();
                    }
                } else if(itemName.equals("§aSchwammkopf")) {
                    e.setCancelled(true);
                    ItemManager.giveItems(p);
                    if(!p.hasPermission("zyneon.cosmetics.hat.sponge")) {
                        API.sendErrorMessage(p,API.noPerms);
                    } else {
                        p.getInventory().setHelmet(CosItemManager.spongeHat(true));
                        API.sendMessage(p, "Du trägst nun den §aSchwammkopf§8.");
                        p.closeInventory();
                    }
                } else if(itemName.equals("§aGlaskopf")) {
                    e.setCancelled(true);
                    ItemManager.giveItems(p);
                    if(!p.hasPermission("zyneon.cosmetics.hat.glass")) {
                        API.sendErrorMessage(p,API.noPerms);
                    } else {
                        p.getInventory().setHelmet(CosItemManager.glassHat(true));
                        API.sendMessage(p, "Du trägst nun den §aGlaskopf§8.");
                        p.closeInventory();
                    }
                } else if(itemName.equals("§aMusikbox")) {
                    e.setCancelled(true);
                    ItemManager.giveItems(p);
                    if(!p.hasPermission("zyneon.cosmetics.hat.music")) {
                        API.sendErrorMessage(p,API.noPerms);
                    } else {
                        p.getInventory().setHelmet(CosItemManager.musicHat(true));
                        API.sendMessage(p, "Du trägst nun den §aMusikbox-Kopf§8.");
                        p.closeInventory();
                    }
                } else if(itemName.equals("§aTNT")) {
                    e.setCancelled(true);
                    ItemManager.giveItems(p);
                    if(!p.hasPermission("zyneon.cosmetics.hat.tnt")) {
                        API.sendErrorMessage(p,API.noPerms);
                    } else {
                        p.getInventory().setHelmet(CosItemManager.explosiveHat(true));
                        API.sendMessage(p, "Du trägst nun den §aTNT-Kopf§8.");
                        p.closeInventory();
                    }
                } else if(itemName.equals("§aKürbislaterne")) {
                    e.setCancelled(true);
                    ItemManager.giveItems(p);
                    if(!p.hasPermission("zyneon.cosmetics.hat.pumpkin")) {
                        API.sendErrorMessage(p,API.noPerms);
                    } else {
                        p.getInventory().setHelmet(CosItemManager.pumpkinHat(true));
                        API.sendMessage(p, "Du trägst nun den §aKürbislaternen-Kopf§8.");
                        p.closeInventory();
                    }
                } else if(itemName.equals("§aBücherkopf")) {
                    e.setCancelled(true);
                    ItemManager.giveItems(p);
                    if(!p.hasPermission("zyneon.cosmetics.hat.book")) {
                        API.sendErrorMessage(p,API.noPerms);
                    } else {
                        p.getInventory().setHelmet(CosItemManager.bookHat(true));
                        API.sendMessage(p, "Du trägst nun den §aBücherkopf§8.");
                        p.closeInventory();
                    }
                } else if(itemName.equals("§aMelonenkopf")) {
                    e.setCancelled(true);
                    ItemManager.giveItems(p);
                    if(!p.hasPermission("zyneon.cosmetics.hat.melon")) {
                        API.sendErrorMessage(p,API.noPerms);
                    } else {
                        p.getInventory().setHelmet(CosItemManager.melonHat(true));
                        API.sendMessage(p, "Du trägst nun den §aMelonenkopf§8.");
                        p.closeInventory();
                    }
                } else if(itemName.equals("§aSchildkrötenhelm")) {
                    e.setCancelled(true);
                    ItemManager.giveItems(p);
                    if(!p.hasPermission("zyneon.cosmetics.helmet.turtle")) {
                        API.sendErrorMessage(p,API.noPerms);
                    } else {
                        p.getInventory().setHelmet(CosItemManager.turtleHelmet(true));
                        API.sendMessage(p, "Du trägst nun den §aSchildkrötenhelm§8.");
                        p.closeInventory();
                    }
                } else if(itemName.equals("§aLederhelm")) {
                    e.setCancelled(true);
                    ItemManager.giveItems(p);
                    if(!p.hasPermission("zyneon.cosmetics.helmet.leather")) {
                        API.sendErrorMessage(p,API.noPerms);
                    } else {
                        p.getInventory().setHelmet(CosItemManager.leatherHelmet(true));
                        API.sendMessage(p, "Du trägst nun den §aLederhelm§8.");
                        p.closeInventory();
                    }
                } else if(itemName.equals("§aKettenhelm")) {
                    e.setCancelled(true);
                    ItemManager.giveItems(p);
                    if(!p.hasPermission("zyneon.cosmetics.helmet.chain")) {
                        API.sendErrorMessage(p,API.noPerms);
                    } else {
                        p.getInventory().setHelmet(CosItemManager.chainHelmet(true));
                        API.sendMessage(p, "Du trägst nun den §aKettenhelm§8.");
                        p.closeInventory();
                    }
                } else if(itemName.equals("§aEisenhelm")) {
                    e.setCancelled(true);
                    ItemManager.giveItems(p);
                    if(!p.hasPermission("zyneon.cosmetics.helmet.iron")) {
                        API.sendErrorMessage(p,API.noPerms);
                    } else {
                        p.getInventory().setHelmet(CosItemManager.ironHelmet(true));
                        API.sendMessage(p, "Du trägst nun den §aEisenhelm§8.");
                        p.closeInventory();
                    }
                } else if(itemName.equals("§aGoldhelm")) {
                    e.setCancelled(true);
                    ItemManager.giveItems(p);
                    if(!p.hasPermission("zyneon.cosmetics.helmet.gold")) {
                        API.sendErrorMessage(p,API.noPerms);
                    } else {
                        p.getInventory().setHelmet(CosItemManager.goldHelmet(true));
                        API.sendMessage(p, "Du trägst nun den §aGoldhelm§8.");
                        p.closeInventory();
                    }
                } else if(itemName.equals("§aDiamanthelm")) {
                    e.setCancelled(true);
                    ItemManager.giveItems(p);
                    if(!p.hasPermission("zyneon.cosmetics.helmet.diamond")) {
                        API.sendErrorMessage(p,API.noPerms);
                    } else {
                        p.getInventory().setHelmet(CosItemManager.diamondHelmet(true));
                        API.sendMessage(p, "Du trägst nun den §aDiamanthelm§8.");
                        p.closeInventory();
                    }
                } else if(itemName.equals("§aNetherithelm")) {
                    e.setCancelled(true);
                    ItemManager.giveItems(p);
                    if(!p.hasPermission("zyneon.cosmetics.helmet.netherite")) {
                        API.sendErrorMessage(p,API.noPerms);
                    } else {
                        p.getInventory().setHelmet(CosItemManager.netheriteHelmet(true));
                        API.sendMessage(p, "Du trägst nun den §aNetherithelm§8.");
                        p.closeInventory();
                    }
                } else if(itemName.equals("§aLederharnisch")) {
                    e.setCancelled(true);
                    ItemManager.giveItems(p);
                    if(!p.hasPermission("zyneon.cosmetics.chests.leather")) {
                        API.sendErrorMessage(p,API.noPerms);
                    } else {
                        p.getInventory().setChestplate(CosItemManager.leatherChest(true));
                        API.sendMessage(p, "Du trägst nun den §aLederharnisch§8.");
                        p.closeInventory();
                    }
                } else if(itemName.equals("§aKettenharnisch")) {
                    e.setCancelled(true);
                    ItemManager.giveItems(p);
                    if(!p.hasPermission("zyneon.cosmetics.chests.chain")) {
                        API.sendErrorMessage(p,API.noPerms);
                    } else {
                        p.getInventory().setChestplate(CosItemManager.chainChest(true));
                        API.sendMessage(p, "Du trägst nun den §aKettenharnisch§8.");
                        p.closeInventory();
                    }
                } else if(itemName.equals("§aEisenharnisch")) {
                    e.setCancelled(true);
                    ItemManager.giveItems(p);
                    if(!p.hasPermission("zyneon.cosmetics.chests.iron")) {
                        API.sendErrorMessage(p,API.noPerms);
                    } else {
                        p.getInventory().setChestplate(CosItemManager.ironChest(true));
                        API.sendMessage(p, "Du trägst nun den §aEisenharnisch§8.");
                        p.closeInventory();
                    }
                } else if(itemName.equals("§aGoldharnisch")) {
                    e.setCancelled(true);
                    ItemManager.giveItems(p);
                    if(!p.hasPermission("zyneon.cosmetics.chests.gold")) {
                        API.sendErrorMessage(p,API.noPerms);
                    } else {
                        p.getInventory().setChestplate(CosItemManager.goldChest(true));
                        API.sendMessage(p, "Du trägst nun den §aGoldharnisch§8.");
                        p.closeInventory();
                    }
                } else if(itemName.equals("§aDiamantharnisch")) {
                    e.setCancelled(true);
                    ItemManager.giveItems(p);
                    if(!p.hasPermission("zyneon.cosmetics.chests.diamond")) {
                        API.sendErrorMessage(p,API.noPerms);
                    } else {
                        p.getInventory().setChestplate(CosItemManager.diamondChest(true));
                        API.sendMessage(p, "Du trägst nun den §aDiamantharnisch§8.");
                        p.closeInventory();
                    }
                } else if(itemName.equals("§aNetheritharnisch")) {
                    e.setCancelled(true);
                    ItemManager.giveItems(p);
                    if(!p.hasPermission("zyneon.cosmetics.chests.netherite")) {
                        API.sendErrorMessage(p,API.noPerms);
                    } else {
                        p.getInventory().setChestplate(CosItemManager.netheriteChest(true));
                        API.sendMessage(p, "Du trägst nun den §aNetheritharnisch§8.");
                        p.closeInventory();
                    }
                } else if(itemName.equals("§aLederhose")) {
                    e.setCancelled(true);
                    ItemManager.giveItems(p);
                    if(!p.hasPermission("zyneon.cosmetics.leggings.leather")) {
                        API.sendErrorMessage(p,API.noPerms);
                    } else {
                        p.getInventory().setLeggings(CosItemManager.leatherLeggings(true));
                        API.sendMessage(p, "Du trägst nun den §aLederhose§8.");
                        p.closeInventory();
                    }
                } else if(itemName.equals("§aKettenhose")) {
                    e.setCancelled(true);
                    ItemManager.giveItems(p);
                    if(!p.hasPermission("zyneon.cosmetics.leggings.chain")) {
                        API.sendErrorMessage(p,API.noPerms);
                    } else {
                        p.getInventory().setLeggings(CosItemManager.chainLeggings(true));
                        API.sendMessage(p, "Du trägst nun den §aKettenhose§8.");
                        p.closeInventory();
                    }
                } else if(itemName.equals("§aEisenhose")) {
                    e.setCancelled(true);
                    ItemManager.giveItems(p);
                    if(!p.hasPermission("zyneon.cosmetics.leggings.iron")) {
                        API.sendErrorMessage(p,API.noPerms);
                    } else {
                        p.getInventory().setLeggings(CosItemManager.ironLeggings(true));
                        API.sendMessage(p, "Du trägst nun den §aEisenhose§8.");
                        p.closeInventory();
                    }
                } else if(itemName.equals("§aGoldhose")) {
                    e.setCancelled(true);
                    ItemManager.giveItems(p);
                    if(!p.hasPermission("zyneon.cosmetics.leggings.gold")) {
                        API.sendErrorMessage(p,API.noPerms);
                    } else {
                        p.getInventory().setLeggings(CosItemManager.goldLeggings(true));
                        API.sendMessage(p, "Du trägst nun den §aGoldhose§8.");
                        p.closeInventory();
                    }
                } else if(itemName.equals("§aDiamanthose")) {
                    e.setCancelled(true);
                    ItemManager.giveItems(p);
                    if(!p.hasPermission("zyneon.cosmetics.leggings.diamond")) {
                        API.sendErrorMessage(p,API.noPerms);
                    } else {
                        p.getInventory().setLeggings(CosItemManager.diamondLeggings(true));
                        API.sendMessage(p, "Du trägst nun den §aDiamanthose§8.");
                        p.closeInventory();
                    }
                } else if(itemName.equals("§aNetherithose")) {
                    e.setCancelled(true);
                    ItemManager.giveItems(p);
                    if(!p.hasPermission("zyneon.cosmetics.leggings.netherite")) {
                        API.sendErrorMessage(p,API.noPerms);
                    } else {
                        p.getInventory().setLeggings(CosItemManager.netheriteLeggings(true));
                        API.sendMessage(p, "Du trägst nun den §aNetherithose§8.");
                        p.closeInventory();
                    }
                } else if(itemName.equals("§aLederschuhe")) {
                    e.setCancelled(true);
                    ItemManager.giveItems(p);
                    if(!p.hasPermission("zyneon.cosmetics.boots.leather")) {
                        API.sendErrorMessage(p,API.noPerms);
                    } else {
                        p.getInventory().setBoots(CosItemManager.leatherBoots(true));
                        API.sendMessage(p, "Du trägst nun den §aLederschuhe§8.");
                        p.closeInventory();
                    }
                } else if(itemName.equals("§aKettenschuhe")) {
                    e.setCancelled(true);
                    ItemManager.giveItems(p);
                    if(!p.hasPermission("zyneon.cosmetics.boots.chain")) {
                        API.sendErrorMessage(p,API.noPerms);
                    } else {
                        p.getInventory().setBoots(CosItemManager.chainBoots(true));
                        API.sendMessage(p, "Du trägst nun den §aKettenschuhe§8.");
                        p.closeInventory();
                    }
                } else if(itemName.equals("§aEisenschuhe")) {
                    e.setCancelled(true);
                    ItemManager.giveItems(p);
                    if(!p.hasPermission("zyneon.cosmetics.boots.iron")) {
                        API.sendErrorMessage(p,API.noPerms);
                    } else {
                        p.getInventory().setBoots(CosItemManager.ironBoots(true));
                        API.sendMessage(p, "Du trägst nun den §aEisenschuhe§8.");
                        p.closeInventory();
                    }
                } else if(itemName.equals("§aGoldschuhe")) {
                    e.setCancelled(true);
                    ItemManager.giveItems(p);
                    if(!p.hasPermission("zyneon.cosmetics.boots.gold")) {
                        API.sendErrorMessage(p,API.noPerms);
                    } else {
                        p.getInventory().setBoots(CosItemManager.goldBoots(true));
                        API.sendMessage(p, "Du trägst nun den §aGoldschuhe§8.");
                        p.closeInventory();
                    }
                } else if(itemName.equals("§aDiamantschuhe")) {
                    e.setCancelled(true);
                    ItemManager.giveItems(p);
                    if(!p.hasPermission("zyneon.cosmetics.boots.diamond")) {
                        API.sendErrorMessage(p,API.noPerms);
                    } else {
                        p.getInventory().setBoots(CosItemManager.diamondBoots(true));
                        API.sendMessage(p, "Du trägst nun den §aDiamantschuhe§8.");
                        p.closeInventory();
                    }
                } else if(itemName.equals("§aNetheritschuhe")) {
                    e.setCancelled(true);
                    ItemManager.giveItems(p);
                    if(!p.hasPermission("zyneon.cosmetics.boots.netherite")) {
                        API.sendErrorMessage(p,API.noPerms);
                    } else {
                        p.getInventory().setBoots(CosItemManager.netheriteBoots(true));
                        API.sendMessage(p, "Du trägst nun den §aNetheritschuhe§8.");
                        p.closeInventory();
                    }
                } else if(itemName.equals(CosItemManager.removeHat.getItemMeta().getDisplayName())) {
                    e.setCancelled(true);
                    API.sendMessage(p, "Du trägst nun keinen Hut mehr§8.");
                    ItemStack AIR = new ItemStack(Material.AIR);
                    p.getInventory().setHelmet(AIR);
                } else if(itemName.equals(CosItemManager.removeChest.getItemMeta().getDisplayName())) {
                    e.setCancelled(true);
                    API.sendMessage(p, "Du trägst nun kein Oberteil mehr§8.");
                    ItemStack AIR = new ItemStack(Material.AIR);
                    p.getInventory().setChestplate(AIR);
                } else if(itemName.equals(CosItemManager.removeLeggings.getItemMeta().getDisplayName())) {
                    e.setCancelled(true);
                    API.sendMessage(p, "Du trägst nun keine Hose mehr§8.");
                    ItemStack AIR = new ItemStack(Material.AIR);
                    p.getInventory().setLeggings(AIR);
                } else if(itemName.equals(CosItemManager.removeBoots.getItemMeta().getDisplayName())) {
                    e.setCancelled(true);
                    API.sendMessage(p, "Du trägst nun keine Schuhe mehr§8.");
                    ItemStack AIR = new ItemStack(Material.AIR);
                    p.getInventory().setBoots(AIR);
                }
            }
        }
    }
}