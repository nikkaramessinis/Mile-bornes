package CardTypes;

/**
 * 
 * @author Nick Karamessinis
 * 
 */

public class Safety implements Card {
	private String name;
/**
 * Constructor
 * @param name
 */
	public Safety(String name) {
		this.setName(name);
	}
/**
 * Accessor 
 * @return private String name
 */
	public String getName() {
		return name;
	}
/**
 * Transformer 
 * Postcondition:Sets the name of the card 
 * @param name
 */
	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return name;

	}

}
