package me.blake852369.Items;

import me.blake852369.DevConCore;
import me.blake852369.DevConCore;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wither;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class DevConWand implements Listener {
	
	public DevConWand(DevConCore plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);	
	}
       public ItemStack wand = new ItemStack(Material.STICK, 1);
       ItemMeta wandm = wand.getItemMeta();
       
        public void register(String what, Player player){
       wandm.setDisplayName(ChatColor.GOLD + "Wand");
       wandm.addEnchant(Enchantment.DURABILITY, 1, true);
       wand.setItemMeta(wandm);
       
       if(what.isEmpty() == false){
       if(what.toLowerCase().equals("give")){
           player.getInventory().addItem(wand);
           player.sendMessage(ChatColor.GOLD + "You Have Been Trusted With The Power Of Wizards!");
       }
           
           }
        }
        
        @EventHandler
        public void TrustPlayer(EntityDamageByEntityEvent event){
            Entity wither = event.getEntity();
            Entity attacker = event.getDamager();
            
            if(wither instanceof Wither){
                if(attacker instanceof Player){
                    Player player = (Player) event.getDamager();
                    register("give", player);
                }
            }
         }
        
        
        
        @EventHandler
        public void UseWand(PlayerInteractEvent event){
            Player player = event.getPlayer();
            if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
       wandm.setDisplayName(ChatColor.GOLD + "Wand");
       wandm.addEnchant(Enchantment.DURABILITY, 1, true);
       wand.setItemMeta(wandm);
                if(player.getItemInHand().getType().equals(Material.STICK)){
                    if(player.getItemInHand().getItemMeta().equals(wand.getItemMeta())){
                Block target = player.getTargetBlock(null, 50);
                if(target.getType() != Material.AIR){
                player.getWorld().strikeLightning(target.getLocation());
                player.getWorld().createExplosion(target.getLocation(), 5);
                player.sendMessage(ChatColor.GRAY + "You Feel Yourself Weaken As You Summon The Storm");
            }}
            }
        }
        }
      
}