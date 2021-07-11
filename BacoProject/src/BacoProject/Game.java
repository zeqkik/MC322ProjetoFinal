package BacoProject;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    ArrayList<Card> cards = new ArrayList<Card>();
    private Player player1;
    private Player player2;
    ArrayList<Player> players = new ArrayList<Player>();
    private int numRound = 0;
    private int numTurn = 0;
    Board board;


    public Game() {

    }

    private boolean exitSelected;

    public void start() {
        exitSelected = false;
        System.out.println("Game started!");
        Player player1 = new Player();
        player1.setAttack(true);
        Player player2 = new Player();
        player2.setAttack(false);
        players.add(player1);
        players.add(player2);
        giveInitialCards();
        numRound = 0;
        numTurn = 0;

        firstRound();

        while (!exitSelected) {
            drawBoard();
            readInput();
            drawTurn();
            evocateTurn();
            battleTurn();
            updateBoard();
            numTurn++;
            if (numTurn > 10) {
                nextRound();
            }
        }
        System.out.println("Game terminated. Bye!");
    }

    private void incrementMana() {
        for(Player i : players){
            i.incrementMana(numRound);
        }
    }

    private void drawBoard() {

    }

    private void readInput() {

    }

    private void updateBoard() {

    }

    private void giveInitialCards() {
        for (Player i : players) {
            i.giveInitialCards();
        }
    }

    private void nextRound() {
        numTurn = 0;
        for(Player i : players) {

            i.switchAttacker();

            if(i.getMana() > 3){
                i.incrementMana(3-i.getMana());
            }
        }
    }

    private void getCard(){
        for(Player i : players){
            i.getCard(1);
        }
    }

    private void initBattle() {
        Player atackPlayer = null;
        Player defensePlayer = null;
        if (player1.getAttack()) {
            atackPlayer = player1;
            defensePlayer = player2;
        } else {
            atackPlayer = player2;
            defensePlayer = player2;
        }
        System.out.println(atackPlayer.toString() + ", deseja entrar em batalha? Digite 1 para sim, 2 para não");
        Scanner sc = new Scanner(System.in);
        int battle = sc.nextInt();
        int newC = 1;
        if (battle == 1) {
            do {
                System.out.println("Selecione a carta que deseja enviar para a batalha(Digite o id)");

                int n = 1;
                for (Card card : atackPlayer.getEvockedUnits()) {
                    System.out.println(n + ": " + card.toString());
                    n++;
                }
                int select = sc.nextInt();
                Card card = atackPlayer.getEvockedUnits().get(select - 1);
                atackPlayer.getEvockedUnits().remove(card);
                board.toBattle(card);
                System.out.println("Deseja jogar uma nova carta?(Digite 0 caso queira encerrar)");
                newC = sc.nextInt();
            } while (newC != 0 || atackPlayer.getEvockedUnits().size() > 0);
            do {
                System.out.println(defensePlayer.toString() + ", selecione a carta que você deseja usar para defender");
                int n = 1;
                for (Card card : defensePlayer.getEvockedUnits()) {
                    System.out.println(n + ": " + card.toString());
                    n++;
                }
                int select = sc.nextInt();
                Card card = atackPlayer.getEvockedUnits().get(select - 1);
                defensePlayer.getEvockedUnits().remove(card);
                System.out.println(defensePlayer.toString() + ", selecione que carta você deseja defender com essa carta");
                board.showAttackField();
                select = sc.nextInt();
                board.toBattle(card, select - 1);
                newC = sc.nextInt();
                System.out.println("Deseja jogar uma nova carta?(Digite 0 caso queira encerrar)");
            } while (newC != 0 || defensePlayer.getEvockedUnits().size() > 0);
        }
    }

    private void firstRound(){
        numRound++;
        Board board = new Board();//conferir
        for(Player player : players){
            player.giveInitialCards();
            player.changeCards();
        }
    }

    private void drawTurn(){
        for(Player player : players){
            player.getCard(1);
            player.newMana(numRound);
        }
    }

    private void evocateTurn() {
        for (Player player : players) {
            player.evoke();
        }
    }
    private void battleTurn(){
        this.initBattle();
        }


        /* sorta o embrev
        kkkkk
        eu e o neymar
        lado a lado ainda
        Rodada:
            XJogo instancia um board;
            XJogo inicializa os decks dos jogadores;
            XJogo inicia a primeira rodada:
                Primeiro Turno:
                    XJogadores compram 4 cartas aleatórias de seu deck
                    XJogadores podem escolher substituir de 0 a 4 cartas:
                        XEscolhe n, o número de cartas
                        XEscolhe o id das cartas
                        XElas voltam para o deck
                        XJogador recebe n cartas novas de seu deck
                Turno de compra:
                    XJogadores recebem uma carta de seu deck
                    XJogadores ganham pontos de mana
                Turno de evocação
                    XJogadores podem pagar custo de mana de uma carta para evocar ela no campo
                Turno de Batalha
                    XAtacante escolhe entrar em batalha(Sim ou Não)
                        Se(Não)
                            Encerra Fase de batalha
                        Se(Sim)
                            Inicia Fase de batalha
                    Turno de Batalha
                    XJogadores defensor e atacanta alternam
                Fim da Rodada.

         */

    }




}


