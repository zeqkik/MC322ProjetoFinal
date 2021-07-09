package BacoProject.Demacia;

import BacoProject.Champion;
import BacoProject.Trace;
import BacoProject.iEffect;

public class Garen extends Champion implements iEffect {
    private int attackCounter = 0;
    public Garen(){
        this.manaCost = 5;
        this.power = 5;
        this.life = 5;
    }

    @Override
    public void playEffect() {
        this.life = 5;
    }

    public void levelUp() {
        this.trace = Trace.ELUSIVE;
        this.power++;
        this.life++;
    }

    public int attack() {
        attackCounter++;
        if(attackCounter == 2){
            this.levelUp();
        }
        return this.power;
    }
}