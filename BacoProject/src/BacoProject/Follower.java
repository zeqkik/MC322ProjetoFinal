package BacoProject;

public class Follower extends Card implements Battleable {
    protected int battlePosition;
    protected int life;
    protected int power;

    public Follower(Player player, String name, int id) {
        super(player, name, id);
    }

    public void lifeUp(int n) {
    	this.life += n;
    }

    public void powerUp(int n) {
    	this.power += n;
    }


    public int getPower() {
        return this.power;
    }

    public void takeDamage(int i) {
    	this.power -= i;
    }

    public boolean isDead() {
        if (this.life <= 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void setBattlePosition(int i) {
        this.battlePosition = i;
    }

    @Override
    public int getBattlePosition() {
        return battlePosition;
    }


    @Override
    public void update(Battleable kill, Battleable dead, int idKill, int idDead){}



    public void attack(Battleable card){
        card.takeDamage(this.power);
    }
    
    public String toString(){
    	String out = "";
    	out = this.name + ": ";
    	out += "Mana: " + this.manaCost + "/" ;
    	out += "Poder: " + this.power + "/";
    	out += "Vida: " + this.life;
        return out;
    }
}
