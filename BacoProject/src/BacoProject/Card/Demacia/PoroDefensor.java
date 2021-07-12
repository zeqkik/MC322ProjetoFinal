package BacoProject.Card.Demacia;

import BacoProject.*;
import BacoProject.Card.Battleable;
import BacoProject.Card.Follower;
import BacoProject.Card.iEffect;
import BacoProject.Player.Player;

public class PoroDefensor extends Follower implements iEffect {
	public PoroDefensor(Player player, String name, int id) {
		super(player, name, id);
		super.manaCost = 1;
		super.power = 1;
		super.life = 2;
		super.battlePosition = -1;
	}

	@Override
	public void playEffect() {
		super.owner.getCard(1);
	}

	@Override
	public void update(Battleable kill, Battleable dead, int idKill, int idDead) {
		if (idDead == super.id) {
			this.playEffect();
		}
	}
}
