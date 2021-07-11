package BacoProject.Demacia;

import BacoProject.Card;
import BacoProject.Player;
import BacoProject.Spell;
import BacoProject.iEffect;

public class CombateUmAUm extends Spell implements iEffect {
    public CombateUmAUm(Player player, String name, int id) {
        super(player, name, id);
        super.manaCost = 2;
    }
    @Override
    public void playEffect() {
        //escolhe um aliado e um oponente para um combate imediato
    }

    @Override
    public void update(Card kill, Card dead, int idKill, int idDead) {

    }
}
