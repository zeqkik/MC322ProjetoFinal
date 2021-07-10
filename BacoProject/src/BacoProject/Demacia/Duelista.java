package BacoProject.Demacia;

import BacoProject.Follower;
import BacoProject.Lifeable;
import BacoProject.Player;
import BacoProject.iEffect;

public class Duelista extends Follower implements iEffect, Lifeable {
    public Duelista(Player player){
        super(player);
        super.name = "Duelista";
        this.manaCost = 3;
        this.power = 3;
        this.life = 2;
    }

    @Override
    public void playEffect() {
        //se destruir um seguidor do inimigo, adiciona uma carta "Poro" à mão
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