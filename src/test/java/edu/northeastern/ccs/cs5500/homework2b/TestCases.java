package edu.northeastern.ccs.cs5500.homework2b;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

public class TestCases extends TestCase {

	private Map<String, Integer> faceMap = new HashMap<String, Integer>();
	private Map<String, Integer> suitMap = new HashMap<String, Integer>();

	public TestCases() {
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
	 * Test 1 The creation of individual cards (meaning test that a card has the
	 * right suit and rank)
	 */
	public void testCreateCard() {
		Card card = new Card(new Rank("Q", 0), new Suit("clubs", '1'));
		assertEquals(card.getRank().getName(), "Q");
		assertEquals(card.getRank().getPips(), 0);
		assertEquals(card.getSuit().getName(), "clubs");
		assertEquals(card.getSuit().getSymbol(), '1');
	}

	/*
	 * Test 2 A deck has the right cards in it and the right number of cards.
	 */
	public void testStandardDeck() {
		Deck standard = new Standard();
		assertEquals(52, standard.officialSize());
		for (Map.Entry<String, Integer> suitPair : suitMap.entrySet()) {
			Suit suit = new Suit(suitPair.getKey(), (char) ((int) (suitPair.getValue()) + '0'));
			for (int i = 2; i <= 10; i++) {
				Rank rank = new Rank(String.valueOf(i), i);
				assertTrue(standard.containsCard(new Card(rank, suit)));
			}
			for (Map.Entry<String, Integer> facePair : faceMap.entrySet()) {
				Rank rank = new Rank(facePair.getKey(), 0);
				assertTrue(standard.containsCard(new Card(rank, suit)));
			}
		}
	}

	public void testEuchreDeck() {
		Deck euchre = new Euchre();
		assertEquals(24, euchre.officialSize());
		for (Map.Entry<String, Integer> suitPair : suitMap.entrySet()) {
			Suit suit = new Suit(suitPair.getKey(), (char) ((int) (suitPair.getValue()) + '0'));
			for (int i = 9; i <= 10; i++) {
				Rank rank = new Rank(String.valueOf(i), i);
				assertTrue(euchre.containsCard(new Card(rank, suit)));
			}
			for (Map.Entry<String, Integer> facePair : faceMap.entrySet()) {
				Rank rank = new Rank(facePair.getKey(), 0);
				assertTrue(euchre.containsCard(new Card(rank, suit)));
			}
		}
	}

	public void testPinochleDeck() {
		Deck pinochle = new Pinochle();
		assertEquals(48, pinochle.officialSize());
		for (int j = 0; j < 2; j++) {
			for (Map.Entry<String, Integer> suitPair : suitMap.entrySet()) {
				Suit suit = new Suit(suitPair.getKey(), (char) ((int) (suitPair.getValue()) + '0'));
				for (int i = 9; i <= 10; i++) {
					Rank rank = new Rank(String.valueOf(i), i);
					assertTrue(pinochle.containsCard(new Card(rank, suit)));
				}
				for (Map.Entry<String, Integer> facePair : faceMap.entrySet()) {
					Rank rank = new Rank(facePair.getKey(), 0);
					assertTrue(pinochle.containsCard(new Card(rank, suit)));
				}
			}
		}
	}

	public void testVegasDeck() {
		Deck vegas = new Vegas();
		assertEquals(6 * 52, vegas.officialSize());
		for (int j = 0; j < 6; j++) {
			for (Map.Entry<String, Integer> suitPair : suitMap.entrySet()) {
				Suit suit = new Suit(suitPair.getKey(), (char) ((int) (suitPair.getValue()) + '0'));
				for (int i = 1; i <= 10; i++) {
					Rank rank = new Rank(String.valueOf(i), i);
					assertTrue(vegas.containsCard(new Card(rank, suit)));
				}
				for (Map.Entry<String, Integer> facePair : faceMap.entrySet()) {
					Rank rank = new Rank(facePair.getKey(), 0);
					assertTrue(vegas.containsCard(new Card(rank, suit)));
				}
			}
		}
	}

	/*
	 * Test 3 A deck after being shu ed has a dierent order than before.
	 */
	public void testShuffle() {
		Deck standard1 = new Standard();
		Deck standard2 = new Standard();

		// Ensure that Deck1 and Deck2 are the same.
		assertTrue(standard1.equals(standard2));

		// Ensure Deck2 after shuffle is different from Deck1.
		standard2.shuffle();
		assertTrue(!standard1.equals(standard2));
	}

	/*
	 * Test 4 A deck after being sorted by rank, suit, or both rank and suit, is in
	 * the expected order
	 */
	public void testSort() {
		// Test sort by "both"
		Deck standard1 = new Standard();
		standard1.shuffle();
		standard1.sort("both");
		for (Map.Entry<String, Integer> suitPair : suitMap.entrySet()) {
			Suit suit = new Suit(suitPair.getKey(), (char) ((int) (suitPair.getValue()) + '0'));
			for (int i = 2; i <= 10; i++) {
				Rank rank = new Rank(String.valueOf(i), i);
				assertTrue(standard1.containsCard(new Card(rank, suit)));
			}
			for (Map.Entry<String, Integer> facePair : faceMap.entrySet()) {
				Rank rank = new Rank(facePair.getKey(), 0);
				assertTrue(standard1.containsCard(new Card(rank, suit)));
			}
		}

		// Test sort by "Rank"
		Deck standard2 = new Standard();
		standard2.shuffle();
		standard2.sort("Rank");
		Card last = standard2.pullCard();
		while (!standard2.emptyDeck()) {
			Card cur = standard2.pullCard();
			int lastVal = 0;
			try {
				lastVal = Integer.valueOf(last.getRank().getName());
			} catch (NumberFormatException e) {
				if (faceMap.containsKey(last.getRank().getName())) {
					lastVal = faceMap.get(last.getRank().getName());
				}
			}
			int curVal = 0;
			try {
				curVal = Integer.valueOf(cur.getRank().getName());
			} catch (NumberFormatException e) {
				if (faceMap.containsKey(cur.getRank().getName())) {
					curVal = faceMap.get(cur.getRank().getName());
				}
			}
			assertTrue(lastVal <= curVal);

		}

		// Test sort by "Suit"
		Deck standard3 = new Standard();
		standard3.shuffle();
		standard3.sort("Suit");
		Card suitLast = standard3.pullCard();
		while (!standard3.emptyDeck()) {
			Card cur = standard3.pullCard();
			int lastVal = suitMap.getOrDefault(suitLast.getSuit().getName(), 0);
			int curVal = suitMap.getOrDefault(cur.getSuit().getName(), 0);
			assertTrue(lastVal <= curVal);

		}
	}

	/*
	 * Test 5 A deck after being cut is in the right order.
	 */
	public void testCut() {

	}

	/*
	 * Test 6 A deck after a card is pulled has one less card than before that card
	 * was pulled (and that card is no longer in the deck). Beware of the pinochle
	 * deck for this test case!
	 */
	public void testPull() {
		Deck standard = new Standard();
		int before = standard.deckSize();
		standard.pullCard();
		int after = standard.deckSize();
		assertEquals(before - 1, after);
	}

	/*
	 * Test 7 An empty deck is indeed empty. A deck with cards in it is indeed not
	 * empty.
	 */
	public void testEmptyDeck() {
		Deck standard = new Standard();
		assertTrue(standard.deckSize() != 0);
		assertTrue(!standard.emptyDeck());

		while (!standard.emptyDeck()) {
			standard.pullCard();
		}
		assertTrue(standard.deckSize() == 0);
		assertTrue(standard.emptyDeck());
	}

	/*
	 * Test 8 A hand is properly constructed.
	 */
	public void testHandConstructed() {
		Game game = new Game();
		game.setNumberOfHands(1);
		game.createDeck("Standard");
		game.deal();
		Hand hand = game.getPlayer(0);
		assertTrue(hand != null);
		assertTrue(hand.showCards().size() == 1);
	}

	/*
	 * Test 9 A hand properly accepts a card.
	 */
	public void testHandAccept() {
		Rank rank = new Rank("test", 1);
		Suit suit = new Suit("testSuit", 't');
		Card card = new Card(rank, suit);
		Hand hand = new Hand();
		hand.accept(card);
		assertTrue(hand.showCards().get(0).getRank().getName().equals("test"));
	}

	/*
	 * Test 10 When a card is pulled from the hand, the hand now has one less card
	 * and that card is no longer in the deck. Op cit, beware the pinochle deck. . .
	 */
	public void testHandPull() {
		Game game = new Game();
		game.setNumberOfHands(1);
		game.createDeck("Standard");
		game.deal();
		Hand hand = game.getPlayer(0);
		assertTrue(hand != null);
		assertTrue(hand.showCards().size() == 1);
		Card firstCard = hand.pullCard();
		assertTrue(firstCard != null);
		assertTrue(hand.showCards().size() == 0);
	}

	/*
	 * Test 11 The hand tells accurately whether a particular card, rank, or suit is
	 * present
	 */
	public void testHandTellCardRank() {
		Rank rank = new Rank("test", 1);
		Suit suit = new Suit("testSuit", 't');
		Card card = new Card(rank, suit);
		Hand hand = new Hand();
		hand.accept(card);
		assertTrue(hand.hasCard(card));
	}

	/*
	 * Test 12 The hand tells accurately whether a particular card, rank, or suit is
	 * present
	 */
	public void testHandSort() {
		// Test sort by "both"
		Hand both = new Hand();
		both.shuffle();
		both.sort("both");
		List<Card> bothlist = both.showCards();
		for (int i = 1; i < bothlist.size(); ++i) {

			Card last = bothlist.get(i - 1);
			Card cur = bothlist.get(i);

			int lastSuitVal = suitMap.getOrDefault(last.getSuit().getName(), 0);
			int curSuitVal = suitMap.getOrDefault(cur.getSuit().getName(), 0);

			int lastCardRankVal = 0;
			try {
				lastCardRankVal = Integer.valueOf(last.getRank().getName());
			} catch (NumberFormatException e) {
				if (faceMap.containsKey(last.getRank().getName())) {
					lastCardRankVal = faceMap.get(last.getRank().getName());
				}
			}
			int curCardRankVal = 0;
			try {
				curCardRankVal = Integer.valueOf(cur.getRank().getName());
			} catch (NumberFormatException e) {
				if (faceMap.containsKey(cur.getRank().getName())) {
					curCardRankVal = faceMap.get(cur.getRank().getName());
				}
			}

			if (lastCardRankVal == curSuitVal) {
				assertTrue(lastCardRankVal <= curCardRankVal);
			} else {
				assertTrue(lastSuitVal <= curSuitVal);
			}
		}

		// Test sort by "Rank"
		Hand rankHand = new Hand();
		rankHand.shuffle();
		rankHand.sort("Rank");
		List<Card> ranklist = rankHand.showCards();
		for (int i = 1; i < ranklist.size(); ++i) {
			Card last = bothlist.get(i - 1);
			Card cur = bothlist.get(i);

			int lastCardRankVal = 0;
			try {
				lastCardRankVal = Integer.valueOf(last.getRank().getName());
			} catch (NumberFormatException e) {
				if (faceMap.containsKey(last.getRank().getName())) {
					lastCardRankVal = faceMap.get(last.getRank().getName());
				}
			}
			int curCardRankVal = 0;
			try {
				curCardRankVal = Integer.valueOf(cur.getRank().getName());
			} catch (NumberFormatException e) {
				if (faceMap.containsKey(cur.getRank().getName())) {
					curCardRankVal = faceMap.get(cur.getRank().getName());
				}
			}
			assertTrue(lastCardRankVal <= curCardRankVal);
		}

		// Test sort by "Suit"
		Hand suitHand = new Hand();
		suitHand.shuffle();
		suitHand.sort("Suit");
		List<Card> suitList = suitHand.showCards();
		for (int i = 1; i < bothlist.size(); ++i) {
			Card last = bothlist.get(i - 1);
			Card cur = bothlist.get(i);

			int lastSuitVal = suitMap.getOrDefault(last.getSuit().getName(), 0);
			int curSuitVal = suitMap.getOrDefault(cur.getSuit().getName(), 0);

			assertTrue(lastSuitVal <= curSuitVal);
		}
	}

	/*
	 * Test 13 The hand properly shuffl es the cards in it
	 */
	public void testHandShuffle() {
		Deck standard = new Standard();
		
		Hand hand1 = new Hand();
		Hand hand2 = new Hand();
		
		while (!standard.emptyDeck()) {
			Card card = standard.pullCard();
			hand1.accept(card);
			hand2.accept(card);
		}
		
		List<Card> list1 = hand1.showCards();
		List<Card> list2 = hand2.showCards();

		// Ensure that hand1 and hand2 are the same.
		assertTrue(list1.size() == list2.size());
		for (int i = 0; i < list1.size(); ++i) {
			assertTrue(list1.get(i).equals(list2.get(i)));
		}

		// Ensure hand2 after shuffle is different from hand1.
		hand2.shuffle();
		assertTrue(list1.size() == list2.size());
		boolean allEq = true;
		for (int i = 0; i < list1.size(); ++i) {
			if(!list1.get(i).equals(list2.get(i))){
				allEq = false;
				break;
			}
		}
		assertFalse(allEq);
	}
	

}
