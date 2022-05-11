package Location;

import Award.Award;
import Game.Player;
import Obstacle.Obstacle;

public class Mine extends BattleLoc{

    Mine(Player player, String name, Obstacle obstacle, Award award) {

        super(player, name, obstacle, award);
    }
}
