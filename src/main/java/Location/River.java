package Location;

import Award.Water;
import Game.Player;
import Obstacle.Bear;

public class River extends BattleLoc {

	public River(Player player) {
		super(player, "Nehir", new Bear(), new Water());
	}

}
