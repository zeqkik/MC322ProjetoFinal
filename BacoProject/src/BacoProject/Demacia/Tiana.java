package BacoProject.Demacia;

import BacoProject.Follower;
import BacoProject.iEffect;

public class Tiana extends Follower implements iEffect {
    public Tiana(){
        this.manaCost = 8;
        this.power = 7;
        this.life = 7;
    }
    @Override
    public void playEffect() {
        //ao ser comprada uma unidade evocada ataca o nexus
    }
}
