package BacoProject.Demacia;

import BacoProject.Follower;
import BacoProject.iEffect;

public class Vanguarda extends Follower implements iEffect {
    public Vanguarda(){
        this.manaCost = 4;
        this.power = 3;
        this.life = 3;
    }
    @Override
    public void playEffect() {
        //de +1/+1 a todas cartas aliadas
    }
}