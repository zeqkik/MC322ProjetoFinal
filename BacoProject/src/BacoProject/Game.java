package BacoProject;

import java.util.ArrayList;

public class Game {
    ArrayList<Card> cards = new ArrayList<Card>();
    ArrayList<Player> players = new ArrayList<Player>();
    private int numRound;
    private int numTurn;


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


        while (!exitSelected) {
            if(numTurn == 0){
                getCard();
            }
            incrementMana();
            drawBoard();
            readInput();
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
            i.incrementMana(numTurn);
        }
    }

    private void drawBoard() {

    }

    private void readInput() {

    }

    private void updateBoard() {

    }

    private void switchCards() {
        for (int i = 0; i < 40; i++) {
            Card card = new Card();
            cards.add(card);
        }
    }

    void giveMana(Player player) {
        if (player.getMana() + numRound < 10) {
            player.addMana(numRound);
        } else {
            player.addMana(10 - player.getMana());
        }
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
            i.getCard();
        }
    }
}

