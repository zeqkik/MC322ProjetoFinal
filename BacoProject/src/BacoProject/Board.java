package BacoProject;

import java.util.ArrayList;

public class Board {
    ArrayList<Card> battlefieldAttack= new ArrayList<Card>();
    ArrayList<Card> battlefieldDefense = new ArrayList<Card>();

    void toBattle(Card card){
        battlefieldAttack.add(card);
    }
    void toBattle(Card card, int index){
        battlefieldDefense.add(index,card);
    }
    void showAttackField(){
        for(Card card : battlefieldAttack){
            int n = 1;
            System.out.println(n+": "+ card.toString());
        }
    }

    void Battle(Player atackPlayer, Player defensePlayer){
        for(Card card : battlefieldAttack){
            int id = 0;
            Lifeable aux = (Lifeable)card;
            int attackerPower = aux.attack();
            if(battlefieldDefense.get(id) == null){ //validar
                defensePlayer.nexusDamage(attackerPower);
            }
            else{
                Card defender = battlefieldDefense.get(id);
                Lifeable aux1 = (Lifeable)defender;
                int defenderPower = aux1.attack();
                aux1.takeDamage(attackerPower);
                aux.takeDamage(defenderPower);
                if(aux1.isDead()){
                    battlefieldDefense.remove(aux1);
                }
                if(aux.isDead()){
                    battlefieldAttack.remove(aux);
                }
            }
        }
    }



}
