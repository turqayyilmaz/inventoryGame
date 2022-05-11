package Location;

import Game.Player;
import Location.NormalLoc;

public class SafeHouse extends NormalLoc {

	public SafeHouse(Player player) {
		super(player, "Güvenli Ev");
	}
	
	public boolean getLocation() {
		player.setHealthy(player.getrHealthy());
		System.out.println("Ýyileþtiniz...");
		System.out.println("Þuan Güvenli Ev adlý yerdesiniz.");
		return true;
	}

}
