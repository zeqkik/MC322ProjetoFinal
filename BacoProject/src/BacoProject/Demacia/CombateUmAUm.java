package BacoProject.Demacia;

import BacoProject.Spell;
import BacoProject.iEffect;

public class CombateUmAUm extends Spell implements iEffect {
    public CombateUmAUm(){
        this.manaCost = 2;
    }
    @Override
    public void playEffect() {
        //escolhe um aliado e um oponente para um combate imediato
    }
}
