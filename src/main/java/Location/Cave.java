package Location;

import Award.Food;
import Game.Player;
import Location.BattleLoc;
import Obstacle.Zombie;


public class Cave extends BattleLoc {

    public Cave(Player player) {
        super(player, "Maðara", new Zombie(),new Food());
    }

}
