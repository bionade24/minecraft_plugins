import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class NotunterkunftPlugin extends JavaPlugin {
	public void onEnable() {
	}

	public void onDisable() {
	}

	public boolean onCommand(CommandSender sender, Command befehl, String befehlsname, String[] args) {
		if(sender instanceof Player)
		{
			Player spieler = (Player) sender;
			World welt = spieler.getWorld();
	
			Location pos = spieler.getLocation();
			
			int hoehe = 4;
			int breite = 10;
			int tiefe = 10;
			
			Location aussenQuaderPosition = new Location(welt, pos.getX()+breite/2, pos.getY(), pos.getZ());
			Location innenQuaderPosition  = new Location(welt, pos.getX()+breite/2+1, pos.getY(), pos.getZ()+1);
			Location bodenQuaderPosition  = new Location(welt, pos.getX()+breite/2+1, pos.getY(), pos.getZ()+1);
			Location lampePosition = new Location(welt, pos.getX()+breite, pos.getY()+hoehe-1, pos.getZ()+tiefe/2);
			Location tuerPosition = new Location(welt, pos.getX()+breite, pos.getY()+1, pos.getZ());
			Quader aussen = new Quader(hoehe, breite, tiefe, Material.BRICKS);
			Quader innen = new Quader(hoehe-1, breite-2, tiefe-2, Material.AIR);
			Quader boden = new Quader(1, breite-2, tiefe-2, Material.JUNGLE_WOOD);
			Quader lampe = new Quader(1, 2, 2, Material.GLOWSTONE);
			Quader tuer = new Quader(2, 1, 1, Material.AIR);
			
			aussen.bauen(spieler, aussenQuaderPosition);
			innen.bauen(spieler, innenQuaderPosition);
			boden.bauen(spieler, bodenQuaderPosition);
			lampe.bauen(spieler, lampePosition);
			tuer.bauen(spieler, tuerPosition);
		}
		else
		{
			this.getLogger().info("Dieser Befehl kann nur von Spielern ausgefuehrt werden.");
		}
		return true;
	}
}