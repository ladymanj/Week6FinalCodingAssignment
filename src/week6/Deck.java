package week6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	
// Fields
	
	private List<Card> cards = new ArrayList<>();
	
	
// Constructor
	
	public Deck() {
		for (int i = 2; i <= 14; i++) {
			cards.add(new Card(i, "Hearts"));
			cards.add(new Card(i, "Diamonds"));
			cards.add(new Card(i, "Spades"));
			cards.add(new Card(i, "Clubs"));
		}
	}
	
	
// Methods
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Here is the current deck order:\n");
		for (Card card : cards) {
			sb.append("    " + card.getName() + "\n");
		}
		// sb.append("\n");
		return sb.toString();
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public Card draw() {
		return cards.remove(0);
	}

	public int getDeckSize() {
		return cards.size();
	}
}
