package BacoProject.Demacia;

import BacoProject.Follower;
import BacoProject.iEffect;

public class Tiana extends Follower implements iEffect {
    public Tiana(){
        super.manaCost = 8;
        super.power = 7;
        super.life = 7;
    }
    @Override
    public void playEffect() {
        //ao ser comprada uma unidade evocada ataca o nexus
    }
}
