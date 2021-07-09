package BacoProject;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player {
    int mana;
    int nexusLife;
    ArrayList<Card> deck = new ArrayList<Card>();
    ArrayList<Card> hands = new ArrayList<Card>();
    boolean attack = true;

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

    public void giveInitialCards() {
        Random ran = new Random();
        for (int i = 0; i < 4; i++) {
            hands.add(deck.get(ran.nextInt(deck.size())));
        }
    }

    public Card evoke() {
        Scanner card_hand = new Scanner(System.in);
        System.out.println("Selecione a carta que deseja invocar");
        //colocar um print com as listas de cartas em mãos

        int choose_card = card_hand.nextInt(); //recebe a posição da carta

        if (choose_card > hands.size()) {
            System.out.println("Posicao invalida");
        }
        if (this.mana < Card.manaCost){
            System.out.println("Pontos de mana insuficiente");
        }
        else
            this.mana = this.mana - Card.manaCost;

        return hands.get(choose_card);
    }

    private void checkSizeDeck() throws SizeException {
        if (hands.size() > 10) {
            throw new SizeException("Numero de cartas invalido");
        }
    }

    public void switchAttacker(){
        this.attack = !this.attack;
    }

    public void setAttack(boolean b){
        attack = b;
    }

}
