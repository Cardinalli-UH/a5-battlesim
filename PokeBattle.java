
import java.util.Scanner;

/**
 * @author Robert Cardinalli
 * @since 06 Mar 2018
 * @version 1.0
 */
public class PokeBattle {

	/**
	 * method table of contents:
	 * main method -
	 * switchBoard() -main menu controls
	 * printChoices() -displays Pokemon
	 * printChosen() -displays Player's chosen Pokemon
	 * selectMon() -everything assigning Pokemon to Player
	 * takeName() -lets Player name Pokemon (inside selectMon())
	 * battleSim() -Creates, Maintains, and Terminates battle sequence
	 * battleMenu() -displays attack round options
	 * battleChoice() -handles user choice at battleMenu()
	 * damageTracker() -displays damage dealt and defenders remaining HP
	 * victoryCheck() -checks if victory conditions met (inside battleSim())
	 */

	/** used in switch statements. */
	protected static String choice = new String("");

	/** scanner install. */
	protected static Scanner input = new Scanner(System.in);

	/**
	 * Main Method.
	 * creates two trainers to battle
	 * prints main menu
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {

		// creates Trainers(Players)
		Trainer p1 = new Trainer();
		Trainer p2 = new Trainer();

		do {

			System.out.println("************MAIN MENU************");
			System.out.println("1:  Choose Pokemon for Trainer 1");
			System.out.println("2:  Choose Pokemon for Trainer 2");
			System.out.println("3:  Battle");
			System.out.println("4:  View Stats for Chosen Pokemon");

			choice = input.nextLine();

			// main menu controls
			switchBoard(p1, p2);

		} while (true);

	} // end of main driver

	/**
	 * @param p1
	 *            player 1
	 * @param p2
	 *            player 2
	 */
	static void switchBoard(Trainer p1, Trainer p2) {

		switch (choice) {

			case "1":

				// displays possible Pokemon
				printChoices();
				// selects pokemon for player 2
				selectMon(p1);

				break;

			case "2":

				// displays possible Pokemon
				printChoices();
				// selects pokemon for player 2
				selectMon(p2);

				break;

			case "3":

				// commences battle if both players have chosen Pokemon
				if (p1.mon == null || p2.mon == null) {
					System.out.println(
							"\nBoth players must choose a Pokemon to battle!\n");
				} else {

					battleBorder();

					// starts the fight
					battleSim(p1, p2);
				}

				break;

			case "4":

				// display each players chosen pokemon
				printChosen(p1);
				printChosen(p2);

				break;

			default:
				// if (!choice.matches("0")) {
				System.out.println(
						"\nInvalid selection, please enter 1, 2, 3, or 4.\n"
								+ "Sorry, you cannot exit program.  "
								+ "\n\n          POKE'DEATHMATCH FOOL!!!\n\n");
				// }

				break;
		}

		promptEnter();

	}

	/**
	 * Displays Pokemon available for battle.
	 */

	static void printChoices() {

		String menu = new String("");

		menu += "Choose your Pokemon, mon!\n";

		menu += "1. Bulbasaur\n";
		menu += "2. Ivysaur\n";
		menu += "3. Venusaur\n";
		menu += "4. Charmander\n";
		menu += "5. Charmeleon\n";
		menu += "6. Charizard\n";
		menu += "7. Squirtle\n";
		menu += "8. Wartortle\n";
		menu += "9. Blastoise\n";

		menu += "\nOr make any other entry to go back.";

		System.out.println(menu);

	}

	/**
	 * Displays toString() of the player's chosen Pokemon.
	 * -returns error message if player hasn't chosen a Pokemon
	 * 
	 * @param p
	 *            the relevant player
	 */
	static void printChosen(Trainer p) {

		
		preRoundBorder();

		if (p.mon != null) {
			System.out
					.println("\n" + p.name + "'s Pokemon:" + p.mon.toString());
		} else {
			System.out.println(
					"**" + p.name + " has not chosen a Pokemon.**\n\n");
		}

	}

