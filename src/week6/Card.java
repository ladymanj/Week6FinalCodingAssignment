package week6;

import java.util.Map;
import static java.util.Map.entry;

public class Card {
	
// Fields
	
	private int value;
	private String suit;
	private String name;
	private static final Map<Integer, String> VALUES_OF_CARDS = Map.ofEntries(
			entry(2, "Two"), entry(3, "Three"), entry(4, "Four"), entry(5, "Five"), entry(6, "Six"),
			entry(7, "Seven"), entry(8, "Eight"), entry(9, "Nine"), entry(10, "Ten"), entry(11, "Jack"),
			entry(12, "Queen"), entry(13, "King"), entry(14, "Ace")
	);
	
	
// Constructor
	
	public Card(int value, String suit) {
		this.value = value;
		this.suit = suit;
		name = valueToString(value) + " of " + suit;
	}
	
	
// Getters and Setters
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	

// Other Methods
	
	public void describe() {
		System.out.println(name);
	}
	
	public static String valueToString(int key) {
		return VALUES_OF_CARDS.get(key);
	}
}
