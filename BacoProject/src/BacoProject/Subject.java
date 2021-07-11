package BacoProject;

public interface Subject {
    public void attach(Card card);
    public void dettach (Card card);
    public void notifyAttack(Card kill, Card dead, int id);
}
