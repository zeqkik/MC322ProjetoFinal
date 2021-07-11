package BacoProject;

public interface Lifeable {

    public void lifeUp(int i);
    public void powerUp(int i);
    public int attack();
    public void attack(Lifeable card);
    public void takeDamage(int i);
    public boolean isDead();
    public void setBattlePosition(int i);
}
