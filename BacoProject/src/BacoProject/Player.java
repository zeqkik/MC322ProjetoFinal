package BacoProject;

import java.util.ArrayList;
import java.util.Random;

public class Player {
    int mana;
    int nexusLife;
    ArrayList<Card> deck = new ArrayList<Card>();
    ArrayList<Card> hands = new ArrayList<Card>();
    //ArrayList<Card> hands = new ArrayList<Card>();
    TipeAttack tipe_attack;

    public Player() {
        this.mana = 0;
        this.nexusLife = 20;
    }

    //pega do deck
    public void takeCard(int turn) {
        Random ran = new Random();
        for (int i = 0; i < turn; i++) {
            int j = ran.nextInt(deck.size());
            hands.add(deck.get(j));
            try {
                checkSizeDeck();
                deck.remove(j);
            } catch (SizeException e) {
                hands.remove(j);
            }
        }


    }

    //invoca no campo
    public void evoke() {

    }

    public void giveInitialCards() {
        Random ran = new Random();
        for (int i = 0; i < 4; i++) {
            hands.add(deck.get(ran.nextInt(deck.size())));
        }
    }

    private void checkSizeDeck() throws SizeException {
        if (hands.size() > 10) {
            throw new SizeException("Numero de cartas invaido");
        }
    }

}
