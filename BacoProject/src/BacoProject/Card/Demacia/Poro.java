package BacoProject.Card.Demacia;

import BacoProject.Card.Battleable;
import BacoProject.Card.Follower;
import BacoProject.Player.Player;

public class Poro extends Follower {
	public Poro(Player player, String name, int id) {
		super(player, name, id);
		super.manaCost = 1;
		super.power = 2;
		super.life = 1;
		super.battlePosition = -1;
	}

	@Override
	public void update(Battleable kill, Battleable dead, int idKill, int idDead) {

	}
}
