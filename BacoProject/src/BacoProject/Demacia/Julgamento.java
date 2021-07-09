package BacoProject.Demacia;

import BacoProject.Spell;
import BacoProject.iEffect;

public class Julgamento extends Spell implements iEffect {
    public Julgamento(){
        super.manaCost = 8;
    }

    @Override
    public void playEffect() {
        //um aliado atacante golpeia todos oponentes defensores
    }
}