	/**
	 * Creates and assigns a Pokemon to the relevant player.
	 * 
	 * @param p
	 *            the relevant player
	 */
	public static void selectMon(Trainer p) {

		Pokemon mon = null;

		choice = input.nextLine();

		switch (choice) {

			case "1":
				mon = new Bulbasaur();
				break;
			case "2":
				mon = new Ivysaur();
				break;
			case "3":
				mon = new Venusaur();
				break;
			case "4":
				mon = new Charmander();
				break;
			case "5":
				mon = new Charmeleon();
				break;
			case "6":
				mon = new Charizard();
				break;
			case "7":
				mon = new Squirtle();
				break;
			case "8":
				mon = new Wartortle();
				break;
			case "9":
				mon = new Blastoise();
				break;
			default: // if user enters anything other than ints 1-9

				System.out.println("Returning to main menu..\n");
				break;
		}

		// displays the chosen Pokemon, or that player did not choose one

		if (mon != null) {

			// prompts user to enter Pokemon name
			takeName(p, mon);
			postRoundBorder();

			p.mon = mon;

			// displays: [Player] has chosen [Pokemon]
			System.out.println(
					"\n" + p.name + " has chosen " + mon.species + ".\n");

			// displays Pokemon
			System.out.println(mon.species + "'s stats: \n " + mon);

		} else { // Player did not choose a Pokemon; returns to Main Menu
			System.out.println(p.name + " did not choose a Pokemon!\n");
		}

		System.out.println();
	}

	/**
	 * Asks user for Pokemon name; used in selectMon().
	 * 
	 * @param p
	 *            the player
	 * @param mon
	 *            the pokemon
	 */
	public static void takeName(Trainer p, Pokemon mon) {

		System.out.println("\nCongrats " + p.name + "! You have chosen "
				+ mon.getSpecies() + " as your Pokemon!");
		System.out.println(
				"\nGo ahead and give your " + mon.getSpecies() + " a name!");
		System.out.println("(..or just press enter to skip naming)");
		String n = input.nextLine();

		/**
		 * if statement checks whether there is any user input for name,
		 * -any input will become pokemon's name
		 * -empty string skips naming, returns user to main menu
		 */
		if (!n.isEmpty()) {
			mon.setName(n);
		}
	}

	/**
	 * This method simulates a battle.
	 * 1) Flips a coin to see which player goes first
	 * -assigns players as "first" and "second" with if-statement
	 * 2) Rotates Battle-Rounds
	 * -boolean oddTurn starts true with "first" trainer's turn
	 * 3) Recognizes victory conditions and prints victory message
	 * -victoryCheck() method is called
	 * 
	 * @param p1
	 *            player 1
	 * @param p2
	 *            player 2
	 */
	public static void battleSim(Trainer p1, Trainer p2) {

		// Part 1

		int coinToss = (int) (Math.random() * 2);

		Trainer first = null;
		Trainer second = null;

		boolean oddTurn = true;

		if (coinToss == 0) {
			first = p1;
			second = p2;
		} else {
			first = p2;
			second = p1;
		}

		System.out.println(first.name + " will begin!");

		/**
		 * Part 2.
		 * -maintains sequence of battle
		 * -relies on boolean oddTurn (flips after each round)
		 */

		while (first.mon.getHP() > 0 && second.mon.getHP() > 0) {

			if (oddTurn) {

				battleChoice(first, second);

			} else {

				battleChoice(second, first);

			}

			// flip trigger
			oddTurn = !oddTurn;
		}

		// Part 3 calls victoryCheck methods for each case

		victoryCheck(p1, p2);

		victoryCheck(p2, p1);

	} // end of battle simulation method

	/**
	 * Prints battle UI.
	 * -displays attacking Pokemon's HP
	 * -displays defending Pokemon's HP
	 * -battle options:
	 * 1. fast attack
	 * 2. special attack
	 * 3. pass
	 * 
	 * @param attacker
	 *            the attacking trainer
	 * @param defender
	 *            the defending trainer
	 */
	public static void battleMenu(Trainer attacker, Trainer defender) {

		String menu = new String();

		menu += "\n";
		menu += attacker.mon.name + "'s current HP: " + attacker.mon.hP + "\n";

		menu += "Enemy ";
		menu += defender.mon.name + "'s current HP: " + defender.mon.hP + "\n";

		menu += "\n\n";

		menu += attacker.name + " choose what your " + attacker.mon.name
				+ " will do:\n";

		menu += "\n1. Fast Attack";

		menu += "\n2. Special Attack (" + attacker.passCount
				+ "/3 required passes)";

		menu += "\n3. Pass";

		System.out.println(menu);

	}

