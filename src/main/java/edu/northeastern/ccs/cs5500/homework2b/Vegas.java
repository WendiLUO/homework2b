package edu.northeastern.ccs.cs5500.homework2b;

import java.util.Map;
/*
 * Interface Vegas
 * @author Wendi Luo
 */
public class Vegas extends Deck {
	/*
	 * A Vegas blackjack deck. It's composed of two or more standard decks. 
	 * Typically it's six to eight decks. In this assignment, I choose six 
	 * decks. Therefore, the size is initialized as 52 *6.
	 */
	private static int VEGAS_SIZE = 52 * 6;

	public Vegas() {
		//iterate through Map.Entry
		for (int j = 0; j < 6; j++) {
			for (Map.Entry<String, Integer> suitPair : suitMap.entrySet()) {
				Suit suit = new Suit(suitPair.getKey(), (char) ((int) (suitPair.getValue()) + '0'));
				for (int i = 1; i <= 10; i++) {
					Rank rank = new Rank(String.valueOf(i), i);
					cards.add(new Card(rank, suit));
				}
				for (Map.Entry<String, Integer> facePair : faceMap.entrySet()) {
					Rank rank = new Rank(facePair.getKey(), 0);
					cards.add(new Card(rank, suit));
				}
			}
		}
	}

	public int officialSize() {
		return VEGAS_SIZE;
	}

}
