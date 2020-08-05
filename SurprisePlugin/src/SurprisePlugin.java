import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import java.util.concurrent.ThreadLocalRandom;

public class SurprisePlugin extends JavaPlugin {
	public void onEnable() {
	}

	public void onDisable() {
	}

	public boolean onCommand(CommandSender sender, Command befehl, String befehlsname, String[] args) {
		Player spieler = (Player) sender;
		Location position = spieler.getLocation();
		float yaw = position.getYaw();
		if (yaw < 0)
			yaw += 360.f;
		World welt = spieler.getWorld();
		Bukkit.broadcastMessage("Yaw: " + Float.toString(yaw));
		if (yaw > 315 || yaw < 45)
			position.setZ(position.getZ() + 2);
		else if (yaw > 45 && yaw < 135)
			position.setX(position.getX() - 2);
		else if (yaw > 135 && yaw < 225)
			position.setZ(position.getZ() - 2);
		else
			position.setX(position.getX() + 2);

		Material m = Material.PUMPKIN;
		int randomNum = ThreadLocalRandom.current().nextInt(0, 10 + 1);

		switch (randomNum) {
		case 0:
			m = Material.PUMPKIN;
			break;
		case 1:
			m = Material.TNT;
			break;
		case 2:
			m = Material.DIAMOND_BLOCK;
			break;
		case 3:
			m = Material.GOLD_BLOCK;
			break;
		case 4:
			m = Material.LAPIS_BLOCK;
			break;
		case 5:
			m = Material.REDSTONE_BLOCK;
			break;
		case 6:
			m = Material.YELLOW_WOOL;
			break;
		case 7:
			m = Material.BEACON;
			break;
		case 8:
			m = Material.ACACIA_WOOD;
			break;
		case 9:
			m = Material.MELON;
			break;
		case 10:
			m = Material.ATTACHED_PUMPKIN_STEM;
			break;
		}

		welt.getBlockAt(position).setType(m);
		if (m == Material.TNT) {
			double x_center = position.getX();
			double z_center = position.getZ();
			double y_center = position.getY();

			for (int x = -1; x <= 1; x++) {
				for (int z = -1; z <= 1; z++) {
					for (int y = -1; y <= 1; y++) {
						position.setX(x_center + x);
						position.setZ(z_center + z);
						position.setY(y_center + y);
						welt.getBlockAt(position).setType(m);
					}
				}
			}
			position.setX(x_center);
			position.setZ(z_center);
			position.setY(position.getY() - 1);
			m = Material.REDSTONE_BLOCK;
			welt.getBlockAt(position).setType(m);
		}

		return true;
	}
}