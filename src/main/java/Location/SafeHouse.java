package Location;

import Game.Player;
import Location.NormalLoc;

public class SafeHouse extends NormalLoc {

	public SafeHouse(Player player) {
		super(player, "G�venli Ev");
	}
	
	public boolean getLocation() {
		player.setHealthy(player.getrHealthy());
		System.out.println("�yile�tiniz...");
		System.out.println("�uan G�venli Ev adl� yerdesiniz.");
		return true;
	}

}
