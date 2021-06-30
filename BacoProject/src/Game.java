import java.util.ArrayList;

public class Game {
    ArrayList<Card> cards = new ArrayList<Card>();
    private int numRound;


    public Game(){

    }

    public void run(){

    }

    void giveMana(Player player){
        player.addMana(numRound);
    }
}
