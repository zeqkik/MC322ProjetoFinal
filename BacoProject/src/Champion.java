public class Champion extends Card{
    private int power;
    private int life;
    private int nivel = 0;
    private Trace trace;

    public void takeDamage(int n){
        this.life -= n;
    }
    public int attack(){
        return this.power;
    }
}