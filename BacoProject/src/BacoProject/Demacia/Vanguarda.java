package BacoProject.Demacia;

import BacoProject.*;

import java.util.ArrayList;

public class Vanguarda extends Follower implements iEffect {
	public Vanguarda(Player player, String name, int id) {
		super(player, name, id);
		super.manaCost = 4;
		super.power = 3;
		super.life = 3;
		super.battlePosition = -1;
	}

	@Override
	public void playEffect() {
		// De +1/+1 a todos os seguidores aliados.
		ArrayList<Card> evocked = super.owner.getEvockedUnits();
		for (Card card : evocked) {
			if (card instanceof Battleable) {
				((Battleable) card).lifeUp(1);
				((Battleable) card).powerUp(1);
			}
		}
	}

	@Override
	public void update(Battleable kill, Battleable dead, int idKill, int idDead) {

	}
}