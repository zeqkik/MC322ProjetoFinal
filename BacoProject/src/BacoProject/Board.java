package BacoProject;

import java.util.ArrayList;
//padrao Observer (Vanguarda - Board)
//Board extender observable
public class Board {
    ArrayList<Card> evocatePlayer1 = new ArrayList<Card>();
    ArrayList<Card> evocatePlayer2 = new ArrayList<Card>();
    ArrayList<Card> battlefield1 = new ArrayList<Card>();
    ArrayList<Card> battlefield2 = new ArrayList<Card>();

    public void evocateCard(Card card, int id) {
        if (id == 1) {
            evocatePlayer1.add(card);
        } else {
            evocatePlayer2.add(card);
        }

    }
}
