package BacoProject;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player {
    private String name;
    private int mana;
    private int nexusLife;
    //private ArrayList<Card> deck = new ArrayList<Card>();
    Deck deck;
    private ArrayList<Card> hands = new ArrayList<Card>();
    private ArrayList<Card> evockedUnits = new ArrayList<Card>();
    private boolean attack = true;

    public Player() {
        this.mana = 0;
        this.nexusLife = 20;
        deck = new Deck(this);

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

    public void getCard(){
        if(deck.size()>0){
            hands.add(deck.get(0));
            try{
                checkSizeDeck();
                deck.remove(0);
            } catch (SizeException e) {
                System.out.println("Nao foi possivel adicionar a carta. Sua mao ja esta cheia.");
                hands.remove(deck.get(0));
            }
        }
    }

    public void evoke() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Selecione a carta que deseja invocar");
        //colocar um print com as listas de cartas em mãos
        deckToString(hands);

        int choose_card = sc.nextInt(); //recebe a posição da carta

        if (choose_card > hands.size()) {
            System.out.println("Posicao invalida");
        }

        System.out.println("Digite 0 caso queira evocar uma carta nova e 1 caso deseje substituir uma carta ja evocada.");
        int evockeOrChange = sc.nextInt();

        if (evockeOrChange == 0) {
            if (this.mana < hands.get(choose_card).getMana()) {
                System.out.println("Pontos de mana insuficiente");
            } else {
                try {
                    checkSizeEvockeUnits();
                    this.mana = this.mana - hands.get(choose_card).getMana();
                    this.evockedUnits.add(hands.get(choose_card));
                    hands.remove(choose_card);
                } catch (SizeException e) {
                    evoke();
                }
            }
        } else if (evockeOrChange == 1) {
            if (this.evockedUnits.size() == 0) {
                System.out.println("Voce nao tem cartas evocadas.");
            } else {
                deckToString(evockedUnits);
                int choose_evocked = sc.nextInt(); //recebe a posição da carta

                if (choose_evocked > evockedUnits.size()) {
                    System.out.println("Posicao invalida");
                }

                if (hands.get(choose_card).getMana() - this.evockedUnits.get(choose_evocked).getMana() > this.mana) {
                    System.out.println("Pontos de mana insuficiente");
                } else {
                    try {
                        checkSizeEvockeUnits();
                        this.mana = this.mana - hands.get(choose_card).getMana() + evockedUnits.get(choose_evocked).getMana();
                        this.evockedUnits.add(hands.get(choose_card));
                        this.hands.add(evockedUnits.get(choose_evocked));
                        this.evockedUnits.remove(choose_evocked);
                        this.hands.remove(choose_card);
                    } catch (SizeException e) {
                        evoke();
                    }
                }
            }
        }
    }

    private void deckToString(ArrayList<Card> cards){
        int n = 1;
        for (Card card : cards) {
            System.out.println(n + ": " + card.toString());
            n++;
        }
    }

    private void checkSizeEvockeUnits() throws SizeException {
        if(evockedUnits.size() > 6){
            throw new SizeException("Nao eh possivel evocar. Voce ja envocou 6 cartas.");
        }
    }

    private void checkSizeDeck() throws SizeException {
        if (hands.size() > 10) {
            throw new SizeException("Numero de cartas invalido.");
        }
    }

    public void switchAttacker(){
        this.attack = !this.attack;
    }

    public void setAttack(boolean b){
        attack = b;
    }

    public boolean getAttack() {
        return attack;
    }

    public void incrementMana(int turn) {
        if(this.mana + turn > 10){
            this.mana = 10;
        } else if(this.mana + turn < 0) {
            this.mana = 0;
        }
        else {
            this.mana += turn;
        }
    }

    public int getMana() {
        return this.mana;
    }

    public ArrayList<Card> getEvockedUnits(){
        return evockedUnits;
    }

    public String toString(){
        return this.name;
    }
}
