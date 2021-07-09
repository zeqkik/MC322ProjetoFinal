package BacoProject;

import java.util.ArrayList;

public class Game {
    ArrayList<Card> cards = new ArrayList<Card>();
    ArrayList<Player> players = new ArrayList<Player>();
    private int numRound;


    public Game() {

    }

    private boolean exitSelected;

    public void start() {
        exitSelected = false;
        System.out.println("BacoProject.Game started!");
        player1 = new Player()
        giveInitialCards();

        while (!exitSelected) {
            drawBoard();
            readInput();
            updateBoard();
        }
        System.out.println("BacoProject.Game terminated. Bye!");
    }

    private void drawBoard() {

    }

    private void readInput() {

    }

    private void updateBoard() {

    }

    private void switchCards(){
        for (int i = 0; i<40; i++){
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
}
