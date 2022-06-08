package live.nerotv.lobbysystem.commands;

import live.nerotv.lobbysystem.api.API;
import live.nerotv.lobbysystem.api.ConfigAPI;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import java.io.File;
import java.util.UUID;

public class Hologram implements CommandExecutor {

    private final File holoFile = new File("plugins/Lobbysystem/holo.yml");
    private final YamlConfiguration hF = YamlConfiguration.loadConfiguration(holoFile);

    private void sendSyntax(CommandSender s) {
        API.sendErrorMessage(s,"§4Fehler:§c /holo [create/§7remove§c/addline/remline] §c[§7holo_to_remove§c/holoname§c] [content/line_to_remove]");
    }

    private void sendHoloAlreadyExists(CommandSender s) {
        API.sendErrorMessage(s,"§cDieses Hologramm existiert bereits§8!");
    }

    private void sendHoloDoesntExists(CommandSender s) {
        API.sendErrorMessage(s,"§cDieses Hologramm existiert nicht§8!");
    }

    private void sendHoloLineDoesntExists(CommandSender s) {
        API.sendErrorMessage(s,"§cDiese Hologramm-Zeile existiert nicht§8!");
    }

    private void createHologram(Location location, String holoname, String content) {
        int line;
        content = content.replace("&&","%and%").replace("&","§").replace("%and%","&");
        if(hF.contains("Hologram."+holoname+".lines")) {
            line = 1+hF.getInt("Hologram."+holoname+".lines");
            hF.set("Hologram."+holoname+".lines",line);
        } else {
            line = 1;
            hF.set("Hologram."+holoname+".lines",line);
        }
        if(line > 1) {
            location = new Location(location.getWorld(),location.getX(),location.getY()-0.25,location.getZ(),0,0);
        }
        hF.set("Hologram."+holoname+".line"+line+".content",content);
        ArmorStand hologram = location.getWorld().spawn(location,ArmorStand.class);
        hF.set("Hologram."+holoname+".line"+line+".uuid",hologram.getUniqueId().toString());
        hF.set("Hologram."+holoname+".line"+line+".location.W",location.getWorld().getName());
        hF.set("Hologram."+holoname+".line"+line+".location.X",location.getX());
        hF.set("Hologram."+holoname+".line"+line+".location.Y",location.getY());
        hF.set("Hologram."+holoname+".line"+line+".location.Z",location.getZ());
        ConfigAPI.saveConfig(holoFile,hF);
        hologram.setVisible(false);
        hologram.setInvulnerable(true);
        hologram.setGravity(false);
        hologram.setCustomName(content);
        hologram.setCustomNameVisible(true);
        ConfigAPI.reloadConfig(holoFile,hF);
    }

    private boolean addHololine(String holoname, String content) {
        if(hF.contains("Hologram."+holoname+".lines")) {
            content = content.replace("&&","%and%").replace("&","§").replace("%and%","&");
            int line = hF.getInt("Hologram."+holoname+".lines");
            if(Bukkit.getWorld(hF.getString("Hologram."+holoname+".line"+line+".location.W"))==null) {
                Bukkit.createWorld(new WorldCreator(hF.getString("Hologram."+holoname+".line"+line+".location.W")));
            }
            Location location = new Location(Bukkit.getWorld(hF.getString("Hologram."+holoname+".line"+line+".location.W")),hF.getDouble("Hologram."+holoname+".line"+line+".location.X"),hF.getDouble("Hologram."+holoname+".line"+line+".location.Y")-0.25,hF.getDouble("Hologram."+holoname+".line"+line+".location.Z"));
            line = line+1;
            hF.set("Hologram."+holoname+".lines",line);
            hF.set("Hologram."+holoname+".line"+line+".content",content);
            ArmorStand hologram = location.getWorld().spawn(location,ArmorStand.class);
            hF.set("Hologram."+holoname+".line"+line+".uuid",hologram.getUniqueId().toString());
            hF.set("Hologram."+holoname+".line"+line+".location.W",location.getWorld().getName());
            hF.set("Hologram."+holoname+".line"+line+".location.X",location.getX());
            hF.set("Hologram."+holoname+".line"+line+".location.Y",location.getY());
            hF.set("Hologram."+holoname+".line"+line+".location.Z",location.getZ());
            ConfigAPI.saveConfig(holoFile,hF);
            hologram.setVisible(false);
            hologram.setInvulnerable(true);
            hologram.setGravity(false);
            hologram.setCustomName(content);
            hologram.setCustomNameVisible(true);
            ConfigAPI.reloadConfig(holoFile,hF);
            return true;
        } else {
            return false;
        }
    }

