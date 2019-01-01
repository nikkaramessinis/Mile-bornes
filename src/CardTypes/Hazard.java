package CardTypes;
/**
 * 
 * @author Nick Karamessinis 3335
 *
 */

public class Hazard implements Card {
	private String name;

	/**
	 * Constructor 
	 * Postcondition: Creates an instance of a Hazard Card
	 * @param name
	 */
	public Hazard(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return name;

	}
}
