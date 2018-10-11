package edu.northeastern.ccs.cs5500.homework2b;

import java.util.Map;
/*
 * Interface Euchre
 * @author Wendi Luo
 */
public class Euchre extends Deck {
	/* A Euchre deck, which is composed of 9, 10, J, Q, K, 
	 * and A of the four suits - 24 cards in total.
	 */
	private static int EUCHRE_SIZE = 24;

	public Euchre() {
		//iterate through Map.Entry
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

	public int officialSize() {
		return EUCHRE_SIZE;
	}

}
