package com.customitems.listeners;

import com.customitems.CustomItemsPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.Sound;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

public class PlayerInteractListener implements Listener {
    @SuppressWarnings("unused")
    private final CustomItemsPlugin plugin;
    
    public PlayerInteractListener(CustomItemsPlugin plugin) {
        this.plugin = plugin;
    }
    
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();
        
        if (item == null || !item.hasItemMeta()) return;
        
        ItemMeta meta = item.getItemMeta();
        if (!meta.hasCustomModelData()) return;
        
        // Handle custom item abilities
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            handleRightClick(player, item, meta.getCustomModelData());
        }
    }
    
    private void handleRightClick(Player player, ItemStack item, int customModelData) {
        switch (customModelData) {
            case 2001: // Mystic Sword - Teleport Strike
                handleMysticSwordAbility(player);
                break;
            case 2002: // Mystic Bow - Already handled by enchantments
                handleMysticBowAbility(player);
                break;
            case 2003: // Shadow Blade - Shadow Strike
                handleShadowBladeAbility(player);
                break;
        }
    }
    
    private void handleMysticSwordAbility(Player player) {
        // Teleport to target location (where player is looking)
        Location targetLocation = player.getTargetBlock(null, 10).getLocation();
        if (targetLocation.getBlock().getType().isSolid()) {
            targetLocation.add(0, 1, 0); // Teleport above the block
        }
        
        // Add some particles/effects
        player.getWorld().spawnParticle(org.bukkit.Particle.PORTAL, player.getLocation(), 20);
        player.teleport(targetLocation);
        player.getWorld().spawnParticle(org.bukkit.Particle.PORTAL, targetLocation, 20);
        player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);
        
        player.sendMessage(Component.text("⚔ Mystic Teleport! ⚔").color(NamedTextColor.LIGHT_PURPLE));
        
        // Add cooldown logic here if needed
    }
    
    private void handleMysticBowAbility(Player player) {
        // Enhanced bow effects are handled in the item creation
        player.sendMessage(Component.text("🏹 Mystic Shot Charged! 🏹").color(NamedTextColor.LIGHT_PURPLE));
        player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 200, 0));
    }
    
    private void handleShadowBladeAbility(Player player) {
        // Grant temporary invisibility
        player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 100, 0));
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 1));
        
        // Blind nearby enemies
        for (LivingEntity entity : player.getWorld().getLivingEntities()) {
            if (entity != player && entity.getLocation().distance(player.getLocation()) <= 5) {
                entity.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 60, 1));
            }
        }
        
        player.getWorld().spawnParticle(org.bukkit.Particle.SMOKE, player.getLocation(), 30);
        player.playSound(player.getLocation(), Sound.ENTITY_BAT_TAKEOFF, 1.0f, 0.5f);
        player.sendMessage(Component.text("🗡 Shadow Strike Activated! 🗡").color(NamedTextColor.DARK_PURPLE));
    }
}