    private boolean removeHololine(String holoname, int line) {
        if(hF.contains("Hologram."+holoname+".line"+line+".uuid")) {
            UUID holoID = UUID.fromString(hF.getString("Hologram." + holoname + ".line" + line + ".uuid"));
            if(Bukkit.getWorld(hF.getString("Hologram."+holoname+".line"+line+".location.W"))==null) {
                Bukkit.createWorld(new WorldCreator(hF.getString("Hologram."+holoname+".line"+line+".location.W")));
            }
            Bukkit.getEntity(holoID).remove();
            int lines = hF.getInt("Hologram."+holoname+".lines")-1;
            hF.set("Hologram."+holoname+".line"+line+".uuid",null);
            hF.set("Hologram."+holoname+".line"+line+".location.W",null);
            hF.set("Hologram."+holoname+".line"+line+".location.X",null);
            hF.set("Hologram."+holoname+".line"+line+".location.Y",null);
            hF.set("Hologram."+holoname+".line"+line+".location.Z",null);
            hF.set("Hologram."+holoname+".line"+line+".location",null);
            hF.set("Hologram."+holoname+".line"+line+".content",null);
            if(lines <= 0) {
                hF.set("Hologram."+holoname+".lines",null);
            } else {
                hF.set("Hologram."+holoname+".lines",lines);
            }
            ConfigAPI.saveConfig(holoFile,hF);
            ConfigAPI.reloadConfig(holoFile,hF);
            return true;
        } else {
            return false;
        }
    }

    private void removeHologram(String holoname) {
        if(hF.contains("Hologram."+holoname+".lines")) {
            int lines = hF.getInt("Hologram."+holoname+".lines");
            for(int i = 1; i < lines; i++) {
                removeHololine(holoname,i);
            }
        }
    }

    @Override
    public boolean onCommand(@NotNull CommandSender s, Command cmd, @NotNull String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("Hologram")) {
            if (s instanceof Player) {
                Player p = (Player) s;
                if(p.hasPermission("zyneon.team.hologram")) {
                    if(args.length < 3) {
                        sendSyntax(p);
                    } else {
                        String holoname = args[1];
                        String argument = args[0];
                        if(argument.equalsIgnoreCase("create")||argument.equalsIgnoreCase("add")||argument.equalsIgnoreCase("new")) {
                            if(hF.contains("Hologram."+holoname+".lines")) {
                                sendHoloAlreadyExists(p);
                            } else {
                                String m = "";
                                for (int i = 2; i < args.length; i++) {
                                    m=m+args[i]+" ";
                                }
                                m=m.substring(0,m.length()-1);
                                createHologram(p.getLocation(),holoname,m);
                                API.sendMessage(p,"§7Du hast erfolgreich das Hologramm §a"+holoname+"§7 mit dem Inhalt §e\"§r"+m+"§e\"§7 erstellt§8!");
                            }
                        } else if(argument.equalsIgnoreCase("rem")||argument.equalsIgnoreCase("remove")||argument.equalsIgnoreCase("del")||argument.equalsIgnoreCase("delete")) {
                            removeHologram(holoname);
                            API.sendMessage(p, "§7Du hast erfolgreich das Hologramm §e" + holoname + "§c gelöscht§8!");
                        } else if(argument.equalsIgnoreCase("createline")||argument.equalsIgnoreCase("addline")||argument.equalsIgnoreCase("newline")) {
                            if(!hF.contains("Hologram."+holoname+".lines")) {
                                sendHoloDoesntExists(p);
                            } else {
                                String m = "";
                                for (int i = 2; i < args.length; i++) {
                                    m=m+args[i]+" ";
                                }
                                m=m.substring(0,m.length()-1);
                                addHololine(holoname,m);
                                API.sendMessage(p,"§7Du hast erfolgreich die Zeile §e\""+m+"§e\"§7 zu dem Hologramm §a"+holoname+"§7 hinzugefügt§8!");
                            }
                        } else if(argument.equalsIgnoreCase("remline")||argument.equalsIgnoreCase("removeline")||argument.equalsIgnoreCase("delline")||argument.equalsIgnoreCase("deleteline")) {
                            if(!hF.contains("Hologram."+holoname+".lines")) {
                                sendHoloDoesntExists(p);
                            } else {
                                if(API.isNumeric(args[2])) {
                                    int line = Integer.parseInt(args[2]);
                                    if(removeHololine(holoname,line)) {
                                        API.sendMessage(p,"§7Du hast die Zeile §e"+line+"§7 vom Hologramm §a"+holoname+"§7 erfolgreich §centfernt§8!");
                                    } else {
                                        sendHoloDoesntExists(p);
                                    }
                                } else {
                                    sendHoloLineDoesntExists(p);
                                }
                            }
                        }

                        }
                } else {
                    API.sendErrorMessage(p,API.noPerms);
                }
            } else {
                API.sendErrorMessage(s, "§cDazu §4musst§c du ein Spieler sein§8!");
            }
        }
        return false;
    }
}