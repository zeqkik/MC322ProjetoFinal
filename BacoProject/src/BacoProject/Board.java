package BacoProject;

import java.util.ArrayList;

public class Board {
    ArrayList<Lifeable> evocateAttack = new ArrayList<Lifeable>();
    ArrayList<Lifeable> evocateDefense = new ArrayList<Lifeable>();
    ArrayList<Lifeable> battlefieldAttack = new ArrayList<Lifeable>();
    ArrayList<Lifeable> battlefieldDefense = new ArrayList<Lifeable>();

    void getEvocate(ArrayList<Card> attack,ArrayList<Card> defense){
        for(Card i : attack){
            this.evocateAttack.add((Lifeable) i);
        }
        for(Card i : defense){
            this.evocateDefense.add((Lifeable) i);
        }
    }


    void toBattle(Player player, Card card, int index) throws PositionException {
        if(player.getAttack()){
            if(!ocuppedPosition(index, battlefieldAttack)) {
                battlefieldAttack.add((Lifeable) card);
            } else{
                System.out.println("Posicao invalida. Tente novamente.");
                throw new PositionException();
            }
        } else {
            if(!ocuppedPosition(index, battlefieldDefense)) {
                battlefieldDefense.add((Lifeable) card);
            } else{
                System.out.println("Posicao invalida. Tente novamente.");
                throw new PositionException();
            }
        }
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
            if (cardInPosition(battlefieldDefense, attacker.getBattlePosition()) == null) {
                defensePlayer.nexusDamage(attacker.getPower());
            } else {
                Lifeable defender = cardInPosition(battlefieldDefense, attacker.getBattlePosition());
                attacker.attack(defender);
                defender.attack(attacker);
                if (defender.isDead()) {
                    notifyBattle(attacker, defender, attacker.getId(), defender.getId());
                    battlefieldDefense.remove(defender);
                }
                if (attacker.isDead()) {
                    notifyBattle(defender, attacker, defender.getId(), attacker.getId());
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
            if (card.getBattlePosition() == i) {
                out = card;
            }
        }
        return out;
    }

    public void showBoard(){
        System.out.println("Cartas evocadas do jogador 1:");
        for (Lifeable card : evocateAttack) {
            int n = 1;
            System.out.println(n + ": " + card.toString());
        }
        System.out.println("Cartas evocadas do jogador 2:");
        for (Lifeable card : evocateDefense) {
            int n = 1;
            System.out.println(n + ": " + card.toString());
        }
    }

    private void notifyBattle(Lifeable kill, Lifeable dead, int idKill, int idDead){
        for(Lifeable i : battlefieldAttack){
            i.update(kill, dead, idKill, idDead);
        }
        for(Lifeable i : battlefieldDefense){
            i.update(kill, dead, idKill, idDead);
        }
    }
    public boolean ocuppedPosition(int pos, ArrayList<Lifeable> battlefield){
        for(Lifeable card : battlefield){
            if(card.getBattlePosition()==pos){
                return true;
            }
        }
    return false;
    }
}
