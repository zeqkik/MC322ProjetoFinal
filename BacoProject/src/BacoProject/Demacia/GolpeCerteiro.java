package BacoProject.Demacia;

import BacoProject.Player;
import BacoProject.Spell;
import BacoProject.iEffect;

public class GolpeCerteiro extends Spell implements iEffect {
    public GolpeCerteiro(){
        super.manaCost=1;
    }
    @Override
    public void playEffect() {
        //dê +1/+1 a um aliado nesta rodada;
    }
}
