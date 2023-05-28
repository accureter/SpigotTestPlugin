package pl.accureter.thirdfirstplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.accureter.thirdfirstplugin.ThirdFirstPlugin;

import java.util.ArrayList;

public class MenuCommand implements CommandExecutor {

    ThirdFirstPlugin plugin;
    public MenuCommand(ThirdFirstPlugin plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player){

            Inventory inventory = Bukkit.createInventory(player, 9, ChatColor.RED + "Sraka");

            ItemStack item = new ItemStack(Material.GOLD_NUGGET, 20);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GOLD + "Kliknij mnie!");
            item.setItemMeta(meta);

            ItemStack chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 10);
            ItemMeta chestplateMeta = chestplate.getItemMeta();
            chestplateMeta.setDisplayName("zbrojka");
            ArrayList<String> lore = new ArrayList<>();
            lore.add("To jest ");
            lore.add("GIGA ZBROJA ");
            lore.add("wtf");
            chestplateMeta.setLore(lore);
            chestplateMeta.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
            chestplate.setItemMeta(chestplateMeta);

            inventory.setItem(0, item);
            inventory.setItem(1, chestplate);

            player.openInventory(inventory);
        }

        return true;
    }
}
