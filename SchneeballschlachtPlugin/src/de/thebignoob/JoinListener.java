package de.thebignoob;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener extends MasterListener{
	@EventHandler
	public void onEvent(PlayerJoinEvent event)
	{
		Player spieler = event.getPlayer();
		this.schneebaelleGeben(event);
		
		spieler.setGameMode(GameMode.ADVENTURE);
	}

}
