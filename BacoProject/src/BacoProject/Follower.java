package BacoProject;

public class Follower extends Card implements Lifeable {
    protected int power;
    protected int life;

    public Follower(Player player) {
        super(player);
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
}
