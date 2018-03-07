/**
 * Blastoise Pokemone object .
 * Subclass of Wartortle.
 * 
 * @author Bob Cardinalli from:
 * @author Lisa Miller
 * @since 04 Feb 18
 * 
 */
public class Blastoise extends Wartortle {

	/** The minimum attack power for species. */
	static final int BASE_ATTACK_POWER = 171;
	/** The minimum defense power for species. */
	static final int BASE_DEFENSE_POWER = 210;
	/** The minimum stamina power for species. */
	static final int BASE_STAMINA_POWER = 158;

	/**
	 * Constructor with no name. uses Pokemon superclass constructor attacks
	 * must be set after contruction of Pokemon Object because of dependence on
	 * type interface
	 */
	public Blastoise() {
		super("Blastoise", "Blastoise", 9, 1.6, 85.5, BASE_ATTACK_POWER,
				BASE_DEFENSE_POWER, BASE_STAMINA_POWER);
	}

	/**
	 * Constructor with name. uses Pokemon superclass constructor attacks must
	 * be set after contruction of Pokemon Object because of dependence on type
	 * interface
	 * 
	 * @param name The user-defined name.
	 */
	public Blastoise(String name) {
		super("Blastoise", name, 9, 1.6, 85.5, BASE_ATTACK_POWER,
				BASE_DEFENSE_POWER, BASE_STAMINA_POWER);
	}

} // end of class
