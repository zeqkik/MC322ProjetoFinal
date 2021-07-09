package BacoProject;

import BacoProject.Demacia.Observer;

import java.util.ArrayList;
//padrao Observer (Vanguarda - Board)
//Board extender observable
public class Board implements Subject{
    ArrayList<Card> evocatePlayer1 = new ArrayList<Card>();
    ArrayList<Card> evocatePlayer2 = new ArrayList<Card>();
    ArrayList<Card> battlefield1 = new ArrayList<Card>();
    ArrayList<Card> battlefield2 = new ArrayList<Card>();
    ArrayList<Observer> observers;

    public void evocateCard(Card card, int id) {
        if (id == 1) {
            evocatePlayer1.add(card);
        } else {
            evocatePlayer2.add(card);
        }

    }

    @Override
    public void Attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void Dettach(Observer o) {
        observers.remove(o);
    }

    @Override
    public void Notify() {
        for(int i = 0; i<observers.size(); i++){
            observers.get(i).update(this.evocatePlayer1);
        }
    }
}