	/**
	 * **CORE FUNCTIONS OF BATTLE** .
	 * Takes in choice from battleMenu
	 * 
	 * @param attacker
	 *            the attacking trainer
	 * @param defender
	 *            the defending trainer
	 */
	public static void battleChoice(Trainer attacker, Trainer defender) {

		// tracks if player tried special attack without enough passes
		boolean specialFail;

		// tracks if player gave an invalid input
		boolean invalidTrig;

		do { // loops if special attack fails, or input is invalid

			battleMenu(attacker, defender);

			specialFail = false;
			invalidTrig = false;

			choice = input.nextLine();

			// takes in defending pokemon's HP to calculate damage each round
			int startingHP = defender.mon.getHP();

			preRoundBorder();

			switch (choice) {

				case "1": // fast attack

					// randomizes Pokemon's attack
					attacker.mon.chooseFastAttack();

					// performs a fast attack, prints accompanying message
					System.out.println(
							attacker.mon.performFastAttack(defender.mon));

					// displays damage done, and remaining HP
					damageTracker(attacker, defender, startingHP);

					break;

				case "2": // special attack (needs 3 passes)

					// checks if special attack requirements are met
					if (attacker.passCount >= 3) {

						// choose special attack
						attacker.mon.chooseSpecialAttack();

						// performs a special attack, prints accompanying
						// message
						System.out.println(attacker.mon
								.performSpecialAttack(defender.mon));

						// displays damage done, and remaining HP
						damageTracker(attacker, defender, startingHP);

						// deducts passes from trainer on successful attack
						attacker.passCount -= 3;
						System.out.println(
								attacker.passCount + " pass(es) remaining.");

					} else { // ridicules player for not knowing how to count

						System.out.println("Not enough passes sucka!");
						specialFail = true;
					}

					break;

				case "3": // pass

					// increases attacker's pass count
					attacker.passCount++;

					// displays attackers current passes
					System.out.println(attacker.name + " has passed; "
							+ attacker.name + " has saved " + attacker.passCount
							+ " pass(es).");

					break;

				default:

					System.out
							.println("Invalid:  Trainer must attack or pass.");

					invalidTrig = true;

					break;

			}

			postRoundBorder();
			promptEnter();

			/**
			 * if a special attack fails, or invalid input is given menu loops
			 * to the start of the round
			 */

		} while (specialFail || invalidTrig);

	}

	/**
	 * tracks how much damage is being done in a round.
	 * -displays damage done to defender
	 * -displays defenders remaining hp
	 * 
	 * @param attacker
	 *            the attacking trainer
	 * @param defender
	 *            the defending trainer
	 * @param startingHP
	 *            the defending pokemon's HP at the start of the round
	 */

	static void damageTracker(Trainer attacker, Trainer defender,
			int startingHP) {

		// displays damage done to defending Pokemon
		System.out.println(attacker.mon.name + "'s attack dealt "
				+ (startingHP - defender.mon.hP) + " damage to "
				+ defender.mon.name);

		// displays defending Pokemon's remaining HP
		System.out.println(
				defender.mon.name + " has " + defender.mon.hP + " HP left.");
	}

	/**
	 * Is called after each battle round.
	 * -verifies victory conditions meant
	 * -prints victory banner to winner
	 * 
	 * @param p1
	 *            the potential winner
	 * @param p2
	 *            the potential loser
	 */
	static void victoryCheck(Trainer p1, Trainer p2) {

		if (p2.mon.hP == 0) {

			System.out.println(
					"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println(
					"~                                                   ~");
			System.out.println(
					"~     Congrats " + p1.name + " you have won!          ~");
			System.out.println(
					"~                                                   ~");
			System.out.println(
					"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.exit(0);
		}
	}

	/**
	 * beyond here are print methods used for borders/display purposes only.
	 */
	static void battleBorder() {
		System.out.println("************************************************");
		System.out.println("=======!!!COMMENCE POKE'MORTAL KOMBAT!!!========");
		System.out.println("************************************************");

	}

	static void preRoundBorder() {

		System.out.println(
				"\n************************************************\n");
	}

	static void postRoundBorder() {

		System.out.println(
				"\n================================================\n");
	}

	/**
	 * inserted in various areas of the program to control pace.
	 * -prevents program from blasting users with walls of text
	 */
	static void promptEnter() {

		System.out.println("...press Enter to continue.");
		input.nextLine();
	}
}
