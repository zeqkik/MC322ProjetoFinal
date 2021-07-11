package BacoProject;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player {
    private String name;
    private int mana;
    private int spellMana;
    private int nexusLife;
    Deck deck;
    private ArrayList<Card> hand = new ArrayList<Card>();
    private ArrayList<Card> evockedUnits = new ArrayList<Card>();
    private boolean attack = true;
    private int numCards;

    public Player(String name) {
        this.name = "name";
        this.mana = 0;
        this.spellMana = 0;
        this.nexusLife = 20;
        this.deck = new Deck(this);
    }

    public void takeCard(int turn) {
        Random ran = new Random();
        for (int i = 0; i < turn; i++) {
            int j = ran.nextInt(deck.size());
            hand.add(deck.get(j));
            try {
                checkSizeDeck();
                deck.remove(j);
            } catch (SizeException e) {
                hand.remove(j);
            }
        }
    }

    public void giveInitialCards() {
        Random ran = new Random();
        for (int i = 0; i < 4; i++) {
            hand.add(deck.get(ran.nextInt(deck.size())));
        }
    }

    public void getCard(int n) {
        for (int i = 0; i < n; i++) {
            if (deck.size() > 0) {
                hand.add(deck.get(0));
                try {
                    checkSizeDeck();
                    deck.remove(0);
                } catch (SizeException e) {
                    System.out.println("Nao foi possivel adicionar a carta. Sua mao ja esta cheia.");
                    hand.remove(deck.get(0));
                }
            }
        }
        cardsToString(hand);
    }

    public void changeCards() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Deseja trocar alguma das cartas?(Digite 1 caso queira)");
        int change = sc.nextInt();
        if (change == 1) {
            int quant = 0;
            System.out.println("Quantas cartas você deseja substituir(De 0 a 4)");
            quant = sc.nextInt();
            if (quant < 0 || quant > 4) {
                System.out.println("Valor inválido! Digite novamente");
                this.changeCards();
                return;
            }
            for (int i = 1; i < quant; i++) {
                System.out.println("Digite o id da " + i + "º carta:");
                int id = sc.nextInt();
                deck.add(hand.get(i-1));
                hand.remove(i - 1);
                hand.add(deck.get(0));
            }
        }
    }

    public void evoke() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Selecione a carta que deseja invocar");
        cardsToString(hand);

        int choose_card = sc.nextInt(); //recebe a posição da carta

        if (choose_card > hand.size()) {
            System.out.println("Posicao invalida");
            evoke();
            return;
        }

        if (hand.get(choose_card) instanceof iSpell spell) {
            if (this.spellMana < spell.getMana()) {
                System.out.println("Pontos de mana insuficientes.");
                evoke();
                return;
            } else {
                spell.playEffect();
                return;
            }
        }

        evockeLifeable(choose_card);
        System.out.println("Deseja evocar uma nova carta?(Digite 1 para evocar)");
        int newEvocate = sc.nextInt();
        if(newEvocate == 1){
            this.evoke();
        }
    }

    private void evockeLifeable(int choose_card) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite 0 caso queira evocar como uma carta nova, 1 caso deseje substituir uma carta ja evocada ou 2 caso deseja escolher outra carta para evocar.");
        int evockeOrChange = sc.nextInt();

        if (evockeOrChange == 0) {
            if (this.mana < hand.get(choose_card).getMana()) {
                System.out.println("Pontos de mana insuficiente");
                evockeLifeable(choose_card);
            } else {
                try {
                    checkSizeEvockeUnits();
                    this.mana = this.mana - hand.get(choose_card).getMana();
                    this.evockedUnits.add(hand.get(choose_card));
                    hand.remove(choose_card);
                } catch (SizeException e) {
                    evockeLifeable(choose_card);
                }
            }
        } else if (evockeOrChange == 1) {
            if (this.evockedUnits.size() == 0) {
                System.out.println("Voce nao tem cartas evocadas.");
                evockeLifeable(choose_card);
            } else {
                cardsToString(evockedUnits);
                int choose_evocked = sc.nextInt(); //recebe a posição da carta

                if (choose_evocked > evockedUnits.size()) {
                    System.out.println("Posicao invalida");
                    evockeLifeable(choose_card);
                    return;
                }

                if (hand.get(choose_card).getMana() - this.evockedUnits.get(choose_evocked).getMana() > this.mana) {
                    System.out.println("Pontos de mana insuficiente");
                    evockeLifeable(choose_card);
                } else {
                    try {
                        checkSizeEvockeUnits();
                        this.mana = this.mana - hand.get(choose_card).getMana() + evockedUnits.get(choose_evocked).getMana();
                        this.evockedUnits.add(hand.get(choose_card));
                        this.hand.add(evockedUnits.get(choose_evocked));
                        this.evockedUnits.remove(choose_evocked);
                        this.hand.remove(choose_card);
                    } catch (SizeException e) {
                        evockeLifeable(choose_card);
                    }
                }
            }
        } else if(evockeOrChange == 2){
            evoke();
        }
    }

    public void cardsToString(ArrayList<Card> cards) {
        int n = 1;
        for (Card card : cards) {
            System.out.println(n + ": " + card.toString());
            n++;
        }
    }

    private void checkSizeEvockeUnits() throws SizeException {
        if (evockedUnits.size() > 6) {
            throw new SizeException("Nao eh possivel evocar. Voce ja envocou 6 cartas.");
        }
    }

    private void checkSizeDeck() throws SizeException {
        if (hand.size() > 10) {
            throw new SizeException("Numero de cartas invalido.");
        }
    }

    public void addHandCard(Card card) {
        hand.add(card);
    }

    public void incrementNumCards() {
        numCards++;
    }

    public int getNumCards() {
        return numCards;
    }

    public void switchAttacker() {
        this.attack = !this.attack;
    }

    public void setAttack(boolean b) {
        attack = b;
    }

    public boolean getAttack() {
        return attack;
    }

    public void incrementMana(int turn) {
        if (this.mana + turn > 10) {
            this.mana = 10;
        } else if (this.mana + turn < 0) {
            this.mana = 0;
        } else {
            this.mana += turn;
        }
    }

    public void incrementSpellMana(int n) {
        if (n > 3) {
            this.spellMana += 3;
        } else if (n > 0 && n < 3) {
            this.spellMana += n;
        }
    }

    public int getMana() {
        return this.mana;
    }

    public void nexusDamage(int damage) {
        this.nexusLife -= damage;
    }

    public ArrayList<Card> getEvockedUnits() {
        return evockedUnits;
    }

    public boolean isDead() {
        return this.nexusLife <= 0;
    }

    public String toString() {
        return this.name;
    }

    public void setMana() {
        if (this.mana > 3) {
            this.spellMana = 3;
        }
        if (this.mana > 0 && this.mana <= 3) {
            this.spellMana = this.mana;
        }
        this.mana = 0;
    }

    public void returnToEvockedUnits(ArrayList<Lifeable> battlefield) {
        for (Lifeable card : battlefield) {
            evockedUnits.add((Card) card);
        }
    }
}
