/**
 * 
 * @author Dre
 * @since 06 Mar 2018
 * @version 1.1
 * 
 * Trainer.java is used by PokeBattle.java.
 * -the class defines a trainer which can battle
 * 
 * a trainer has a pokemon
 * a trainer may pass
 * 
 *
 */
class Trainer {

	// used to track a trainers passes
	protected int passCount = 0;

	// assigns trainer default number
	protected static int number = 0;

	protected String name = "";

	// null pokemon
	protected Pokemon mon = null;

	/**
	 * constructor, provides trainer with default name.
	 */
	Trainer() {

		this.number++;

		this.name = "Trainer " + number;
	}

	/**
	 * @param mon
	 *            the chosen pokemon
	 */
	void setMon(Pokemon chosenMon) {

		this.mon = chosenMon;

	}

}
