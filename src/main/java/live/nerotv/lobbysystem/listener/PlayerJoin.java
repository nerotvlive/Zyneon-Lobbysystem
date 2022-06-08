package live.nerotv.lobbysystem.listener;

import live.nerotv.lobbysystem.Main;
import live.nerotv.lobbysystem.api.API;
import live.nerotv.lobbysystem.api.BedrockAPI;
import live.nerotv.lobbysystem.api.PlayerAPI;
import live.nerotv.lobbysystem.api.WarpAPI;
import live.nerotv.lobbysystem.commands.Fly;
import live.nerotv.lobbysystem.commands.Nametags;
import live.nerotv.lobbysystem.jumper.Jumper;
import live.nerotv.lobbysystem.jumper.JumperAPI;
import live.nerotv.lobbysystem.manager.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        Nametags.noRenew.remove(p);
        p.setOp(false);
        API.checkRotating();
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"deop "+p.getName());
        p.setFlying(false);
        p.setAllowFlight(false);
        Fly.flyPlayers.remove(p);
        PlayerAPI.renewScoreboard(p,false);
        p.setGameMode(GameMode.ADVENTURE);
        for(Player all : Bukkit.getOnlinePlayers()) {
            Main.setPrefix(all);
        }
        if(API.canPlayerBuild(p)) {
            API.setBuildMode(p,false);
        }
        if(WarpAPI.isWarpEnabled("Spawn")) {
            p.teleport(WarpAPI.getWarp("Spawn"));
        } else if(Bukkit.getWorlds().get(0)!=null) {
            p.teleport(Bukkit.getWorlds().get(0).getSpawnLocation());
        }
        ItemManager.giveItems(p);
        if(Main.PM.getPlugin("floodgate")!=null) {
            BedrockAPI.initBedrockPlayer(p);
        }
        e.setJoinMessage("§8» §a"+p.getName());
        p.setInvulnerable(true);
        API.setTablist();
        API.getPlayerTime(p);
        API.getPlayerWeather(p);
        if(JumperAPI.Jumpers.containsKey(p)) {
            Jumper j = JumperAPI.Jumpers.get(p);
            j.fail();
        }
    }
}