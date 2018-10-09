package edu.northeastern.ccs.cs5500.homework2b;

import java.util.*;

public class Game {
	private static int DEFAULT_DECK_NUM = 1;
	private List<Deck> decks = new ArrayList<Deck>();
	private List<Hand> hands = new ArrayList<Hand>();
	// Deal card using round-robin.
	private int currentCardAcceptor = 0;

	public void createDeck(String deckType) {
		createDeck(deckType, DEFAULT_DECK_NUM);
	}

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

	public void setNumberOfHands(int howManyHands) {
		for (int i = 0; i < howManyHands; ++i) {
			hands.add(new Hand());
		}
	}
	
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
