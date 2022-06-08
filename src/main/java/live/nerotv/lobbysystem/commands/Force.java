package live.nerotv.lobbysystem.commands;

import live.nerotv.lobbysystem.api.API;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Force implements CommandExecutor {

    private void sendSyntax(CommandSender s) {
        API.sendErrorMessage(s,"§4Fehler: §c/force [reload/restart]");
    }

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("Force")) {
            if(s.hasPermission("zyneon.leading.force")) {
                if(args.length == 0) {
                    sendSyntax(s);
                } else {
                    if(args[0].equalsIgnoreCase("reload")) {
                        API.sendMessage(s,"Serverreload...");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"reload confirm");
                    } else if(args[0].equalsIgnoreCase("stop")) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"stop");
                    } else {
                        sendSyntax(s);
                    }
                }
            } else {
                API.sendErrorMessage(s,API.noPerms);
            }
        }
        return false;
    }
}