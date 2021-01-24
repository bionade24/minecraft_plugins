package de.thebignoob;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerRespawnEvent;

public class RespawnListener extends MasterListener{
	@EventHandler
	public void onEvent(PlayerRespawnEvent event)
	{
		Player spieler = event.getPlayer();
		
		Location jailLocation = new Location(spieler.getWorld(), -57, 5, 287);
		event.setRespawnLocation(jailLocation);
	}

}
