//this is property of the account holder of Minecraft account of UUID 69d66ef1-7c1e-40de-a47f-1cfad11bbe83 and is made by him
package me.blake852369;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class DevConCore extends JavaPlugin {
    
    
    private static Plugin plugin;

	@Override
	public void onEnable() {	
            new me.blake852369.Items.DevConWand(this);
            new me.blake852369.Items.DevConSunArmor(this);
            
          
            
           
                    
            PluginManager pm = getServer().getPluginManager();
            getConfig().options().copyDefaults(true);
            saveConfig();
            plugin = this;
            
            
	}
	
	@Override
	public void onDisable() {
            plugin = null;
	}
	
public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
for (Listener listener : listeners) {
Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
}
}
 
//To access the plugin variable from other classes
public static Plugin getPlugin() {
return plugin;
}        
        
		
	   
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            
            
            ItemStack sunBoots = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta sb = (LeatherArmorMeta) sunBoots.getItemMeta();
        sb.setColor(Color.YELLOW);
        sb.setDisplayName(ChatColor.YELLOW + "Sun Boots");
        sb.addEnchant(Enchantment.DURABILITY, 100, true);
        sunBoots.setItemMeta(sb);
        
        ItemStack sunPants = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta sp = (LeatherArmorMeta) sunPants.getItemMeta();
        sp.setColor(Color.YELLOW);
        sp.setDisplayName(ChatColor.YELLOW + "Sun Pantaloons");
        sp.addEnchant(Enchantment.DURABILITY, 100, true);
        sunPants.setItemMeta(sp);
        
        ItemStack sunHelm = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta sh = (LeatherArmorMeta) sunHelm.getItemMeta();
        sh.setColor(Color.YELLOW);
        sh.setDisplayName(ChatColor.YELLOW + "Sun Helmet");
        sh.addEnchant(Enchantment.DURABILITY, 100, true);
        sunHelm.setItemMeta(sh);
        
        ItemStack sunChest = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta sc = (LeatherArmorMeta) sunChest.getItemMeta();
        sc.setColor(Color.YELLOW);
        sc.setDisplayName(ChatColor.YELLOW + "Sun Chestplate");
        sc.addEnchant(Enchantment.DURABILITY, 100, true);
        sunChest.setItemMeta(sc);
            
       ItemStack wand = new ItemStack(Material.STICK);
       ItemMeta wandm = wand.getItemMeta(); 
       wandm.setDisplayName(ChatColor.GOLD + "Wand");
       wandm.addEnchant(Enchantment.DURABILITY, 1, true);
       wand.setItemMeta(wandm);            
            
            
            
		Player player = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("kit") && sender instanceof Player) {
			if(player.isOp() == true){
                            
                            Inventory items = Bukkit.createInventory(null, 18, ChatColor.GOLD + "Available Items");
                            items.addItem(wand);
                            items.addItem(sunHelm);
                            items.addItem(sunChest);
                            items.addItem(sunPants);
                            items.addItem(sunBoots);
                            player.openInventory(items);
                            
			
                        }
			return true;
                
                }
        
        

           












return false;

        }
}
