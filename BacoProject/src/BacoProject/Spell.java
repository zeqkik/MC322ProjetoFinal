package BacoProject;

public class Spell extends Card implements iEffect {
    public Spell(Player player, String name, int id) {
        super(player, name, id);
    }

    @Override
    public void playEffect() {
    }

    @Override
    public void update(Card kill, Card dead, int idKill, int idDead) {
    }
}
