package BacoProject;

public class Follower extends Card{
    protected int power;
    protected int life;

    public void lifeUp(int n){
        life+=n;
    }
    public void powerUp(int n){
        power+=n;
    }
}
