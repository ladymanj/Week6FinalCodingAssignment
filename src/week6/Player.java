package week6;

import java.util.ArrayList;
import java.util.List;

public class Player {

// Fields

	private List<Card> hand = new ArrayList<>();
	private int score;
	private String name;

// Constructor

	public Player(String name) {
		this.name = name;
		score = 0;
	}

// Getters and Setters

	public int getScore() {
		return score; 
	}
	 
	public String getName() {
		return name;
	}
	
	public List<Card> getHand() {
		return hand;
	}

// Methods

	public void describe() {
		System.out.println("These are the cards in " + name + "'s hand: ");
		for (Card card : hand) {
			System.out.print("    ");
			card.describe();
		}
		System.out.println();
	}

	public Card flip() {
		return hand.remove(0);
	}

	public void draw(Deck deck) {
		hand.add(deck.draw());
	}

	public void incrementScore() {
		score += 1;
	}
}
