package BacoProject.Demacia;

import BacoProject.Follower;
import BacoProject.Player;

public class Poro extends Follower {
    public Poro(Player player){
        super(player);
        super.name = "Poro";
        super.manaCost = 1;
        super.power = 2;
        super.life = 1;
    }
}
