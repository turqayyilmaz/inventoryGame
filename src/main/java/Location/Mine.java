package Location;


import Game.Player;

import Obstacle.Snake;
import Award.Wam;

public class Mine extends BattleLoc{

    public Mine(Player player) {
        super(player, "Maden", new Snake(), new Wam());


    }
}
