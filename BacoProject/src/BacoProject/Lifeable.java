package BacoProject;

public interface Lifeable {

    public void lifeUp(int i);
    public void powerUp(int i);
    public int getPower();
    public void attack(Lifeable card);
    public void takeDamage(int i);
    public boolean isDead();
    public void setBattlePosition(int i);
    public int getBattlePosition();
    public int getId();
    public void update(Lifeable kill, Lifeable dead, int idKill, int idDead);
    public String toString();
}
