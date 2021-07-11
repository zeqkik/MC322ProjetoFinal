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
        Random ran = new Random();

        for (int i = 0; i < 40; i++) {
            player.incrementNumCards();
            int j = ran.nextInt(11);
            switch (j) {
                case 0:
                    deck.add(new Garen(this.player, "Garen", i));
                    break;
                case 1:
                    deck.add(new Tiana(this.player, "Tiana", i));
                    break;
                case 2:
                    deck.add(new Vanguarda(this.player, "Vanguarda", i));
                    break;
                case 3:
                    deck.add(new Duelista(this.player, "Duelista", i));
                    break;
                case 4:
                    deck.add(new Defensor(this.player, "Defensor", i));
                    break;
                case 5:
                    deck.add(new Poro(this.player, "Poro", i));
                    break;
                case 6:
                    deck.add(new PoroDefensor(this.player, "Poro Defensor", i));
                    break;
                case 7:
                    deck.add(new Julgamento(this.player, "Julgamento", i));
                    break;
                case 8:
                    deck.add(new ValorRedobrado(this.player, "Valor Redobrado", i));
                    break;
                case 9:
                    deck.add(new GolpeCerteiro(this.player, "Golpe Certeiro", i));
                    break;
                case 10:
                    deck.add(new CombateUmAUm(this.player, "Vanguarda", i));
                    break;
            }

        }
    }

    public Card getRandomCard(){
        Random ran = new Random();
        int j = ran.nextInt(11);
        switch (j) {
            case 0:
                deck.add(new Garen(this.player, "Garen", i));
                break;
            case 1:
                deck.add(new Tiana(this.player, "Tiana", i));
                break;
            case 2:
                deck.add(new Vanguarda(this.player, "Vanguarda", i));
                break;
            case 3:
                deck.add(new Duelista(this.player, "Duelista", i));
                break;
            case 4:
                deck.add(new Defensor(this.player, "Defensor", i));
                break;
            case 5:
                deck.add(new Poro(this.player, "Poro", i));
                break;
            case 6:
                deck.add(new PoroDefensor(this.player, "Poro Defensor", i));
                break;
            case 7:
                deck.add(new Julgamento(this.player, "Julgamento", i));
                break;
            case 8:
                deck.add(new ValorRedobrado(this.player, "Valor Redobrado", i));
                break;
            case 9:
                deck.add(new GolpeCerteiro(this.player, "Golpe Certeiro", i));
                break;
            case 10:
                deck.add(new CombateUmAUm(this.player, "Vanguarda", i));
                break;
        }
    }
}

