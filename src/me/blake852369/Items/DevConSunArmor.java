package me.blake852369.Items;



import java.util.ArrayList;
import me.blake852369.DevConCore;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 *
 * @author Blake
 */
public class DevConSunArmor implements Listener{

    public DevConSunArmor(DevConCore plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    
    public void Register(String what, Player player){
    
        
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
        
        ArrayList<Player> flight = new ArrayList<>();
        if(what.isEmpty() == false){
        if(what.toLowerCase().equals("effect")){
            ItemStack pchest = player.getInventory().getChestplate();
            ItemStack phelm = player.getInventory().getHelmet();
            ItemStack ppants = player.getInventory().getLeggings();
            ItemStack pboots = player.getInventory().getBoots();
            
            if(!(pchest == null)){
            if(pchest.getItemMeta().getDisplayName().equals(sunChest.getItemMeta().getDisplayName())){
            if(pchest.getItemMeta().getEnchants().equals(sunChest.getItemMeta().getEnchants())){
                
                if(!(phelm == null)){
                if(phelm.getItemMeta().getDisplayName().equals(sunHelm.getItemMeta().getDisplayName())){
                if(phelm.getItemMeta().getEnchants().equals(sunHelm.getItemMeta().getEnchants())){
                    
                    if(!(ppants == null)){
                    if(ppants.getItemMeta().getDisplayName().equals(sunPants.getItemMeta().getDisplayName())){
                    if(ppants.getItemMeta().getEnchants().equals(sunPants.getItemMeta().getEnchants())){
                        
                        if(!(pboots == null)){
                        if(pboots.getItemMeta().getDisplayName().equals(sunBoots.getItemMeta().getDisplayName())){
                        if(pboots.getItemMeta().getEnchants().equals(sunBoots.getItemMeta().getEnchants())){
                            
                player.setAllowFlight(true);
               
                            if(player.isFlying() == false){
                            
                for(Player online : Bukkit.getOnlinePlayers()){
                int x = player.getLocation().getBlockX();
                int y = player.getLocation().getBlockY() - 1;
                int z = player.getLocation().getBlockZ();
                Location particles = new Location(player.getWorld() , x, y, z);
                online.playEffect(particles, Effect.MOBSPAWNER_FLAMES, 1);
            }
                            }
                player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 400, 4));
                for(Entity e : player.getNearbyEntities(3, 3, 3)){
                    if(e instanceof Player){
                        Player target = (Player) e;
                        if(target.getGameMode() == GameMode.SURVIVAL){
                            if(!(target.getHealth() - 1 <= 10)){
                            target.damage(1);
                        }}
                    }
                }
                        }}}}}}}}}}}}
                
             
            
            }
            }else if(what.toLowerCase().equals("give")){
                player.getInventory().addItem(sunBoots);
                player.getInventory().addItem(sunChest);
                player.getInventory().addItem(sunHelm);
                player.getInventory().addItem(sunPants);
                player.sendMessage(ChatColor.YELLOW + "You Have Been Trusted With The Powers Of The Sun!");
            }
        }
    
    
    
    @EventHandler
    public void PlayerMove(PlayerMoveEvent event){
        Register("effect", event.getPlayer());
    }
            
        

    }
    

