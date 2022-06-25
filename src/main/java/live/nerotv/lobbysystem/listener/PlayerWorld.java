package live.nerotv.lobbysystem.listener;

import live.nerotv.lobbysystem.api.API;
import live.nerotv.lobbysystem.api.PlayerAPI;
import live.nerotv.lobbysystem.commands.Fly;
import live.nerotv.lobbysystem.manager.ItemManager;
import live.nerotv.lobbysystem.pixel.PixelAPI;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PlayerWorld implements Listener {

    @EventHandler
    public void onWorldChange(PlayerChangedWorldEvent e) {
        Player p = e.getPlayer();
        if(p.getWorld().getName().equals("Primal2")) {
            API.getPlayerTime(p);
            API.getPlayerWeather(p);
            p.setAllowFlight(true);
            if(!Fly.flyPlayers.contains(p)) {
                Fly.flyPlayers.add(p);
            }
            p.setFlying(true);
        } else if(p.getWorld().getName().equals("Primal3")) {
                API.getPlayerTime(p);
                API.getPlayerWeather(p);
                p.setAllowFlight(true);
            if(!Fly.flyPlayers.contains(p)) {
                Fly.flyPlayers.add(p);
            }
                p.setFlying(true);
        } else if(p.getWorld().getName().contains("pixels-")) {
            p.resetPlayerTime();
            p.resetPlayerWeather();
            p.getWorld().setTime(6000);
            p.setAllowFlight(true);
            if(!Fly.flyPlayers.contains(p)) {
                Fly.flyPlayers.add(p);
            }
            p.setFlying(true);
        } else if(p.getWorld().getName().equals("Argria1")) {
            API.getPlayerTime(p);
            API.getPlayerWeather(p);
            p.setAllowFlight(true);
            if(!Fly.flyPlayers.contains(p)) {
                Fly.flyPlayers.add(p);
            }
            p.setFlying(true);
        } else if(p.getWorld().getName().equals("Deadwood")) {
            API.getPlayerTime(p);
            API.getPlayerWeather(p);
            p.setAllowFlight(true);
            if(!Fly.flyPlayers.contains(p)) {
                Fly.flyPlayers.add(p);
            }
            p.setFlying(true);
        } else if(p.getWorld().getName().equals("pixels")) {
            p.resetPlayerTime();
            p.resetPlayerWeather();
            ItemManager.giveItems(p);
            p.setAllowFlight(true);
            if(!Fly.flyPlayers.contains(p)) {
                Fly.flyPlayers.add(p);
            }
            p.setFlying(true);
            Inventory Inv = p.getInventory();
            Inv.clear();
            p.setGameMode(GameMode.SURVIVAL);
            p.setAllowFlight(true);
            if(!Fly.flyPlayers.contains(p)) {
                Fly.flyPlayers.add(p);
            }
            p.setFlying(true);

            PixelAPI.givePixelItems(p);



            API.sendMessage(p,"§7Um zurückzukehren, gebe §e/back §8(oder einen anderen Befehl)§7 ein§8.");
        } else {
            API.getPlayerTime(p);
            API.getPlayerWeather(p);
            ItemManager.giveItems(p);
            p.setFlying(false);
            Fly.flyPlayers.remove(p);
            p.setAllowFlight(false);
        }
    }

    @EventHandler
    public void onExplosion(ExplosionPrimeEvent e) {
        e.setCancelled(true);
    }
}