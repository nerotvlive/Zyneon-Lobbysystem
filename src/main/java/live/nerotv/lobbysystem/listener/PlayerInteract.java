package live.nerotv.lobbysystem.listener;

import live.nerotv.lobbysystem.api.API;
import live.nerotv.lobbysystem.api.ConfigAPI;
import live.nerotv.lobbysystem.manager.BroadcastManager;
import live.nerotv.lobbysystem.manager.GUIManager;
import live.nerotv.lobbysystem.manager.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerInteract implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        if(e.getClickedBlock()!=null) {
            if (e.getClickedBlock().getType().equals(Material.LIGHT_WEIGHTED_PRESSURE_PLATE)) {
                e.getPlayer().performCommand("jumper");
                e.setCancelled(true);
            }
        }
        if(e.getItem()!=null) {
            if(e.getItem().getType().equals(Material.FISHING_ROD)) {
                e.setCancelled(false);
                return;
            }
        }
        Player p = e.getPlayer();
        if(e.getAction().equals(Action.LEFT_CLICK_AIR)||e.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
            if(!(API.canPlayerBuild(p))) {
                e.setCancelled(true);
            }
        } else {
            if (!(API.canPlayerBuild(p))) {
                if (e.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
                    e.setCancelled(true);
                    if(p.getWorld().getName().equalsIgnoreCase("pixels")) {
                        if(e.getClickedBlock()!=null) {
                            if(e.getClickedBlock().getY()>2) {
                                e.getClickedBlock().setType(Material.AIR);
                            }
                        }
                    }
                } else if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                    if(p.getWorld().getName().equalsIgnoreCase("pixels")) {
                        if(e.getClickedBlock()!=null) {
                            if(e.getClickedBlock().getY()>2) {
                                if(!e.getClickedBlock().getType().equals(Material.BARRIER)) {
                                    e.getClickedBlock().setType(Material.AIR);
                                }
                            }
                        }
                    }
                    if (e.getClickedBlock().getType().equals(Material.OAK_STAIRS)) {
                        e.setCancelled(false);
                    } else if (p.getWorld().getName().equals("Primal2")) {
                        e.setCancelled(false);
                        if (e.getItem() != null) {
                            e.setCancelled(true);
                        }
                    } else if (p.getWorld().getName().equals("Primal3")) {
                        e.setCancelled(false);
                        if (e.getItem() != null) {
                            e.setCancelled(true);
                        }
                    } else if (p.getWorld().getName().equals("Argria1")) {
                        e.setCancelled(false);
                        if (e.getItem() != null) {
                            e.setCancelled(true);
                        }
                    } else if (p.getWorld().getName().equals("Deadwood")) {
                        e.setCancelled(false);
                        if (e.getItem() != null) {
                            e.setCancelled(true);
                        }
                    } else {
                        e.setCancelled(true);
                        if (e.getItem() != null) {
                            ItemStack Item = e.getItem();
                            if (Item.getItemMeta() != null) {
                                ItemMeta ItemMeta = Item.getItemMeta();
                                String Name = ItemMeta.getDisplayName();
                                if (Name.equals("§bNavigator")) {
                                    GUIManager.openCompassInventory(p);
                                } else if (Name.equals("§bSpieler verstecken")) {
                                    p.performCommand("hide");
                                    p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100, 100);
                                } else if (Name.equals("§bProfil")) {
                                    p.performCommand("friendsgui");
                                    p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100, 100);
                                } else if (Name.equals("§bFreunde- und Partysystem")) {
                                    p.performCommand("friendsgui");
                                    p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100, 100);
                                } else if (Name.equals("§dMaps")) {
                                    GUIManager.openMapsInventory(p);
                                } else if (Name.equals("§bMinigames")) {
                                    p.performCommand(ConfigAPI.CFG.getString("Core.Minigames.Command"));
                                    p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100, 100);
                                } else if (Name.toLowerCase().contains("und optionen")) {
                                    GUIManager.openProfileOptionsInventory(p);
                                } else if (Name.equals(ItemManager.Settings.getItemMeta().getDisplayName())) {
                                    p.performCommand("settings");
                                } else if (Name.equals("§bExtras")) {
                                    GUIManager.openMiniMusicInventory(p);
                                }
                            }
                        }
                    }
                } else {
                    e.setCancelled(true);
                    if (e.getItem() != null) {
                        ItemStack Item = e.getItem();
                        if (Item.getItemMeta() != null) {
                            ItemMeta ItemMeta = Item.getItemMeta();
                            String Name = ItemMeta.getDisplayName();
                            if (Name.equals("§bNavigator")) {
                                GUIManager.openCompassInventory(p);
                            } else if (Name.equals("§dMaps")) {
                                GUIManager.openMapsInventory(p);
                            } else if (Name.equals("§bProfil")) {
                                p.performCommand("friendsgui");
                                p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100, 100);
                            } else if (Name.equals("§bSpieler verstecken")) {
                                p.performCommand("hide");
                                p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100, 100);
                            } else if (Name.equals(ItemManager.Settings.getItemMeta().getDisplayName())) {
                                p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100, 100);
                                p.performCommand("settings");
                            } else if (Name.equals("§bFreunde- und Partysystem")) {
                                p.performCommand("friendsgui");
                                p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100, 100);
                            } else if (Name.equals("§bMinigames")) {
                                p.performCommand(ConfigAPI.CFG.getString("Core.Minigames.Command"));
                                p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100, 100);
                            } else if (Name.toLowerCase().contains("und optionen")) {
                                GUIManager.openProfileOptionsInventory(p);
                            } else if (Name.equals(ItemManager.Settings.getItemMeta().getDisplayName())) {
                                p.performCommand("settings");
                            } else if (Name.equals("§bExtras")) {
                                GUIManager.openMiniMusicInventory(p);
                            }
                        }
                    }
                }
            }
        }
        if(e.getItem()!=null) {
            if(e.getItem().getItemMeta()!=null) {
                if(e.getItem().getItemMeta().getDisplayName().equals(ItemManager.slimeLobby.getItemMeta().getDisplayName())) {
                    e.setCancelled(true);
                    p.performCommand("back");
                }
            }
        }
    }

    @EventHandler
    public void Interact1(PlayerInteractEntityEvent e) {
        if(!(API.canPlayerBuild(e.getPlayer()))) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void Interact2(PlayerInteractAtEntityEvent e) {
        if(!(API.canPlayerBuild(e.getPlayer()))) {
            e.setCancelled(true);
        } else {
            Player p = e.getPlayer();
            if (p.isSneaking()) {
                if(e.getRightClicked() instanceof Player) {
                    p.getInventory().addItem(ItemManager.getWorld());
                } else {
                    p.getInventory().addItem(ItemManager.rotateStick);
                }
            }
            ItemStack item = p.getInventory().getItemInMainHand();
            if (item.getItemMeta() != null) {
                if (item.getItemMeta().getDisplayName().equals(ItemManager.rotateStick.getItemMeta().getDisplayName())) {
                    BroadcastManager.rotate(Bukkit.getScheduler(), e.getRightClicked());
                }
            }
        }
    }

    @EventHandler
    public void entityDamage(EntityDamageByEntityEvent e) {
        if(e.getDamager() instanceof Player) {
            Player p = (Player)e.getDamager();
            if(!(API.canPlayerBuild(p))) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void entityDamage(EntityDamageByBlockEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onHanging(HangingBreakByEntityEvent e) {
        if(e.getRemover() instanceof Player) {
            if(!(API.canPlayerBuild((Player)e.getRemover()))) {
                e.setCancelled(true);
            }
        }
    }
}