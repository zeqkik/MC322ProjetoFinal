package BacoProject.Demacia;

import BacoProject.*;

public class Defensor extends Follower implements iEffect, Lifeable {
    private int furyN;
    private int furyM;
    private Trace trace=Trace.FURY;
    public Defensor(Player player, String name, int id){
        super(player, name, id);
        this.manaCost = 2;
        this.power = 2;
        this.life = 2;
        this.battlePosition = -1;
    }

    @Override
    public void playEffect() {
        // Quando destruir um seguidor adversario ganhá +0/ +1.
        this.power++;
    }

    @Override
    public void update(Card kill, Card dead, int idKill, int idDead) {
        if(dead instanceof Follower && idKill == this.id){
            this.playEffect();
        }
    }

}