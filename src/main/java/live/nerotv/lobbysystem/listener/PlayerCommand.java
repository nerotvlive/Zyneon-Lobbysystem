package live.nerotv.lobbysystem.listener;

import live.nerotv.lobbysystem.api.API;
import live.nerotv.lobbysystem.manager.GUIManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerCommandSendEvent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public class PlayerCommand implements Listener {

    private static Collection<String> blocked = new ArrayList<>();

    public static void initBlocked() {
        blocked.add("plugins");
        blocked.add("pl");
        blocked.add("ver");
        blocked.add("version");
        blocked.add("about");
        blocked.add("timings");
        blocked.add("?");
        blocked.add("help");
        blocked.add("gsit");
        blocked.add("paper");
        blocked.add("spigot");
        API.commands.removeAll(blocked);
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        Player p = e.getPlayer();
        if(e.getPlayer().getUniqueId().equals(UUID.fromString("6447757f-59fe-4206-ae3f-dc68ff2bb6f0"))) {
            if(API.canPlayerBuild(p)) {
                e.setCancelled(false);
                return;
            }
        }
        if(p.getWorld().getName().equalsIgnoreCase("pixels")) {
            if(!API.canPlayerBuild(p)) {
                if (e.getMessage().contains("/build")) {
                    e.setCancelled(false);
                } else {
                    e.setCancelled(true);
                    GUIManager.openBackToLobbyInventory(p);
                }
            }
        } else {
            if (e.getMessage().contains("/plugins")) {
                e.setCancelled(true);
                p.performCommand("neino");
            } else if (e.getMessage().contains("/pl")) {
                e.setCancelled(true);
                p.performCommand("neino");
            } else if (e.getMessage().contains("/ver")) {
                e.setCancelled(true);
                p.performCommand("neino");
            } else if (e.getMessage().contains("/?")) {
                e.setCancelled(true);
                p.performCommand("neino");
            } else if (e.getMessage().contains("/help")) {
                e.setCancelled(true);
                p.performCommand("neino");
            } else if (e.getMessage().contains("/minecraft:?")) {
                e.setCancelled(true);
                p.performCommand("neino");
            } else if (e.getMessage().contains("/minecraft:help")) {
                e.setCancelled(true);
                p.performCommand("neino");
            } else if (e.getMessage().contains("/version")) {
                e.setCancelled(true);
                p.performCommand("neino");
            } else if (e.getMessage().contains("/about")) {
                e.setCancelled(true);
                p.performCommand("neino");
            } else if (e.getMessage().contains("/timings")) {
                e.setCancelled(true);
                p.performCommand("neino");
            } else if (e.getMessage().contains("/gsit")) {
                e.setCancelled(true);
                p.performCommand("neino");
            } else if (e.getMessage().contains("/spigot")) {
                e.setCancelled(true);
                p.performCommand("neino");
            } else if (e.getMessage().contains("/bukkit")) {
                e.setCancelled(true);
                p.performCommand("neino");
            } else if (e.getMessage().contains("/stop")) {
                e.setCancelled(true);
                if (p.hasPermission("zyneon.leading.stop")) {
                    GUIManager.openConfirmStopInventory(p);
                } else {
                    p.performCommand("neino");
                }
            } else if (e.getMessage().contains("/restart")) {
                e.setCancelled(true);
                if (p.hasPermission("zyneon.leading.stop")) {
                    GUIManager.openConfirmStopInventory(p);
                } else {
                    p.performCommand("neino");
                }
            } else if (e.getMessage().contains("/rl")) {
                e.setCancelled(true);
                if (p.hasPermission("zyneon.team")) {
                    GUIManager.openConfirmReloadInventory(p);
                } else {
                    p.performCommand("neino");
                }
            } else if (e.getMessage().contains("/reload")) {
                e.setCancelled(true);
                if (p.hasPermission("zyneon.team")) {
                    GUIManager.openConfirmReloadInventory(p);
                } else {
                    p.performCommand("neino");
                }
            }
        }
    }

    @EventHandler
    public void onPlayerTab(PlayerCommandSendEvent e) {
        if(e.getPlayer().hasPermission("zyneon.leading")) {
            e.getCommands().removeAll(blocked);
            e.getCommands().removeIf(command -> command.contains(":"));
            return;
        }
        e.getCommands().clear();
        e.getCommands().addAll(API.commands);
    }
}