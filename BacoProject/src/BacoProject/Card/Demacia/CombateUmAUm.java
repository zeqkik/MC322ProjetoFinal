package BacoProject.Card.Demacia;

import BacoProject.Card.Card;
import BacoProject.Card.iSpell;
import BacoProject.Player.Player;

public class CombateUmAUm extends Card implements iSpell {
	public CombateUmAUm(Player player, String name, int id) {
		super(player, name, id);
		super.manaCost = 2;
	}

	@Override
	public void playEffect() {
		// escolhe um aliado e um oponente para um combate imediato

	}

	@Override
	public String toString() {
		return super.toString();
	}

}
