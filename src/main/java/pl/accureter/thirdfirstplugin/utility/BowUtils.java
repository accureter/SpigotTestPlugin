/*
 * Accureter Development Copyright (c) 2023.
 */

package pl.accureter.thirdfirstplugin.utility;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class BowUtils {

    public static ItemStack createTeleportBow(){

        ItemStack bow = new ItemStack(Material.BOW);
        ItemMeta bowMeta = bow.getItemMeta();
        bowMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Teleport Bow");
        List<String> bowLore = new ArrayList<>();
        bowLore.add("Shoot your arrow");
        bowLore.add("and teleport anywhhere D:");
        bowMeta.setLore(bowLore);
        bowMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, false);
        bowMeta.setUnbreakable(true);
        bowMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        bow.setItemMeta(bowMeta);

        return bow;
    }
}
