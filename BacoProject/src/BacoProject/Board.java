package BacoProject;

import java.util.ArrayList;

public class Board {
	ArrayList<Battleable> evocateAttack = new ArrayList<Battleable>();
	ArrayList<Battleable> evocateDefense = new ArrayList<Battleable>();
	ArrayList<Battleable> battlefieldAttack = new ArrayList<Battleable>();
	ArrayList<Battleable> battlefieldDefense = new ArrayList<Battleable>();

	void getEvocate(ArrayList<Card> attack, ArrayList<Card> defense) {
		for (Card i : attack) {
			this.evocateAttack.add((Battleable) i);
		}
		for (Card i : defense) {
			this.evocateDefense.add((Battleable) i);
		}
	}

	void toBattle(Player player, Card card, int index) throws PositionException {
		if (player.getAttack()) {
			if (!ocuppedPosition(index, battlefieldAttack)) {
				Battleable aux = (Battleable) card;
				aux.setBattlePosition(index);
				battlefieldAttack.add(aux);
			} else {
				System.out.println("Posicao invalida. Tente novamente.");
				throw new PositionException();
			}
		} else {
			if (!ocuppedPosition(index, battlefieldDefense)) {
				Battleable aux1 = (Battleable) card;
				aux1.setBattlePosition(index);
				battlefieldDefense.add(aux1);
			} else {
				System.out.println("Posicao invalida. Tente novamente.");
				throw new PositionException();
			}
		}
	}

	void showAttackField() {
		int n = 1;
		for (Battleable card : battlefieldAttack) {
			System.out.println(n + ": " + card.toString());
			n++;
		}
	}

	void Battle(Player attackPlayer, Player defensePlayer) {
		for (Battleable attacker : battlefieldAttack) {
			if (cardInPosition(battlefieldDefense, attacker.getBattlePosition()) == null) {
				defensePlayer.nexusDamage(attacker.getPower());
			} else {
				Battleable defender = cardInPosition(battlefieldDefense, attacker.getBattlePosition());
				attacker.attack(defender);
				defender.attack(attacker);
				if (defender.isDead()) {
					notifyBattle(attacker, defender, attacker.getId(), defender.getId());
					battlefieldDefense.remove(defender);
				}
				if (attacker.isDead()) {
					notifyBattle(defender, attacker, defender.getId(), attacker.getId());
					battlefieldAttack.remove(attacker);
				}
			}
		}
		attackPlayer.returnToEvockedUnits(battlefieldAttack);
		defensePlayer.returnToEvockedUnits(battlefieldDefense);
	}

	private Battleable cardInPosition(ArrayList<Battleable> array, int i) {
		Battleable out = null;
		for (Battleable card : array) {
			if (card.getBattlePosition() == i) {
				out = card;
			}
		}
		return out;
	}

	public void showBoard() {
		System.out.println("Cartas evocadas do jogador 1:");
		for (Battleable card : evocateAttack) {
			int n = 1;
			System.out.println(n + ": " + card.toString());
		}
		System.out.println("Cartas evocadas do jogador 2:");
		for (Battleable card : evocateDefense) {
			int n = 1;
			System.out.println(n + ": " + card.toString());
		}
	}

	private void notifyBattle(Battleable kill, Battleable dead, int idKill, int idDead) {
		for (Battleable i : battlefieldAttack) {
			i.update(kill, dead, idKill, idDead);
		}
		for (Battleable i : battlefieldDefense) {
			i.update(kill, dead, idKill, idDead);
		}
	}

	public boolean ocuppedPosition(int pos, ArrayList<Battleable> battlefield) {
		for (Battleable card : battlefield) {
			if (card.getBattlePosition() == pos) {
				return true;
			}
		}
		return false;
	}
}
