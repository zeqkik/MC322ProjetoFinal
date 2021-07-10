package BacoProject.Demacia;

import BacoProject.Follower;
import BacoProject.Lifeable;
import BacoProject.Player;
import BacoProject.iEffect;

public class Tiana extends Follower implements iEffect, Lifeable {
    public Tiana(Player player){
        super(player);
        super.name = "Tiana";
        super.manaCost = 8;
        super.power = 7;
        super.life = 7;
    }
    @Override
    public void playEffect() {
        //ao ser comprada uma unidade evocada ataca o nexus
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
