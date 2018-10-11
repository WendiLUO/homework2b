package edu.northeastern.ccs.cs5500.homework2b;

import java.util.*;
/*
 * Class Game
 * @author Wendi Luo
 */

public class Game {
	private static int DEFAULT_DECK_NUM = 1;
	//initialize ArrayList with type Deck
	private List<Deck> decks = new ArrayList<Deck>();
	//initialize ArrayList with type Deck
	private List<Hand> hands = new ArrayList<Hand>();
	
	/* Deal card using round-robin.
	 * It means time slices are assigned to each process in equal 
	 * portions and in circular order, handling all processes without
	 * priority.
	 */
	private int currentCardAcceptor = 0;
	
	/*
	 * @param String deckType
	 */
	public void createDeck(String deckType) {
		createDeck(deckType, DEFAULT_DECK_NUM);
	}
	
    /*
     * @param String deckType
     *        int numberOfDecks
     */
	public void createDeck(String deckType, int numberOfDecks) {
		for (int i = 0; i < numberOfDecks; ++i) {
			if (deckType == "Standard") {
				decks.add(new Standard());
			} else if (deckType == "Pinochle") {
				decks.add(new Pinochle());
			} else if (deckType == "Euchre") {
				decks.add(new Euchre());
			} else if (deckType == "Vegas") {
				decks.add(new Vegas());
			}
		}
	}
	
	/*
	 * @param int howManyHands
	 */
	public void setNumberOfHands(int howManyHands) {
		for (int i = 0; i < howManyHands; ++i) {
			hands.add(new Hand());
		}
	}
	
	/*
	 * @param int handNumber
	 */
	public Hand getPlayer(int handNumber) {
		if (handNumber >= 0 && handNumber < hands.size()) {
			return hands.get(handNumber);
		} else {
			return null;
		}
	}

	public void deal() {
		int i = 0;
		Deck firstNoneEmptyDeck = decks.get(i);
		while (firstNoneEmptyDeck.emptyDeck()) {
			if (++i == decks.size()) {
				// All decks are empty.
				return;
			}
			firstNoneEmptyDeck = decks.get(i);
		}
		hands.get(currentCardAcceptor).accept(
				firstNoneEmptyDeck.pullCard());
		currentCardAcceptor = (currentCardAcceptor + 1) % hands.size();
	}
}
