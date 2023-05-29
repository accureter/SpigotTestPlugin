/*
 * Accureter Development Copyright (c) 2023.
 */

package pl.accureter.thirdfirstplugin.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.accureter.thirdfirstplugin.ThirdFirstPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ArmorStandGUIListener implements Listener {

    ThirdFirstPlugin plugin;

    public ArmorStandGUIListener(ThirdFirstPlugin plugin) {
        this.plugin = plugin;
    }

    boolean armsBoolean = false;
    boolean glowBoolean = false;
    boolean armorBoolean = false;
    boolean baseBoolean = false;

    HashMap<Player, ArmorStand> standHashMap = new HashMap<>();

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();
        ItemStack item = event.getCurrentItem();
        if (item == null) {
            return;
        }

        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.BLUE + "ArmorStand GUI")) {
            event.setCancelled(true);
            switch (item.getType()) {
                case ARMOR_STAND -> {
                    player.closeInventory();
                    player.sendMessage("Opened Armor Stand Create/Edit Menu");

                    Inventory createMenu = Bukkit.createInventory(player, 9, ChatColor.GREEN + "Create/Edit an Armor Stand");

                    ItemStack arms = new ItemStack(Material.ARMOR_STAND);
                    ItemMeta armsMeta = arms.getItemMeta();
                    armsMeta.setDisplayName("Arms");

                    ItemStack glow = new ItemStack(Material.NETHER_STAR);
                    ItemMeta glowMeta = glow.getItemMeta();
                    glowMeta.setDisplayName("Glow");

                    ItemStack armor = new ItemStack(Material.LEATHER_CHESTPLATE);
                    ItemMeta armorMeta = armor.getItemMeta();
                    armorMeta.setDisplayName("Armor");

                    ItemStack base = new ItemStack(Material.STONE_SLAB);
                    ItemMeta baseMeta = base.getItemMeta();
                    baseMeta.setDisplayName("Baseplate");

                    if (!standHashMap.containsKey(player)) {

                        armsMeta.setLore(List.of(ChatColor.GREEN + "Enable Arms"));
                        arms.setItemMeta(armsMeta);

                        glowMeta.setLore(List.of(ChatColor.GREEN + "Enable Glowing"));
                        glow.setItemMeta(glowMeta);

                        armorMeta.setLore(List.of(ChatColor.GREEN + "Enable Armor"));
                        armor.setItemMeta(armorMeta);

                        baseMeta.setLore(List.of(ChatColor.RED + "Disable Baseplate"));
                        base.setItemMeta(baseMeta);
                    }else {
                        ArmorStand playerArmorStand = standHashMap.get(player);

                        armsMeta.setLore(List.of((!playerArmorStand.hasArms() ? ChatColor.GREEN + "Enable Arms" : ChatColor.RED + "Disable Arms")));
                        arms.setItemMeta(armsMeta);

                        glowMeta.setLore(List.of((!playerArmorStand.isGlowing() ? ChatColor.GREEN + "Enable Glowing" : ChatColor.RED + "Disable Glowing")));
                        glow.setItemMeta(glowMeta);

                        armorMeta.setLore(List.of((playerArmorStand.getEquipment().getChestplate().getType().isAir() ? ChatColor.GREEN + "Enable Armor" : ChatColor.RED + "Disable Armor")));
                        armor.setItemMeta(armorMeta);

                        baseMeta.setLore(List.of((!playerArmorStand.hasBasePlate() ? ChatColor.GREEN + "Enable Baseplate" : ChatColor.RED + "Disable Baseplate")));
                        base.setItemMeta(baseMeta);
                    }

                    ItemStack complete = new ItemStack(Material.GREEN_WOOL);
                    ItemMeta completeMeta = complete.getItemMeta();
                    completeMeta.setDisplayName("Confirm & Save");
                    complete.setItemMeta(completeMeta);

                    ItemStack cancel = new ItemStack(Material.RED_WOOL);
                    ItemMeta cancelMeta = cancel.getItemMeta();
                    cancelMeta.setDisplayName("Destroy");
                    cancel.setItemMeta(cancelMeta);

                    ItemStack[] menuItems = {arms, glow, armor, base, null, null, null, complete, cancel};

                    createMenu.setContents(menuItems);

                    player.openInventory(createMenu);
                }
                case BARRIER -> {
                    player.closeInventory();
                    player.sendMessage("Closing Main Menu");
                }
            }
        } else if (event.getView().getTitle().equalsIgnoreCase(ChatColor.GREEN + "Create/Edit an Armor Stand")) {
            event.setCancelled(true);
            if(!standHashMap.containsKey(player)) {
                ArmorStand armorStand = (ArmorStand) player.getWorld().spawnEntity(player.getLocation(), EntityType.ARMOR_STAND);
                armorStand.setInvisible(true);
                standHashMap.put(player, armorStand);
            }
            ArmorStand playerArmorStand = standHashMap.get(player);
            ItemMeta meta = item.getItemMeta();
            switch (meta.getDisplayName()) {
                case "Arms" -> {
                    if(standHashMap.containsKey(player)){
                        meta.setLore(List.of((playerArmorStand.hasArms() ? ChatColor.GREEN + "Enable Arms" : ChatColor.RED + "Disable Arms")));
                        playerArmorStand.setArms(!playerArmorStand.hasArms());
                    }
                }
                case "Glow" -> {
                    if(standHashMap.containsKey(player)) {
                        meta.setLore(List.of((playerArmorStand.isGlowing() ? ChatColor.GREEN + "Enable Glowing" : ChatColor.RED + "Disable Glowing")));
                        playerArmorStand.setGlowing(!playerArmorStand.isGlowing());
                    }
                }
                case "Armor" -> {
                    if(standHashMap.containsKey(player)) {
                        meta.setLore(List.of((playerArmorStand.getEquipment().getChestplate().getType().isAir() ? ChatColor.GREEN + "Enable Armor" : ChatColor.RED + "Disable Armor")));
                        if(playerArmorStand.getEquipment().getChestplate().getType().isAir()){
                            playerArmorStand.getEquipment().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
                        }else {
                            playerArmorStand.getEquipment().setChestplate(new ItemStack(Material.AIR));
                        }
                    }
                }
                case "Baseplate" -> {
                    if(standHashMap.containsKey(player)) {
                        meta.setLore(List.of((playerArmorStand.hasBasePlate() ? ChatColor.GREEN + "Enable Baseplate" : ChatColor.RED + "Disable Baseplate")));
                        playerArmorStand.setBasePlate(!playerArmorStand.hasBasePlate());
                    }
                }
                case "Confirm & Save" -> {
                    player.closeInventory();
                    playerArmorStand.setInvisible(false);
                    player.playSound(player, Sound.ENTITY_ARMOR_STAND_PLACE, 1.0f, 1.0f);
                }
                case "Destroy" -> {
                    player.closeInventory();
                    playerArmorStand.remove();
                    standHashMap.remove(player);
                    player.playSound(player, Sound.ENTITY_ARMOR_STAND_BREAK, 1.0f, 1.0f);
                }
                default -> {
                    return;
                }
            }
            item.setItemMeta(meta);
        }
    }
}
