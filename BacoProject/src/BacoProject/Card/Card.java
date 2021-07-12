package BacoProject.Card;

import BacoProject.Player.Player;

public class Card {
	protected String name;
	protected Player owner;
	protected int manaCost;
	protected int id;

	public Card(Player player, String name, int id) {
		this.owner = player;
		this.name = name;
		this.id = id;
	}

	public String toString() {
		String out = "";
		out = this.name + ": ";
		out += "Mana: " + this.manaCost;
		return out;
	}

	public int getMana() {
		return this.manaCost;
	}

	public int getId() {
		return this.id;
	}

}
