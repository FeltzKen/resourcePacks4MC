package com.customitems.items;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.Color;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.java.JavaPlugin;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CustomItemManager {
    
    @SuppressWarnings("unused")
    private final JavaPlugin plugin;
    private final Map<String, ItemStack> customItems;
    
    public CustomItemManager(JavaPlugin plugin) {
        plugin.getLogger().info("CustomItemManager: Constructor called");
        this.plugin = plugin;
        this.customItems = new HashMap<>();
        plugin.getLogger().info("CustomItemManager: HashMap initialized");
        
        try {
            plugin.getLogger().info("CustomItemManager: Starting item initialization");
            initializeItems();
            plugin.getLogger().info("CustomItemManager: Item initialization completed successfully");
            plugin.getLogger().info("CustomItemManager: Total items created: " + customItems.size());
        } catch (Exception e) {
            plugin.getLogger().severe("CustomItemManager: FATAL ERROR during item initialization");
            plugin.getLogger().severe("Error: " + e.getMessage());
            e.printStackTrace();
            throw e; // Re-throw to fail plugin loading
        }
    }
    
    private void initializeItems() {
        // Legendary Weapons (for backward compatibility)
        customItems.put("excalibur", createVoidcutterBlade()); // Map old names to new items
        customItems.put("mjolnir", createSoulReaper());
        customItems.put("dragonbane", createDragonFangDagger());
        
        // Mystic Armor Set - Using custom models on different base items
        customItems.put("mystic_helmet", createMysticHelmet());
        customItems.put("mystic_chestplate", createMysticChestplate());
        customItems.put("mystic_leggings", createMysticLeggings());
        customItems.put("mystic_boots", createMysticBoots());
        
        // Completely Custom Weapons - Using unique base items
        customItems.put("voidcutter_blade", createVoidcutterBlade());
        customItems.put("astral_bow", createAstralBow());
        customItems.put("soul_reaper", createSoulReaper());
        customItems.put("dragon_fang_dagger", createDragonFangDagger());
        
        // Mystical Tools & Artifacts
        customItems.put("ethereal_staff", createEtherealStaff());
        customItems.put("phoenix_wings", createPhoenixWings());
        customItems.put("crystal_core", createCrystalCore());
        customItems.put("void_essence", createVoidEssence());
    }
    
    private ItemStack createMysticHelmet() {
        ItemStack item = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        
        meta.displayName(Component.text("✦ Mystic Helmet ✦").color(NamedTextColor.LIGHT_PURPLE).decoration(TextDecoration.ITALIC, false));
        meta.lore(Arrays.asList(
            Component.text("A helmet infused with mystical energy").color(NamedTextColor.GRAY).decoration(TextDecoration.ITALIC, false),
            Component.text("Set Bonus: Invisibility when sneaking").color(NamedTextColor.BLUE).decoration(TextDecoration.ITALIC, false),
            Component.text("+5 Armor").color(NamedTextColor.GREEN).decoration(TextDecoration.ITALIC, false),
            Component.text("+3 Magic Resistance").color(NamedTextColor.RED).decoration(TextDecoration.ITALIC, false),
            Component.text("Mystic Set (1/4)").color(NamedTextColor.GOLD).decoration(TextDecoration.ITALIC, false)
        ));
        
        // Set the purple/pink color
        meta.setColor(Color.fromRGB(199, 84, 221));
        
        meta.setCustomModelData(1001); // For custom textures
        item.setItemMeta(meta);
        
        // Add enchantments using modern API
        item.addEnchantment(Enchantment.PROTECTION, 4);
        item.addEnchantment(Enchantment.UNBREAKING, 3);
        item.addEnchantment(Enchantment.RESPIRATION, 2);
        
        return item;
    }
    
    private ItemStack createMysticChestplate() {
        ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        
        meta.displayName(Component.text("✦ Mystic Chestplate ✦").color(NamedTextColor.LIGHT_PURPLE).decoration(TextDecoration.ITALIC, false));
        meta.lore(Arrays.asList(
            Component.text("Chestplate forged from ethereal materials").color(NamedTextColor.GRAY).decoration(TextDecoration.ITALIC, false),
            Component.text("Set Bonus: Invisibility when sneaking").color(NamedTextColor.BLUE).decoration(TextDecoration.ITALIC, false),
            Component.text("+8 Armor").color(NamedTextColor.GREEN).decoration(TextDecoration.ITALIC, false),
            Component.text("+5 Magic Resistance").color(NamedTextColor.RED).decoration(TextDecoration.ITALIC, false),
            Component.text("Mystic Set (2/4)").color(NamedTextColor.GOLD).decoration(TextDecoration.ITALIC, false)
        ));
        
        meta.setColor(Color.fromRGB(199, 84, 221));
        meta.setCustomModelData(1002);
        item.setItemMeta(meta);
        
        item.addEnchantment(Enchantment.PROTECTION, 4);
        item.addEnchantment(Enchantment.UNBREAKING, 3);
        
        return item;
    }
    
    private ItemStack createMysticLeggings() {
        ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        
        meta.displayName(Component.text("✦ Mystic Leggings ✦").color(NamedTextColor.LIGHT_PURPLE).decoration(TextDecoration.ITALIC, false));
        meta.lore(Arrays.asList(
            Component.text("Leggings that shimmer with magical power").color(NamedTextColor.GRAY).decoration(TextDecoration.ITALIC, false),
            Component.text("Set Bonus: Invisibility when sneaking").color(NamedTextColor.BLUE).decoration(TextDecoration.ITALIC, false),
            Component.text("+6 Armor").color(NamedTextColor.GREEN).decoration(TextDecoration.ITALIC, false),
            Component.text("+4 Magic Resistance").color(NamedTextColor.RED).decoration(TextDecoration.ITALIC, false),
            Component.text("Mystic Set (3/4)").color(NamedTextColor.GOLD).decoration(TextDecoration.ITALIC, false)
        ));
        
        meta.setColor(Color.fromRGB(199, 84, 221));
        meta.setCustomModelData(1003);
        item.setItemMeta(meta);
        
        item.addEnchantment(Enchantment.PROTECTION, 4);
        item.addEnchantment(Enchantment.UNBREAKING, 3);
        
        return item;
    }
    
    private ItemStack createMysticBoots() {
        ItemStack item = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        
        meta.displayName(Component.text("✦ Mystic Boots ✦").color(NamedTextColor.LIGHT_PURPLE).decoration(TextDecoration.ITALIC, false));
        meta.lore(Arrays.asList(
            Component.text("Boots that allow silent movement").color(NamedTextColor.GRAY).decoration(TextDecoration.ITALIC, false),
            Component.text("Set Bonus: Invisibility when sneaking").color(NamedTextColor.BLUE).decoration(TextDecoration.ITALIC, false),
            Component.text("+3 Armor").color(NamedTextColor.GREEN).decoration(TextDecoration.ITALIC, false),
            Component.text("+2 Magic Resistance").color(NamedTextColor.RED).decoration(TextDecoration.ITALIC, false),
            Component.text("Special: No fall damage").color(NamedTextColor.YELLOW).decoration(TextDecoration.ITALIC, false),
            Component.text("Mystic Set (4/4)").color(NamedTextColor.GOLD).decoration(TextDecoration.ITALIC, false)
        ));
        
        meta.setColor(Color.fromRGB(199, 84, 221));
        meta.setCustomModelData(1004);
        item.setItemMeta(meta);
        
        item.addEnchantment(Enchantment.PROTECTION, 4);
        item.addEnchantment(Enchantment.UNBREAKING, 3);
        item.addEnchantment(Enchantment.FEATHER_FALLING, 4);
        
        return item;
    }
    
    private ItemStack createVoidcutterBlade() {
        // Using a STICK as base item for completely custom sword model
        ItemStack item = new ItemStack(Material.STICK);
        ItemMeta meta = item.getItemMeta();
        
        meta.displayName(Component.text("⚫ Voidcutter Blade ⚫")
            .color(NamedTextColor.DARK_PURPLE)
            .decoration(TextDecoration.ITALIC, false)
            .decoration(TextDecoration.BOLD, true));
        
        meta.lore(Arrays.asList(
            Component.text("A blade forged from the void itself").color(NamedTextColor.GRAY).decoration(TextDecoration.ITALIC, false),
            Component.text(""),
            Component.text("⚔ Damage: 15").color(NamedTextColor.RED).decoration(TextDecoration.ITALIC, false),
            Component.text("⚡ Speed: Very Fast").color(NamedTextColor.YELLOW).decoration(TextDecoration.ITALIC, false),
            Component.text("✨ Special: Void Slash").color(NamedTextColor.LIGHT_PURPLE).decoration(TextDecoration.ITALIC, false),
            Component.text("🌀 Right-click: Teleport Strike").color(NamedTextColor.AQUA).decoration(TextDecoration.ITALIC, false),
            Component.text(""),
            Component.text("LEGENDARY WEAPON").color(NamedTextColor.GOLD).decoration(TextDecoration.ITALIC, false).decoration(TextDecoration.BOLD, true)
        ));
        
        meta.setCustomModelData(10001); // Unique custom model
        item.setItemMeta(meta);
        
        // Add custom attributes for sword-like behavior using unsafe enchantments
        item.addUnsafeEnchantment(Enchantment.SHARPNESS, 5); // Use unsafe to allow on any item
        item.addUnsafeEnchantment(Enchantment.UNBREAKING, 5);
        
        return item;
    }
    
    private ItemStack createAstralBow() {
        // Using CARROT_ON_A_STICK for completely custom bow model
        ItemStack item = new ItemStack(Material.CARROT_ON_A_STICK);
        ItemMeta meta = item.getItemMeta();
        
        meta.displayName(Component.text("🌟 Astral Bow 🌟")
            .color(NamedTextColor.BLUE)
            .decoration(TextDecoration.ITALIC, false)
            .decoration(TextDecoration.BOLD, true));
        
        meta.lore(Arrays.asList(
            Component.text("Crafted from starlight and celestial energy").color(NamedTextColor.GRAY).decoration(TextDecoration.ITALIC, false),
            Component.text(""),
            Component.text("🏹 Damage: 12").color(NamedTextColor.RED).decoration(TextDecoration.ITALIC, false),
            Component.text("⭐ Range: Infinite").color(NamedTextColor.YELLOW).decoration(TextDecoration.ITALIC, false),
            Component.text("✨ Special: Astral Arrows").color(NamedTextColor.LIGHT_PURPLE).decoration(TextDecoration.ITALIC, false),
            Component.text("🌌 Arrows pierce through enemies").color(NamedTextColor.AQUA).decoration(TextDecoration.ITALIC, false),
            Component.text(""),
            Component.text("LEGENDARY WEAPON").color(NamedTextColor.GOLD).decoration(TextDecoration.ITALIC, false).decoration(TextDecoration.BOLD, true)
        ));
        
        meta.setCustomModelData(10002);
        item.setItemMeta(meta);
        
        return item;
    }
    
    private ItemStack createSoulReaper() {
        // Using WARPED_FUNGUS_ON_A_STICK for scythe model
        ItemStack item = new ItemStack(Material.WARPED_FUNGUS_ON_A_STICK);
        ItemMeta meta = item.getItemMeta();
        
        meta.displayName(Component.text("💀 Soul Reaper 💀")
            .color(NamedTextColor.DARK_RED)
            .decoration(TextDecoration.ITALIC, false)
            .decoration(TextDecoration.BOLD, true));
        
        meta.lore(Arrays.asList(
            Component.text("Harvests the souls of the fallen").color(NamedTextColor.GRAY).decoration(TextDecoration.ITALIC, false),
            Component.text(""),
            Component.text("⚔ Damage: 18").color(NamedTextColor.RED).decoration(TextDecoration.ITALIC, false),
            Component.text("👻 Soul Steal: 25%").color(NamedTextColor.YELLOW).decoration(TextDecoration.ITALIC, false),
            Component.text("✨ Special: Death Aura").color(NamedTextColor.LIGHT_PURPLE).decoration(TextDecoration.ITALIC, false),
            Component.text("💀 Kills heal the wielder").color(NamedTextColor.AQUA).decoration(TextDecoration.ITALIC, false),
            Component.text(""),
            Component.text("MYTHIC WEAPON").color(NamedTextColor.DARK_PURPLE).decoration(TextDecoration.ITALIC, false).decoration(TextDecoration.BOLD, true)
        ));
        
        meta.setCustomModelData(10003);
        item.setItemMeta(meta);
        
        item.addUnsafeEnchantment(Enchantment.SHARPNESS, 5); // Use unsafe for non-weapon items
        item.addUnsafeEnchantment(Enchantment.LOOTING, 3);
        
        return item;
    }
    
    private ItemStack createDragonFangDagger() {
        // Using KNOWLEDGE_BOOK for dagger model
        ItemStack item = new ItemStack(Material.KNOWLEDGE_BOOK);
        ItemMeta meta = item.getItemMeta();
        
        meta.displayName(Component.text("🐉 Dragon Fang Dagger 🐉")
            .color(NamedTextColor.DARK_GREEN)
            .decoration(TextDecoration.ITALIC, false)
            .decoration(TextDecoration.BOLD, true));
        
        meta.lore(Arrays.asList(
            Component.text("Carved from an ancient dragon's fang").color(NamedTextColor.GRAY).decoration(TextDecoration.ITALIC, false),
            Component.text(""),
            Component.text("⚔ Damage: 8").color(NamedTextColor.RED).decoration(TextDecoration.ITALIC, false),
            Component.text("⚡ Speed: Lightning Fast").color(NamedTextColor.YELLOW).decoration(TextDecoration.ITALIC, false),
            Component.text("🔥 Special: Dragon Fire").color(NamedTextColor.LIGHT_PURPLE).decoration(TextDecoration.ITALIC, false),
            Component.text("💨 Right-click: Shadow Step").color(NamedTextColor.AQUA).decoration(TextDecoration.ITALIC, false),
            Component.text("🐲 Burns enemies with dragon fire").color(NamedTextColor.GOLD).decoration(TextDecoration.ITALIC, false),
            Component.text(""),
            Component.text("LEGENDARY WEAPON").color(NamedTextColor.GOLD).decoration(TextDecoration.ITALIC, false).decoration(TextDecoration.BOLD, true)
        ));
        
        meta.setCustomModelData(10004);
        item.setItemMeta(meta);
        
        return item;
    }
    
    private ItemStack createEtherealStaff() {
        // Using BLAZE_ROD for staff model
        ItemStack item = new ItemStack(Material.BLAZE_ROD);
        ItemMeta meta = item.getItemMeta();
        
        meta.displayName(Component.text("🔮 Ethereal Staff 🔮")
            .color(NamedTextColor.AQUA)
            .decoration(TextDecoration.ITALIC, false)
            .decoration(TextDecoration.BOLD, true));
        
        meta.lore(Arrays.asList(
            Component.text("Channels pure magical energy").color(NamedTextColor.GRAY).decoration(TextDecoration.ITALIC, false),
            Component.text(""),
            Component.text("⚡ Magic Power: 20").color(NamedTextColor.BLUE).decoration(TextDecoration.ITALIC, false),
            Component.text("🌟 Mana: Infinite").color(NamedTextColor.YELLOW).decoration(TextDecoration.ITALIC, false),
            Component.text("✨ Special: Energy Blast").color(NamedTextColor.LIGHT_PURPLE).decoration(TextDecoration.ITALIC, false),
            Component.text("🌊 Right-click: Wave of Force").color(NamedTextColor.AQUA).decoration(TextDecoration.ITALIC, false),
            Component.text(""),
            Component.text("LEGENDARY ARTIFACT").color(NamedTextColor.GOLD).decoration(TextDecoration.ITALIC, false).decoration(TextDecoration.BOLD, true)
        ));
        
        meta.setCustomModelData(10005);
        item.setItemMeta(meta);
        
        return item;
    }
    
    private ItemStack createPhoenixWings() {
        // Using ELYTRA for wings model
        ItemStack item = new ItemStack(Material.ELYTRA);
        ItemMeta meta = item.getItemMeta();
        
        meta.displayName(Component.text("🔥 Phoenix Wings 🔥")
            .color(NamedTextColor.GOLD)
            .decoration(TextDecoration.ITALIC, false)
            .decoration(TextDecoration.BOLD, true));
        
        meta.lore(Arrays.asList(
            Component.text("Wings of the legendary phoenix").color(NamedTextColor.GRAY).decoration(TextDecoration.ITALIC, false),
            Component.text(""),
            Component.text("🕊️ Flight: Unlimited").color(NamedTextColor.YELLOW).decoration(TextDecoration.ITALIC, false),
            Component.text("🔥 Fire Immunity").color(NamedTextColor.RED).decoration(TextDecoration.ITALIC, false),
            Component.text("✨ Special: Phoenix Dive").color(NamedTextColor.LIGHT_PURPLE).decoration(TextDecoration.ITALIC, false),
            Component.text("🌟 Rebirth on death (once per day)").color(NamedTextColor.AQUA).decoration(TextDecoration.ITALIC, false),
            Component.text(""),
            Component.text("MYTHIC ARTIFACT").color(NamedTextColor.DARK_PURPLE).decoration(TextDecoration.ITALIC, false).decoration(TextDecoration.BOLD, true)
        ));
        
        meta.setCustomModelData(10006);
        item.setItemMeta(meta);
        
        item.addEnchantment(Enchantment.UNBREAKING, 3); // Changed from 10 to 3 (max safe level)
        
        return item;
    }
    
    private ItemStack createCrystalCore() {
        // Using NETHER_STAR for crystal model
        ItemStack item = new ItemStack(Material.NETHER_STAR);
        ItemMeta meta = item.getItemMeta();
        
        meta.displayName(Component.text("💎 Crystal Core 💎")
            .color(NamedTextColor.WHITE)
            .decoration(TextDecoration.ITALIC, false)
            .decoration(TextDecoration.BOLD, true));
        
        meta.lore(Arrays.asList(
            Component.text("A core of pure crystallized energy").color(NamedTextColor.GRAY).decoration(TextDecoration.ITALIC, false),
            Component.text(""),
            Component.text("⚡ Energy: 1000").color(NamedTextColor.BLUE).decoration(TextDecoration.ITALIC, false),
            Component.text("🔋 Powers magical items").color(NamedTextColor.YELLOW).decoration(TextDecoration.ITALIC, false),
            Component.text("✨ Crafting Component").color(NamedTextColor.LIGHT_PURPLE).decoration(TextDecoration.ITALIC, false),
            Component.text("🌟 Used to upgrade weapons").color(NamedTextColor.AQUA).decoration(TextDecoration.ITALIC, false),
            Component.text(""),
            Component.text("LEGENDARY MATERIAL").color(NamedTextColor.GOLD).decoration(TextDecoration.ITALIC, false).decoration(TextDecoration.BOLD, true)
        ));
        
        meta.setCustomModelData(10007);
        item.setItemMeta(meta);
        
        return item;
    }
    
    private ItemStack createVoidEssence() {
        // Using ECHO_SHARD for void essence model
        ItemStack item = new ItemStack(Material.ECHO_SHARD);
        ItemMeta meta = item.getItemMeta();
        
        meta.displayName(Component.text("🌌 Void Essence 🌌")
            .color(NamedTextColor.DARK_PURPLE)
            .decoration(TextDecoration.ITALIC, false)
            .decoration(TextDecoration.BOLD, true));
        
        meta.lore(Arrays.asList(
            Component.text("Essence extracted from the void itself").color(NamedTextColor.GRAY).decoration(TextDecoration.ITALIC, false),
            Component.text(""),
            Component.text("⚫ Void Energy: 500").color(NamedTextColor.DARK_PURPLE).decoration(TextDecoration.ITALIC, false),
            Component.text("🌀 Dimensional Power").color(NamedTextColor.YELLOW).decoration(TextDecoration.ITALIC, false),
            Component.text("✨ Crafting Component").color(NamedTextColor.LIGHT_PURPLE).decoration(TextDecoration.ITALIC, false),
            Component.text("🌌 Used for void weapons").color(NamedTextColor.AQUA).decoration(TextDecoration.ITALIC, false),
            Component.text(""),
            Component.text("MYTHIC MATERIAL").color(NamedTextColor.DARK_PURPLE).decoration(TextDecoration.ITALIC, false).decoration(TextDecoration.BOLD, true)
        ));
        
        meta.setCustomModelData(10008);
        item.setItemMeta(meta);
        
        return item;
    }
    
    public ItemStack getCustomItem(String itemName) {
        ItemStack original = customItems.get(itemName.toLowerCase());
        return original != null ? original.clone() : null;
    }
    
    public Map<String, ItemStack> getAllCustomItems() {
        return new HashMap<>(customItems);
    }
    
    public boolean isCustomItem(ItemStack item) {
        if (item == null || !item.hasItemMeta()) return false;
        ItemMeta meta = item.getItemMeta();
        return meta.hasCustomModelData() && meta.getCustomModelData() >= 1000;
    }
    
    public String getCustomItemName(ItemStack item) {
        if (!isCustomItem(item)) return null;
        
        for (Map.Entry<String, ItemStack> entry : customItems.entrySet()) {
            if (entry.getValue().isSimilar(item)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
