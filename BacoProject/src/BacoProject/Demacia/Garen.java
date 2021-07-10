package BacoProject.Demacia;

import BacoProject.Champion;
import BacoProject.Player;
import BacoProject.Trace;
import BacoProject.iEffect;

public class Garen extends Champion implements iEffect {
    private int attackCounter = 0;
    public Garen(){
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
}