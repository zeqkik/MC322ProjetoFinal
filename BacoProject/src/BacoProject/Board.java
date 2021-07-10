package BacoProject;

import java.util.ArrayList;

public class Board {
    Player player1;
    Player player2;
    ArrayList<Card> battlefieldAtack= new ArrayList<Card>();
    ArrayList<Card> battlefieldDefense = new ArrayList<Card>();

    void toBattle(Card card){
        battlefieldAtack.add(card);
    }
    void toBattle(Card card, int index){
        battlefieldDefense.add(index,card);
    }
    void showAtackField(){
        for(Card card : battlefieldAtack){
            int n = 1;
            System.out.println(n+": "+ card.toString());
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
