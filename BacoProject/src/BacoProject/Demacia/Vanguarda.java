package BacoProject.Demacia;

import BacoProject.Follower;
import BacoProject.iEffect;

public class Vanguarda extends Follower implements iEffect {
    public Vanguarda(){
        super.manaCost = 4;
        super.power = 3;
        super.life = 3;
    }
    @Override
    public void playEffect() {
        //de +1/+1 a todas cartas aliadas
    }
}