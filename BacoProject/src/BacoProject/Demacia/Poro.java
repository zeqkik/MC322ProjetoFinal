package BacoProject.Demacia;

import BacoProject.Follower;
import BacoProject.Lifeable;
import BacoProject.Player;

public class Poro extends Follower implements Lifeable {
    public Poro(Player player){
        super(player);
        super.name = "Poro";
        super.manaCost = 1;
        super.power = 2;
        super.life = 1;
    }

    @Override
    public void lifeUp(int i){
        this.life += i;
    }

    @Override
    public void powerUp(int i){
        this.power -= i;
    }
}
