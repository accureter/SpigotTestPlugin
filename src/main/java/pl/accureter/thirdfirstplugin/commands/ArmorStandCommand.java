/*
 * Accureter Development Copyright (c) 2023.
 */

package pl.accureter.thirdfirstplugin.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.EulerAngle;
import pl.accureter.thirdfirstplugin.ThirdFirstPlugin;

public class ArmorStandCommand implements CommandExecutor {

    ThirdFirstPlugin plugin;
    public ArmorStandCommand(ThirdFirstPlugin plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player){

            ArmorStand armorStand = (ArmorStand) player.getWorld().spawnEntity(player.getLocation(), EntityType.ARMOR_STAND);
            armorStand.setArms(true);
            armorStand.getEquipment().setHelmet(new ItemStack(Material.JUNGLE_LOG));
            armorStand.setInvulnerable(true);
            armorStand.setGlowing(true);
            armorStand.getEquipment().setItemInMainHand(new ItemStack(Material.GOLDEN_SWORD));
            armorStand.setBodyPose(new EulerAngle(Math.toRadians(72), Math.toRadians(30), Math.toRadians(21)));

        }

        return true;
    }
}
