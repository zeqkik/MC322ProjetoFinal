package BacoProject;

import java.util.List;
import java.util.Random;

public class Player {
    int mana, nexus;
    List<Card> deck = new List<Card>();
    Card[] hands = new Card[10];
    //ArrayList<BacoProject.Card> hands = new ArrayList<BacoProject.Card>();
    TipeAttack tipe_attack;

    public Player(){
        Random ran = new Random(40);
        for(int i = 0; i<4; i++){

        }

    }

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
