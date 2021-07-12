package BacoProject;

public class Follower extends Card implements Lifeable {
    protected int battlePosition;

    public Follower(Player player, String name, int id) {
        super(player, name, id);
    }

    public void lifeUp(int n) {
    	super.life += n;
    }

    public void powerUp(int n) {
    	super.power += n;
    }


    public int getPower() {
        return super.power;
    }

    public void takeDamage(int i) {
    	super.power -= i;
    }

    public boolean isDead() {
        if (super.life <= 0) {
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
    public void update(Lifeable kill, Lifeable dead, int idKill, int idDead){}



    public void attack(Lifeable card){
        card.takeDamage(super.power);
    }
    
    public String toString() {
    	return super.toString();
    }
}
