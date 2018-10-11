package edu.northeastern.ccs.cs5500.homework2b;

/*
 * Class Rank
 * @author Wendi Luo
 */
public class Rank{
	/*
	 *  Rank expressed as a string along with a number of pips 
	 *  equal to the value of the card. 
	 *  Therefore, we need to initialize a String and a int as
	 *  global parameter
	 */
	private String name;
	private int pips;
    /*
     * @param String name
     *        int pips
     */
	public Rank(String name, int pips) {
		super();
		this.name = name;
		
		//rank may also be called pips
		this.pips = pips;
	}
	 /*
     * Cards will have the rank expressed as a string (e.g. 2, 3,. . . ,
     * 10, J, Q, K, or A) along with a number of pips equal to the 
     * value of the card (2, 3,. . . , 10). 
     */
	public String getName() {
		//A pip is a mark on a card
		return name;
	}
    /*
     * Cards will have the rank expressed as a string (e.g. 2, 3,. . . ,
     * 10, J, Q, K, or A) along with a number of pips equal to the 
     * value of the card (2, 3,. . . , 10). However, face cards do 
     * not have pips so the corresponding pip count would be zero.
     */
	public int getPips() {
		return pips;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Rank)) {
			return false;
		}
		Rank other = (Rank) obj;
		return other.getName().equals(name) && other.pips == pips;
	}

}
