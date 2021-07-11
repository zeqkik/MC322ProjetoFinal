package BacoProject.Demacia;

import BacoProject.Card;
import BacoProject.Player;
import BacoProject.Spell;
import BacoProject.iEffect;

public class Julgamento extends Spell implements iEffect {
    public Julgamento(Player player, String name, int id) {
        super(player, name, id);
        super.manaCost = 8;
    }

    @Override
    public void playEffect() {
        //um aliado atacante golpeia todos oponentes defensores
    }

    @Override
    public void update(Card kill, Card dead, int idKill, int idDead) {

    }
}
