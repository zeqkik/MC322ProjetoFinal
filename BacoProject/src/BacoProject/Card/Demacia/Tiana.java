package BacoProject.Card.Demacia;

import BacoProject.*;
import BacoProject.Card.Battleable;
import BacoProject.Card.Follower;
import BacoProject.Card.iEffect;
import BacoProject.Player.Player;

public class Tiana extends Follower implements iEffect {
	public Tiana(Player player, String name, int id) {
		super(player, name, id);
		super.manaCost = 8;
		super.power = 7;
		super.life = 7;
		super.battlePosition = -1;
	}

	@Override
	public void playEffect() {
		// ao ser comprada uma unidade evocada ataca o nexus

	}

	@Override
	public void update(Battleable kill, Battleable dead, int idKill, int idDead) {

	}
}
