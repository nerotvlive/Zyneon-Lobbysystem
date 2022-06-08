package live.nerotv.lobbysystem.commands;

import live.nerotv.lobbysystem.api.API;
import live.nerotv.lobbysystem.jumper.JumperAPI;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Fly implements CommandExecutor {

    public static ArrayList<Player> flyPlayers = new ArrayList<>();
    private void sendSyntax(CommandSender s) {
        if(!(s instanceof Player)) {
            s.sendMessage("§4Fehler: §c/fly [Spieler]");
        } else {
            Player p = (Player)s;
            p.sendMessage("&4Fehler: §c/fly §7[Spieler]");
            p.playSound(p.getLocation(),Sound.BLOCK_ANVIL_BREAK,100,100);
        }
    }

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if(!(s instanceof Player)) {
            if(args.length == 0) {
                sendSyntax(s);
            } else {
                if(Bukkit.getPlayer(args[0])!=null) {
                    Player t = Bukkit.getPlayer(args[0]);
                    if(flyPlayers.contains(t)) {
                        t.setFlying(false);
                        t.setAllowFlight(false);
                        flyPlayers.remove(t);
                        API.sendMessage(s,"Der Spieler §e"+t.getName()+"§7 kann nun nicht mehr fliegen!");
                        API.sendMessage(t,"Du kannst nun nicht mehr fliegen!");
                    } else {
                        t.setAllowFlight(true);
                        t.setFlying(true);
                        if(!flyPlayers.contains(t)) {
                            flyPlayers.add(t);
                        }
                        API.sendMessage(s,"Der Spieler §e"+t.getName()+"§7 kann nun fliegen!");
                        API.sendMessage(t,"Du kannst nun fliegen!");
                    }
                } else {
                    API.sendErrorMessage(s,API.noPlayer);
                }
            }
        } else {
            Player p = (Player)s;
            if(p.hasPermission("zyneon.premium")) {
                if(JumperAPI.Jumpers.containsKey(p)) {
                    API.sendErrorMessage(p,"§cDu kannst während du einen Jumper spielst nicht §4/fly§c aktivieren§8.");
                    return false;
                }
                if(args.length == 0) {
                    if(flyPlayers.contains(p)) {
                        p.setFlying(false);
                        p.setAllowFlight(false);
                        flyPlayers.remove(p);
                        API.sendMessage(p,"Du kannst nun nicht mehr fliegen!");
                    } else {
                        p.setAllowFlight(true);
                        p.setFlying(true);
                        if(!flyPlayers.contains(p)) {
                            flyPlayers.add(p);
                        }
                        API.sendMessage(p,"Du kannst nun fliegen!");
                    }
                } else {
                    if(p.hasPermission("zyneon.team")) {
                        if(Bukkit.getPlayer(args[0])!=null) {
                            Player t = Bukkit.getPlayer(args[0]);
                            if(flyPlayers.contains(t)) {
                                t.setFlying(false);
                                t.setAllowFlight(false);
                                flyPlayers.remove(t);
                                API.sendMessage(s,"Der Spieler §e"+t.getName()+"§7 kann nun nicht mehr fliegen!");
                                API.sendMessage(t,"Du kannst nun nicht mehr fliegen!");
                            } else {
                                t.setAllowFlight(true);
                                t.setFlying(true);
                                if(!flyPlayers.contains(t)) {
                                    flyPlayers.add(t);
                                }
                                API.sendMessage(s,"Der Spieler §e"+t.getName()+"§7 kann nun fliegen!");
                                API.sendMessage(t,"Du kannst nun fliegen!");
                            }
                        } else {
                            API.sendErrorMessage(s,API.noPlayer);
                        }
                    } else {
                        API.sendErrorMessage(s,API.noPerms);
                    }
                }
            } else {
                API.sendErrorMessage(s,API.noPerms);
            }
        }
        return false;
    }
}