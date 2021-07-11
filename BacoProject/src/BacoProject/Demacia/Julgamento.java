package BacoProject.Demacia;

import BacoProject.*;

import java.util.Scanner;

public class Julgamento extends Spell implements iEffect {
    public Julgamento(Player player, String name, int id) {
        super(player, name, id);
        super.manaCost = 8;
    }

    @Override
    public void playEffect() {
        //um aliado atacante golpeia todos oponentes defensores
        owner.deckToString(owner.getEvockedUnits());
        System.out.println("Selecione um aliado para golpear todos os oponentes defensores");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n > owner.getEvockedUnits().size() || n < 0){
            System.out.println("Posicao invalida, tente novamente.");
            this.playEffect();
        } else{
            Lifeable card = (Lifeable) owner.getEvockedUnits().get(n);

            card.attack();
        }
    }

    @Override
    public void update(Card kill, Card dead, int idKill, int idDead) {

    }
}
