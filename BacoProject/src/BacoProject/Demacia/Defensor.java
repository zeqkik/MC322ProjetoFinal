package BacoProject.Demacia;

import BacoProject.*;

public class Defensor extends Follower implements iEffect, Lifeable {
    private int furyN;
    private int furyM;
    private Trace trace=Trace.FURY;
    public Defensor(Player player, String name, int id){
        super(player, name, id);
        super.manaCost = 2;
        super.power = 2;
        super.life = 2;
        super.battlePosition = -1;
    }

    @Override
    public void playEffect() {
        // Quando destruir um seguidor adversario ganhaÌ� +0/ +1.
    	super.power++;
    }

    @Override
    public void update(Lifeable kill, Lifeable dead, int idKill, int idDead) {
        if(dead instanceof Follower && idKill == super.id){
            this.playEffect();
        }
    }

}