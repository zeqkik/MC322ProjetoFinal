package BacoProject.Demacia;

import BacoProject.Follower;
import BacoProject.iEffect;

public class Duelista extends Follower implements iEffect {
    public Duelista() {
        this.manaCost = 3;
        this.power = 3;
        this.life = 2;
    }

    @Override
    public void playEffect() {
        //se destruir um seguidor do inimigo, adiciona uma carta "Poro" à mão
    }
}