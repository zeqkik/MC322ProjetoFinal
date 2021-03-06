package BacoProject.Game;

import java.util.ArrayList;
import java.util.Scanner;
import BacoProject.Card.Card;
import BacoProject.Player.Player;

public class Game {
	private ArrayList<Player> players = new ArrayList<Player>();
	private int numRound;
	private Board board;
	private boolean hasBattle;
	private boolean exitSelected;

	public void start() {
		exitSelected = false;
		System.out.println("Game started!");
		Player player1 = createPlayer("Player 1");
		Player player2 = createPlayer("Player 2");
		player1.setAttack(true);
		player2.setAttack(false);
		board = createBoard();
		numRound = 1;

		firstRound();

		while (!exitSelected) {
			if (player1.getAttack()) {
				System.out.println("Rodada do " + player1.toString() + " atacando.");
			} else {
				System.out.println("Rodada do " + player2.toString() + " atacando.");
			}
			hasBattle = false;
			drawTurn();
			evocateTurn();
			battleTurn();
			if (hasBattle) {
				nextRound();
				exitSelected = isNexusDead();
			}
		}
		System.out.println("Game terminated. Bye!");
	}

	private void nextRound() {
		for (Player i : players) {

			i.switchAttacker();
			i.getCard(1);
			if (i.getMana() > 0) {
				i.setMana();
			}
		}
		numRound++;
	}

	public void initBattle() {
		Player attackPlayer;
		Player defensePlayer;

		if (players.get(0).getAttack()) {
			attackPlayer = players.get(0);
			defensePlayer = players.get(1);
		} else {
			attackPlayer = players.get(0);
			defensePlayer = players.get(1);
		}
		board.getEvocate(attackPlayer.getEvockedUnits(), defensePlayer.getEvockedUnits());

		System.out.println(attackPlayer.toString() + ", deseja entrar em batalha? Digite 1 para sim, 2 para nao");
		Scanner sc = new Scanner(System.in);
		int battle = sc.nextInt();
		if (battle == 1) {
			System.out.println(
					attackPlayer.toString() + ", selecione a carta que deseja enviar para a batalha(Digite o id)");
			battle(attackPlayer);
			System.out.println(defensePlayer.toString() + ", selecione a carta que voce deseja usar para defender");
			battle(defensePlayer);
			this.hasBattle = true;
		}
	}

	private void battle(Player player) {
		Scanner sc = new Scanner(System.in);
		int newC = 1;
		do {
			int n = 1;
			for (Card card : player.getEvockedUnits()) {
				System.out.println(n + ": " + card.toString());
				n++;
			}
			int select = sc.nextInt();
			select--;
			if (select < 0 || select > player.getEvockedUnits().size()) {
				if(player.getEvockedUnits().size() == 0) {
					System.out.println("Posicao invalida.");
					return;
				}
				System.out.println("Posicao invalida, tente novamente.");
				battle(player);
				return;
			}
			Card card = player.getEvockedUnits().get(select);
			player.getEvockedUnits().remove(card);
			System.out.println("Qual posicao deseja colocar a carta? De 1 a 6.");
			if (!player.getAttack()) {
				System.out.println("Campo de ataque do oponente:");
				board.showAttackField();
			}
			int pos = sc.nextInt();
			try {
				board.toBattle(player, card, pos);
				System.out.println(
						"Deseja jogar uma nova carta?(Digite 0 caso queira encerrar e qualquer outro numero para continuar.)");
				newC = sc.nextInt();
			} catch (PositionException e) {
				player.getEvockedUnits().add(card);
				battle(player);
				return;
			}
		} while (newC != 0 || player.getEvockedUnits().size() != 0);
	}

	private void firstRound() {
		numRound++;
		for (Player player : players) {
			player.giveInitialCards();
			player.changeCards();
			player.incrementMana(1);
		}
	}

	private void drawTurn() {
		for (Player player : players) {
			player.getCard(1);
			player.incrementMana(numRound);
		}
		System.out.println("Situacao atual da mesa:");
		board.showBoard();
	}

	private void evocateTurn() {
		Scanner sc = new Scanner(System.in);
		if (players.get(0).getAttack()) {
			System.out.println("Turno de evocacao do " + players.get(0).toString());
			players.get(0).evoke();
			System.out.println("Turno de evocacao do " + players.get(1).toString());
			players.get(1).evoke();
		} else {
			System.out.println("Turno de evocacao do " + players.get(1).toString());
			players.get(1).evoke();
			System.out.println("Turno de evocacao do " + players.get(0).toString());
			players.get(0).evoke();
		}
		System.out.println("Situacao atual da mesa:");
		printEvocked();
	}

	private void printEvocked() {
		for (Player i : players) {
			System.out.print("Cartas evocadas de ");
			i.cardsToString(i.getEvockedUnits());
		}
	}

	private void battleTurn() {
		this.initBattle();
		if (players.get(0).getAttack()) {
			board.Battle(players.get(0), players.get(1));
		} else {
			board.Battle(players.get(1), players.get(0));
		}
		System.out.println("Situacao atual da mesa:");
	}

	private boolean isNexusDead() {
		for (Player player : players) {
			if (player.isDead()) {
				System.out.println(player.toString() + ", voce perdeu! Seu Nexus esta morto.");
				return true;
			}
		}
		return false;
	}

	public Player createPlayer(String name) {
		Player player = new Player(name);
		players.add(player);
		return player;
	}

	public Board createBoard() {
		Board board = new Board();
		return board;
	}

}
