package BacoProject.Demacia;

import BacoProject.*;

public class Duelista extends Follower implements iEffect, Battleable {

    public Duelista(Player player, String name, int id) {
        super(player, name, id);
        super.manaCost = 3;
        super.power = 3;
        super.life = 2;
        super.battlePosition = -1;
    }

    @Override
    public void playEffect() {
        //se destruir um seguidor do inimigo, adiciona uma carta "Poro" à mão
    	super.owner.addHandCard(new Poro(owner, "Poro", owner.getNumCards()));
    	super.owner.incrementNumCards();
    }

    @Override
    public void update(Battleable kill, Battleable dead, int idKill, int idDead) {
        if(dead instanceof Follower && idKill == this.id){
            playEffect();
        }

    }

}