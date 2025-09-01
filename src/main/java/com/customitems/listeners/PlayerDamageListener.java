package com.customitems.listeners;

import com.customitems.CustomItemsPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.entity.LivingEntity;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

public class PlayerDamageListener implements Listener {
    @SuppressWarnings("unused")
    private final CustomItemsPlugin plugin;
    
    public PlayerDamageListener(CustomItemsPlugin plugin) {
        this.plugin = plugin;
    }
    
    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        // Handle custom weapon effects when attacking
        if (event.getDamager() instanceof Player) {
            Player attacker = (Player) event.getDamager();
            ItemStack weapon = attacker.getInventory().getItemInMainHand();
            
            if (weapon != null && weapon.hasItemMeta()) {
                ItemMeta meta = weapon.getItemMeta();
                if (meta.hasCustomModelData()) {
                    handleWeaponAttack(attacker, event, meta.getCustomModelData());
                }
            }
        }
    }
    
    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        // Handle custom armor effects when taking damage
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            
            // Mystic Boots - No fall damage
            if (event.getCause() == EntityDamageEvent.DamageCause.FALL) {
                ItemStack boots = player.getInventory().getBoots();
                if (isMysticBoots(boots)) {
                    event.setCancelled(true);
                    player.getWorld().spawnParticle(org.bukkit.Particle.CLOUD, player.getLocation(), 10);
                }
            }
        }
    }
    
    private void handleWeaponAttack(Player attacker, EntityDamageByEntityEvent event, int customModelData) {
        switch (customModelData) {
            case 2001: // Mystic Sword
                if (event.getEntity() instanceof LivingEntity) {
                    LivingEntity target = (LivingEntity) event.getEntity();
                    // 30% chance to inflict weakness
                    if (Math.random() < 0.3) {
                        target.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 100, 1));
                        attacker.sendMessage(Component.text("⚔ Mystic Weakness Applied! ⚔").color(NamedTextColor.LIGHT_PURPLE));
                    }
                    // Increase damage
                    event.setDamage(event.getDamage() + 3);
                }
                break;
                
            case 2003: // Shadow Blade
                if (event.getEntity() instanceof LivingEntity) {
                    LivingEntity target = (LivingEntity) event.getEntity();
                    // 25% chance to blind and go invisible after kill
                    if (Math.random() < 0.25) {
                        target.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 80, 1));
                    }
                    
                    // If this attack would kill the target, grant invisibility
                    if (target.getHealth() - event.getFinalDamage() <= 0) {
                        attacker.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 100, 0));
                        attacker.sendMessage(Component.text("🗡 Shadow Cloak Activated! 🗡").color(NamedTextColor.DARK_PURPLE));
                    }
                }
                break;
        }
    }
    
    private boolean isMysticBoots(ItemStack item) {
        if (item == null || !item.hasItemMeta()) return false;
        ItemMeta meta = item.getItemMeta();
        return meta.hasCustomModelData() && meta.getCustomModelData() == 1004;
    }
}
