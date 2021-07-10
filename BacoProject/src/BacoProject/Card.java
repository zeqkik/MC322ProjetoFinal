package BacoProject;

public class Card {
    protected String name;
    protected Player owner;
    protected int manaCost;

    public Card (Player player){
        this.owner = player;
    }
    public String toString(){
        return this.name;
    }

    public int getMana() {
        return this.manaCost;
    }

}