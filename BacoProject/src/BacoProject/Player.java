package BacoProject;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player {
    int mana;
    int nexusLife;
    ArrayList<iCard> deck = new ArrayList<iCard>();
    ArrayList<iCard> hands = new ArrayList<iCard>();
    ArrayList<iCard> evockedUnits = new ArrayList<iCard>();
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

    public iCard evoke() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Selecione a carta que deseja invocar");
        //colocar um print com as listas de cartas em mãos

        int choose_card = sc.nextInt(); //recebe a posição da carta

        if (choose_card > hands.size()) {
            System.out.println("Posicao invalida");
        }
        if (this.mana < hands.get(hands.indexOf(choose_card)).getMana()){
            System.out.println("Pontos de mana insuficiente");
        }
        else
            this.mana = this.mana - hands.get(hands.indexOf(choose_card)).getMana();

        return hands.get(hands.indexOf(choose_card));
    }

    public boolean attackDefense(){
        Scanner atack = new Scanner(System.in);
        System.out.println("Digite 1 para atacar, 2 para defender e qualquer outra valor para encerrar o turno");
        int ata_def = atack.nextInt();

        if (ata_def == 1){
           return tipe_attack = true;
        }
        else if (ata_def == 2) {
            return tipe_attack = false;
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
}
