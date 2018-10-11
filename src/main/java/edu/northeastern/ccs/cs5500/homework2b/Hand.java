package edu.northeastern.ccs.cs5500.homework2b;

import java.util.*;
/*
 * Class Hand
 * a hand is a game has one or more hands.3 A hand contains some number 
 * of cards, usually fixed by the game
 * @author Wendi Luo
 */
public class Hand {

	private List<Card> myCards; //initialize a global parameter
	
	public Hand() {
		//initialize linkedlist myCards to store the result
		myCards = new LinkedList<Card>();
	}
	
	public List<Card> showCards() {
		return myCards;
	}
	/*
	 * @param Card card
	 */
	public void accept(Card card) {
		myCards.add(card);
	}
	
	public Card pullCard() {
		return myCards.remove(0);
	}
	/*
	 * @param Card cardToFind
	 */
	public Boolean hasCard(Card cardToFind) {
		for (Card card : myCards) {
			if (card.equals(cardToFind)) {
				return true;
			}
		}
		return false;
	}
	/*
	 * @param String guidance
	 */
	public void sort(String guidance) {
		CardSorter.sort(myCards, guidance);
	}
	
	public void shuffle() {
		Collections.shuffle(myCards);
	}
}
