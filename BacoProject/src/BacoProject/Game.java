package BacoProject;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    //ArrayList<Card> cards = new ArrayList<Card>();
    private ArrayList<Player> players = new ArrayList<Player>();
    private int numRound;
    private Board board;
    private boolean hasBattle;
    private boolean exitSelected;

    public void start(Player player1, Player player2) {
        exitSelected = false;
        System.out.println("Game started!");
        Player player1 = createPlayer("Camino");
        Player player2 = createPlayer("Serpa");
        player1.setAttack(true);
        player2.setAttack(false);
        board = createBoard();
        numRound = 0;

        firstRound();

        while (!exitSelected) {
            //drawBoard();
            //readInput();
            if(player1.getAttack()) {
                System.out.println("Rodada do " + player1.toString() + " atacando.");
            }else{
                System.out.println("Rodada do " + player2.toString() + " atacando.");
            }
            hasBattle = false;
            drawTurn();
            evocateTurn();
            battleTurn();
            if(hasBattle){
                nextRound();
                exitSelected = isNexusDead();
            }
        }
        System.out.println("Game terminated. Bye!");
    }

    private void incrementMana() {
        for(Player i : players){
            i.incrementMana(numRound);
        }
    }

//    private void drawBoard() {
//
//    }
//
//    private void readInput() {
//
//    }
//
//    private void updateBoard() {
//
//    }



    private void nextRound() {
        for(Player i : players) {

            i.switchAttacker();
            i.getCard(1);
            if(i.getMana() > 0){
                i.incrementSpellMana(i.getMana());
                i.incrementMana(i.getMana() * (-1));
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

        if (players.get(0).getAttack()) {
            atackPlayer = players.get(0);
            defensePlayer = players.get(1);
        } else {
            atackPlayer = players.get(0);
            defensePlayer = players.get(1);
        }
        //atackPlayer.getEvockedUnits()
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
        for(Player player : players){
            player.giveInitialCards();
            player.changeCards();
        }
    }

    private void drawTurn(){
        for(Player player : players){
            player.getCard(1);
            player.incrementMana(numRound);
        }
    }

    private void evocateTurn() {
        Scanner sc = new Scanner(System.in);
        int newEvocate = 0;
        if(players.get(0).getAttack()) {
            System.out.println("Turno de evocação do " + players.get(0).toString());
                players.get(0).evoke();
            System.out.println("Turno de evocação do " + players.get(1).toString());
                players.get(1).evoke();
        } else {
                System.out.println("Turno de evocação do " + players.get(1).toString());
                players.get(1).evoke();
                System.out.println("Turno de evocação do " + players.get(0).toString());
                players.get(0).evoke();
            }
        }

    private void battleTurn() {
        this.initBattle();
        if (players.get(0).getAttack()) {
            board.Battle(players.get(0), players.get(1));
        } else {
            board.Battle(players.get(1), players.get(0));
        }
        for(Player player : players){
            player.setMana();
        }
    }

    private boolean isNexusDead(){
        for(Player player : players) {
            if(player.isDead()) {
                System.out.println(player.toString() + ", voce perdeu! Seu Nexus esta morto.");
                return true;
            }
        }
        return false;
    }
    public Player createPlayer(String name){
        Player player = new Player(name);
        players.add(player);
        return player;
    }
    public Board createBoard(){
        Board board = new Board();
        return board;
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
                    Deseja uma
         */






}


