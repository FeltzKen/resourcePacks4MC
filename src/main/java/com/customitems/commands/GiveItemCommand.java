package com.customitems.commands;

import com.customitems.CustomItemsPlugin;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

public class GiveItemCommand implements CommandExecutor {
    
    private final CustomItemsPlugin plugin;
    
    public GiveItemCommand(CustomItemsPlugin plugin) {
        this.plugin = plugin;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 2) {
            sender.sendMessage(Component.text("Usage: /giveitem <player> <item>").color(NamedTextColor.RED));
            return true;
        }
        
        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            sender.sendMessage(Component.text("Player not found: " + args[0]).color(NamedTextColor.RED));
            return true;
        }
        
        String itemName = args[1];
        ItemStack item = plugin.getItemManager().getCustomItem(itemName);
        
        if (item == null) {
            sender.sendMessage(Component.text("Unknown item: " + itemName).color(NamedTextColor.RED));
            sender.sendMessage(Component.text("Use /customitems list to see available items").color(NamedTextColor.YELLOW));
            return true;
        }
        
        target.getInventory().addItem(item);
        Component displayName = item.getItemMeta().displayName();
        if (displayName == null) {
            displayName = Component.text(item.getType().toString());
        }
        
        sender.sendMessage(Component.text("Given ").color(NamedTextColor.GREEN)
            .append(displayName)
            .append(Component.text(" to " + target.getName()).color(NamedTextColor.GREEN)));
        target.sendMessage(Component.text("You received ").color(NamedTextColor.GREEN)
            .append(displayName)
            .append(Component.text("!").color(NamedTextColor.GREEN)));
        
        return true;
    }
}
