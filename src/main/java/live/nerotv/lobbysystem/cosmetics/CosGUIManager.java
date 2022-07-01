package live.nerotv.lobbysystem.cosmetics;

import live.nerotv.lobbysystem.Main;
import live.nerotv.lobbysystem.api.PlayerAPI;
import live.nerotv.lobbysystem.manager.GUIManager;
import live.nerotv.lobbysystem.manager.ItemManager;
import live.nerotv.lobbysystem.utils.Countdown;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CosGUIManager {

    private static ItemStack i28;
    private static ItemStack i29;
    private static ItemStack i30;
    private static ItemStack i31;
    private static ItemStack i32;
    private static ItemStack i33;
    private static ItemStack i34;
    private static ItemStack i10;
    private static ItemStack i11;
    private static ItemStack i12;
    private static ItemStack i13;
    private static ItemStack i14;
    private static ItemStack i19;
    private static ItemStack i20;
    private static ItemStack i21;
    private static ItemStack i22;
    private static ItemStack i23;
    private static ItemStack i37;
    private static ItemStack i38;
    private static ItemStack i39;
    private static ItemStack i40;
    private static ItemStack i41;
    private static ItemStack i42;
    private static ItemStack i43;

    public static Inventory skullInventory = Bukkit.createInventory(null, 54, "§bHüte");
    public static void initSkullInventory() {
        GUIManager.fillInventory(skullInventory);
        i28 = CosItemManager.glassHat(false);
        i29 = CosItemManager.spongeHat(false);
        i30 = CosItemManager.bookHat(false);
        i31 = CosItemManager.melonHat(false);
        i32 = CosItemManager.musicHat(false);
        i33 = CosItemManager.explosiveHat(false);
        i34 = CosItemManager.pumpkinHat(false);
        i10 = CosItemManager.nerotvliveSkull(false);
        i11 = CosItemManager.fantasticotvSkull(false);
        i12 = CosItemManager.add_westSkull(false);
        i13 = CosItemManager.ideallauchSkull(false);
        i14 = CosItemManager.schleimerSkull(false);
        i19 = CosItemManager.pauulSkull(false);
        i20 = CosItemManager.mercySkull(false);
        i21 = CosItemManager.herrbergmannSkull(false);
        i22 = CosItemManager.attisanderSkull(false);
        i23 = CosItemManager.ungeSkull(false);
        i37 = CosItemManager.turtleHelmet(false);
        i38 = CosItemManager.leatherHelmet(false);
        i39 = CosItemManager.chainHelmet(false);
        i40 = CosItemManager.ironHelmet(false);
        i41 = CosItemManager.goldHelmet(false);
        i42 = CosItemManager.diamondHelmet(false);
        i43 = CosItemManager.netheriteHelmet(false);
    }

    public static void openCosmeticsInventory(Player p) {
        Inventory cosmeticsInventory = Bukkit.createInventory(null,9,"§bCosmetics");
        GUIManager.fillInventory(cosmeticsInventory);

        p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG,100,100);
        if(!PlayerAPI.hasAnimations(p)) {
            cosmeticsInventory.setItem(1, CosItemManager.hats);
            cosmeticsInventory.setItem(2, CosItemManager.chests);
            cosmeticsInventory.setItem(4, CosItemManager.leggings);
            cosmeticsInventory.setItem(5, CosItemManager.boots);
            cosmeticsInventory.setItem(7, ItemManager.BackEX);
        } else {
            new Countdown(5, Main.get()) {
                @Override
                public void count(int time) {
                    if (time == 4) {
                        if (p.getOpenInventory().getTopInventory() == cosmeticsInventory) {
                            p.playSound(p.getLocation(), Sound.ITEM_BUNDLE_DROP_CONTENTS, 1, 255);
                        }
                        cosmeticsInventory.setItem(1, CosItemManager.hats);
                    } else if (time == 3) {
                        if (p.getOpenInventory().getTopInventory() == cosmeticsInventory) {
                            p.playSound(p.getLocation(), Sound.ITEM_BUNDLE_DROP_CONTENTS, 1, 255);
                        }
                        cosmeticsInventory.setItem(2, CosItemManager.chests);
                    } else if (time == 2) {
                        if (p.getOpenInventory().getTopInventory() == cosmeticsInventory) {
                            p.playSound(p.getLocation(), Sound.ITEM_BUNDLE_DROP_CONTENTS, 1, 255);
                        }
                        cosmeticsInventory.setItem(4, CosItemManager.leggings);
                    } else if (time == 1) {
                        if (p.getOpenInventory().getTopInventory() == cosmeticsInventory) {
                            p.playSound(p.getLocation(), Sound.ITEM_BUNDLE_DROP_CONTENTS, 1, 255);
                        }
                        cosmeticsInventory.setItem(5, CosItemManager.boots);
                    } else if (time == 0) {
                        if (p.getOpenInventory().getTopInventory() == cosmeticsInventory) {
                            p.playSound(p.getLocation(), Sound.ITEM_BUNDLE_DROP_CONTENTS, 1, 255);
                        }
                        cosmeticsInventory.setItem(7, ItemManager.BackEX);
                    }
                }
            }.startTicks();
        }
        p.openInventory(cosmeticsInventory);
    }

    public static void openChestsInventory(Player p) {
        Inventory chestsInventory = Bukkit.createInventory(null,9,"§bOberteile");
        GUIManager.fillInventory(chestsInventory);
        p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG,100,100);
        if(!PlayerAPI.hasAnimations(p)) {
            chestsInventory.setItem(4, CosItemManager.goldChest(false));
            chestsInventory.setItem(3, CosItemManager.ironChest(false));
            chestsInventory.setItem(5, CosItemManager.diamondChest(false));
            chestsInventory.setItem(2, CosItemManager.chainChest(false));
            chestsInventory.setItem(6, CosItemManager.netheriteChest(false));
            chestsInventory.setItem(1, CosItemManager.leatherChest(false));
            chestsInventory.setItem(7, ItemManager.BackCS);
        } else {
            new Countdown(4, Main.get()) {
                @Override
                public void count(int time) {
                    if (time == 3) {
                        if (p.getOpenInventory().getTopInventory() == chestsInventory) {
                            p.playSound(p.getLocation(), Sound.ITEM_BUNDLE_DROP_CONTENTS, 1, 255);
                        }
                        chestsInventory.setItem(4, CosItemManager.goldChest(false));
                    } else if (time == 2) {
                        if (p.getOpenInventory().getTopInventory() == chestsInventory) {
                            p.playSound(p.getLocation(), Sound.ITEM_BUNDLE_DROP_CONTENTS, 1, 255);
                        }
                        chestsInventory.setItem(3, CosItemManager.ironChest(false));
                        chestsInventory.setItem(5, CosItemManager.diamondChest(false));
                    } else if (time == 1) {
                        if (p.getOpenInventory().getTopInventory() == chestsInventory) {
                            p.playSound(p.getLocation(), Sound.ITEM_BUNDLE_DROP_CONTENTS, 1, 255);
                        }
                        chestsInventory.setItem(2, CosItemManager.chainChest(false));
                        chestsInventory.setItem(6, CosItemManager.netheriteChest(false));
                    } else if (time == 0) {
                        if (p.getOpenInventory().getTopInventory() == chestsInventory) {
                            p.playSound(p.getLocation(), Sound.ITEM_BUNDLE_DROP_CONTENTS, 1, 255);
                        }
                        chestsInventory.setItem(1, CosItemManager.leatherChest(false));
                        chestsInventory.setItem(7, ItemManager.BackCS);
                    }
                }
            }.startTicks();
        }
        p.openInventory(chestsInventory);
    }

    public static void openLeggingsInventory(Player p) {
        Inventory chestsInventory = Bukkit.createInventory(null,9,"§bOberteile");
        GUIManager.fillInventory(chestsInventory);
        p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG,100,100);
        if(!PlayerAPI.hasAnimations(p)) {
            chestsInventory.setItem(4, CosItemManager.goldLeggings(false));
            chestsInventory.setItem(3, CosItemManager.ironLeggings(false));
            chestsInventory.setItem(5, CosItemManager.diamondLeggings(false));
            chestsInventory.setItem(2, CosItemManager.chainLeggings(false));
            chestsInventory.setItem(6, CosItemManager.netheriteLeggings(false));
            chestsInventory.setItem(1, CosItemManager.leatherLeggings(false));
            chestsInventory.setItem(7, ItemManager.BackCS);
        } else {
            new Countdown(4, Main.get()) {
                @Override
                public void count(int time) {
                    if (time == 3) {
                        if (p.getOpenInventory().getTopInventory() == chestsInventory) {
                            p.playSound(p.getLocation(), Sound.ITEM_BUNDLE_DROP_CONTENTS, 1, 255);
                        }
                        chestsInventory.setItem(4, CosItemManager.goldLeggings(false));
                    } else if (time == 2) {
                        if (p.getOpenInventory().getTopInventory() == chestsInventory) {
                            p.playSound(p.getLocation(), Sound.ITEM_BUNDLE_DROP_CONTENTS, 1, 255);
                        }
                        chestsInventory.setItem(3, CosItemManager.ironLeggings(false));
                        chestsInventory.setItem(5, CosItemManager.diamondLeggings(false));
                    } else if (time == 1) {
                        if (p.getOpenInventory().getTopInventory() == chestsInventory) {
                            p.playSound(p.getLocation(), Sound.ITEM_BUNDLE_DROP_CONTENTS, 1, 255);
                        }
                        chestsInventory.setItem(2, CosItemManager.chainLeggings(false));
                        chestsInventory.setItem(6, CosItemManager.netheriteLeggings(false));
                    } else if (time == 0) {
                        if (p.getOpenInventory().getTopInventory() == chestsInventory) {
                            p.playSound(p.getLocation(), Sound.ITEM_BUNDLE_DROP_CONTENTS, 1, 255);
                        }
                        chestsInventory.setItem(1, CosItemManager.leatherLeggings(false));
                        chestsInventory.setItem(7, ItemManager.BackCS);
                    }
                }
            }.startTicks();
        }
        p.openInventory(chestsInventory);
    }

    public static void openBootsInventory(Player p) {
        Inventory chestsInventory = Bukkit.createInventory(null,9,"§bOberteile");
        GUIManager.fillInventory(chestsInventory);
        if(!PlayerAPI.hasAnimations(p)) {
            chestsInventory.setItem(4, CosItemManager.goldBoots(false));
            chestsInventory.setItem(3, CosItemManager.ironBoots(false));
            chestsInventory.setItem(5, CosItemManager.diamondBoots(false));
            chestsInventory.setItem(2, CosItemManager.chainBoots(false));
            chestsInventory.setItem(6, CosItemManager.netheriteBoots(false));
            chestsInventory.setItem(1, CosItemManager.leatherBoots(false));
            chestsInventory.setItem(7, ItemManager.BackCS);
        } else {
            new Countdown(4, Main.get()) {
                @Override
                public void count(int time) {
                    if (time == 3) {
                        if (p.getOpenInventory().getTopInventory() == chestsInventory) {
                            p.playSound(p.getLocation(), Sound.ITEM_BUNDLE_DROP_CONTENTS, 1, 255);
                        }
                        chestsInventory.setItem(4, CosItemManager.goldBoots(false));
                    } else if (time == 2) {
                        if (p.getOpenInventory().getTopInventory() == chestsInventory) {
                            p.playSound(p.getLocation(), Sound.ITEM_BUNDLE_DROP_CONTENTS, 1, 255);
                        }
                        chestsInventory.setItem(3, CosItemManager.ironBoots(false));
                        chestsInventory.setItem(5, CosItemManager.diamondBoots(false));
                    } else if (time == 1) {
                        if (p.getOpenInventory().getTopInventory() == chestsInventory) {
                            p.playSound(p.getLocation(), Sound.ITEM_BUNDLE_DROP_CONTENTS, 1, 255);
                        }
                        chestsInventory.setItem(2, CosItemManager.chainBoots(false));
                        chestsInventory.setItem(6, CosItemManager.netheriteBoots(false));
                    } else if (time == 0) {
                        if (p.getOpenInventory().getTopInventory() == chestsInventory) {
                            p.playSound(p.getLocation(), Sound.ITEM_BUNDLE_DROP_CONTENTS, 1, 255);
                        }
                        chestsInventory.setItem(1, CosItemManager.leatherBoots(false));
                        chestsInventory.setItem(7, ItemManager.BackCS);
                    }
                }
            }.startTicks();
        }
        p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG,100,100);
        p.openInventory(chestsInventory);
    }

    public static void openSkullInventory(Player p) {
        GUIManager.fillInventory(skullInventory);
        p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG,100,100);
        if(!PlayerAPI.hasAnimations(p)) {
            skullInventory.setItem(10, i10);
            skullInventory.setItem(11, i11);
            skullInventory.setItem(12, i12);
            skullInventory.setItem(13, i13);
            skullInventory.setItem(14, i14);
            skullInventory.setItem(16, ItemManager.BackCS);
            skullInventory.setItem(19, i19);
            skullInventory.setItem(20, i20);
            skullInventory.setItem(21, i21);
            skullInventory.setItem(22, i22);
            skullInventory.setItem(23, i23);
            skullInventory.setItem(28, i28);
            skullInventory.setItem(29, i29);
            skullInventory.setItem(30, i30);
            skullInventory.setItem(31, i31);
            skullInventory.setItem(32, i32);
            skullInventory.setItem(33, i33);
            skullInventory.setItem(34, i34);
            skullInventory.setItem(37, i37);
            skullInventory.setItem(38, i38);
            skullInventory.setItem(39, i39);
            skullInventory.setItem(40, i40);
            skullInventory.setItem(41, i41);
            skullInventory.setItem(42, i42);
            skullInventory.setItem(43, i43);
        } else {
            new Countdown(25, Main.get()) {
                @Override
                public void count(int time) {
                    if (time == 24) {
                        if (p.getOpenInventory().getTopInventory() == skullInventory) {
                            p.playSound(p.getLocation(), Sound.ITEM_BUNDLE_DROP_CONTENTS, 1, 255);
                        }
                        skullInventory.setItem(10, i10);
                    } else if (time == 23) {
                        if (p.getOpenInventory().getTopInventory() == skullInventory) {
                            p.playSound(p.getLocation(), Sound.ITEM_BUNDLE_DROP_CONTENTS, 1, 255);
                        }
                        skullInventory.setItem(11, i11);
                    } else if (time == 22) {
                        if (p.getOpenInventory().getTopInventory() == skullInventory) {
                            p.playSound(p.getLocation(), Sound.ITEM_BUNDLE_DROP_CONTENTS, 1, 255);
                        }
                        skullInventory.setItem(12, i12);
                    } else if (time == 21) {
                        if (p.getOpenInventory().getTopInventory() == skullInventory) {
                            p.playSound(p.getLocation(), Sound.ITEM_BUNDLE_DROP_CONTENTS, 1, 255);
                        }
                        skullInventory.setItem(13, i13);
                    } else if (time == 20) {
                        if (p.getOpenInventory().getTopInventory() == skullInventory) {
                            p.playSound(p.getLocation(), Sound.ITEM_BUNDLE_DROP_CONTENTS, 1, 255);
                        }
                        skullInventory.setItem(14, i14);
                    } else if (time == 19) {
                        if (p.getOpenInventory().getTopInventory() == skullInventory) {
                            p.playSound(p.getLocation(), Sound.ITEM_BUNDLE_DROP_CONTENTS, 1, 255);
                        }
                        skullInventory.setItem(16, ItemManager.BackCS);
                    } else if (time == 18) {
                        if (p.getOpenInventory().getTopInventory() == skullInventory) {
                            p.playSound(p.getLocation(), Sound.ITEM_BUNDLE_DROP_CONTENTS, 1, 255);
                        }
                        skullInventory.setItem(19, i19);
                    } else if (time == 17) {
                        if (p.getOpenInventory().getTopInventory() == skullInventory) {
                            p.playSound(p.getLocation(), Sound.ITEM_BUNDLE_DROP_CONTENTS, 1, 255);
                        }
                        skullInventory.setItem(20, i20);
                    } else if (time == 16) {
                        if (p.getOpenInventory().getTopInventory() == skullInventory) {
                            p.playSound(p.getLocation(), Sound.ITEM_BUNDLE_DROP_CONTENTS, 1, 255);
                        }
                        skullInventory.setItem(21, i21);
                    } else if (time == 15) {
                        if (p.getOpenInventory().getTopInventory() == skullInventory) {
                            p.playSound(p.getLocation(), Sound.ITEM_BUNDLE_DROP_CONTENTS, 1, 255);
                        }
                        skullInventory.setItem(22, i22);
                    } else if (time == 14) {
                        if (p.getOpenInventory().getTopInventory() == skullInventory) {
                            p.playSound(p.getLocation(), Sound.ITEM_BUNDLE_DROP_CONTENTS, 1, 255);
                        }
                        skullInventory.setItem(23, i23);
                    } else if (time == 13) {
                        if (p.getOpenInventory().getTopInventory() == skullInventory) {
                            p.playSound(p.getLocation(), Sound.ITEM_BUNDLE_DROP_CONTENTS, 1, 255);
                        }
                        skullInventory.setItem(28, i28);
                    } else if (time == 12) {
                        if (p.getOpenInventory().getTopInventory() == skullInventory) {
                            p.playSound(p.getLocation(), Sound.ITEM_BUNDLE_DROP_CONTENTS, 1, 255);
                        }
                        skullInventory.setItem(29, i29);
                    } else if (time == 11) {
                        if (p.getOpenInventory().getTopInventory() == skullInventory) {
                            p.playSound(p.getLocation(), Sound.ITEM_BUNDLE_DROP_CONTENTS, 1, 255);
                        }
                        skullInventory.setItem(30, i30);
                    } else if (time == 10) {
                        if (p.getOpenInventory().getTopInventory() == skullInventory) {
                            p.playSound(p.getLocation(), Sound.ITEM_BUNDLE_DROP_CONTENTS, 1, 255);
                        }
                        skullInventory.setItem(31, i31);
                    } else if (time == 9) {
                        if (p.getOpenInventory().getTopInventory() == skullInventory) {
                            p.playSound(p.getLocation(), Sound.ITEM_BUNDLE_DROP_CONTENTS, 1, 255);
                        }
                        skullInventory.setItem(32, i32);
                    } else if (time == 8) {
                        if (p.getOpenInventory().getTopInventory() == skullInventory) {
                            p.playSound(p.getLocation(), Sound.ITEM_BUNDLE_DROP_CONTENTS, 1, 255);
                        }
                        skullInventory.setItem(33, i33);
                    } else if (time == 7) {
                        if (p.getOpenInventory().getTopInventory() == skullInventory) {
                            p.playSound(p.getLocation(), Sound.ITEM_BUNDLE_DROP_CONTENTS, 1, 255);
                        }
                        skullInventory.setItem(34, i34);
                    } else if (time == 6) {
                        if (p.getOpenInventory().getTopInventory() == skullInventory) {
                            p.playSound(p.getLocation(), Sound.ITEM_BUNDLE_DROP_CONTENTS, 1, 255);
                        }
                        skullInventory.setItem(37, i37);
                    } else if (time == 5) {
                        if (p.getOpenInventory().getTopInventory() == skullInventory) {
                            p.playSound(p.getLocation(), Sound.ITEM_BUNDLE_DROP_CONTENTS, 1, 255);
                        }
                        skullInventory.setItem(38, i38);
                    } else if (time == 4) {
                        if (p.getOpenInventory().getTopInventory() == skullInventory) {
                            p.playSound(p.getLocation(), Sound.ITEM_BUNDLE_DROP_CONTENTS, 1, 255);
                        }
                        skullInventory.setItem(39, i39);
                    } else if (time == 3) {
                        if (p.getOpenInventory().getTopInventory() == skullInventory) {
                            p.playSound(p.getLocation(), Sound.ITEM_BUNDLE_DROP_CONTENTS, 1, 255);
                        }
                        skullInventory.setItem(40, i40);
                    } else if (time == 2) {
                        if (p.getOpenInventory().getTopInventory() == skullInventory) {
                            p.playSound(p.getLocation(), Sound.ITEM_BUNDLE_DROP_CONTENTS, 1, 255);
                        }
                        skullInventory.setItem(41, i41);
                    } else if (time == 1) {
                        if (p.getOpenInventory().getTopInventory() == skullInventory) {
                            p.playSound(p.getLocation(), Sound.ITEM_BUNDLE_DROP_CONTENTS, 1, 255);
                        }
                        skullInventory.setItem(42, i42);
                    } else if (time == 0) {
                        if (p.getOpenInventory().getTopInventory() == skullInventory) {
                            p.playSound(p.getLocation(), Sound.ITEM_BUNDLE_DROP_CONTENTS, 1, 255);
                        }
                        skullInventory.setItem(43, i43);
                    }
                }
            }.startTicks();
        }
        p.openInventory(skullInventory);
    }
}