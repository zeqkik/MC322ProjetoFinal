public abstract class Champion extends Card{
    private int power;
    private int life;
    private int nivel;
    private Trace trace;

    public abstract void LevelUp();

    public void takeDamage(int n){
        this.life -= n;
    }
    public int attack(){
        return this.power;
    }
}