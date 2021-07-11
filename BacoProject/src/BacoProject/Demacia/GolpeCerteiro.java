package BacoProject.Demacia;

import BacoProject.*;

import java.util.Scanner;

public class GolpeCerteiro extends Spell implements iEffect {
    public GolpeCerteiro(Player player, String name, int id) {
        super(player, name, id);
        super.manaCost = 1;
    }
    @Override
    public void playEffect() {
        //dê +1/+1 a um aliado nesta rodada;
        owner.deckToString(owner.getEvockedUnits());
        System.out.println("Selecione um aliado para dar +1/+1");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n > owner.getEvockedUnits().size() || n < 0){
            System.out.println("Posicao invalida, tente novamente.");
            this.playEffect();
        } else{
            Lifeable card = (Lifeable) owner.getEvockedUnits().get(n);
            card.lifeUp(1);
            card.powerUp(1);
        }
    }

    @Override
    public void update(Card kill, Card dead, int idKill, int idDead) {

    }
}
