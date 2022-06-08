package live.nerotv.lobbysystem.jumper;

import live.nerotv.lobbysystem.api.API;
import live.nerotv.lobbysystem.api.NewSound;
import live.nerotv.lobbysystem.api.PlayerAPI;
import live.nerotv.lobbysystem.commands.Fly;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import java.util.concurrent.ThreadLocalRandom;

public class Jumper {

    private final Player player;
    private boolean isActive;
    private Location currentLocation;
    private Location nextLocation;
    private int streak = 0;
    private int highscore = 0;
    private String color;

    public Jumper(Player player) {
        this.player = player;
        Fly.flyPlayers.remove(this.player);
        int colorid = ThreadLocalRandom.current().nextInt(0,15);
        if(colorid == 1) {
            this.color = "ORANGE";
        } else if(colorid == 2) {
            this.color = "MAGENTA";
        } else if(colorid == 3) {
            this.color = "LIGHT_BLUE";
        } else if(colorid == 4) {
            this.color = "YELLOW";
        } else if(colorid == 5) {
            this.color = "LIME";
        } else if(colorid == 6) {
            this.color = "PINK";
        } else if(colorid == 7) {
            this.color = "GRAY";
        } else if(colorid == 8) {
            this.color = "LIGHT_GRAY";
        } else if(colorid == 9) {
            this.color = "CYAN";
        } else if(colorid == 10) {
            this.color = "PURPLE";
        } else if(colorid == 11) {
            this.color = "BLUE";
        } else if(colorid == 12) {
            this.color = "BROWN";
        } else if(colorid == 13) {
            this.color = "GREEN";
        } else if(colorid == 14) {
            this.color = "RED";
        } else if(colorid == 15) {
            this.color = "BLACK";
        } else {
            this.color = "WHITE";
        }
        this.player.setAllowFlight(false);
        int x;
        int z;
        int x0 = ThreadLocalRandom.current().nextInt(0,2);
        int x1 = ThreadLocalRandom.current().nextInt(10,20);
        int z0 = ThreadLocalRandom.current().nextInt(0,2);
        int z1 = ThreadLocalRandom.current().nextInt(10,20);
        if(x0 == 1) {
            x = player.getLocation().getBlockX()+x1;
        } else {
            x = player.getLocation().getBlockX()-x1;
        }
        if(z0 == 1) {
            z = player.getLocation().getBlockZ()+z1;
        } else {
            z = player.getLocation().getBlockZ()-z1;
        }
        int y = 66;
        if(player.getWorld()!=Bukkit.getWorlds().get(0)&&!player.getWorld().getName().toLowerCase().contains("pixels")) {
            y = 100;
        }
        Location gen = new Location(player.getWorld(),x,y,z);
        this.currentLocation = JumperAPI.nextLoc(gen);
        this.currentLocation.getBlock().setType(Material.valueOf(color+"_TERRACOTTA"));
        this.nextLocation = JumperAPI.nextLoc(currentLocation);
        this.nextLocation.getBlock().setType(Material.valueOf(color+"_WOOL"));
        if(JumperAPI.hasHighscore(this.player.getUniqueId())) {
            highscore = JumperAPI.getHighscore(this.player.getUniqueId());
        }
        player.teleport(new Location(currentLocation.getWorld(),currentLocation.getBlockX()+0.5,currentLocation.getBlockY()+1,currentLocation.getBlockZ()+0.5));
        this.isActive = true;
        JumperAPI.Jumpers.put(player,this);
    }

    public Player getPlayer() {
        return this.player;
    }

    public Location getCurrentLocation() {
        return this.currentLocation;
    }

    public Material getNextBlock() {
        return Material.valueOf(color+"_WOOL");
    }

    public Material getCurrentBlock() {
        return Material.valueOf(color+"_TERRACOTTA");
    }

    public Location getNextLocation() {
        return this.nextLocation;
    }

    public int getStreak() {
        return this.streak;
    }

    public int getHighscore() {
        return this.highscore;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public void setNextLocation(Location nextLocation) {
        this.currentLocation.getBlock().setType(Material.AIR);
        this.currentLocation = this.nextLocation;
        this.nextLocation = nextLocation;
    }

    public void fail() {
        if(this.streak > this.highscore) {
            this.highscore = this.streak;
            JumperAPI.setHighscore(this.player.getUniqueId(),highscore);
            API.sendMessage(this.player,"§7Du hast deinen §dJumper§8-§dHighscore §7gebrochen§8! §7Dein neuer Highscore ist §e"+highscore+"§8!",NewSound.ENTITY_CHICKEN_EGG);
        }
        this.currentLocation.getBlock().setType(Material.AIR);
        this.nextLocation.getBlock().setType(Material.AIR);
        this.isActive = false;
        this.player.setAllowFlight(true);
        API.sendErrorMessage(this.player,"§cJumper abgebrochen§8! §cDu hast §4"+this.streak+"§c Sprünge geschafft§8.");
        if(this.player.getWorld()!=Bukkit.getWorlds().get(0)) {
            Fly.flyPlayers.add(this.player);
        }
        JumperAPI.Jumpers.remove(player);
        PlayerAPI.renewScoreboard(this.player,false);
        System.gc();
    }

    public void increaseStreak() {
        this.streak = this.streak+1;
    }
}