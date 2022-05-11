package Location;

import Game.Player;
import Location.Location;

public abstract class NormalLoc extends Location {

	NormalLoc(Player player, String name) {
		super(player);
		this.name = name;
	}
	

	public boolean getLocation() {
		return true;
	}
	
	
}
