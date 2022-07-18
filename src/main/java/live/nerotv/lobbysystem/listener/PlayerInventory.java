package live.nerotv.lobbysystem.listener;

import com.zyneonstudios.api.paper.Zyneon;
import live.nerotv.lobbysystem.Main;
import live.nerotv.lobbysystem.api.*;
import live.nerotv.lobbysystem.cosmetics.CosGUIManager;
import live.nerotv.lobbysystem.manager.GUIManager;
import live.nerotv.lobbysystem.manager.ItemManager;
import live.nerotv.lobbysystem.manager.bedrock.FormManager;
import live.nerotv.lobbysystem.manager.bedrock.SettingsManager;
import live.nerotv.lobbysystem.utils.Countdown;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.WeatherType;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;

public class PlayerInventory implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player p = (Player)e.getWhoClicked();
        if(!(API.canPlayerBuild(p))) {
            e.setCancelled(true);
            if(e.getCurrentItem()!=null) {
                ItemStack Item = e.getCurrentItem();
                if(Item.getItemMeta()!=null) {
                    ItemMeta ItemMeta = Item.getItemMeta();
                    String Name = ItemMeta.getDisplayName();
                    if(Name.equals("§cFrei...§4")) {
                        p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, 100, 100);
                    } else if(Name.contains("Jumper")) {
                        p.performCommand("jumper");
                        p.playSound(p.getLocation(),Sound.ENTITY_CHICKEN_EGG,100,100);
                    } else if(Name.equals("&cFrei...&4")) {
                        p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, 100, 100);
                    } else if(Name.equals(ItemManager.CompassItem01.getItemMeta().getDisplayName())) {
                        API.doCompassWarp(p,1);
                    } else if(Name.equals(ItemManager.CompassItem02.getItemMeta().getDisplayName())) {
                        API.doCompassWarp(p,2);
                    } else if(Name.equals(ItemManager.CompassItem03.getItemMeta().getDisplayName())) {
                        API.doCompassWarp(p,3);
                    } else if(Name.equals(ItemManager.BackPS.getItemMeta().getDisplayName())) {
                        p.closeInventory();
                        GUIManager.openProfileOptionsInventory(p);
                    } else if(Name.equals(ItemManager.BackCS.getItemMeta().getDisplayName())) {
                        p.closeInventory();
                        CosGUIManager.openCosmeticsInventory(p);
                    } else if(Name.equals(ItemManager.BackEX.getItemMeta().getDisplayName())) {
                        p.closeInventory();
                        GUIManager.openExtrasInventory(p);
                    } else if(Name.equals(ItemManager.CompassItem04.getItemMeta().getDisplayName())) {
                        API.doCompassWarp(p,4);
                    } else if (Name.equals("§bOberteile")) {
                        e.setCancelled(true);
                        CosGUIManager.openChestsInventory(p);
                    } else if (Name.equals("§bHosen")) {
                        e.setCancelled(true);
                        CosGUIManager.openLeggingsInventory(p);
                    } else if (Name.equals("§bSchuhe")) {
                        e.setCancelled(true);
                        CosGUIManager.openBootsInventory(p);
                    /*} else if(Name.equals(ItemManager.settingsChannel(p).getItemMeta().getDisplayName())) {
                        API.toggleChannel(p);
                        e.getClickedInventory().setItem(e.getSlot(),ItemManager.settingsChannel(p));
                        p.playSound(p.getLocation(),Sound.ENTITY_CHICKEN_EGG,100,100);*/
                    } else if (Name.equals("§bSpieler verstecken")) {
                        p.performCommand("hide");
                        p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100, 100);
                    } else if (Name.equals("§bFreunde- und Partysystem")) {
                        p.performCommand("friendsgui");
                        p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100, 100);
                    } else if (Name.toLowerCase().contains("und optionen")) {
                        GUIManager.openProfileOptionsInventory(p);
                    } else if(Name.equals(ItemManager.CompassItem05.getItemMeta().getDisplayName())) {
                        API.doCompassWarp(p,5);
                    } else if(Name.equals(ItemManager.CompassItem06.getItemMeta().getDisplayName())) {
                        API.doCompassWarp(p,6);
                    } else if(Name.equals(ItemManager.CompassItem07.getItemMeta().getDisplayName())) {
                        API.doCompassWarp(p,7);
                    } else if(Name.equals(ItemManager.Maps.getItemMeta().getDisplayName())) {
                        GUIManager.openMapsInventory(p);
                    } else if(Name.equals(ItemManager.Primal2_1.getItemMeta().getDisplayName())) {
                        if (WarpAPI.isWarpEnabled("Primal2_1")) {
                            p.teleport(WarpAPI.getWarp("Primal2_1"));
                            p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 100, 100);
                            p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100, 100);
                        } else {
                            p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, 100, 100);
                        }
                    } else if(Name.equals(ItemManager.Primal3_1.getItemMeta().getDisplayName())) {
                        if (WarpAPI.isWarpEnabled("Primal3_1")) {
                            p.teleport(WarpAPI.getWarp("Primal3_1"));
                            p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 100, 100);
                            p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100, 100);
                        } else {
                            p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, 100, 100);
                        }
                    } else if(Name.equals(ItemManager.Primal3_2.getItemMeta().getDisplayName())) {
                        if (WarpAPI.isWarpEnabled("Primal3_2")) {
                            p.teleport(WarpAPI.getWarp("Primal3_2"));
                            p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 100, 100);
                            p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100, 100);
                        } else {
                            p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, 100, 100);
                        }
                    } else if(Name.equals(ItemManager.Primal3_3.getItemMeta().getDisplayName())) {
                        if (WarpAPI.isWarpEnabled("Primal3_3")) {
                            p.teleport(WarpAPI.getWarp("Primal3_3"));
                            p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 100, 100);
                            p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100, 100);
                        } else {
                            p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, 100, 100);
                        }
                    } else if(Name.equals(ItemManager.Primal2_2.getItemMeta().getDisplayName())) {
                        if(WarpAPI.isWarpEnabled("Primal2_2")) {
                            p.teleport(WarpAPI.getWarp("Primal2_2"));
                            p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 100, 100);
                            p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100, 100);
                        } else {
                            p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, 100, 100);
                        }
                    } else if(Name.equals(ItemManager.PixelsAug21.getItemMeta().getDisplayName())) {
                        p.teleport(Bukkit.getServer().getWorld("pixels-aug21").getSpawnLocation());
                        p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 100, 100);
                        p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100, 100);
                    } else if(Name.equals(ItemManager.PixelsJan22.getItemMeta().getDisplayName())) {
                        p.teleport(Bukkit.getServer().getWorld("pixels-jan22").getSpawnLocation());
                        p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 100, 100);
                        p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100, 100);
                    } else if(Name.equals(ItemManager.PixelsApr22.getItemMeta().getDisplayName())) {
                        p.teleport(Bukkit.getServer().getWorld("pixels-apr22").getSpawnLocation());
                        p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 100, 100);
                        p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100, 100);
                    } else if(Name.equals(ItemManager.PixelsJun22.getItemMeta().getDisplayName())) {
                        p.teleport(Bukkit.getServer().getWorld("pixels-jun22").getSpawnLocation());
                        p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 100, 100);
                        p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100, 100);
                    } else if(Name.equals(ItemManager.Lobby.getItemMeta().getDisplayName())) {
                        if (WarpAPI.isWarpEnabled("Lobby")) {
                            p.teleport(WarpAPI.getWarp("Lobby"));
                            p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 100, 100);
                            p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100, 100);
                        } else {
                            p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, 100, 100);
                        }
                    } else if(Name.equals(ItemManager.FlyItem(p).getItemMeta().getDisplayName())) {
                        p.performCommand("fly");
                        e.getClickedInventory().setItem(e.getSlot(), ItemManager.FlyItem(p));
                    } else if(Name.equals(ItemManager.MiniMusic.getItemMeta().getDisplayName())) {
                        e.setCancelled(true);
                        GUIManager.openMiniMusicInventory(p);
                    } else if(Name.equals(ItemManager.Music.getItemMeta().getDisplayName())) {
                        e.setCancelled(true);
                        p.playSound(p.getLocation(),Sound.ENTITY_CHICKEN_EGG,100,100);
                        //API.sendErrorMessage(p,"§cDas Musik-Feature ist für den Argria 2-Start deaktiviert§8!");
                        p.performCommand("music");
                    } else if(Name.equals(ItemManager.AnimateItem(p).getItemMeta().getDisplayName())) {
                        SettingsManager.changeAnimationState(p);
                        p.playSound(p.getLocation(),Sound.ENTITY_CHICKEN_EGG,100,100);
                        e.getClickedInventory().setItem(e.getSlot(),ItemManager.AnimateItem(p));
                    } else if(Name.equals("§aScoreboard")) {
                        File TempFile = new File("plugins/Lobbysystem/temp/" + p.getUniqueId().toString() + "_lobbysettings.temp");
                        YamlConfiguration TF = YamlConfiguration.loadConfiguration(TempFile);
                        TF.set("Settings.Scoreboard",false);
                        ConfigAPI.saveConfig(TempFile,TF);
                        ConfigAPI.reloadConfig(TempFile,TF);
                        PlayerAPI.renewScoreboard(p,false);
                        p.playSound(p.getLocation(),Sound.ENTITY_CHICKEN_EGG,100,100);
                        e.getClickedInventory().setItem(e.getSlot(), ItemManager.ScoreboardItem(p));
                    } else if(Name.equals("§cScoreboard")) {
                        File TempFile = new File("plugins/Lobbysystem/temp/" + p.getUniqueId().toString() + "_lobbysettings.temp");
                        YamlConfiguration TF = YamlConfiguration.loadConfiguration(TempFile);
                        TF.set("Settings.Scoreboard",true);
                        ConfigAPI.saveConfig(TempFile,TF);
                        ConfigAPI.reloadConfig(TempFile,TF);
                        PlayerAPI.renewScoreboard(p,false);
                        p.playSound(p.getLocation(),Sound.ENTITY_CHICKEN_EGG,100,100);
                        e.getClickedInventory().setItem(e.getSlot(), ItemManager.ScoreboardItem(p));
                    } else if(Name.equals(ItemManager.bedrockItem.getItemMeta().getDisplayName())) {
                        if(Main.PM.getPlugin("floodgate")!=null) {
                            if(BedrockAPI.isFloodgate(p)) {
                                SettingsManager.changeBedrockState(p,true);
                                p.closeInventory();
                                p.playSound(p.getLocation(),Sound.ENTITY_CHICKEN_EGG,100,100);
                                API.sendMessage(p,"§7Bitte warten§8...");
                                new Countdown(1, Main.instance) {
                                    @Override
                                    public void count(int current) {
                                        if(current == 0) {
                                            API.sendMessage(p,"§7Du hast den §eBedrock§8-§eModus§7 erfolgreich §aaktiviert§8!");
                                            FormManager.openSettings(p);
                                        }
                                    }
                                }.start();
                            } else {
                                API.sendErrorMessage(p,"§cDazu musst du mit der Bedrock-Edition spielen!");
                            }
                        } else {
                            API.sendErrorMessage(p,"§cDieses Feature ist zurzeit deaktiviert!");
                        }
                    } else if(Name.equals(ItemManager.Settings.getItemMeta().getDisplayName())) {
                        p.closeInventory();
                        GUIManager.openSettingsInventory(p);
                        p.playSound(p.getLocation(),Sound.ENTITY_CHICKEN_EGG,100,100);
                    } else if (Name.equals("§bProfil")) {
                        p.performCommand("friendsgui");
                        p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100, 100);
                    } else if(Name.equals(ItemManager.Gadgets.getItemMeta().getDisplayName())) {
                        e.setCancelled(true);
                        p.sendMessage("§cDieses Feature ist derzeit deaktiviert.");
                        p.closeInventory();
                        p.playSound(p.getLocation(),Sound.BLOCK_ANVIL_BREAK,100,100);
                    } else if(Name.equals(ItemManager.Argria1.getItemMeta().getDisplayName())) {
                        if (WarpAPI.isWarpEnabled("Argria1")) {
                            p.teleport(WarpAPI.getWarp("Argria1"));
                            p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 100, 100);
                            p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100, 100);
                        } else {
                            p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, 100, 100);
                        }
                    } else if(Name.equals(ItemManager.Deadwood1.getItemMeta().getDisplayName())) {
                        if (WarpAPI.isWarpEnabled("Deadwood1")) {
                            p.teleport(WarpAPI.getWarp("Deadwood1"));
                            p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 100, 100);
                            p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100, 100);
                        } else {
                            p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, 100, 100);
                        }
                    } else if(Name.equals(ItemManager.Cancel.getItemMeta().getDisplayName())) {
                        p.closeInventory();
                        p.playSound(p.getLocation(),Sound.ENTITY_CHICKEN_EGG,100,100);
                    } else if(Name.equals(ItemManager.StopYes.getItemMeta().getDisplayName())) {
                        if(p.hasPermission("zyneon.leading.stop")) {
                            Zyneon.getZyneonServer().stopServer();
                            p.closeInventory();
                        } else {
                            p.playSound(p.getLocation(),Sound.BLOCK_ANVIL_BREAK,100,100);
                            p.sendMessage(API.noPerms);
                            p.closeInventory();
                        }
                    } else if(Name.equals(ItemManager.timeItem(0).getItemMeta().getDisplayName())) {
                        File TempFile = new File("plugins/Lobbysystem/temp/" + p.getUniqueId().toString() + "_lobbysettings.temp");
                        YamlConfiguration TF = YamlConfiguration.loadConfiguration(TempFile);
                        TF.set("Settings.timeItem", 1);
                        ConfigAPI.saveConfig(TempFile, TF);
                        p.resetPlayerTime();
                        p.setPlayerTime(16000, false);
                        p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100, 100);
                        e.getClickedInventory().setItem(e.getSlot(), ItemManager.timeItem(1));
                    } else if(Name.equals(ItemManager.rainItem(0).getItemMeta().getDisplayName())) {
                        File TempFile = new File("plugins/Lobbysystem/temp/" + p.getUniqueId().toString() + "_lobbysettings.temp");
                        YamlConfiguration TF = YamlConfiguration.loadConfiguration(TempFile);
                        TF.set("Settings.weatherItem", 1);
                        ConfigAPI.saveConfig(TempFile, TF);
                        p.resetPlayerWeather();
                        p.setPlayerWeather(WeatherType.DOWNFALL);
                        p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100, 100);
                        e.getClickedInventory().setItem(e.getSlot(), ItemManager.rainItem(1));
                    } else if(Name.equals(ItemManager.rainItem(1).getItemMeta().getDisplayName())) {
                        File TempFile = new File("plugins/Lobbysystem/temp/" + p.getUniqueId().toString() + "_lobbysettings.temp");
                        YamlConfiguration TF = YamlConfiguration.loadConfiguration(TempFile);
                        TF.set("Settings.weatherItem", 0);
                        ConfigAPI.saveConfig(TempFile, TF);
                        p.resetPlayerWeather();
                        p.setPlayerWeather(WeatherType.CLEAR);
                        p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100, 100);
                        e.getClickedInventory().setItem(e.getSlot(), ItemManager.rainItem(0));
                    } else if(Name.equals(ItemManager.timeItem(1).getItemMeta().getDisplayName())) {
                        File TempFile = new File("plugins/Lobbysystem/temp/"+p.getUniqueId().toString()+"_lobbysettings.temp");
                        YamlConfiguration TF = YamlConfiguration.loadConfiguration(TempFile);
                        TF.set("Settings.timeItem",2);
                        ConfigAPI.saveConfig(TempFile,TF);
                        p.resetPlayerTime();
                        p.setPlayerTime(500,false);
                        p.playSound(p.getLocation(),Sound.ENTITY_CHICKEN_EGG,100,100);
                        e.getClickedInventory().setItem(e.getSlot(),ItemManager.timeItem(2));
                    } else if(Name.equals(ItemManager.timeItem(2).getItemMeta().getDisplayName())) {
                        File TempFile = new File("plugins/Lobbysystem/temp/"+p.getUniqueId().toString()+"_lobbysettings.temp");
                        YamlConfiguration TF = YamlConfiguration.loadConfiguration(TempFile);
                        TF.set("Settings.timeItem",0);
                        ConfigAPI.saveConfig(TempFile,TF);
                        p.resetPlayerTime();
                        p.playSound(p.getLocation(),Sound.ENTITY_CHICKEN_EGG,100,100);
                        e.getClickedInventory().setItem(e.getSlot(),ItemManager.timeItem(0));
                    } else if(Name.equals(ItemManager.ReloadYes.getItemMeta().getDisplayName())) {
                        if (p.hasPermission("zyneon.team")) {
                            p.sendMessage("§cServer-Reload...");
                            p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100, 100);
                            p.closeInventory();
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "reload confirm");
                        } else {
                            p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, 100, 100);
                            p.sendMessage(API.noPerms);
                            p.closeInventory();
                        }
                    } else if(Name.equals(ItemManager.BackTL.getItemMeta().getDisplayName())) {
                        p.teleport(WarpAPI.getWarp("Spawn"));
                        p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 100, 100);
                        p.playSound(p.getLocation(),Sound.ENTITY_CHICKEN_EGG,100,100);
                    } else if(Name.equals("§bNavigator")) {
                        GUIManager.openCompassInventory(p);
                    } else if(Name.equals("§bMinigames")) {
                        p.performCommand(ConfigAPI.CFG.getString("Core.Minigames.Command"));
                        p.playSound(p.getLocation(),Sound.ENTITY_CHICKEN_EGG,100,100);
                    } else if (Name.equals("§9Extras")) {
                        GUIManager.openExtrasInventory(p);
                    } else {
                        p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, 100, 100);
                    }
                }
            }
        } else {
            e.setCancelled(false);
            if(e.getCurrentItem()!=null) {
                ItemStack Item = e.getCurrentItem();
                if(Item.getItemMeta()!=null) {
                    ItemMeta ItemMeta = Item.getItemMeta();
                    String Name = ItemMeta.getDisplayName();
                    if(Name.equals("§cFrei...§4")) {
                        e.setCancelled(true);
                        p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, 100, 100);
                    } else if(Name.equals(ItemManager.Placeholder.getItemMeta().getDisplayName())) {
                        e.setCancelled(true);
                        p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG,100,100);
                    } else if(Name.equals(ItemManager.Cancel.getItemMeta().getDisplayName())) {
                        e.setCancelled(true);
                        p.closeInventory();
                        p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG,100,100);
                    } else if(Name.equals(ItemManager.StopYes.getItemMeta().getDisplayName())) {
                        e.setCancelled(true);
                        if(p.hasPermission("zyneon.leading.stop")) {
                            Zyneon.getZyneonServer().stopServer();
                            p.closeInventory();
                        } else {
                            p.playSound(p.getLocation(),Sound.BLOCK_ANVIL_BREAK,100,100);
                            p.sendMessage(API.noPerms);
                            p.closeInventory();
                        }
                    } else if(Name.equals(ItemManager.ReloadYes.getItemMeta().getDisplayName())) {
                        e.setCancelled(true);
                        if(p.hasPermission("zyneon.team")) {
                            for(Player all:Bukkit.getOnlinePlayers()) {
                                all.kickPlayer("§cDie Systeme werden erneut geladen...");
                            }
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"reload confirm");
                        } else {
                            p.playSound(p.getLocation(),Sound.BLOCK_ANVIL_BREAK,100,100);
                            p.sendMessage(API.noPerms);
                            p.closeInventory();
                        }
                    } else {
                        e.setCancelled(false);
                    }
                }
            }
        }
        if(p.getWorld().getName().equalsIgnoreCase("pixels")) {
            e.setCancelled(false);
            if(e.getCurrentItem()!=null&&e.getCurrentItem().getItemMeta()!=null) {
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ItemManager.Placeholder.getItemMeta().getDisplayName())) {
                    e.setCancelled(true);
                } else if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ItemManager.slimeLobby.getItemMeta().getDisplayName())) {
                    e.setCancelled(true);
                    p.performCommand("back");
                }
            }
        }
    }

    @EventHandler
    public void onSwap(PlayerSwapHandItemsEvent e) {
        if(!(API.canPlayerBuild(e.getPlayer()))) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onInvSwap(InventoryMoveItemEvent e) {
        if(e.getInitiator() instanceof Player) {
            if (!(API.canPlayerBuild((Player)e.getInitiator()))) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onSlotChange(PlayerItemHeldEvent e) {
        Player p = e.getPlayer();
        if(!(API.canPlayerBuild(p))) {
            p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_STEP, 100, 100);
        }
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onPickUp(PlayerPickupItemEvent e) {
        Player p = e.getPlayer();
        if(!(API.canPlayerBuild(p))) {
            e.setCancelled(true);
        }
    }
}