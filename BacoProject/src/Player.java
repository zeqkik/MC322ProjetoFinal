import java.util.ArrayList;
import java.util.Random;

public class Player {
    int mana, nexus;
    Card[] deck = new Card[40];
    ArrayList<Card> hands = new ArrayList<Card>();
    TipeAttack tipe_attack;

    //pega do deck
    public void takeCard(){
        Randon r = new Random();

        if (numRound == 0){
            for (int i = 0; i < 4; ++i)
                hands.add(deck[r.nextInt()]);
        }
        else
            hands.add(deck[r.nextInt()]);
    }

    //invoca no campo
    public void evoke(){

    }

}
