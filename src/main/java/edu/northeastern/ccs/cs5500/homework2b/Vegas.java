package edu.northeastern.ccs.cs5500.homework2b;

import java.util.Map;

public class Vegas extends Deck {
	private static int VEGAS_SIZE = 52 * 6;

	public Vegas() {
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
