package Location;

import Award.Firewood;
import Game.Player;
import Obstacle.Vampire;

public class Forest extends BattleLoc {

	public Forest(Player player) {
		super(player, "Orman", new Vampire(),new Firewood());
		
	}
	

}
