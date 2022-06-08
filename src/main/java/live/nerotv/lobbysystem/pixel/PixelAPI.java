package live.nerotv.lobbysystem.pixel;

import live.nerotv.lobbysystem.manager.ItemManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PixelAPI {

    public static void givePixelItems(Player p) {
        Inventory Inv = p.getInventory();
        Inv.addItem(new ItemStack(Material.WHITE_TERRACOTTA));
        Inv.addItem(new ItemStack(Material.ORANGE_TERRACOTTA));
        Inv.addItem(new ItemStack(Material.MAGENTA_TERRACOTTA));
        Inv.addItem(new ItemStack(Material.LIGHT_BLUE_TERRACOTTA));
        Inv.addItem(new ItemStack(Material.YELLOW_TERRACOTTA));
        Inv.addItem(new ItemStack(Material.LIME_TERRACOTTA));
        Inv.addItem(new ItemStack(Material.PINK_TERRACOTTA));
        Inv.addItem(new ItemStack(Material.GRAY_TERRACOTTA));
        Inv.addItem(new ItemStack(Material.LIGHT_GRAY_TERRACOTTA));
        Inv.addItem(new ItemStack(Material.CYAN_TERRACOTTA));
        Inv.addItem(new ItemStack(Material.PURPLE_TERRACOTTA));
        Inv.addItem(new ItemStack(Material.BLUE_TERRACOTTA));
        Inv.addItem(new ItemStack(Material.BROWN_TERRACOTTA));
        Inv.addItem(new ItemStack(Material.GREEN_TERRACOTTA));
        Inv.addItem(new ItemStack(Material.RED_TERRACOTTA));
        Inv.addItem(new ItemStack(Material.BLACK_TERRACOTTA));
        Inv.addItem(new ItemStack(Material.TERRACOTTA));
        Inv.addItem(new ItemStack(Material.WHITE_CONCRETE));
        Inv.addItem(new ItemStack(Material.ORANGE_CONCRETE));
        Inv.addItem(new ItemStack(Material.MAGENTA_CONCRETE));
        Inv.addItem(new ItemStack(Material.LIGHT_BLUE_CONCRETE));
        Inv.addItem(new ItemStack(Material.YELLOW_CONCRETE));
        Inv.addItem(new ItemStack(Material.LIME_CONCRETE));
        Inv.addItem(new ItemStack(Material.PINK_CONCRETE));
        Inv.addItem(new ItemStack(Material.GRAY_CONCRETE));
        Inv.addItem(new ItemStack(Material.LIGHT_GRAY_CONCRETE));
        Inv.addItem(new ItemStack(Material.CYAN_CONCRETE));
        Inv.addItem(new ItemStack(Material.PURPLE_CONCRETE));
        Inv.addItem(new ItemStack(Material.BLUE_CONCRETE));
        Inv.addItem(new ItemStack(Material.BROWN_CONCRETE));
        Inv.addItem(new ItemStack(Material.GREEN_CONCRETE));
        Inv.addItem(new ItemStack(Material.RED_CONCRETE));
        Inv.addItem(new ItemStack(Material.BLACK_CONCRETE));
        ItemStack save = Inv.getItem(8);
        Inv.clear(8);
        Inv.setItem(8, ItemManager.slimeLobby);
        if(save!=null) {
            Inv.addItem(save);
        }
    }
}