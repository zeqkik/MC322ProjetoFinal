package BacoProject.Demacia;

import BacoProject.Player;
import BacoProject.Spell;
import BacoProject.iEffect;

public class ValorRedobrado extends Spell implements iEffect {
    public ValorRedobrado(){
        super.manaCost=6;
    }
    @Override
    public void playEffect() {
        //Cure inteiramente um aliado; dobre o ataque e defesa deste aliado;
    }
}
