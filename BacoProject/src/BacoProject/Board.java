package BacoProject;

import java.util.ArrayList;

public class Board {
    Player player1;
    Player player2;
    ArrayList<Card> evocatePlayer1 = player1.getEvockedUnits();
    ArrayList<Card> evocatePlayer2 = player2.getEvockedUnits();
    ArrayList<Card> battlefield1 = new ArrayList<Card>();
    ArrayList<Card> battlefield2 = new ArrayList<Card>();

    void toBattle(Card card, boolean atack){
        if(atack){
            battlefieldAtack.add(card);
        }else{
            battlefieldDefense.add(card);
        }
    }
    //efetuar a batalha campo a campo
    //retornar nexus para player


}
