package de.thebignoob;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class SnowballfightListener extends MasterListener{

	@EventHandler
	public void onPlayerInteractEvent(PlayerInteractEvent event)
	{
		Player spieler = event.getPlayer();

		/* The rest of the action is currently done by a command block.
		 * TODO: Replace Hacky solution with better indentifier
		 */
		if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			Block clickedBlock = event.getClickedBlock();
			if (clickedBlock.getType() == Material.STONE_BUTTON) {
				this.schneebaelleGeben(event);
				spieler.setGameMode(GameMode.ADVENTURE);
			}
		}
	}

}
