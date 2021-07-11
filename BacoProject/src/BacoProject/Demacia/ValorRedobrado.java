package BacoProject.Demacia;

import BacoProject.Card;
import BacoProject.Player;
import BacoProject.Spell;
import BacoProject.iEffect;

public class ValorRedobrado extends Spell implements iEffect {

    public ValorRedobrado(Player player, String name, int id){
        super(player, name, id);
        super.name = "ValorRedobrado";
        super.manaCost = 6;
    }
    @Override
    public void playEffect() {
        //Cure inteiramente um aliado; dobre o ataque e defesa deste aliado;
    }

    @Override
    public void update(Card kill, Card dead, int idKill, int idDead) {

    }
}
