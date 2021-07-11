package BacoProject.Demacia;

import BacoProject.*;

public class Duelista extends Follower implements iEffect, Lifeable {

    public Duelista(Player player, String name, int id) {
        super(player, name, id);
        this.manaCost = 3;
        this.power = 3;
        this.life = 2;
        this.battlePosition = -1;
    }

    @Override
    public void playEffect() {
        //se destruir um seguidor do inimigo, adiciona uma carta "Poro" à mão
        this.owner.addHandCard(new Poro(owner, "Poro", owner.getNumCards()));
        this.owner.incrementNumCards();
    }

    @Override
    public void update(Card kill, Card dead, int idKill, int idDead) {
        if(dead instanceof Follower && idKill == this.id){
            playEffect();
        }

    }

}