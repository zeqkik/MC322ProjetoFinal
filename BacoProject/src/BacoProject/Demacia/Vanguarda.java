package BacoProject.Demacia;

import BacoProject.*;

import java.util.ArrayList;
import java.util.Observer;

public class Vanguarda extends Follower implements iEffect {
    public Vanguarda(Player player){
        super(player);
        super.name = "Vanguarda";
        super.manaCost = 4;
        super.power = 3;
        super.life = 3;
    }
    @Override
    public void playEffect() {
        ArrayList evocked = this.owner.getEvockedUnits();
        for(Follower card : evocked){
            card.lifeUp(1);
            card.powerUp(1);
        }
        for(Champion card : evocked){
            card.lifeUp(1);
            card.powerUp(1);
        }
    }

    @Override
    public void update(Object o) {
        if(o instanceof Board){

        }
    }
}