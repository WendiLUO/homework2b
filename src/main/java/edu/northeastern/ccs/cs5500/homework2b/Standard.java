package edu.northeastern.ccs.cs5500.homework2b;

import java.util.*;

public class Standard extends Deck {
	private static int STANDARD_SIZE = 52;
	
	public Standard() {
		for(Map.Entry<String, Integer> suitPair: suitMap.entrySet()) {
			Suit suit = new Suit(suitPair.getKey(),
					(char)((int)(suitPair.getValue()) + '0'));
			for(int i = 2; i <= 10; i++) {
				Rank rank = new Rank(String.valueOf(i), i);
				cards.add(new Card(rank, suit));
			}
			for (Map.Entry<String, Integer> facePair: faceMap.entrySet()) {
				Rank rank = new Rank(facePair.getKey(), 0);
				cards.add(new Card(rank, suit));
			}
		}
	}
	
	public int officialSize() {
		return STANDARD_SIZE;
	}

}
