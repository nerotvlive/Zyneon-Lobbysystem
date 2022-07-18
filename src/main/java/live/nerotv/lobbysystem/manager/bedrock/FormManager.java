package live.nerotv.lobbysystem.manager.bedrock;

import live.nerotv.lobbysystem.api.API;
import live.nerotv.lobbysystem.api.PlayerAPI;
import live.nerotv.lobbysystem.api.WarpAPI;
import live.nerotv.lobbysystem.manager.GUIManager;
import live.nerotv.lobbysystem.manager.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.geysermc.cumulus.SimpleForm;
import org.geysermc.cumulus.component.ButtonComponent;
import org.geysermc.cumulus.response.FormResponse;
import org.geysermc.floodgate.api.FloodgateApi;
import org.geysermc.floodgate.api.player.FloodgatePlayer;

import java.io.File;

public class FormManager {

    public static void openNavigator(Player p) {
        if(PlayerAPI.isBedrock(p)) {
            FloodgatePlayer player = FloodgateApi.getInstance().getPlayer(p.getUniqueId());
            player.sendForm(SimpleForm.builder().title("§9Navigator").button(ItemManager.CompassItem04.getItemMeta().getDisplayName()).button(ItemManager.CompassItem01.getItemMeta().getDisplayName()).button(ItemManager.CompassItem07.getItemMeta().getDisplayName()).button(ItemManager.CompassItem02.getItemMeta().getDisplayName()).button(ItemManager.CompassItem06.getItemMeta().getDisplayName()).button(ItemManager.CompassItem03.getItemMeta().getDisplayName()).button(ItemManager.CompassItem05.getItemMeta().getDisplayName()).button("§bJUMPER").button("§8Zurück").responseHandler((form, responseData) -> {
                FormResponse response = form.parseResponse(responseData);
                if(response.isCorrect()&&!response.isClosed()&&!response.isInvalid()||form.parseResponse(responseData).getClickedButton()!=null) {
                    ButtonComponent button = form.parseResponse(responseData).getClickedButton();
                    String Name = button.getText();
                    if(Name.equals("§cFrei...§4")) {
                        p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, 100, 100);
                    } else if(Name.equals("&cFrei...&4")) {
                        p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, 100, 100);
                    } else if(Name.contains("JUMPER")) {
                        p.performCommand("jumper");
                    } else if(Name.equals(ItemManager.CompassItem01.getItemMeta().getDisplayName())) {
                        API.doCompassWarp(p,1);
                    } else if(Name.equals(ItemManager.CompassItem02.getItemMeta().getDisplayName())) {
                        API.doCompassWarp(p,2);
                    } else if(Name.equals(ItemManager.CompassItem03.getItemMeta().getDisplayName())) {
                        API.doCompassWarp(p,3);
                    } else if(Name.equals(ItemManager.CompassItem04.getItemMeta().getDisplayName())) {
                        API.doCompassWarp(p,4);
                    } else if(Name.equals(ItemManager.CompassItem05.getItemMeta().getDisplayName())) {
                        API.doCompassWarp(p,5);
                    } else if(Name.equals(ItemManager.CompassItem06.getItemMeta().getDisplayName())) {
                        API.doCompassWarp(p,6);
                    } else if(Name.equals(ItemManager.CompassItem07.getItemMeta().getDisplayName())) {
                        API.doCompassWarp(p,7);
                    }
                }
            }).build());
            p.playSound(p.getLocation(),Sound.ENTITY_CHICKEN_EGG,100,100);
        } else {
            GUIManager.openCompassInventory(p);
        }
    }

    public static void openPixelsBack(Player p) {
        if(PlayerAPI.isBedrock(p)) {
            FloodgatePlayer player = FloodgateApi.getInstance().getPlayer(p.getUniqueId());
            player.sendForm(SimpleForm.builder().title("§9Zurück zur Lobby?").button("§aJa").button("§cNein").responseHandler((form,responseData) -> {
                FormResponse response = form.parseResponse(responseData);
                if(response.isCorrect()&&!response.isClosed()&&!response.isInvalid()||form.parseResponse(responseData).getClickedButton()!=null) {
                    ButtonComponent button = form.parseResponse(responseData).getClickedButton();
                    String Name = button.getText();
                    if(Name.equals("§aJa")) {
                        p.teleport(WarpAPI.getWarp("Spawn"));
                    }
                }
            }).build());
            p.playSound(p.getLocation(),Sound.ENTITY_CHICKEN_EGG,100,100);
        } else {
            GUIManager.openBackToLobbyInventory(p);
        }
    }

    public static void openProfile(Player p) {
        if(PlayerAPI.isBedrock(p)) {
            FloodgatePlayer player = FloodgateApi.getInstance().getPlayer(p.getUniqueId());
            player.sendForm(SimpleForm.builder().title("§9Profil§8, §9Optionen §8& §9Extras").button("§9Cosmetics").button("§9Einstellungen").button("§9Freunde- und Partysystem").button("§8Zurück").responseHandler((form,responseData) -> {
                FormResponse response = form.parseResponse(responseData);
                if(response.isCorrect()&&!response.isClosed()&&!response.isInvalid()||form.parseResponse(responseData).getClickedButton()!=null) {
                    ButtonComponent button = form.parseResponse(responseData).getClickedButton();
                    String Name = button.getText();
                    if(Name.equals("§9Cosmetics")) {
                        p.playSound(p.getLocation(),Sound.ENTITY_CHICKEN_EGG,100,100);
                        API.sendErrorMessage(p,"§cDieses Feature wird für Bedrock-Spieler noch nicht unterstützt!");
                    } else if(Name.equals("§9Freunde- und Partysystem")) {
                        p.performCommand("friendsgui");
                        p.playSound(p.getLocation(),Sound.ENTITY_CHICKEN_EGG,100,100);
                    } else if(Name.equals("§9Einstellungen")) {
                        p.playSound(p.getLocation(),Sound.ENTITY_CHICKEN_EGG,100,100);
                        openSettings(p);
                    }
                }
            }).build());
            p.playSound(p.getLocation(),Sound.ENTITY_CHICKEN_EGG,100,100);
        } else {
            GUIManager.openProfileOptionsInventory(p);
        }
    }

    public static void openSettings(Player p) {
        if(PlayerAPI.isBedrock(p)) {
            File TempFile = new File("plugins/Lobbysystem/temp/"+p.getUniqueId().toString()+"_lobbysettings.temp");
            FloodgatePlayer player = FloodgateApi.getInstance().getPlayer(p.getUniqueId());
            YamlConfiguration TF = YamlConfiguration.loadConfiguration(TempFile);
            String Time = "Settings.timeItem";
            String Rain = "Settings.weatherItem";
            String Bedrock = "Settings.BedrockMode";
            String Scoreboard = "Settings.Scoreboard";
            String Flight;
            if(TF.contains(Time)) {
                if(TF.getInt(Time)==0) {
                    Time = "§cZeit §8(§eEchte Zeit§8)";
                } else if(TF.getInt(Time)==1) {
                    Time = "§aZeit §8(§eNacht§8)";
                } else {
                    Time = "§aZeit §8(§eTag§8)";
                }
            } else {
                Time = "§cZeit §8(§eEchte Zeit§8)";
            }
            if(TF.contains(Scoreboard)) {
                if(TF.getBoolean(Scoreboard)) {
                    Scoreboard = "§aScoreboard §8(§eAn§8)";
                } else {
                    Scoreboard = "§cScoreboard §8(§eAus§8)";
                }
            } else {
                Scoreboard = "§aScoreboard §8(§eAn§8)";
            }
            if(TF.contains(Rain)) {
                if(TF.getInt(Rain)==0) {
                    Rain = "§cRegen §8(§eAus§8)";
                } else {
                    Rain = "§aRegen §8(§eAn§8)";
                }
            } else {
                Rain = "§cRegen §8(§eAus§8)";
            }
            if(p.getAllowFlight()) {
                Flight = "§aFliegen §8(§eAn§8)";
            } else {
                Flight = "§cFliegen §8(§eAus§8)";
            }
            if(TF.contains(Bedrock)) {
                if(TF.getBoolean(Bedrock)) {
                    Bedrock = "§aBedrock-Modus §8(§eAn§8)";
                } else {
                    Bedrock = "§cBedrock-Modus §8(§eAus§8)";
                }
            } else {
                Bedrock = "§aBedrock-Modus §8(§eAn§8)";
            }
            String finalTime = Time;
            String finalRain = Rain;
            String finalBedrock = Bedrock;
            String finalScoreboard = Scoreboard;
            player.sendForm(SimpleForm.builder().title("§9Einstellungen").button(Bedrock).button(Scoreboard).button(Time).button(Rain).button(Flight).button("§8Zurück").responseHandler((form, responseData) -> {
                FormResponse response = form.parseResponse(responseData);
                if(response.isCorrect()&&!response.isClosed()&&!response.isInvalid()||form.parseResponse(responseData).getClickedButton()!=null) {
                    ButtonComponent button = form.parseResponse(responseData).getClickedButton();
                    String Name = button.getText();
                    if(Name.equals(finalBedrock)) {
                        SettingsManager.changeBedrockState(p);
                        openSettings(p);
                    } else if(Name.equals(finalScoreboard)) {
                        SettingsManager.changeScoreboardState(p);
                        openSettings(p);
                    } else if(Name.equals(finalTime)) {
                        SettingsManager.changeTimeState(p);
                        openSettings(p);
                    } else if(Name.equals(finalRain)) {
                        SettingsManager.changeRainState(p);
                        openSettings(p);
                    } else if(Name.equals(Flight)) {
                        SettingsManager.changeFlightState(p);
                        openSettings(p);
                    } else {
                        openProfile(p);
                    }
                }
            }).build());
        } else {
            GUIManager.openSettingsInventory(p);
        }
    }

    public static void openMaps(Player p) {
        if(PlayerAPI.isBedrock(p)) {
            FloodgatePlayer player = FloodgateApi.getInstance().getPlayer(p.getUniqueId());
            player.sendForm(SimpleForm.builder().title("§9Zyneon§8-§9Karten").button("§9Musik hören").button("§9PIXELS-Karten").button("§9Projekt-Karten").button("§8Zurück zur Lobby").button("§8Zurück").responseHandler((form,responseData) -> {
                FormResponse response = form.parseResponse(responseData);
                if(response.isCorrect()&&!response.isClosed()&&!response.isInvalid()||form.parseResponse(responseData).getClickedButton()!=null) {
                    ButtonComponent button = form.parseResponse(responseData).getClickedButton();
                    String Name = button.getText();
                    if(Name.equals("§9PIXELS-Karten")) {
                        openPixelsMaps(p);
                    } else if(Name.equals("§9Projekt-Karten")) {
                        openProjectMaps(p);
                    } else if(Name.equals("§9Musik hören")) {
                        p.performCommand("music");
                    } else if(Name.equals("§8Zurück zur Lobby")) {
                        if (WarpAPI.isWarpEnabled("Lobby")) {
                            p.teleport(WarpAPI.getWarp("Lobby"));
                        } else {
                            p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, 100, 100);
                        }
                    }
                }
            }).build());
            p.playSound(p.getLocation(),Sound.ENTITY_CHICKEN_EGG,100,100);
        } else {
            GUIManager.openMapsInventory(p);
        }
    }

    public static void openProjectMaps(Player p) {
        if(PlayerAPI.isBedrock(p)) {
            FloodgatePlayer player = FloodgateApi.getInstance().getPlayer(p.getUniqueId());
            player.sendForm(SimpleForm.builder().title("§9Projekt§8-§9Karten").button("§9Shervann §8(§8Primal 2§8)").button("§9Falkenwacht §8(§8Primal 2§8)").button("§9Falkenwacht Ruinen §8(§8Primal 3§8)").button("§9Falkenwacht §8(§8Primal 3§8)").button("§9Tiefenstein §8(§8Primal 3§8)").button("§9Wolfshaven §8(§8Argria§8)").button("§9Deadwood §8(§8Deadwood§8)").button("§8Zurück zur Lobby").button("§8Zurück").responseHandler((form,responseData) -> {
                FormResponse response = form.parseResponse(responseData);
                if(response.isCorrect()&&!response.isClosed()&&!response.isInvalid()||form.parseResponse(responseData).getClickedButton()!=null) {
                    ButtonComponent button = form.parseResponse(responseData).getClickedButton();
                    String Name = button.getText();
                    if(Name.equals("§9Falkenwacht §8(§8Primal 2§8)")) {
                        p.teleport(WarpAPI.getWarp("Primal2_1"));
                        p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 100, 100);
                    } else if(Name.equals("§9Shervann §8(§8Primal 2§8)")) {
                        p.teleport(WarpAPI.getWarp("Primal2_2"));
                        p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 100, 100);
                    } else if(Name.equals("§9Deadwood §8(§8Deadwood§8)")) {
                        API.sendErrorMessage(p,"§cDeadwood kann sich nicht über die Bedrock-Edition angeschaut werden§8.");
                    } else if(Name.equals("§9Wolfshaven §8(§8Argria§8)")) {
                        p.teleport(WarpAPI.getWarp("Argria1"));
                        p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 100, 100);
                    } else if(Name.equals("§9Falkenwacht Ruinen §8(§8Primal 3§8)")) {
                        p.teleport(WarpAPI.getWarp("Primal3_3"));
                        p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 100, 100);
                    } else if(Name.equals("§9Falkenwacht §8(§8Primal 3§8)")) {
                        p.teleport(WarpAPI.getWarp("Primal3_2"));
                        p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 100, 100);
                    } else if(Name.equals("§9Tiefenstein §8(§8Primal 3§8)")) {
                        p.teleport(WarpAPI.getWarp("Primal3_1"));
                        p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 100, 100);
                    } else if(Name.equals("§8Zurück zur Lobby")) {
                        if (WarpAPI.isWarpEnabled("Lobby")) {
                            p.teleport(WarpAPI.getWarp("Lobby"));
                        } else {
                            p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, 100, 100);
                        }
                    }
                }
            }).build());
            p.playSound(p.getLocation(),Sound.ENTITY_CHICKEN_EGG,100,100);
        } else {
            GUIManager.openMapsInventory(p);
        }
    }

    public static void openPixelsMaps(Player p) {
        if(PlayerAPI.isBedrock(p)) {
            FloodgatePlayer player = FloodgateApi.getInstance().getPlayer(p.getUniqueId());
            player.sendForm(SimpleForm.builder().title("§9PIXELS§8-§9Karten").button("§9PIXELS SEASON 1 §8(§8Jun. 21 - Aug. 21§8)").button("§9PIXELS SEASON 2 §8(§8Sep. 21 - Jan. 22§8)").button("§9PIXELS SEASON 3 §8(§8Feb. 22 - Apr. 22§8)").button("§9PIXELS SEASON 4 §8(§8Mai 22 - Jun. 22§8)").button("§8Zurück zur Lobby").button("§8Zurück").responseHandler((form,responseData) -> {
                FormResponse response = form.parseResponse(responseData);
                if(response.isCorrect()&&!response.isClosed()&&!response.isInvalid()||form.parseResponse(responseData).getClickedButton()!=null) {
                    ButtonComponent button = form.parseResponse(responseData).getClickedButton();
                    String Name = button.getText();
                    if(Name.equals("§9PIXELS SEASON 1 §8(§8Jun. 21 - Aug. 21§8)")) {
                        p.teleport(Bukkit.getServer().getWorld("pixels-aug21").getSpawnLocation());
                        p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100, 100);
                        p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 100, 100);
                    } else if(Name.equals("§9PIXELS SEASON 2 §8(§8Sep. 21 - Jan. 22§8)")) {
                        p.teleport(Bukkit.getServer().getWorld("pixels-jan22").getSpawnLocation());
                        p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100, 100);
                        p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 100, 100);
                    } else if(Name.equals("§9PIXELS SEASON 3 §8(§8Feb. 22 - Apr. 22§8)")) {
                        p.teleport(Bukkit.getServer().getWorld("pixels-apr22").getSpawnLocation());
                        p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100, 100);
                        p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 100, 100);
                    } else if(Name.equals("§9PIXELS SEASON 4 §8(§8Mai 22 - Jun. 22§8)")) {
                        p.teleport(Bukkit.getServer().getWorld("pixels-jun22").getSpawnLocation());
                        p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100, 100);
                        p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 100, 100);
                    } else if(Name.equals("§8Zurück zur Lobby")) {
                        if (WarpAPI.isWarpEnabled("Lobby")) {
                            p.teleport(WarpAPI.getWarp("Lobby"));
                        } else {
                            p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, 100, 100);
                        }
                    }
                }
            }).build());
            p.playSound(p.getLocation(),Sound.ENTITY_CHICKEN_EGG,100,100);
        } else {
            GUIManager.openMapsInventory(p);
        }
    }
}