package BacoProject.Demacia;

import BacoProject.Card;
import BacoProject.Player;
import BacoProject.Spell;
import BacoProject.iEffect;

public class GolpeCerteiro extends Spell implements iEffect {
    public GolpeCerteiro(Player player, String name, int id) {
        super(player, name, id);
        super.manaCost = 1;
    }
    @Override
    public void playEffect() {
        //dê +1/+1 a um aliado nesta rodada;
    }

    @Override
    public void update(Card kill, Card dead, int idKill, int idDead) {

    }
}
