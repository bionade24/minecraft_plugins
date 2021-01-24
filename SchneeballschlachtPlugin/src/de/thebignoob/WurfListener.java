package de.thebignoob;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class WurfListener extends MasterListener{
	@EventHandler
	public void onEvent(PlayerInteractEvent event)
	{
		if(event.hasItem())
		{
			ItemStack gegenstand = event.getItem();
			
			if(gegenstand.getType()==Material.SNOWBALL)
			{
				gegenstand.setAmount(16);
			}
		}
	}

}
