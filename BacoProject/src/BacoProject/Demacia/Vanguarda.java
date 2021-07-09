package BacoProject.Demacia;

import BacoProject.Board;
import BacoProject.Follower;
import BacoProject.iEffect;

public class Vanguarda extends Follower implements iEffect, Observer{
    public Vanguarda(){
        super.manaCost = 4;
        super.power = 3;
        super.life = 3;
    }
    @Override
    public void playEffect() {
        //de +1/+1 a todas cartas aliadas
    }

    @Override
    public void update(Object o) {
        if(o instanceof Board){

        }
    }
}