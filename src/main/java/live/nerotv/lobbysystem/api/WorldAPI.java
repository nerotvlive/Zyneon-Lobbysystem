package live.nerotv.lobbysystem.api;

import live.nerotv.lobbysystem.utils.VoidGenerator;
import org.bukkit.*;
import org.bukkit.entity.Player;

public class WorldAPI {

    public static World getPlayerWorld(Player player) {
        return player.getWorld();
    }

    public static World getWorld(String worldname) {
        if(Bukkit.getWorld(worldname) == null) { return null; } else {
            return Bukkit.getWorld(worldname);
        }
    }

    public static void setTime(long time, World world) {
        world.setTime(time);
    }


    public static void addTime(long time, World world) {
        long t = world.getTime()+time;
        world.setTime(t);
    }

    public static void removeTime(long time, World world) {
        long t = world.getTime()-time;
        world.setTime(t);
    }

    public static void setSun(World world) {
        world.setThundering(false);
        world.setStorm(false);
    }

    public static void setRain(World world) {
        world.setThundering(false);
        world.setStorm(true);
    }

    public static void setStorm(World world) {
        world.setStorm(true);
        world.setThundering(true);
    }

    public static void setDifficulty(World world, Difficulty difficulty) {
        world.setDifficulty(difficulty);
    }

    @Deprecated
    public static void setDifficulty(String worldname, Difficulty difficulty) {
        World world = Bukkit.getServer().getWorld(worldname);
        if(world != null)  {
            world.setDifficulty(difficulty);
        }
    }

    public static void loadWorld(String mapName) {
        new WorldCreator(mapName).environment(World.Environment.NORMAL).createWorld();
    }

    public static void loadWorld(String mapName, World.Environment environment, WorldType type, Boolean generateStructures, Boolean cleanRoom) {
        if(cleanRoom) {
            new WorldCreator(mapName).environment(environment).generator(new VoidGenerator()).generateStructures(generateStructures).type(type).createWorld();
        } else {
            new WorldCreator(mapName).environment(environment).generateStructures(generateStructures).type(type).createWorld();
        }
    }

    public static void createWorld(String mapName, World.Environment environment, WorldType type, boolean structures) {
        new WorldCreator(mapName).generateStructures(structures).environment(environment).type(type).createWorld();
    }

    public static void createVoidWorld(String mapName, World.Environment environment) {
        new WorldCreator(mapName).generateStructures(false).environment(environment).type(WorldType.FLAT).generator(new VoidGenerator()).createWorld();
    }
}