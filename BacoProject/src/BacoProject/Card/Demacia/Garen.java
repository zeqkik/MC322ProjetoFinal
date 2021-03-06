package BacoProject.Card.Demacia;

import BacoProject.*;
import BacoProject.Card.Battleable;
import BacoProject.Card.Champion;
import BacoProject.Card.Trace;
import BacoProject.Card.iEffect;
import BacoProject.Player.Player;

public class Garen extends Champion implements iEffect {
	private int attackCounter = 0;
	private int numKills;

	public Garen(Player player, String name, int id) {
		super(player, name, id);
		super.manaCost = 5;
		super.power = 5;
		super.life = 5;
		super.battlePosition = -1;
		this.numKills = 0;

	}

	@Override
	public void playEffect() {
		// Se cura totalmente no finalde cada rodada.
		super.life = 5;
	}

	@Override
	public void update(Battleable kill, Battleable dead, int idKill, int idDead) {

		if (idKill == this.id && owner.getAttack()) {
			this.numKills++;
			if (numKills == 2) {
				// Level Up: Depois de ter atacado duas vezes.
				this.levelUp();
			}
		}
	}

	public void levelUp() {
		// Ganha o traco ?Elusivo?; +1 ao poder; +1 pontos de vida.
		super.trace = Trace.ELUSIVE;
		super.power++;
		super.life++;
	}

	public int attack() {
		this.attackCounter++;
		if (attackCounter == 2) {
			this.levelUp();
		}
		return super.power;
	}

}