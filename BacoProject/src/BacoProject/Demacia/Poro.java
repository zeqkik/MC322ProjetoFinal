package BacoProject.Demacia;

import BacoProject.Follower;
import BacoProject.Lifeable;
import BacoProject.Player;

public class Poro extends Follower implements Lifeable {
    public Poro(Player player, String name, int id){
        super(player, name, id);
        super.manaCost = 1;
        super.power = 2;
        super.life = 1;
        super.battlePosition = -1;
    }
}
