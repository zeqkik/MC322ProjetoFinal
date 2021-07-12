package BacoProject.Demacia;

import BacoProject.*;

import java.util.Scanner;

public class Julgamento extends Card implements iSpell {
    public Julgamento(Player player, String name, int id) {
        super(player, name, id);
        super.manaCost = 8;
    }

    @Override
    public void playEffect() {
        //um aliado atacante golpeia todos oponentes defensores
    	super.owner.cardsToString(super.owner.getEvockedUnits());
        System.out.println("Selecione um aliado para golpear todos os oponentes defensores");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n > super.owner.getEvockedUnits().size() || n < 0){
            System.out.println("Posicao invalida, tente novamente.");
            this.playEffect();
        } else{
            Lifeable card = (Lifeable) super.owner.getEvockedUnits().get(n);

        }
    }
    
    @Override
    public String toString() {
    	String out = "";
    	out = super.name + ": ";
    	out += "Mana: " +super.manaCost ;
        return out;
    }
}
