package BacoProject.Demacia;

import BacoProject.Follower;
import BacoProject.Lifeable;
import BacoProject.Player;
import BacoProject.iEffect;

public class PoroDefensor extends Follower implements iEffect, Lifeable {
    public PoroDefensor(Player player){
        super(player);
        super.name = "Poro Defensor";
        super.manaCost = 1;
        super.power = 1;
        super.life = 2;
    }
    @Override
    public void playEffect() {

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
