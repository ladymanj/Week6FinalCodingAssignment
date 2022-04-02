package week6;

public class App {

	public static void main(String[] args) {
		Player player1 = new Player("Tom");
		Player player2 = new Player("Jerry");
		System.out.println(player1.getName() + " is playing " + player2.getName() + "\n");
		
		System.out.println("Let's get the deck ready to play WAR!");
		Deck deck = new Deck();
		System.out.println(deck.toString()); // TESTING THE DECK CONSTRUCTOR
		
		deck.shuffle(); 
		System.out.println("The deck has been shuffled!");
		System.out.println(deck.toString()); // TESTING THE SHUFFLE METHOD
		
		System.out.println("It's time to d-d-d-d-deal!!");
		deal(deck, player1, player2);
		player1.describe(); // TESTING THE DEAL METHOD ON PLAYER1
		player2.describe(); // TESTING THE DEAL METHOD ON PLAYER2
		
		System.out.println("Let's play! Good luck to both players!\n");
		play(player1, player2); // CONTAINS A METHOD THAT SHOWS INDIVIDUAL TURN RESULTS
		
		printWinner(player1, player2);
	}

	private static void deal(Deck deck, Player player1, Player player2) {
		int size = deck.getDeckSize();

		for (int index = 0; index < size; index++) {
			if (index % 2 == 0) {
				player1.draw(deck);
			} else {
				player2.draw(deck);
			}
		}
	}
	
	private static void play(Player player1, Player player2) {
		int numTurns = player1.getHand().size();

		for (int turn = 1; turn <= numTurns; turn++) {
			Card card1 = player1.flip();
			Card card2 = player2.flip();

			if (card1.getValue() > card2.getValue()) {
				player1.incrementScore();
			} else if (card2.getValue() > card1.getValue()) {
				player2.incrementScore();
			}
			turnResults(turn, player1, player2, card1, card2); // TESTING THE PLAY METHOD FOR EACH TURN
		}
	}
	
	private static void turnResults(int turnNumber, Player player1, Player player2, Card card1, Card card2) {
		System.out.println("Turn " + turnNumber);
		System.out.println(player1.getName() + " plays " + card1.getName() + ".");
		System.out.println(player2.getName() + " plays " + card2.getName() + ".");
		System.out.println(player1.getName() + ": " + player1.getScore() + "   " 
						 + player2.getName() + ": " + player2.getScore() + "\n");
	}

	private static void printWinner(Player player1, Player player2) {
		System.out.println(player1.getName() + "'s final score: " + player1.getScore());
		System.out.println(player2.getName() + "'s final score: " + player2.getScore() + "\n");
		
		if (player1.getScore() == player2.getScore()) {
			System.out.println("It's a draw!!");
		} else {
			String winner = "";
			if (player1.getScore() > player2.getScore()) {
				winner = player1.getName();
			} else {
				winner = player2.getName();
			}
			System.out.println("The winner is " + winner + "!!!");
		}
	}
}
