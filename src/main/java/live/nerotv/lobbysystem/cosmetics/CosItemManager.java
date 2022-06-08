package live.nerotv.lobbysystem.cosmetics;

import live.nerotv.lobbysystem.Main;
import live.nerotv.lobbysystem.utils.Glow;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.jetbrains.annotations.NotNull;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class CosItemManager {

    public static ItemStack createGuiItem(final Material material, final String name, final String... lore) {
        final ItemStack item = new ItemStack(material, 1);
        final ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore((List) Arrays.asList(lore));
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack hats = createGuiItem(
            Material.LEATHER_HELMET,
            "§bHüte"
    );

    public static ItemStack removeHat() {
        ItemStack RI = createGuiItem(Material.LEATHER_HELMET, "§eHut entfernen");
        return getGlowStack(RI);
    }
    public static ItemStack removeHat = removeHat();

    public static ItemStack removeChest() {
        ItemStack RI = createGuiItem(Material.LEATHER_CHESTPLATE, "§eOberteil entfernen");
        return getGlowStack(RI);
    }
    public static ItemStack removeChest = removeChest();

    public static ItemStack removeLeggings() {
        ItemStack RI = createGuiItem(Material.LEATHER_LEGGINGS, "§eHose entfernen");
        return getGlowStack(RI);
    }
    public static ItemStack removeLeggings = removeLeggings();

    public static ItemStack removeBoots() {
        ItemStack RI = createGuiItem(Material.LEATHER_BOOTS, "§eSchuhe entfernen");
        return getGlowStack(RI);
    }

    @NotNull
    public static ItemStack getGlowStack(ItemStack RI) {
        ItemMeta RM = RI.getItemMeta();
        NamespacedKey key = new NamespacedKey(Main.instance,Main.instance.getDescription().getName());
        Glow glow = new Glow(key);
        RM.addEnchant(glow,1,true);
        RI.setItemMeta(RM);
        return RI;
    }

    public static ItemStack removeBoots = removeBoots();

    public static ItemStack schleimerSkull(Boolean type) {
        ItemStack Skull;
        if(type) {
            Skull = createGuiItem(Material.PLAYER_HEAD, "§aSchleimerHD§8'§7s §7Kopf§r"/*, "§cKlicke zum entfernen"*/);
            SkullMeta skullMeta = (SkullMeta) Skull.getItemMeta();
            skullMeta.setOwner("SchleimerHD");
            Skull.setItemMeta(skullMeta);
        } else {
            Skull = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta skullMeta = (SkullMeta) Skull.getItemMeta();
            skullMeta.setOwner("SchleimerHD");
            skullMeta.setDisplayName("§aSchleimerHD§8'§as §7Kopf");
            Skull.setItemMeta(skullMeta);
        }
        return Skull;
    }

    public static ItemStack nerotvliveSkull(Boolean type) {
        ItemStack Skull;
        if(type) {
            Skull = createGuiItem(Material.PLAYER_HEAD, "§anerotvlive§8'§7s §7Kopf§r"/*, "§cKlicke zum entfernen"*/);
            SkullMeta skullMeta = (SkullMeta) Skull.getItemMeta();
            skullMeta.setOwningPlayer(Bukkit.getOfflinePlayer(UUID.fromString("6447757f-59fe-4206-ae3f-dc68ff2bb6f0")));
            Skull.setItemMeta(skullMeta);
        } else {
            Skull = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta skullMeta = (SkullMeta) Skull.getItemMeta();
            skullMeta.setOwningPlayer(Bukkit.getOfflinePlayer(UUID.fromString("6447757f-59fe-4206-ae3f-dc68ff2bb6f0")));
            skullMeta.setDisplayName("§anerotvlive§8'§as §7Kopf");
            Skull.setItemMeta(skullMeta);
        }
        return Skull;
    }

    public static ItemStack ideallauchSkull(Boolean type) {
        ItemStack Skull;
        if(type) {
            Skull = createGuiItem(Material.PLAYER_HEAD, "§aideallauch§8'§7s §7Kopf§r"/*, "§cKlicke zum entfernen"*/);
            SkullMeta skullMeta = (SkullMeta) Skull.getItemMeta();
            skullMeta.setOwner("ideallauch");
            Skull.setItemMeta(skullMeta);
        } else {
            Skull = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta skullMeta = (SkullMeta) Skull.getItemMeta();
            skullMeta.setOwner("ideallauch");
            skullMeta.setDisplayName("§aideallauch§8'§as §7Kopf");
            Skull.setItemMeta(skullMeta);
        }
        return Skull;
    }

    public static ItemStack fantasticotvSkull(Boolean type) {
        ItemStack Skull;
        if(type) {
            Skull = createGuiItem(Material.PLAYER_HEAD, "§aFantasticoTV§8'§7s §7Kopf§r"/*, "§cKlicke zum entfernen"*/);
            SkullMeta skullMeta = (SkullMeta) Skull.getItemMeta();
            skullMeta.setOwner("FantasticoTV");
            Skull.setItemMeta(skullMeta);
        } else {
            Skull = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta skullMeta = (SkullMeta) Skull.getItemMeta();
            skullMeta.setOwner("FantasticoTV");
            skullMeta.setDisplayName("§aFantasticoTV§8'§as §7Kopf");
            Skull.setItemMeta(skullMeta);
        }
        return Skull;
    }

    public static ItemStack add_westSkull(Boolean type) {
        ItemStack Skull;
        if(type) {
            Skull = createGuiItem(Material.PLAYER_HEAD, "§aadd_West§8'§7s §7Kopf§r"/*, "§cKlicke zum entfernen"*/);
            SkullMeta skullMeta = (SkullMeta) Skull.getItemMeta();
            skullMeta.setOwner("add_West");
            Skull.setItemMeta(skullMeta);
        } else {
            Skull = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta skullMeta = (SkullMeta) Skull.getItemMeta();
            skullMeta.setOwner("add_West");
            skullMeta.setDisplayName("§aadd_West§8'§as §7Kopf");
            Skull.setItemMeta(skullMeta);
        }
        return Skull;
    }

    public static ItemStack mercySkull(Boolean type) {
        ItemStack Skull;
        if(type) {
            Skull = createGuiItem(Material.PLAYER_HEAD, "§aMercy21718§8'§7s §7Kopf§r"/*, "§cKlicke zum entfernen"*/);
            SkullMeta skullMeta = (SkullMeta) Skull.getItemMeta();
            skullMeta.setOwner("Mercy21718");
            Skull.setItemMeta(skullMeta);
        } else {
            Skull = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta skullMeta = (SkullMeta) Skull.getItemMeta();
            skullMeta.setOwner("Mercy21718");
            skullMeta.setDisplayName("§aMercy21718§8'§as §7Kopf");
            Skull.setItemMeta(skullMeta);
        }
        return Skull;
    }

    public static ItemStack ungeSkull(Boolean type) {
        ItemStack Skull;
        if(type) {
            Skull = createGuiItem(Material.PLAYER_HEAD, "§aungespielt§8'§7s §7Kopf§r"/*, "§cKlicke zum entfernen"*/);
            SkullMeta skullMeta = (SkullMeta) Skull.getItemMeta();
            skullMeta.setOwner("ungespielt");
            Skull.setItemMeta(skullMeta);
        } else {
            Skull = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta skullMeta = (SkullMeta) Skull.getItemMeta();
            skullMeta.setOwner("ungespielt");
            skullMeta.setDisplayName("§aungespielt§8'§as §7Kopf");
            Skull.setItemMeta(skullMeta);
        }
        return Skull;
    }

    public static ItemStack attisanderSkull(Boolean type) {
        ItemStack Skull;
            if (type) {
                Skull = createGuiItem(Material.PLAYER_HEAD, "§aAttisander§8'§7s §7Kopf§r"/*, "§cKlicke zum entfernen"*/);
                SkullMeta skullMeta = (SkullMeta) Skull.getItemMeta();
                skullMeta.setOwningPlayer(Bukkit.getOfflinePlayer(UUID.fromString("f8aebea3-1a9d-406f-8fc6-e0f3cab29988")));
                Skull.setItemMeta(skullMeta);
            } else {
                Skull = new ItemStack(Material.PLAYER_HEAD);
                SkullMeta skullMeta = (SkullMeta) Skull.getItemMeta();
                skullMeta.setOwningPlayer(Bukkit.getOfflinePlayer(UUID.fromString("f8aebea3-1a9d-406f-8fc6-e0f3cab29988")));
                skullMeta.setDisplayName("§aAttisander§8'§as §7Kopf");
                Skull.setItemMeta(skullMeta);
            }
        return Skull;
    }

    public static ItemStack herrbergmannSkull(Boolean type) {
        ItemStack Skull;
        if(type) {
            Skull = createGuiItem(Material.PLAYER_HEAD, "§aHerrBergmann§8'§7s §7Kopf§r"/*, "§cKlicke zum entfernen"*/);
            SkullMeta skullMeta = (SkullMeta) Skull.getItemMeta();
            skullMeta.setOwner("HerrBergmann");
            Skull.setItemMeta(skullMeta);
        } else {
            Skull = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta skullMeta = (SkullMeta) Skull.getItemMeta();
            skullMeta.setOwner("HerrBergmann");
            skullMeta.setDisplayName("§aHerrBergmann§8'§as §7Kopf");
            Skull.setItemMeta(skullMeta);
        }
        return Skull;
    }

    public static ItemStack pauulSkull(Boolean type) {
        ItemStack Skull;
        if(type) {
            Skull = createGuiItem(Material.PLAYER_HEAD, "§aMaxi15122§8'§7s §7Kopf§r"/*, "§cKlicke zum entfernen"*/);
            SkullMeta skullMeta = (SkullMeta) Skull.getItemMeta();
            skullMeta.setOwner("Maxi15122");
            Skull.setItemMeta(skullMeta);
        } else {
            Skull = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta skullMeta = (SkullMeta) Skull.getItemMeta();
            skullMeta.setOwner("Maxi15122");
            skullMeta.setDisplayName("§aMaxi15122§8'§as §7Kopf");
            Skull.setItemMeta(skullMeta);
        }
        return Skull;
    }

    public static ItemStack Maxi15122Skull(Boolean type) {
        ItemStack Skull;
        if(type) {
            Skull = createGuiItem(Material.PLAYER_HEAD, "§aMaxi15122§8'§7s §7Kopf§r"/*, "§cKlicke zum entfernen"*/);
            SkullMeta skullMeta = (SkullMeta) Skull.getItemMeta();
            skullMeta.setOwningPlayer(Bukkit.getOfflinePlayer(UUID.fromString("7409e8aa-a356-4a3c-a48c-64e213cca19f")));
            Skull.setItemMeta(skullMeta);
        } else {
            Skull = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta skullMeta = (SkullMeta) Skull.getItemMeta();
            skullMeta.setOwningPlayer(Bukkit.getOfflinePlayer(UUID.fromString("7409e8aa-a356-4a3c-a48c-64e213cca19f")));
            skullMeta.setDisplayName("§aMaxi15122§8'§as §7Kopf");
            Skull.setItemMeta(skullMeta);
        }
        return Skull;
    }

    public static ItemStack spongeHat(Boolean type) {
        ItemStack Skull;
        if(type) {
            Skull = createGuiItem(Material.SPONGE, "§0§aSchwammkopf§0§r");
        } else {
            Skull = createGuiItem(Material.SPONGE, "§aSchwammkopf");
        }
        return Skull;
    }

    public static ItemStack glassHat(Boolean type) {
        ItemStack Skull;
        if(type) {
            Skull = createGuiItem(Material.GLASS, "§0§aGlaskopf§0§r");
        } else {
            Skull = createGuiItem(Material.GLASS, "§aGlaskopf");
        }
        return Skull;
    }

    public static ItemStack musicHat(Boolean type) {
        ItemStack Skull;
        if(type) {
            Skull = createGuiItem(Material.JUKEBOX, "§0§aMusikbox§0§r");
        } else {
            Skull = createGuiItem(Material.JUKEBOX, "§aMusikbox");
        }
        return Skull;
    }

    public static ItemStack explosiveHat(Boolean type) {
        ItemStack Skull;
        if(type) {
            Skull = createGuiItem(Material.TNT, "§0§aTNT§0§r");
        } else {
            Skull = createGuiItem(Material.TNT, "§aTNT");
        }
        return Skull;
    }

    public static ItemStack pumpkinHat(Boolean type) {
        ItemStack Skull;
        if(type) {
            Skull = createGuiItem(Material.JACK_O_LANTERN, "§0§aKürbislaterne§0§r");
        } else {
            Skull = createGuiItem(Material.JACK_O_LANTERN, "§aKürbislaterne");
        }
        return Skull;
    }

    public static ItemStack bookHat(Boolean type) {
        ItemStack Skull;
        if(type) {
            Skull = createGuiItem(Material.BOOKSHELF, "§0§aBücherkopf§0§r");
        } else {
            Skull = createGuiItem(Material.BOOKSHELF, "§aBücherkopf");
        }
        return Skull;
    }

    public static ItemStack melonHat(Boolean type) {
        ItemStack Skull;
        if(type) {
            Skull = createGuiItem(Material.MELON, "§0§aMelonenkopf§0§r");
        } else {
            Skull = createGuiItem(Material.MELON, "§aMelonenkopf");
        }
        return Skull;
    }

    public static ItemStack turtleHelmet(Boolean type) {
        ItemStack Skull;
        if(type) {
            Skull = createGuiItem(Material.TURTLE_HELMET, "§0§aSchildkrötenhelm§0§r");
        } else {
            Skull = createGuiItem(Material.TURTLE_HELMET, "§aSchildkrötenhelm");
        }
        return Skull;
    }

    public static ItemStack leatherHelmet(Boolean type) {
        ItemStack Skull;
        if(type) {
            Skull = createGuiItem(Material.LEATHER_HELMET, "§0§aLederhelm§0§r");
        } else {
            Skull = createGuiItem(Material.LEATHER_HELMET, "§aLederhelm");
        }
        return Skull;
    }

    public static ItemStack chainHelmet(Boolean type) {
        ItemStack Skull;
        if(type) {
            Skull = createGuiItem(Material.CHAINMAIL_HELMET, "§0§aKettenhelm§0§r");
        } else {
            Skull = createGuiItem(Material.CHAINMAIL_HELMET, "§aKettenhelm");
        }
        return Skull;
    }

    public static ItemStack ironHelmet(Boolean type) {
        ItemStack Skull;
        if(type) {
            Skull = createGuiItem(Material.IRON_HELMET, "§0§aEisenhelm§0§r");
        } else {
            Skull = createGuiItem(Material.IRON_HELMET, "§aEisenhelm");
        }
        return Skull;
    }

    public static ItemStack goldHelmet(Boolean type) {
        ItemStack Skull;
        if(type) {
            Skull = createGuiItem(Material.GOLDEN_HELMET, "§0§aGoldhelm§0§r");
        } else {
            Skull = createGuiItem(Material.GOLDEN_HELMET, "§aGoldhelm");
        }
        return Skull;
    }

    public static ItemStack diamondHelmet(Boolean type) {
        ItemStack Skull;
        if(type) {
            Skull = createGuiItem(Material.DIAMOND_HELMET, "§0§aDiamanthelm§0§r");
        } else {
            Skull = createGuiItem(Material.DIAMOND_HELMET, "§aDiamanthelm");
        }
        return Skull;
    }

    public static ItemStack netheriteHelmet(Boolean type) {
        ItemStack Skull;
        if(type) {
            Skull = createGuiItem(Material.NETHERITE_HELMET, "§0§aNetherithelm§0§r");
        } else {
            Skull = createGuiItem(Material.NETHERITE_HELMET, "§aNetherithelm");
        }
        return Skull;
    }

    public static ItemStack leatherChest(Boolean type) {
        ItemStack Skull;
        if(type) {
            Skull = createGuiItem(Material.LEATHER_CHESTPLATE, "§0§aLederharnisch§0§r");
        } else {
            Skull = createGuiItem(Material.LEATHER_CHESTPLATE, "§aLederharnisch");
        }
        return Skull;
    }

    public static ItemStack chainChest(Boolean type) {
        ItemStack Skull;
        if(type) {
            Skull = createGuiItem(Material.CHAINMAIL_CHESTPLATE, "§0§aKettenharnisch§0§r");
        } else {
            Skull = createGuiItem(Material.CHAINMAIL_CHESTPLATE, "§aKettenharnisch");
        }
        return Skull;
    }

    public static ItemStack ironChest(Boolean type) {
        ItemStack Skull;
        if(type) {
            Skull = createGuiItem(Material.IRON_CHESTPLATE, "§0§aEisenharnisch§0§r");
        } else {
            Skull = createGuiItem(Material.IRON_CHESTPLATE, "§aEisenharnisch");
        }
        return Skull;
    }

    public static ItemStack goldChest(Boolean type) {
        ItemStack Skull;
        if(type) {
            Skull = createGuiItem(Material.GOLDEN_CHESTPLATE, "§0§aGoldharnisch§0§r");
        } else {
            Skull = createGuiItem(Material.GOLDEN_CHESTPLATE, "§aGoldharnisch");
        }
        return Skull;
    }

    public static ItemStack diamondChest(Boolean type) {
        ItemStack Skull;
        if(type) {
            Skull = createGuiItem(Material.DIAMOND_CHESTPLATE, "§0§aDiamantharnisch§0§r");
        } else {
            Skull = createGuiItem(Material.DIAMOND_CHESTPLATE, "§aDiamantharnisch");
        }
        return Skull;
    }

    public static ItemStack netheriteChest(Boolean type) {
        ItemStack Skull;
        if(type) {
            Skull = createGuiItem(Material.NETHERITE_CHESTPLATE, "§0§aNetheritharnisch§0§r");
        } else {
            Skull = createGuiItem(Material.NETHERITE_CHESTPLATE, "§aNetheritharnisch");
        }
        return Skull;
    }

    public static ItemStack leatherLeggings(Boolean type) {
        ItemStack Skull;
        if(type) {
            Skull = createGuiItem(Material.LEATHER_LEGGINGS, "§0§aLederhose§0§r");
        } else {
            Skull = createGuiItem(Material.LEATHER_LEGGINGS, "§aLederhose");
        }
        return Skull;
    }

    public static ItemStack chainLeggings(Boolean type) {
        ItemStack Skull;
        if(type) {
            Skull = createGuiItem(Material.CHAINMAIL_LEGGINGS, "§0§aKettenhose§0§r");
        } else {
            Skull = createGuiItem(Material.CHAINMAIL_LEGGINGS, "§aKettenhose");
        }
        return Skull;
    }

    public static ItemStack ironLeggings(Boolean type) {
        ItemStack Skull;
        if(type) {
            Skull = createGuiItem(Material.IRON_LEGGINGS, "§0§aEisenhose§0§r");
        } else {
            Skull = createGuiItem(Material.IRON_LEGGINGS, "§aEisenhose");
        }
        return Skull;
    }

    public static ItemStack goldLeggings(Boolean type) {
        ItemStack Skull;
        if(type) {
            Skull = createGuiItem(Material.GOLDEN_LEGGINGS, "§0§aGoldhose§0§r");
        } else {
            Skull = createGuiItem(Material.GOLDEN_LEGGINGS, "§aGoldhose");
        }
        return Skull;
    }

    public static ItemStack diamondLeggings(Boolean type) {
        ItemStack Skull;
        if(type) {
            Skull = createGuiItem(Material.DIAMOND_LEGGINGS, "§0§aDiamanthose§0§r");
        } else {
            Skull = createGuiItem(Material.DIAMOND_LEGGINGS, "§aDiamanthose");
        }
        return Skull;
    }

    public static ItemStack netheriteLeggings(Boolean type) {
        ItemStack Skull;
        if(type) {
            Skull = createGuiItem(Material.NETHERITE_LEGGINGS, "§0§aNetherithose§0§r");
        } else {
            Skull = createGuiItem(Material.NETHERITE_LEGGINGS, "§aNetherithose");
        }
        return Skull;
    }

    public static ItemStack leatherBoots(Boolean type) {
        ItemStack Skull;
        if(type) {
            Skull = createGuiItem(Material.LEATHER_BOOTS, "§0§aLederschuhe§0§r");
        } else {
            Skull = createGuiItem(Material.LEATHER_BOOTS, "§aLederschuhe");
        }
        return Skull;
    }

    public static ItemStack chainBoots(Boolean type) {
        ItemStack Skull;
        if(type) {
            Skull = createGuiItem(Material.CHAINMAIL_BOOTS, "§0§aKettenschuhe§0§r");
        } else {
            Skull = createGuiItem(Material.CHAINMAIL_BOOTS, "§aKettenschuhe");
        }
        return Skull;
    }

    public static ItemStack ironBoots(Boolean type) {
        ItemStack Skull;
        if(type) {
            Skull = createGuiItem(Material.IRON_BOOTS, "§0§aEisenschuhe§0§r");
        } else {
            Skull = createGuiItem(Material.IRON_BOOTS, "§aEisenschuhe");
        }
        return Skull;
    }

    public static ItemStack goldBoots(Boolean type) {
        ItemStack Skull;
        if(type) {
            Skull = createGuiItem(Material.GOLDEN_BOOTS, "§0§aGoldschuhe§0§r");
        } else {
            Skull = createGuiItem(Material.GOLDEN_BOOTS, "§aGoldschuhe");
        }
        return Skull;
    }

    public static ItemStack diamondBoots(Boolean type) {
        ItemStack Skull;
        if(type) {
            Skull = createGuiItem(Material.DIAMOND_BOOTS, "§0§aDiamantschuhe§0§r");
        } else {
            Skull = createGuiItem(Material.DIAMOND_BOOTS, "§aDiamantschuhe");
        }
        return Skull;
    }

    public static ItemStack netheriteBoots(Boolean type) {
        ItemStack Skull;
        if(type) {
            Skull = createGuiItem(Material.NETHERITE_BOOTS, "§0§aNetheritschuhe§0§r");
        } else {
            Skull = createGuiItem(Material.NETHERITE_BOOTS, "§aNetheritschuhe");
        }
        return Skull;
    }

    public static ItemStack chests = createGuiItem(
            Material.LEATHER_CHESTPLATE,
            "§bOberteile"
    );

    public static ItemStack leggings = createGuiItem(
            Material.LEATHER_LEGGINGS,
            "§bHosen"
    );

    public static ItemStack boots = createGuiItem(
            Material.LEATHER_BOOTS,
            "§bSchuhe"
    );
}