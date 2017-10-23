# InteractivePokemonGame
## Points
 * 100 points for the game code.
   * **Due Wed 11/1**
 * 20 points for writing a code review.
   * **Code reviews will be done in class Mon 10/30. Your game should be somewhat working**
 * 20 for using code reviewer suggestions.
 
 ## Instructions
 * Build a two player PokemonBattle game/main method using your Pokemon object classes.
   * Two players will alternate turns on the same computer.
   
### Game Phase 1 - Game Setup
  * In the first phase of the game, each player will choose a Pokemon. There should be a menu offered to each player to choose one Pokemon to battle with.
    * This will be similar to your menu for choosing Pokemon in Assignment 4.
    * The program should ask Player 1 to choose their Pokemon, then save it, and give an acknowledgement message.
    * Then it should ask Player 2 to choose their Pokemon, save it, and give an acknowledgement message.
  * After both Pokemon are chosen, the game should randomly choose which Player goes first.
### Game Phase 2 - Battling
 * In the second (main game play) phase of the game, the two players should alternate entering commands to attack until one Pokemon "faints" (reaches 0 HP).
 * The program should say something like: "It is Player 1's turn, what do you want to do?"
 * The options each player has during their turn should be:
   * perform fastAttack
   * perform specialAttack
   * pass 
   
 * fastAttack and pass are always allowed. 
 * A player must "pass" three times inorder to build up energy for a specialAttack.
   * You will have to develop a way to keep track of how many passes a player has made and when to allow the specialAttack as this is not part of the Pokemon objects.
   * After specialAttack is performed, the amount of accumulated passes should be reduced by 3.
 * The attacking functionality should use the Pokemon's performFastAttack and performSpecialAttack methods. The attacking player's Pokemon will call the method, with the other player's Pokemon as the "victim" parameter Pokemon.
  * The String returned by these methods should print to the screen.
 
 * You'll have to build a way to check the victim Pokemon's HP (hitPnts) after being attacked. This will be the sentinel value for the battle loop.
   * Once a Pokemon has its hitPnts reduced to 0, that signals the end of the game, with the other player as the winner.
 
### Game Phase 3 - Game Over
 * Once a player's Pokemon has fainted, the game should end and print out a congratulatory message to the winner.

### Assignment 5 Grading
----

- [x] **20/20** Menu for both players to pick their Pokemon
- [x] **20/20** Alternating turns
- [x] **20/20** Implementation of "passing" to charge Special Attack
- [x] **20/20** Tracking of HP, correct win/lose calculation.
- [x] **20/20** Comments, coding style, documentation.
