package live.nerotv;

import live.nerotv.lobbysystem.Main;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Preloader extends JavaPlugin {

    private static Preloader instance;
    private static String version = "v";
    public static String getVersion() { if(version.equalsIgnoreCase("v")) { return "0"; } else { return version; } }
    public static Preloader getInstance() { return instance; }

    @Override
    public void onLoad() {
        sendMessage("Loading Lobbysystem preloader...");
        version = getDescription().getVersion();
        sendMessage("Loading Lobbysystem...");
        Main.onLoad();
    }

    @Override
    public void onEnable() {
        sendMessage("Checking for plugin dependencies...");
        if(Main.PM.getPlugin("floodgate")==null) {
            sendMessage("Couldn't find floodgate, disabling Bedrock Edition features!");
        }
        sendMessage("Enabling Lobbysystem...");
        instance = this;
        Main.onEnable();
    }

    @Override
    public void onDisable() {
        sendMessage("Disabling Lobbysystem plugin...");
        Main.onDisable();
        version = null;
        instance = null;
    }

    private void sendMessage(String message) {
        Bukkit.getConsoleSender().sendMessage("§7[Lobbysystem] §e[PRELOADER] §7"+message);
    }
}