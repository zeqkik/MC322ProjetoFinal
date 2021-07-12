package BacoProject.Demacia;

import BacoProject.Card;
import BacoProject.Player;
import BacoProject.iSpell;

public class ValorRedobrado extends Card implements iSpell {

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
    public String toString() {
    	return super.toString();
    }
}
