import org.bukkit.Material;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.World;

class Quader extends Viereckig {

	private int tiefe;
	
	
	
	public void bauen(Player spieler, Location position) {
		World welt = spieler.getWorld();

		double yStart = position.getY();
		double xStart = position.getX()+2;
		double zStart = position.getZ();
		
		for(int x=0; x<this.tiefe; x++)
		{
			position.setX(xStart+x);
			for(int y=0; y<this.hoehe; y++)
			{
				position.setY(yStart+y);
				for(int z=0; z<this.breite; z++)
				{
					position.setZ(zStart+z);
					welt.getBlockAt(position).setType(this.material);
				}
			}
		}
	}
}
