package BacoProject;

import java.util.ArrayList;

public class Board {
    ArrayList<Lifeable> battlefieldAttack = new ArrayList<Lifeable>();
    ArrayList<Lifeable> battlefieldDefense = new ArrayList<Lifeable>();

    public Board() {

    }

    void toBattle(Card card) {
        battlefieldAttack.add((Lifeable) card);
    }

    void toBattle(Card card, int index) {
        battlefieldDefense.add(index, (Lifeable) card);
    }

    void showAttackField() {
        for (Lifeable card : battlefieldAttack) {
            int n = 1;
            System.out.println(n + ": " + card.toString());
        }
    }

    void Battle(Player attackPlayer, Player defensePlayer) {
        for (Lifeable attacker : battlefieldAttack) {
            int id = 0;
            if (cardInPosition(battlefieldDefense, attacker.getId()) == null) {
                defensePlayer.nexusDamage(attacker.getPower());
            } else {
                Lifeable defender = cardInPosition(battlefieldDefense, attacker.getId());
                attacker.attack(defender);
                defender.attack(attacker);
                if (defender.isDead()) {
                    battlefieldDefense.remove(defender);
                }
                if (attacker.isDead()) {
                    battlefieldAttack.remove(attacker);
                }
            }
        }
        attackPlayer.returnToEvockedUnits(battlefieldAttack);
        defensePlayer.returnToEvockedUnits(battlefieldDefense);
    }

    private Lifeable cardInPosition(ArrayList<Lifeable> array, int i) {
        Lifeable out = null;
        for (Lifeable card : array) {
            if (card.getId() == i) {
                out = card;
            }
        }
        return out;
    }


}
