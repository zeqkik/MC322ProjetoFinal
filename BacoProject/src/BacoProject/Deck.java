package BacoProject;

import BacoProject.Demacia.*;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> deck = new ArrayList<Card>();

    public Deck() {
        getRandomDeck();
    }

    private void getRandomDeck() {
        Random ran = new Random();

        for (int i = 0; i < 40; i++) {
            int j = ran.nextInt(11);
            switch (j) {
                case 0:
                    deck.add(new Garen(this));
                    break;
                case 1:
                    deck.add(new Tiana(this));
                    break;
                case 2:
                    deck.add(new Vanguarda(this));
                    break;
                case 3:
                    deck.add(new Duelista(this));
                    break;
                case 4:
                    deck.add(new Defensor(this));
                    break;
                case 5:
                    deck.add(new Poro(this));
                    break;
                case 6:
                    deck.add(new PoroDefensor(this));
                    break;
                case 7:
                    deck.add(new Julgamento(this));
                    break;
                case 8:
                    deck.add(new ValorRedobrado(this));
                    break;
                case 9:
                    deck.add(new GolpeCerteiro(this));
                    break;
                case 10:
                    deck.add(new CombateUmAUm(this));
                    break;
            }

        }
    }
}

