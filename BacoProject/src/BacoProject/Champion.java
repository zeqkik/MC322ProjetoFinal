package BacoProject;

public class Champion extends Card{
    protected int power;
    protected int life;
    protected int manaCost;
    protected Trace trace;

    public Champion(Player player) {
        super(player);
    }

    public void lifeUp(int n){
        life+=n;
    }
    public void powerUp(int n){
        power+=n;
    }
}
