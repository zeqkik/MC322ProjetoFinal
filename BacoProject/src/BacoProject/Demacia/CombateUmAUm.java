package BacoProject.Demacia;

import BacoProject.Player;
import BacoProject.Spell;
import BacoProject.iEffect;

public class CombateUmAUm extends Spell implements iEffect {
    public CombateUmAUm(Player player) {
        super(player);
        super.name = "Combate um a um";
        super.manaCost = 2;
    }
    @Override
    public void playEffect() {
        //escolhe um aliado e um oponente para um combate imediato
    }
}
