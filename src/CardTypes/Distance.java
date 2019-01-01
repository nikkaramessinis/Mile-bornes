package CardTypes;

/**
 * 
 * @author Nick Karamessinis
 * 
 */

public class Distance implements Card {

	private String name;

	/**
	 * @param name
	 * @param points
	 * Precondition:Name and points for card to be created
	 * postcondition:Creates an instance of a Distance Card 
	 */
	public Distance(String name) {
		this.name = name;
		
	}


	/**
	 * Accessor gets private field name
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * <b>Transformer:</b> sets the card's name 
	 * <b>Postcondition:</b> the card's
	 * name has been set
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return name;

	}

}
