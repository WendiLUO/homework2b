package edu.northeastern.ccs.cs5500.homework2b;


// TODO: Auto-generated Javadoc
/**
 * The Class Card.
 */
public class Card{
	
	/** The rank. */
	private Rank rank;
	
	/** The suit. */
	private Suit suit;
	
	
	
	public Card(Rank rank, Suit suit) {
		super();
		this.rank = rank;
		this.suit = suit;
	}

	/**
	 * Gets the rank.
	 *
	 * @return the rank
	 */
	public Rank getRank() {
		return rank;
	}
	
	/**
	 * Gets the suit.
	 *
	 * @return the suit
	 */
	public Suit getSuit() {
		return suit;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Card)) {
			return false;
		}
		Card other = (Card) obj;
		return other.getRank().equals(rank) &&
				other.getSuit().equals(suit);
	}
	
}
