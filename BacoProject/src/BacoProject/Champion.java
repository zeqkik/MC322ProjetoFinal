package BacoProject;

public abstract class Champion extends Card implements Lifeable{
    protected Trace trace;
    protected int battlePosition;

    public Champion(Player player, String name, int id) {
        super(player, name, id);
    }

    public void lifeUp(int n){
    	super.life+=n;
    }
    public void powerUp(int n){
    	super.power+=n;
    }
    public int getPower(){return super.power;}
    public void takeDamage(int i){ super.power-=i;}
    public boolean isDead(){
        if(super.life <= 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void setBattlePosition(int i) {
    	this.battlePosition = i;
    }

    public int getBattlePosition(){
        return this.battlePosition;
    }

    public void attack(Lifeable card){
        card.takeDamage(super.power);
    }
    public abstract void levelUp();
    
    public String toString() {
    	return super.toString();
    }

}
