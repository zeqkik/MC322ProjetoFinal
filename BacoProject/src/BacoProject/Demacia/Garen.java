package BacoProject.Demacia;

import BacoProject.*;

public class Garen extends Champion implements iEffect, Lifeable {
    private int attackCounter = 0;
    public Garen(Player player){
        super(player);
        super.name = "Garen";
        super.manaCost = 5;
        super.power = 5;
        super.life = 5;
    }

    @Override
    public void playEffect() {
        this.life = 5;
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
        return this.power;
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