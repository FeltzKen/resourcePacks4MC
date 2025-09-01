package com.customitems.commands;

import com.customitems.CustomItemsPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

import java.util.Map;

public class CustomItemsCommand implements CommandExecutor {
    
    private final CustomItemsPlugin plugin;
    
    public CustomItemsCommand(CustomItemsPlugin plugin) {
        this.plugin = plugin;
        plugin.getLogger().info("CustomItemsCommand: Command handler created successfully");
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        try {
            // Debug logging
            plugin.getLogger().info("CustomItems command executed by " + sender.getName() + " with args: " + String.join(", ", args));
            
            if (args.length == 0) {
                sendHelp(sender);
                return true;
            }
            
            String subCommand = args[0].toLowerCase();
            plugin.getLogger().info("Processing subcommand: " + subCommand);
            
            switch (subCommand) {
                case "help":
                    sendHelp(sender);
                    break;
                case "test":
                    sender.sendMessage(Component.text("✅ Plugin is working! Command received successfully!").color(NamedTextColor.GREEN));
                    plugin.getLogger().info("Test command executed successfully by " + sender.getName());
                    break;
                case "list":
                    listItems(sender);
                    break;
                case "give":
                    if (args.length < 2) {
                        sender.sendMessage(Component.text("Usage: /customitems give <item>").color(NamedTextColor.RED));
                        return true;
                    }
                    if (!(sender instanceof Player)) {
                        sender.sendMessage(Component.text("Only players can use this command!").color(NamedTextColor.RED));
                        return true;
                    }
                    giveItem((Player) sender, args[1]);
                    break;
                case "giveall":
                    if (!(sender instanceof Player)) {
                        sender.sendMessage(Component.text("Only players can use this command!").color(NamedTextColor.RED));
                        return true;
                    }
                    giveAllItems((Player) sender);
                    break;
                default:
                    sender.sendMessage(Component.text("Unknown subcommand: " + args[0]).color(NamedTextColor.RED));
                    sendHelp(sender);
                    break;
            }
            
            return true;
        } catch (Exception e) {
            plugin.getLogger().severe("Error executing command: " + e.getMessage());
            e.printStackTrace();
            sender.sendMessage(Component.text("An error occurred while executing the command. Check console for details.").color(NamedTextColor.RED));
            return true;
        }
    }
    
    private void sendHelp(CommandSender sender) {
        try {
            sender.sendMessage(Component.text("=== CustomItems4MC Help ===").color(NamedTextColor.GOLD));
            sender.sendMessage(Component.text("/customitems help - Show this help").color(NamedTextColor.YELLOW));
            sender.sendMessage(Component.text("/customitems test - Test if plugin is working").color(NamedTextColor.YELLOW));
            sender.sendMessage(Component.text("/customitems list - List all custom items").color(NamedTextColor.YELLOW));
            sender.sendMessage(Component.text("/customitems give <item> - Give yourself a custom item").color(NamedTextColor.YELLOW));
            sender.sendMessage(Component.text("/customitems giveall - Give yourself ALL custom items").color(NamedTextColor.YELLOW));
            sender.sendMessage(Component.text("/giveitem <player> <item> - Give item to another player").color(NamedTextColor.YELLOW));
            sender.sendMessage(Component.text("Plugin is working! Version 1.0.0").color(NamedTextColor.GREEN));
        } catch (Exception e) {
            plugin.getLogger().severe("Error in sendHelp: " + e.getMessage());
            e.printStackTrace();
            sender.sendMessage(Component.text("Error showing help: " + e.getMessage()).color(NamedTextColor.RED));
        }
    }
    
