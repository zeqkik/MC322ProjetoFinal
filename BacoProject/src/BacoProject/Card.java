package BacoProject;
//esta igual a follower
public class Card implements Lifeable{
    protected String name;
    protected Player owner;
    protected int life;
    protected int power;
    protected int manaCost;
    protected int id;
    protected int battlePosition;

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
    public int getId(){
        return this.id;
    }
    public void lifeUp(int n) {
        life += n;
    }

    public void powerUp(int n) {
        power += n;
    }


    public int getPower() {
        return this.power;
    }

    public void takeDamage(int i) {
        power -= i;
    }

    public boolean isDead() {
        if (life <= 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void setBattlePosition(int i) {
        this.battlePosition = i;
    }

    public void attack(Lifeable card){
        card.takeDamage(this.power);
    }
}
}
