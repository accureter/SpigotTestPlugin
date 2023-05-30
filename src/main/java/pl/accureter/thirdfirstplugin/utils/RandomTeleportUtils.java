/*
 * Accureter Development Copyright (c) 2023.
 */

package pl.accureter.thirdfirstplugin.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.Location;
import org.bukkit.block.Block;

import java.util.HashSet;
import java.util.Random;

public class RandomTeleportUtils {

    public static HashSet<Material> badBlocks  = new HashSet<>();

    static {
        badBlocks.add(Material.GRASS_BLOCK);
        badBlocks.add(Material.OAK_LEAVES);
    }

    public static Location generateLocation(World world){

        Random random = new Random();

        int x = random.nextInt(1000);
        int y = 150;
        int z = random.nextInt(1000);

        org.bukkit.Location randomLocation = new org.bukkit.Location(world, x, y, z);

        y = randomLocation.getWorld().getHighestBlockYAt(randomLocation);
        randomLocation.setY(y);

        Block block = randomLocation.getWorld().getBlockAt(randomLocation);
        Block bellow = randomLocation.getWorld().getBlockAt(x, y - 1, z);
        Block above = randomLocation.getWorld().getBlockAt(x, y + 1, z);
        Bukkit.getLogger().info("Block: " + block.getType() + "Block Bellow: " + bellow.getType() + "Block Above: " + above.getType());

        if (badBlocks.contains(bellow.getType()) || !block.getType().isSolid() || above.getType().isSolid()){
            generateLocation(world);
        }

        return randomLocation;
    }
}