    private void listItems(CommandSender sender) {
        try {
            sender.sendMessage(Component.text("=== Available Custom Items ===").color(NamedTextColor.GOLD));
            
            if (plugin.getItemManager() == null) {
                sender.sendMessage(Component.text("Error: ItemManager is null!").color(NamedTextColor.RED));
                return;
            }
            
            Map<String, ItemStack> items = plugin.getItemManager().getAllCustomItems();
            
            if (items == null || items.isEmpty()) {
                sender.sendMessage(Component.text("No custom items found!").color(NamedTextColor.YELLOW));
                return;
            }
            
            for (String itemName : items.keySet()) {
                ItemStack item = items.get(itemName);
                if (item == null) {
                    sender.sendMessage(Component.text("• " + itemName + " - [NULL ITEM]").color(NamedTextColor.RED));
                    continue;
                }
                
                Component displayName = null;
                if (item.getItemMeta() != null) {
                    displayName = item.getItemMeta().displayName();
                }
                if (displayName == null) {
                    displayName = Component.text(item.getType().toString());
                }
                sender.sendMessage(Component.text("• " + itemName + " - ").color(NamedTextColor.GREEN)
                    .append(displayName));
            }
        } catch (Exception e) {
            plugin.getLogger().severe("Error in listItems: " + e.getMessage());
            e.printStackTrace();
            sender.sendMessage(Component.text("Error listing items: " + e.getMessage()).color(NamedTextColor.RED));
        }
    }
    
    private void giveItem(Player player, String itemName) {
        try {
            if (plugin.getItemManager() == null) {
                player.sendMessage(Component.text("Error: ItemManager is null!").color(NamedTextColor.RED));
                return;
            }
            
            ItemStack item = plugin.getItemManager().getCustomItem(itemName);
            
            if (item == null) {
                player.sendMessage(Component.text("Unknown item: " + itemName).color(NamedTextColor.RED));
                player.sendMessage(Component.text("Use /customitems list to see available items").color(NamedTextColor.YELLOW));
                return;
            }
            
            player.getInventory().addItem(item);
            Component displayName = null;
            if (item.getItemMeta() != null) {
                displayName = item.getItemMeta().displayName();
            }
            if (displayName == null) {
                displayName = Component.text(item.getType().toString());
            }
            player.sendMessage(Component.text("Given ").color(NamedTextColor.GREEN)
                .append(displayName)
                .append(Component.text("!").color(NamedTextColor.GREEN)));
        } catch (Exception e) {
            plugin.getLogger().severe("Error in giveItem: " + e.getMessage());
            e.printStackTrace();
            player.sendMessage(Component.text("Error giving item: " + e.getMessage()).color(NamedTextColor.RED));
        }
    }
    
    private void giveAllItems(Player player) {
        try {
            if (plugin.getItemManager() == null) {
                player.sendMessage(Component.text("Error: ItemManager is null!").color(NamedTextColor.RED));
                return;
            }
            
            Map<String, ItemStack> items = plugin.getItemManager().getAllCustomItems();
            if (items == null || items.isEmpty()) {
                player.sendMessage(Component.text("No custom items available!").color(NamedTextColor.YELLOW));
                return;
            }
            
            int itemsGiven = 0;
            
            player.sendMessage(Component.text("🎁 Giving you ALL custom items...").color(NamedTextColor.GOLD));
            
            for (Map.Entry<String, ItemStack> entry : items.entrySet()) {
                ItemStack item = entry.getValue();
                if (item != null) {
                    player.getInventory().addItem(item);
                    itemsGiven++;
                }
            }
            
            player.sendMessage(Component.text("✅ Successfully given " + itemsGiven + " custom items!").color(NamedTextColor.GREEN));
            player.sendMessage(Component.text("🎭 Full Mystic set acquired! Sneak for invisibility!").color(NamedTextColor.LIGHT_PURPLE));
        } catch (Exception e) {
            plugin.getLogger().severe("Error in giveAllItems: " + e.getMessage());
            e.printStackTrace();
            player.sendMessage(Component.text("Error giving items: " + e.getMessage()).color(NamedTextColor.RED));
        }
    }
}
