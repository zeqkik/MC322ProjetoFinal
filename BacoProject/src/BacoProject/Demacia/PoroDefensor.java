package BacoProject.Demacia;

import BacoProject.*;

public class PoroDefensor extends Follower implements iEffect, Lifeable {
    public PoroDefensor(Player player, String name, int id){
        super(player, name, id);
        super.manaCost = 1;
        super.power = 1;
        super.life = 2;
        super.battlePosition = -1;
    }
    @Override
    public void playEffect() {
    	super.owner.getCard(1);
    }

    @Override
    public void update(Lifeable kill, Lifeable dead, int idKill, int idDead) {
        if(idDead == super.id){
            this.playEffect();
        }
    }
}
