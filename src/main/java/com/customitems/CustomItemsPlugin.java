package com.customitems;

import com.customitems.commands.CustomItemsCommand;
import com.customitems.commands.GiveItemCommand;
import com.customitems.items.CustomItemManager;
import com.customitems.listeners.ArmorEquipListener;
import com.customitems.listeners.PlayerInteractListener;
import com.customitems.listeners.PlayerDamageListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomItemsPlugin extends JavaPlugin {

    private CustomItemManager itemManager;

    @Override
    public void onEnable() {
        getLogger().info("======= STARTING CustomItems4MC INITIALIZATION =======");
        
        try {
            getLogger().info("Step 1: Starting plugin enable");
            
            // Initialize managers
            getLogger().info("Step 2: Creating CustomItemManager");
            this.itemManager = new CustomItemManager(this);
            getLogger().info("Step 3: CustomItemManager created successfully");
            
            // Register commands with null checks
            getLogger().info("Step 4: Registering commands");
            
            if (getCommand("customitems") != null) {
                getLogger().info("Step 5: Found customitems command, registering executor");
                getCommand("customitems").setExecutor(new CustomItemsCommand(this));
                getLogger().info("Step 6: CustomItems command registered successfully");
            } else {
                getLogger().severe("FATAL: customitems command not found in plugin.yml!");
                return;
            }
            
            if (getCommand("giveitem") != null) {
                getLogger().info("Step 7: Found giveitem command, registering executor");
                getCommand("giveitem").setExecutor(new GiveItemCommand(this));
                getLogger().info("Step 8: GiveItem command registered successfully");
            } else {
                getLogger().warning("giveitem command not found in plugin.yml");
            }
            
            getLogger().info("Step 9: Starting event listener registration");
            
            // Register event listeners
            getServer().getPluginManager().registerEvents(new ArmorEquipListener(this), this);
            getLogger().info("Step 10: ArmorEquipListener registered");
            
            getServer().getPluginManager().registerEvents(new PlayerInteractListener(this), this);
            getLogger().info("Step 11: PlayerInteractListener registered");
            
            getServer().getPluginManager().registerEvents(new PlayerDamageListener(this), this);
            getLogger().info("Step 12: PlayerDamageListener registered");
            
            getLogger().info("Step 13: All event listeners registered successfully");
            
            // Save default config
            getLogger().info("Step 14: Saving default config");
            saveDefaultConfig();
            getLogger().info("Step 15: Default config saved");
            
            getLogger().info("======= CustomItems4MC ENABLED SUCCESSFULLY! =======");
        } catch (Exception e) {
            getLogger().severe("======= FATAL ERROR DURING PLUGIN ENABLE =======");
            getLogger().severe("Error during plugin enablement: " + e.getMessage());
            getLogger().severe("Stack trace:");
            e.printStackTrace();
            getLogger().severe("======= PLUGIN ENABLE FAILED =======");
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("CustomItems4MC has been disabled!");
    }

    public CustomItemManager getItemManager() {
        return itemManager;
    }
}
