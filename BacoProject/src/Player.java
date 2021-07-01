import java.util.ArrayList;
import java.util.Random;

public class Player {
    int mana, nexus;
    Card[] deck = new Card[40];
    Card[] hands = new Card[10];
    //ArrayList<Card> hands = new ArrayList<Card>();
    TipeAttack tipe_attack;

    //pega do deck
    public void takeCard() {
        Random r = new Random();

        if (numRound == 0) {
            for (int i = 0; i < 4; ++i)
                hands[i] = deck[r.nextInt()];
        }
        else
            for (int i = 0; i < 9; ++i) { //sei que ta errado mas to burro hj, amanhã vejo com calma
                for (int j = 0; j < 36; ++j)
                   if (hands[i] == null && deck[j] != null)
                       hands[i] = deck[j];

            break;
            }
    }

    //invoca no campo
    public void evoke(){

    }

}
