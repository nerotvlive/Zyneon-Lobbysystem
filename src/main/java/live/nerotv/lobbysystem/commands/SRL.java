package live.nerotv.lobbysystem.commands;

import com.zyneonstudios.api.Zyneon;
import live.nerotv.lobbysystem.api.API;
import live.nerotv.lobbysystem.api.PlayerAPI;
import live.nerotv.lobbysystem.utils.MessageResolver;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SRL implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("SRL")) {
            if(s.hasPermission("zyneon.leading")) {
                MessageResolver.Language language;
                if(s instanceof Player) {
                    language = PlayerAPI.getLanguage((Player)s);
                } else {
                    language = API.getConsoleLanguage();
                }
                if(!Zyneon.getZyneonServer().isStopping()) {
                    Zyneon.getZyneonServer().stopServer();
                    API.sendMessage(s, MessageResolver.getMessage(MessageResolver.Message.restart_START,language), true);
                } else {
                    API.sendErrorMessage(s, MessageResolver.getMessage(MessageResolver.Message.restart_ERROR,language));
                }
            } else {
                if(s instanceof Player) {
                    API.sendErrorMessage(s,MessageResolver.getMessage(MessageResolver.Message.NoPerms, PlayerAPI.getLanguage((Player)s)));
                } else {
                    API.sendErrorMessage(s,MessageResolver.getMessage(MessageResolver.Message.NoPerms, API.getConsoleLanguage()));
                }
            }
        }
        return false;
    }
}
