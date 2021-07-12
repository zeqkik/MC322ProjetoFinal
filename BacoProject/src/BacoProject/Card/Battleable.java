package BacoProject.Card;

public interface Battleable {

    public void lifeUp(int i);
    public void powerUp(int i);
    public int getPower();
    public void attack(Battleable card);
    public void takeDamage(int i);
    public boolean isDead();
    public void setBattlePosition(int i);
    public int getBattlePosition();
    public int getId();
    public void update(Battleable kill, Battleable dead, int idKill, int idDead);
    public String toString();
}
