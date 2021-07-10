package BacoProject.Demacia;

import BacoProject.*;

import java.util.ArrayList;

public class Vanguarda extends Follower implements iEffect, Lifeable{
    public Vanguarda(Player player){
        super(player);
        super.name = "Vanguarda";
        super.manaCost = 4;
        super.power = 3;
        super.life = 3;
    }
    @Override
    public void playEffect() {
        ArrayList<Card> evocked = this.owner.getEvockedUnits();
        for(Card card : evocked){
            if(card instanceof Lifeable) {
                Lifeable aux = (Lifeable) card;
                aux.lifeUp(1);
                aux.powerUp(1);
            }
        }
    }

//    @Override
//    public void update(Object o) {
//        if(o instanceof Board){
//
//        }
//    }
}