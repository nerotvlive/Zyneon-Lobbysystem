package live.nerotv.lobbysystem.manager;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import live.nerotv.lobbysystem.api.ConfigAPI;
import live.nerotv.lobbysystem.api.PlayerAPI;
import live.nerotv.lobbysystem.api.WorldAPI;
import live.nerotv.lobbysystem.commands.Fly;
import live.nerotv.lobbysystem.cosmetics.CosItemManager;
import org.bukkit.Difficulty;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class ItemManager {

    public static ItemStack createGuiItem(final Material material, final String name, final String... lore) {
        final ItemStack item = new ItemStack(material, 1);
        final ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore((List) Arrays.asList(lore));
        item.setItemMeta(meta);
        return item;
    }

    public static void giveItems(Player p) {
        WorldAPI.setDifficulty(p.getWorld(), Difficulty.PEACEFUL);
        Inventory Inv = p.getInventory();
        if(!p.getWorld().getName().equalsIgnoreCase("pixels")) {
            p.setGameMode(GameMode.ADVENTURE);
            ItemStack Helmet;
            ItemStack Chest;
            ItemStack Leggings;
            ItemStack Boots;
            ItemStack AIR = new ItemStack(Material.AIR);
            if (p.getInventory().getHelmet() != null) {
                Helmet = p.getInventory().getHelmet();
            } else {
                Helmet = AIR;
            }
            if (p.getInventory().getChestplate() != null) {
                Chest = p.getInventory().getChestplate();
            } else {
                Chest = AIR;
            }
            if (p.getInventory().getLeggings() != null) {
                Leggings = p.getInventory().getLeggings();
            } else {
                Leggings = AIR;
            }
            if (p.getInventory().getBoots() != null) {
                Boots = p.getInventory().getBoots();
            } else {
                Boots = AIR;
            }
            if (PlayerAPI.isBedrock(p)) {
                Inv.clear();
                Inv.setItem(4, ProfileOptions(p));
                Inv.setItem(1, Navigator);
                Inv.setItem(7, MiniMusic);
                p.getInventory().setHelmet(Helmet);
                p.getInventory().setChestplate(Chest);
                p.getInventory().setLeggings(Leggings);
                p.getInventory().setBoots(Boots);
            } else {
                Inv.clear();
                Inv.setItem(9, Placeholder);
                Inv.setItem(10, Placeholder);
                Inv.setItem(11, Placeholder);
                Inv.setItem(12, Placeholder);
                Inv.setItem(13, Placeholder);
                Inv.setItem(14, Placeholder);
                Inv.setItem(15, Placeholder);
                Inv.setItem(16, Placeholder);
                Inv.setItem(17, Placeholder);
                Inv.setItem(18, Placeholder);
                Inv.setItem(4, Maps);
                Inv.setItem(3, ProfileOptions(p));
                Inv.setItem(5, Hider);
                Inv.setItem(19, CosItemManager.removeHat);
                Inv.setItem(21, CosItemManager.removeChest);
                Inv.setItem(20, Placeholder);
                Inv.setItem(22, Placeholder);
                Inv.setItem(24, Placeholder);
                Inv.setItem(23, CosItemManager.removeLeggings);
                Inv.setItem(25, CosItemManager.removeBoots);
                Inv.setItem(26, Placeholder);
                Inv.setItem(27, Placeholder);
                Inv.setItem(28, Placeholder);
                Inv.setItem(29, Placeholder);
                Inv.setItem(30, Placeholder);
                Inv.setItem(31, Placeholder);
                Inv.setItem(32, Placeholder);
                Inv.setItem(33, Placeholder);
                Inv.setItem(34, Placeholder);
                Inv.setItem(35, Placeholder);
                Inv.setItem(1, Navigator);
                Inv.setItem(7, MiniMusic);
                p.getInventory().setHelmet(Helmet);
                p.getInventory().setChestplate(Chest);
                p.getInventory().setLeggings(Leggings);
                p.getInventory().setBoots(Boots);
            }
        }
    }

    public static ItemStack Placeholder = createGuiItem(Material.BLACK_STAINED_GLASS_PANE, "§0");

    public static ItemStack CompassItem01 = createGuiItem(
            Material.valueOf(ConfigAPI.CFG.getString("Core.Compass.Items.Item01")),
            ConfigAPI.CFG.getString("Core.Compass.Names.Item01".replace("&", "§"))
    );

    public static ItemStack CompassItem02 = createGuiItem(
            Material.valueOf(ConfigAPI.CFG.getString("Core.Compass.Items.Item02")),
            ConfigAPI.CFG.getString("Core.Compass.Names.Item02".replace("&", "§"))
    );

    public static ItemStack CompassItem03 = createGuiItem(
            Material.valueOf(ConfigAPI.CFG.getString("Core.Compass.Items.Item03")),
            ConfigAPI.CFG.getString("Core.Compass.Names.Item03".replace("&", "§"))
    );

    public static ItemStack CompassItem04 = createGuiItem(
            Material.valueOf(ConfigAPI.CFG.getString("Core.Compass.Items.Item04")),
            ConfigAPI.CFG.getString("Core.Compass.Names.Item04".replace("&", "§"))
    );

    public static ItemStack CompassItem05 = createGuiItem(
            Material.valueOf(ConfigAPI.CFG.getString("Core.Compass.Items.Item05")),
            ConfigAPI.CFG.getString("Core.Compass.Names.Item05".replace("&", "§"))
    );

    public static ItemStack CompassItem06 = createGuiItem(
            Material.valueOf(ConfigAPI.CFG.getString("Core.Compass.Items.Item06")),
            ConfigAPI.CFG.getString("Core.Compass.Names.Item06".replace("&", "§"))
    );

    public static ItemStack CompassItem07 = createGuiItem(
            Material.valueOf(ConfigAPI.CFG.getString("Core.Compass.Items.Item07")),
            ConfigAPI.CFG.getString("Core.Compass.Names.Item07".replace("&", "§"))
    );

    public static ItemStack Navigator = createGuiItem(
            Material.COMPASS,
            "§bNavigator"
    );

    public static ItemStack Minigames = createGuiItem(
            Material.CLOCK,
            "§bMinigames"
    );

    public static ItemStack Music = createGuiItem(
            Material.JUKEBOX,
            "§bMusik §8(§cBETA§8)"
    );

    public static ItemStack jumper = createGuiItem(
            Material.DIAMOND_BOOTS,
            "§bJumper"
    );

    public static ItemStack Maps = createGuiItem(
            Material.CHEST,
            "§9Maps"
    );

    public static ItemStack Lobby = createGuiItem(
            Material.NETHER_STAR,
            "§bSpawn §8(Lobby)"
    );

    public static ItemStack PixelsAug21 = createGuiItem(
            Material.GREEN_CONCRETE,
            "§bSEASON 1 §8(Pixels Juni 2021-August 2021)"

    );

    public static ItemStack PixelsJan22 = createGuiItem(
            Material.LIME_CONCRETE,
            "§bSEASON 2 §8(Pixels September 2021-Januar 2022)"

    );

    public static ItemStack PixelsApr22 = createGuiItem(
            Material.BLUE_CONCRETE,
            "§bSEASON 3 §8(Pixels Februar 2022-April 2022)"

    );

    public static ItemStack PixelsJun22 = createGuiItem(
            Material.LIGHT_BLUE_CONCRETE,
            "§bSEASON 4 §8(Pixels Mai 2022-Juni 2022)"

    );

    public static ItemStack Primal2_1 = createGuiItem(
            Material.LEATHER_HORSE_ARMOR,
            "§bFalkenwacht §8(Primal 2)"
    );

    public static ItemStack Primal2_2 = createGuiItem(
            Material.IRON_HORSE_ARMOR,
            "§bShervann §8(Primal 2)"
    );

    public static ItemStack Primal3_1 = createGuiItem(
            Material.GOLDEN_SWORD,
            "§bTiefenstein §8(Primal 3)"
    );

    public static ItemStack Primal3_2 = createGuiItem(
            Material.GOLDEN_SHOVEL,
            "§bFalkenwacht §8(Primal 3)"
    );

    public static ItemStack Primal3_3 = createGuiItem(
            Material.GOLDEN_HORSE_ARMOR,
            "§bFalkenwacht Ruinen §8(Primal 3)"
    );

    public static ItemStack Argria1 = createGuiItem(
            Material.OAK_BOAT,
            "§bWolfshaven §8(Argria)"
    );

    public static ItemStack Deadwood1 = createGuiItem(
            Material.DEAD_BUSH,
            "§bDeadwood §8(Deadwood)"
    );

    public static ItemStack StopYes = createGuiItem(
            Material.GREEN_CONCRETE,
            "§aJa§2"
    );

    public static ItemStack ReloadYes = createGuiItem(
            Material.GREEN_CONCRETE,
            "§aJa§r"
    );

    public static ItemStack Cancel = createGuiItem(
            Material.RED_CONCRETE,
            "§cNein§r"
    );

    public static ItemStack Cosmetics = createGuiItem(
            Material.LEATHER_CHESTPLATE,
            "§9Cosmetics"
    );

    public static ItemStack Gadgets = createGuiItem(
            Material.FEATHER,
            "§9Gadgets"
    );

    public static ItemStack Profile(Player p) {
        ItemStack Return = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta ProfileMeta = (SkullMeta) Return.getItemMeta();
        ProfileMeta.setOwningPlayer(p);
        ProfileMeta.setDisplayName("§bFreunde- und Partysystem");
        Return.setItemMeta(ProfileMeta);
        return Return;
    }

    public static ItemStack Profile_old(Player p) {
        ItemStack Return = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta ProfileMeta = (SkullMeta) Return.getItemMeta();
        ProfileMeta.setOwningPlayer(p);
        ProfileMeta.setDisplayName("§bProfil");
        Return.setItemMeta(ProfileMeta);
        return Return;
    }

    public static ItemStack ProfileOptions(Player p) {
        ItemStack Return = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta ProfileMeta = (SkullMeta) Return.getItemMeta();
        ProfileMeta.setOwningPlayer(p);
        ProfileMeta.setDisplayName("§bProfil und Optionen§8");
        Return.setItemMeta(ProfileMeta);
        return Return;
    }

    public static ItemStack Extras = createGuiItem(
            Material.TURTLE_HELMET,
            "§9Cosmetics"
    );

    public static ItemStack MiniMusic = createGuiItem(
            Material.ENDER_CHEST,
            "§bExtras"
    );

    public static ItemStack Hider = createGuiItem(
            Material.BLAZE_ROD,
            "§bSpieler verstecken"
    );

    public static ItemStack Settings = createGuiItem(
            Material.COMPARATOR,
            "§9Einstellungen"
    );

    public static ItemStack barrierHolder = createGuiItem(
            Material.BARRIER,
            "§0"
    );

    public static ItemStack slimeLobby = createGuiItem(
            Material.SLIME_BALL,
            "§aLobby"
    );

    public static ItemStack BackPS = createGuiItem(
            Material.DARK_OAK_DOOR,
            "§e<- Zurück§4§4§4§2 §4"
    );

    public static ItemStack BackCS = createGuiItem(
            Material.DARK_OAK_DOOR,
            "§e<- Zurück§1 §2§6§8§7"
    );

    public static ItemStack BackEX = createGuiItem(
            Material.DARK_OAK_DOOR,
            "§e<- Zurück §3§2§0§4§9"
    );

    public static ItemStack BackTL = createGuiItem(
            Material.LIME_CONCRETE,
            "§aJa, zur Lobby zurückkehren!"
    );

    public static ItemStack FlyItem(Player player) {
        if(Fly.flyPlayers.contains(player)) {
            return createGuiItem(Material.FEATHER,"§aFlugmodus","§eAktiviert");
        } else {
            return createGuiItem(Material.LEATHER_BOOTS,"§cFlugmodus","§eDeaktiviert");
        }
    }

    public static ItemStack AnimateItem(Player player) {
        File TempFile = new File("plugins/Lobbysystem/temp/" + player.getUniqueId().toString() + "_lobbysettings.temp");
        YamlConfiguration TF = YamlConfiguration.loadConfiguration(TempFile);
        boolean hasAnimations = true;
        if(TempFile.exists()) {
            if(TF.contains("Settings.Animations")) {
                hasAnimations = TF.getBoolean("Settings.Animations");
            }
        }
        if(hasAnimations) {
            return createGuiItem(Material.ENDER_EYE,"§aAnimationen","§eAktiviert");
        } else {
            return createGuiItem(Material.ENDER_PEARL,"§cAnimationen","§eDeaktiviert");
        }
    }

    public static ItemStack ScoreboardItem(Player player) {
        File TempFile = new File("plugins/Lobbysystem/temp/" + player.getUniqueId().toString() + "_lobbysettings.temp");
        YamlConfiguration TF = YamlConfiguration.loadConfiguration(TempFile);
        boolean hasScoreboard = true;
        if(TempFile.exists()) {
            if(TF.contains("Settings.Scoreboard")) {
                hasScoreboard = TF.getBoolean("Settings.Scoreboard");
            }
        }
        if(hasScoreboard) {
            return createGuiItem(Material.GLOWSTONE_DUST,"§aScoreboard","§eAktiviert");
        } else {
            return createGuiItem(Material.REDSTONE,"§cScoreboard","§eDeaktiviert");
        }
    }

    public static ItemStack timeItem(int type) {
        ItemStack timeItem;
        if(type == 0) {
            timeItem = createGuiItem(Material.CLOCK,"§cZeit","§eEchte Zeit");
        } else if(type == 2) {
            timeItem = createGuiItem(Material.CLOCK,"§0§r§aZeit§r§0 §r","§eTag");
        } else {
            timeItem = createGuiItem(Material.CLOCK,"§aZeit","§eNacht");
        }
        return timeItem;
    }

    public static ItemStack timeItem(Player player) {
        File TempFile = new File("plugins/Lobbysystem/temp/"+player.getUniqueId().toString()+"_lobbysettings.temp");
        YamlConfiguration TF = YamlConfiguration.loadConfiguration(TempFile);
        if(TempFile.exists()) {
            if(TF.contains("Settings.timeItem")) {
                return timeItem(TF.getInt("Settings.timeItem"));
            } else {
                return timeItem(0);
            }
        } else {
            return timeItem(0);
        }
    }

    public static ItemStack rainItem(int type) {
        ItemStack rainItem;
        if(type == 0) {
            rainItem = createGuiItem(Material.WATER_BUCKET,"§cRegen","§eDeaktiviert");
        } else {
            rainItem = createGuiItem(Material.WATER_BUCKET,"§aRegen","§eAktiviert");
        }
        return rainItem;
    }

    public static ItemStack rainItem(Player player) {
        File TempFile = new File("plugins/Lobbysystem/temp/"+player.getUniqueId().toString()+"_lobbysettings.temp");
        YamlConfiguration TF = YamlConfiguration.loadConfiguration(TempFile);
        if(TempFile.exists()) {
            if(TF.contains("Settings.weatherItem")) {
                return rainItem(TF.getInt("Settings.weatherItem"));
            } else {
                return rainItem(0);
            }
        } else {
            return rainItem(0);
        }
    }

    public static ItemStack bedrockItem = createGuiItem(
            Material.BEDROCK,
            "§cBedrock-Modus",
            "§eAus"
    );

    public static ItemStack rotateStick = createGuiItem(
            Material.STICK,
            "§cRotation-Stick",
            "§7(special)"
    );

    public static ItemStack getWorld() {
        ItemStack itemStack = getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODc5ZTU0Y2JlODc4NjdkMTRiMmZiZGYzZjE4NzA4OTQzNTIwNDhkZmVjZDk2Mjg0NmRlYTg5M2IyMTU0Yzg1In19fQ");
        SkullMeta itemMeta = (SkullMeta)itemStack.getItemMeta();
        itemMeta.setDisplayName("§bWelt");
        return itemStack;
    }

    public static ItemStack getSkull(String value) {
        ItemStack item = new ItemStack(Material.PLAYER_HEAD, 1, (short) 3);
        SkullMeta skullMeta = (SkullMeta) item.getItemMeta();
        skullMeta.setDisplayName("Custom Skull");
        GameProfile gameProfile = new GameProfile(UUID.randomUUID(), null);
        gameProfile.getProperties().put("textures", new Property("textures", value));
        try {
            Field profileField = skullMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(skullMeta, gameProfile);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException fieldException) {
            fieldException.printStackTrace();
        }
        item.setItemMeta(skullMeta);
        return item;
    }
}