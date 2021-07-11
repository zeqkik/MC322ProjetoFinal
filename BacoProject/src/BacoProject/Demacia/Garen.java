package BacoProject.Demacia;

import BacoProject.*;

public class Garen extends Champion implements iEffect, Lifeable {
    private int attackCounter = 0;
    private int numKills;
    public Garen(Player player, String name, int id){
        super(player, name, id);
        super.manaCost = 5;
        super.power = 5;
        super.life = 5;
        super.battlePosition = -1;
        this.numKills = 0;

    }

    @Override
    public void playEffect() {
        this.life = 5;
    }

    @Override
    public void update(Card kill, Card dead, int idKill, int idDead) {
        if(idKill == this.id && owner.getAttack()){
            this.numKills ++;
            if(numKills == 2){
                this.levelUp();
            }
        }
    }

    public void levelUp() {
        super.trace = Trace.ELUSIVE;
        super.power++;
        super.life++;
    }

    public int attack() {
        this.attackCounter++;
        if(attackCounter == 2){
            this.levelUp();
        }
        return super.power;
    }

}