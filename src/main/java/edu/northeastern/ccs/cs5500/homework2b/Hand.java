package edu.northeastern.ccs.cs5500.homework2b;

import java.util.*;

public class Hand {
	private List<Card> myCards;
	
	public Hand() {
		myCards = new LinkedList<Card>();
	}
	
	public List<Card> showCards() {
		return myCards;
	}
	
	public void accept(Card card) {
		myCards.add(card);
	}
	
	public Card pullCard() {
		return myCards.remove(0);
	}
	
	public Boolean hasCard(Card cardToFind) {
		for (Card card : myCards) {
			if (card.equals(cardToFind)) {
				return true;
			}
		}
		return false;
	}
	
	public void sort(String guidance) {
		CardSorter.sort(myCards, guidance);
	}
	
	public void shuffle() {
		Collections.shuffle(myCards);
	}
}
