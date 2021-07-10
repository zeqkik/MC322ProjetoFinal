package BacoProject.Demacia;

import BacoProject.Player;
import BacoProject.Spell;
import BacoProject.iEffect;

public class Julgamento extends Spell implements iEffect {
    public Julgamento(Player player) {
        super(player);
        super.name = "Julgamento";
        super.manaCost = 8;
    }

    @Override
    public void playEffect() {
        //um aliado atacante golpeia todos oponentes defensores
    }
}
