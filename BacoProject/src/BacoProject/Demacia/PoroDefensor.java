package BacoProject.Demacia;

import BacoProject.Follower;
import BacoProject.Player;
import BacoProject.iEffect;

public class PoroDefensor extends Follower implements iEffect {
    public PoroDefensor(){
        super.manaCost = 1;
        super.power = 1;
        super.life = 2;
    }
    @Override
    public void playEffect() {

    }
}
