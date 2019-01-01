package CardTypes;
/**
 * 
 * @author Nick Karamessinis 3335
 *
 */
public class Remedy implements Card {
	private String name;
/**
 * Constructor Remedy
 * Postcondition:Creates an instance of a Remedy Card
 * @param name
 */
	public Remedy(String name) {
		this.setName(name);
	}
/**
 * Accessor get private String name
 * @return
 */
	public String getName() {
		return name;
	}
/**
 * <b>Transformer:</b> sets the card's name
 * <b>Postcondition:</b> the card's name is set
 * @param name
 */
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return name;

	}

}
