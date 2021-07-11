package BacoProject;

public class Champion extends Card implements Lifeable{
    protected int power;
    protected int life;
    protected int manaCost;
    protected Trace trace;
    protected int battlePosition;

    public Champion(Player player, String name, int id) {
        super(player, name, id);
    }

    public void lifeUp(int n){
        life+=n;
    }
    public void powerUp(int n){
        power+=n;
    }
    public int attack(){return this.power;}
    public void takeDamage(int i){ power-=i;}
    public boolean isDead(){
        if(life <= 0){
            return true;
        }else{
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
