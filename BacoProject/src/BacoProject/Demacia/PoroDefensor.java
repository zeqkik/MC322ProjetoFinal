package BacoProject.Demacia;

import BacoProject.Follower;
import BacoProject.iEffect;

public class PoroDefensor extends Follower implements iEffect {
    public PoroDefensor(){
        this.manaCost = 1;
        this.power = 1;
        this.life = 2;
    }
    @Override
    public void playEffect() {

    }
}
