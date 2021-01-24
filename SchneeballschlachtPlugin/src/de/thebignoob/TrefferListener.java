package de.thebignoob;

import java.util.HashMap;
import java.util.UUID;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.projectiles.ProjectileSource;

public class TrefferListener implements Listener{

	@EventHandler
	public void onEvent(EntityDamageByEntityEvent event){
		if(event.getCause() == DamageCause.PROJECTILE){
			Projectile projektil = (Projectile) event.getDamager();

			if(projektil.getType() == EntityType.SNOWBALL)
			{
				ProjectileSource angreifer = projektil.getShooter();
				Entity angegriffener = event.getEntity();
	
				if((angreifer instanceof Player) && (angegriffener instanceof Player)){
					Player a1 = (Player) angreifer;
					Player a2 = (Player) angegriffener;
	
					double leben = a2.getHealth()-4;
					if(leben<0) leben = 0;
					a2.setHealth(leben);
				}
			}
		}
	}
}
