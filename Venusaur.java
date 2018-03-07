/**
 * Venusaur Pokemon object class. 
 * Subclass of Ivysaur.
 * 
 * @author Lisa Miller
 * @version 1.0
 * @since 9/24/2016
 */
public class Venusaur extends Ivysaur {

	/** The minimum attack power for species. */
	static final int BASE_ATTACK_POWER = 198;
	/** The minimum defense power for species. */
	static final int BASE_DEFENSE_POWER = 200;
	/** The minimum stamina power for species. */
	static final int BASE_STAMINA_POWER = 160;

	/**
	 * Constructor with no name. uses Pokemon superclass constructor attacks
	 * must be set after contruction of Pokemon Object because of dependence on
	 * type interface
	 */
	public Venusaur() {
		super("Venusaur", "Venusaur", 3, 2.0, 100.0, BASE_ATTACK_POWER,
				BASE_DEFENSE_POWER, BASE_STAMINA_POWER);
	}

	/**
	 * Constructor with name. uses Pokemon superclass constructor attacks must
	 * be set after contruction of Pokemon Object because of dependence on type
	 * interface
	 * 
	 * @param name The user-defined name.
	 */
	public Venusaur(String name) {
		super("Venusaur", name, 3, 2.0, 100.0, BASE_ATTACK_POWER,
				BASE_DEFENSE_POWER, BASE_STAMINA_POWER);
	}
}
