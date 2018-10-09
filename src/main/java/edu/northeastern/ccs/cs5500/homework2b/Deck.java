package edu.northeastern.ccs.cs5500.homework2b;

import java.util.*;

/**
 * The Interface Deck.
 */
public abstract class Deck {

	protected List<Card> cards = new LinkedList<Card>();
	protected Map<String, Integer> faceMap = new HashMap<String, Integer>();
	protected Map<String, Integer> suitMap = new HashMap<String, Integer>();

	public Deck() {
		faceMap.put("J", 11);
		faceMap.put("Q", 12);
		faceMap.put("K", 13);
		faceMap.put("A", 14);
		suitMap.put("clubs", 1);
		suitMap.put("diamonds", 2);
		suitMap.put("hearts", 3);
		suitMap.put("spades", 4);
	}

	/**
	 * Shuffle.
	 */
	public void shuffle() {
		Collections.shuffle(cards);
	}

	/**
	 * Sort.
	 *
	 * @param guidance the guidance
	 */
	public void sort(String guidance) {
		CardSorter.sort(cards, guidance);
	}

	/**
	 * Cut.
	 *
	 * @param cutPoint the cut point
	 */
	public void cut(int cutPoint) {
		cutPoint -= 1;
		if (cutPoint >= 1 && cutPoint < cards.size()) {
			List<Card> firstHalf = cards.subList(0, cutPoint);
			List<Card> secondHalf = cards.subList(cutPoint, cards.size());
			secondHalf.addAll(firstHalf);
			cards = secondHalf;
		}
	}

	/**
	 * Pull card.
	 *
	 * @return the card
	 */
	public Card pullCard() {
		return cards.remove(0);
	}

	/**
	 * Empty deck.
	 *
	 * @return the boolean
	 */
	public Boolean emptyDeck() {
		return cards.isEmpty();
	}

	/**
	 * Official size.
	 *
	 * @return the int
	 */
	public abstract int officialSize();
	
	public boolean containsCard(Card cardToFind) {
		for (Card card : cards) {
			if (card.equals(cardToFind)) {
				return true;
			}
		}
		return false;
	}
	
	public int deckSize() {
		return cards.size();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Deck)) {
			return false;
		}
		Deck other = (Deck)obj;
		for(int i=0; i<cards.size(); ++i) {
			if (!cards.get(i).equals(other.cards.get(i))) {
				return false;
			}
		}
		return true;
	}
	
	
}
