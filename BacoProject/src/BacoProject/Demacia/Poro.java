package BacoProject.Demacia;

import BacoProject.Battleable;
import BacoProject.Follower;
import BacoProject.Player;

public class Poro extends Follower implements Battleable {
    public Poro(Player player, String name, int id){
        super(player, name, id);
        super.manaCost = 1;
        super.power = 2;
        super.life = 1;
        super.battlePosition = -1;
    }

    @Override
    public void update(Battleable kill, Battleable dead, int idKill, int idDead) {

    }
}
