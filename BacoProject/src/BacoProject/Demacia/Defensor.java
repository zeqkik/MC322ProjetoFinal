package BacoProject.Demacia;

import BacoProject.Follower;
import BacoProject.Player;
import BacoProject.Trace;
import BacoProject.iEffect;

public class Defensor extends Follower implements iEffect {
    private int furyN;
    private int furyM;
    private Trace trace=Trace.FURY;
    public Defensor(Player player){
        super(player);
        super.name = "Defensor";
        this.manaCost = 2;
        this.power = 2;
        this.life = 2;
    }

    @Override
    public void playEffect() {
        //se destruir um seguidor do inimigo, adiciona uma carta "Poro" à mão
    }
}