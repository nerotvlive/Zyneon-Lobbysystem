package live.nerotv.lobbysystem.api;

import live.nerotv.lobbysystem.Main;
import live.nerotv.lobbysystem.manager.bedrock.SettingsManager;
import live.nerotv.lobbysystem.utils.Countdown;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.geysermc.cumulus.ModalForm;
import org.geysermc.cumulus.response.FormResponse;
import org.geysermc.floodgate.api.FloodgateApi;
import org.geysermc.floodgate.api.player.FloodgatePlayer;
import java.io.File;

public class BedrockAPI {

    public static boolean isBedrock(Player player) {
        if(FloodgateApi.getInstance().isFloodgatePlayer(player.getUniqueId())) {
            File TempFile = new File("plugins/Lobbysystem/temp/"+player.getUniqueId().toString()+"_lobbysettings.temp");
            YamlConfiguration TF = YamlConfiguration.loadConfiguration(TempFile);
            if(TF.contains("Settings.BedrockMode")) {
                if(TF.getBoolean("Settings.BedrockMode")) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public static boolean isFloodgate(Player player) {
        return FloodgateApi.getInstance().isFloodgatePlayer(player.getUniqueId());
    }

    public static void initBedrockPlayer(Player p) {
        if(FloodgateApi.getInstance().isFloodgatePlayer(p.getUniqueId())) {
            API.sendConsoleMessage("§e" + p.getName() + "§7 ist ein Bedrock-User§8!");
            if(!(PlayerAPI.isBedrock(p))) {
                new Countdown(2, Main.instance) {
                    @Override
                    public void count(int current) {
                        if(current == 1) {
                            FloodgatePlayer bP = FloodgateApi.getInstance().getPlayer(p.getUniqueId());
                            bP.sendForm(ModalForm.builder().title("§9Du nutzt die Bedrock-Edition!").content("§7Du nutzt die Bedrock-Edition, hast aber den Bedrock-Modus deaktiviert, willst du ihn wieder aktivieren?").button1("§aBedrock-Modus aktivieren").button2("§cBedrock-Modus nicht aktivieren").responseHandler((form, responseData)->{
                                FormResponse response = form.parseResponse(responseData);
                                if(response.isCorrect()&&!response.isClosed()&&!response.isInvalid()||form.parseResponse(responseData).getClickedButtonText()!=null) {
                                    String Name = form.parseResponse(responseData).getClickedButtonText();
                                    if(Name.equals("§aBedrock-Modus aktivieren")) {
                                        SettingsManager.changeBedrockState(p,true);
                                    }
                                }
                            }).build());
                        }
                    }
                }.start();
            } else {
                for (Player all : Bukkit.getOnlinePlayers()) {
                    p.showPlayer(all);
                }
                API.fixPlayer(p);
            }
        }
    }
}