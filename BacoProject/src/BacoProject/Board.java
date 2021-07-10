package BacoProject;

import java.util.ArrayList;

public class Board {
    Player player1;
    Player player2;
    ArrayList<Card> battlefieldAtack= new ArrayList<Card>();
    ArrayList<Card> battlefieldDefense = new ArrayList<Card>();

    void toBattle(Card card, boolean atack){
        if(atack){
            battlefieldAtack.add(card);
        }else{
            battlefieldDefense.add(card);
        }
    }

    void Battle(){
        ArrayList<Card> attackfield;
        ArrayList<Card> defensefield;
        for(Card card : battlefieldAtack){

        }
    }
    //efetuar a batalha campo a campo
    //retornar nexus para player


}
