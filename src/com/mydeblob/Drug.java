package com.mydeblob;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Drug extends JavaPlugin implements Listener{
	public void onEnable(){
		getServer().getPluginManager().registerEvents(this, this);
		ItemStack coke = new ItemStack(Material.SUGAR, 1);
		ItemMeta meta = coke.getItemMeta();
		meta.setDisplayName(ChatColor.GRAY  + "" + ChatColor.BOLD + "Cocaine");
		coke.setItemMeta(meta); 
		ShapedRecipe drug = new ShapedRecipe(coke);
		drug.shape("AAA", "AAA", "AAA");
		drug.setIngredient('A', Material.SUGAR_CANE);
		getServer().addRecipe(drug);
	}
	public void onDisable(){
		
	}
	@EventHandler
	public void onWheatBreak(PlayerPickupItemEvent event){
		if(event.getItem().getItemStack().getType() == Material.WHEAT){
			ItemMeta meta = event.getItem().getItemStack().getItemMeta();
			meta.setDisplayName(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Weed");
			event.getItem().getItemStack().setItemMeta(meta); 
		}
	}
	@EventHandler
	public void onShroomzBreak(PlayerPickupItemEvent event){
		if(event.getItem().getItemStack().getType() == Material.BROWN_MUSHROOM){
			ItemMeta meta = event.getItem().getItemStack().getItemMeta();
			meta.setDisplayName(ChatColor.GOLD  + "" + ChatColor.BOLD + "Shroomz");
			event.getItem().getItemStack().setItemMeta(meta); 
		}
	}
	@EventHandler
	public void onGunpowderBreak(PlayerPickupItemEvent event){
		if(event.getItem().getItemStack().getType() == Material.SULPHUR){
			ItemMeta meta = event.getItem().getItemStack().getItemMeta();
			meta.setDisplayName(ChatColor.GRAY  + "" + ChatColor.BOLD + "Meth");
			event.getItem().getItemStack().setItemMeta(meta); 
		}
	}
	@EventHandler
	public void onWheat(PlayerInteractEvent event){
		Player p = (Player) event.getPlayer();
		ItemStack stack = p.getItemInHand();
		if(stack != null){
			if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
				if(stack.getType() == Material.WHEAT){
					if(p.getInventory().getItemInHand().getAmount() == 1){
						p.getInventory().remove(p.getItemInHand());
					}
					p.getInventory().getItemInHand().setAmount(p.getInventory().getItemInHand().getAmount()-1);
					p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20*22, 1));
					p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20*10, 0));
				}
			}
		}
	}
	@EventHandler
	public void onShroomz(PlayerInteractEvent event){
		Player p = (Player) event.getPlayer();
		ItemStack stack = p.getItemInHand();
		if(stack != null){
			if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
				if(stack.getType() == Material.BROWN_MUSHROOM){
					if(p.getInventory().getItemInHand().getAmount() == 1){
						p.getInventory().remove(p.getItemInHand());
					}
					p.getInventory().getItemInHand().setAmount(p.getInventory().getItemInHand().getAmount()-1);
					p.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 20*60, 1));
					p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 20*420, 1));
				}
			}
		}
	}
	@EventHandler
	public void onSugar(PlayerInteractEvent event){
		Player p = (Player) event.getPlayer();
		ItemStack stack = p.getItemInHand();
		if(stack != null){
			if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
				if(stack.getType() == Material.SUGAR){
					if(p.getInventory().getItemInHand().getAmount() == 1){
						p.getInventory().remove(p.getItemInHand());
					}
					p.getInventory().getItemInHand().setAmount(p.getInventory().getItemInHand().getAmount()-1);
					p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20*10, 0));
					p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 20*30, 0));
					p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 20*5, 0));
					p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20*20, 0));
				}
			}
		}
	}
	@EventHandler
	public void onGunpowder(PlayerInteractEvent event){
		Player p = (Player) event.getPlayer();
		ItemStack stack = p.getItemInHand();
		if(stack != null){
			if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
				if(stack.getType() == Material.SULPHUR){
					if(p.getInventory().getItemInHand().getAmount() == 1){
						p.getInventory().remove(p.getItemInHand());
					}
					p.getInventory().getItemInHand().setAmount(p.getInventory().getItemInHand().getAmount()-1);
					p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 20*5, 1));
					p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 20*20, 0));
				}
			}
		}
	}

}
