package edu.northeastern.ccs.cs5500.homework2b;

import java.util.Map;

/*
 * Interface Pinochle
 * A pinochle deck, which is composed 9, 10, J, Q, K, and A of the four 
 * suits, but there are two copies of each suit.
 */
public class Pinochle extends Deck {
	/* 
	 * There are 48 cards in total.
	 */
	private static int PINOCHLE_SIZE = 48;

	public Pinochle() {
		//iterate throuh Map.Entry
		for (int j = 0; j < 2; j++) {
			for (Map.Entry<String, Integer> suitPair : suitMap.entrySet()) {
				Suit suit = new Suit(suitPair.getKey(), (char) ((int) (suitPair.getValue()) + '0'));
				for (int i = 9; i <= 10; i++) {
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
		return PINOCHLE_SIZE;
	}

}
