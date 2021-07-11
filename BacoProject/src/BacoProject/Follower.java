package BacoProject;

public class Follower extends Card implements Lifeable {
    protected int power;
    protected int life;
    protected int battlePosition;

    public Follower(Player player, String name, int id) {
        super(player, name, id);
    }

    public void lifeUp(int n) {
        life += n;
    }

    public void powerUp(int n) {
        power += n;
    }


    public int attack() {
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
}
