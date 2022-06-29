package live.nerotv.lobbysystem.commands;

import live.nerotv.lobbysystem.api.API;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class Test implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender s, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        API.sendErrorMessage(s,"§cZurzeit gibt es nichts zum testen§8!");
        return false;
    }
}