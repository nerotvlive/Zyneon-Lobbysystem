package live.nerotv.lobbysystem.listener;

import live.nerotv.lobbysystem.api.API;
import live.nerotv.lobbysystem.api.WarpAPI;
import live.nerotv.lobbysystem.commands.Fly;
import live.nerotv.lobbysystem.jumper.JumperAPI;
import org.bukkit.*;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;

public class PlayerMove implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        //DOPPELSPRUNG
        if(!JumperAPI.Jumpers.containsKey(p)) {
            if (!Fly.flyPlayers.contains(p)) {
                if ((e.getPlayer().getGameMode() == GameMode.ADVENTURE)
                        && (p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() != Material.AIR)) {
                    p.setAllowFlight(true);
                }
            }
        }
        //PLAYERMOVE
        if(p.getWorld().equals(Bukkit.getWorlds().get(0))) {
            if (p.getGameMode().equals(GameMode.ADVENTURE)) {
                if (!API.canPlayerBuild(p)) {
                    if (p.getLocation().getBlockZ() >= 72) {
                        p.teleport(new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ() - 2, p.getLocation().getYaw(), p.getLocation().getPitch()));
                        p.playSound(p.getLocation(),Sound.ENTITY_BLAZE_SHOOT,100,100);
                        p.sendMessage("§cBitte bleibe innerhalb des Lobbybereiches§8!");
                    }
                    if (p.getLocation().getBlockZ() <= -327) {
                        p.teleport(new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ() + 2, p.getLocation().getYaw(), p.getLocation().getPitch()));
                        p.playSound(p.getLocation(),Sound.ENTITY_BLAZE_SHOOT,100,100);
                        p.sendMessage("§cBitte bleibe innerhalb des Lobbybereiches§8!");
                    }
                    if (p.getLocation().getBlockX() <= -29) {
                        p.teleport(new Location(p.getWorld(), p.getLocation().getX() + 2, p.getLocation().getY(), p.getLocation().getZ(), p.getLocation().getYaw(), p.getLocation().getPitch()));
                        p.playSound(p.getLocation(),Sound.ENTITY_BLAZE_SHOOT,100,100);
                        p.sendMessage("§cBitte bleibe innerhalb des Lobbybereiches§8!");}
                    if (p.getLocation().getBlockX() >= 370) {
                        p.teleport(new Location(p.getWorld(), p.getLocation().getX() - 2, p.getLocation().getY(), p.getLocation().getZ(), p.getLocation().getYaw(), p.getLocation().getPitch()));
                        p.playSound(p.getLocation(),Sound.ENTITY_BLAZE_SHOOT,100,100);
                        p.sendMessage("§cBitte bleibe innerhalb des Lobbybereiches§8!");
                    }
                    if (p.getLocation().getBlockY() <= 0) {
                        if(WarpAPI.isWarpEnabled("Spawn")) {
                            p.teleport(WarpAPI.getWarp("Spawn"));
                        } else {
                            p.teleport(Bukkit.getWorlds().get(0).getSpawnLocation());
                            p.playSound(p.getLocation(),Sound.ENTITY_BLAZE_SHOOT,100,100);
                            p.sendMessage("§cOh§8...§cdu bist aus der Welt gefallen§8!");
                        }
                    }
                }
            }
        } else {
            if (p.getLocation().getBlockY() <= 0) {
                if(WarpAPI.isWarpEnabled("Spawn")) {
                    p.teleport(WarpAPI.getWarp("Spawn"));
                } else {
                    p.teleport(Bukkit.getWorlds().get(0).getSpawnLocation());
                    p.playSound(p.getLocation(),Sound.ENTITY_BLAZE_SHOOT,100,100);
                    p.sendMessage("§cOh§8...§cdu bist aus der Welt gefallen§8!");
                }
            }
        }
    }

    @EventHandler
    public void onPlayerFly(PlayerToggleFlightEvent e) {
        Player p = e.getPlayer();
        if (!JumperAPI.Jumpers.containsKey(p)) {
            if (!Fly.flyPlayers.contains(p)) {
                if (p.getGameMode() == GameMode.ADVENTURE) {
                    e.setCancelled(true);
                    p.setFlying(false);
                    p.setAllowFlight(false);
                    p.setVelocity(p.getLocation().getDirection().multiply(2.0D).setY(0.9D));
                    p.playEffect(p.getLocation(), Effect.BLAZE_SHOOT, 15);
                }
            }
        }
    }
}