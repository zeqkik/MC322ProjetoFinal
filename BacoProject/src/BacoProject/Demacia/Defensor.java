package BacoProject.Demacia;

import BacoProject.*;

public class Defensor extends Follower implements iEffect, Battleable {
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
        // Quando destruir um seguidor adversario ganha +0/ +1.
    	super.power++;
    }

    @Override
    public void update(Battleable kill, Battleable dead, int idKill, int idDead) {
        if(dead instanceof Follower && idKill == super.id){
            this.playEffect();
        }
    }

}