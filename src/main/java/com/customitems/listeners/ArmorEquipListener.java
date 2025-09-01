package com.customitems.listeners;

import com.customitems.CustomItemsPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class ArmorEquipListener implements Listener {
    
    private final CustomItemsPlugin plugin;
    
    public ArmorEquipListener(CustomItemsPlugin plugin) {
        this.plugin = plugin;
    }
    
    @EventHandler
    public void onPlayerSneak(PlayerToggleSneakEvent event) {
        Player player = event.getPlayer();
        
        // Check if player is wearing full Mystic armor set
        if (event.isSneaking() && isWearingFullMysticSet(player)) {
            // Grant invisibility while sneaking
            new BukkitRunnable() {
                @Override
                public void run() {
                    if (player.isSneaking() && isWearingFullMysticSet(player)) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 40, 0));
                    } else {
                        this.cancel();
                    }
                }
            }.runTaskTimer(plugin, 0L, 20L); // Check every second
        }
    }
    
    private boolean isWearingFullMysticSet(Player player) {
        ItemStack helmet = player.getInventory().getHelmet();
        ItemStack chestplate = player.getInventory().getChestplate();
        ItemStack leggings = player.getInventory().getLeggings();
        ItemStack boots = player.getInventory().getBoots();
        
        return isMysticArmor(helmet, 1001) &&
               isMysticArmor(chestplate, 1002) &&
               isMysticArmor(leggings, 1003) &&
               isMysticArmor(boots, 1004);
    }
    
    private boolean isMysticArmor(ItemStack item, int expectedModelData) {
        if (item == null || !item.hasItemMeta()) return false;
        ItemMeta meta = item.getItemMeta();
        return meta.hasCustomModelData() && meta.getCustomModelData() == expectedModelData;
    }
}
