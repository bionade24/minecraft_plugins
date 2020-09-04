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
		Player spieler = (Player) sender;
		Location position = spieler.getLocation();
		World welt = spieler.getWorld();

		position.setX(position.getX() + 2);
		double yStart = position.getY();
		double xStart = position.getX();
		double zStart = position.getZ();
		
		int xmax = Integer.valueOf(args[0]);
		int ymax = Integer.valueOf(args[1]);
		int zmax = Integer.valueOf(args[2]);
		
		if(xmax>50) xmax=50;
		if(ymax>50) ymax=50;
		if(zmax>50) zmax=50;
		
		for(int y=0; y<ymax; y++)
		{
			position.setY(yStart+y);
			for(int x=0; x<xmax; x++)
			{
				position.setX(xStart+x);
				for(int z=0; z<zmax; z++)
				{
					position.setZ(zStart+z);
					welt.getBlockAt(position).setType(Material.PUMPKIN);
				}
			}
		}

		return true;
	}
}