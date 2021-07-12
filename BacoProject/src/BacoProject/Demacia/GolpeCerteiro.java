package BacoProject.Demacia;

import BacoProject.*;

import java.util.Scanner;

public class GolpeCerteiro extends Card implements iSpell {
    public GolpeCerteiro(Player player, String name, int id) {
        super(player, name, id);
        super.manaCost = 1;
    }
    @Override
    public void playEffect() {
        //dê +1/+1 a um aliado nesta rodada;
    	super.owner.cardsToString(super.owner.getEvockedUnits());
        System.out.println("Selecione um aliado para dar +1/+1");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n > owner.getEvockedUnits().size() || n < 0){
            System.out.println("Posicao invalida, tente novamente.");
            this.playEffect();
        } else{
        	Battleable card = (Battleable) super.owner.getEvockedUnits().get(n);
            card.lifeUp(1);
            card.powerUp(1);
        }
    }
    
    @Override
    public String toString() {
    	return super.toString();
    }
}
