package edu.northeastern.ccs.cs5500.homework2b;

/*
 * Class Suit
 * @param Wendi Luo
 */
public class Suit{
	/*
	 *  Suit expressed as a string along with a char symbol 
	 *  Therefore, we need to initialize a String and a char as
	 *  global parameter
	 */
	private String name;
	private char symbol;
	/*
	 * @param String name
	 *        char symbol
	 */
	public Suit(String name, char symbol) {
		this.name = name;
		this.symbol = symbol;
	}
	/*
	 * method to get the name of the card
	 */
	public String getName() {
		return name;
	}
	/*
	 * method to get the symbol of the card
	 */
	public char getSymbol() {
		return symbol;
	}
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Suit)) {
			return false;
		}
		Suit other = (Suit) obj;
		return other.name.equals(name) && other.symbol == symbol;
	}
	
}
