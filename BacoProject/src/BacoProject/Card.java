package BacoProject;

public class Card {
    protected String name;
    protected Player owner;
    protected int manaCost;
    protected int id;

    public Card (Player player, String name, int id){
        this.owner = player;
        this.name = name;
        this.id = id;
    }
    public String toString(){
        return this.name;
    }
    public int getMana() {
        return this.manaCost;
    }

}
