package BacoProject;

import BacoProject.Demacia.*;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> deck = new ArrayList<Card>();
    private Player player;

    public Deck(Player player) {
        getRandomDeck();
        this.player = player;
    }

    public Deck(){

    }

    public Card get(int i){
        return this.deck.get(i);
    }

    public void add(Card card){
        this.deck.add(card);
    }

    public void remove(Card card){
        this.deck.remove(card);
    }

    public void remove (int i){
        this.deck.remove(i);
    }

    public int indexOf (Card card){
        return deck.indexOf(card);
    }

    public int size(){
        return this.deck.size();
    }

    private void getRandomDeck() {
        for (int i = 0; i < 40; i++) {
            deck.add(getRandomCard());
        }
    }

    public Card getRandomCard(){
        Random ran = new Random();
        Card aux = null;
        int j = ran.nextInt(11);
        switch (j) {
            case 0:
                aux = new Garen(this.player, "Garen", player.getNumCards());
                break;
            case 1:
                aux = new Tiana(this.player, "Tiana", player.getNumCards());
                break;
            case 2:
                aux = new Vanguarda(this.player, "Vanguarda", player.getNumCards());
                break;
            case 3:
                aux = new Duelista(this.player, "Duelista", player.getNumCards());
                break;
            case 4:
                aux = new Defensor(this.player, "Defensor", player.getNumCards());
                break;
            case 5:
                aux = new Poro(this.player, "Poro", player.getNumCards());
                break;
            case 6:
                aux = new PoroDefensor(this.player, "Poro Defensor", player.getNumCards());
                break;
            case 7:
                aux = new Julgamento(this.player, "Julgamento", player.getNumCards());
                break;
            case 8:
                aux = new ValorRedobrado(this.player, "Valor Redobrado", player.getNumCards());
                break;
            case 9:
                aux = new GolpeCerteiro(this.player, "Golpe Certeiro", player.getNumCards());
                break;
            case 10:
                aux = new CombateUmAUm(this.player, "Vanguarda", player.getNumCards());
                break;
        }
        player.incrementNumCards();
        return aux;
    }
}

