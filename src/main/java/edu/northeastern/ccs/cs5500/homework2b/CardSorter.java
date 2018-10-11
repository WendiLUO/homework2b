package edu.northeastern.ccs.cs5500.homework2b;

import java.util.*;
/* The Class CardSorter
 * @author Wendi Luo
 */
public class CardSorter {
	/* initialize two hashmaps-
	 * faceMap: key: rank, value: the value of card
	 * suitMap: key: symbols, values: the value of card
	 */
	protected static Map<String, Integer> faceMap = new HashMap<String, Integer>();
	protected static Map<String, Integer> suitMap = new HashMap<String, Integer>();

	private CardSorter() {}
	/*
	 * populate two maps
	 */
	static {
		faceMap.put("J", 11);
		faceMap.put("Q", 12);
		faceMap.put("K", 13);
		faceMap.put("A", 14);
		suitMap.put("clubs", 1);
		suitMap.put("diamonds", 2);
		suitMap.put("hearts", 3);
		suitMap.put("spades", 4);
	}
	/*
	 * class used for sorting the rank of cards using the above 
	 * two maps
	 */
	private static class RankSort implements Comparator<Card> {
		public int compare(Card c1, Card c2) {
			int c1Val = 0;
			try {
				c1Val = Integer.valueOf(c1.getRank().getName());
			} catch (NumberFormatException e) {
				if (faceMap.containsKey(c1.getRank().getName())) {
					c1Val = faceMap.get(c1.getRank().getName());
				}
			}

			int c2Val = 0;
			try {
				c2Val = Integer.valueOf(c2.getRank().getName());
			} catch (NumberFormatException e) {
				if (faceMap.containsKey(c2.getRank().getName())) {
					c2Val = faceMap.get(c2.getRank().getName());
				}
			}
			return c1Val - c2Val;
		}

	}
	/*
	 *  class used for sorting the suit of cards using the above 
	 *  two maps
	 */
	private static class SuitSort implements Comparator<Card> {

		public int compare(Card c1, Card c2) {
			int c1Val = 0;
			int c2Val = 0;
			if (suitMap.containsKey(c1.getSuit().getName())) {
				c1Val = suitMap.get(c1.getSuit().getName());
			}
			if (suitMap.containsKey(c2.getSuit().getName())) {
				c2Val = suitMap.get(c2.getSuit().getName());
			}
			return c1Val - c2Val;
		}

	}
	/*
	 *  class used for sorting both the suit and the rank of cards 
	 *  using the above two maps
	 */

	private static class SuitAndRankSort implements Comparator<Card> {

		public int compare(Card c1, Card c2) {
			int c1Val = 0;
			int c2Val = 0;
			if (suitMap.containsKey(c1.getSuit().getName())) {
				c1Val = suitMap.get(c1.getSuit().getName());
			}
			if (suitMap.containsKey(c2.getSuit().getName())) {
				c2Val = suitMap.get(c2.getSuit().getName());
			}
			if (c1Val - c2Val != 0) {
				return c1Val - c2Val;
			} else {
				c1Val = 0;
				try {
					c1Val = Integer.valueOf(c1.getRank().getName());
				} catch (NumberFormatException e) {
					if (faceMap.containsKey(c1.getRank().getName())) {
						c1Val = faceMap.get(c1.getRank().getName());
					}
				}

				c2Val = 0;
				try {
					c2Val = Integer.valueOf(c2.getRank().getName());
				} catch (NumberFormatException e) {
					if (faceMap.containsKey(c2.getRank().getName())) {
						c2Val = faceMap.get(c2.getRank().getName());
					}
				}
				return c1Val - c2Val;
			}
		}

	}

	public static void sort(List<Card> cards, String guidance) {
		if (guidance == "Suit") {
			Collections.sort(cards, new SuitSort());
		} else if (guidance == "Rank") {
			Collections.sort(cards, new RankSort());
		} else if (guidance == "both") {
			Collections.sort(cards, new SuitAndRankSort());
		}
	}
}
