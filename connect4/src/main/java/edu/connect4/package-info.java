/**
 * <h1>Connect4 API</h1>
 * 
 * This API represents the game of Connect 4, a two-player strategy game. Each player chooses a color 
 * and then takes turns dropping their disk into a 6 by 7 vertically suspended board. The objective is to form a line 
 * of four disks horizontally, vertically, or diagonally while taking turns.
 * 
 * <h2>Classes Overview</h2>
 * The game consists of three main classes:
 * <ul>
 *   <li><b>Player:</b> Represents a player in the game, storing their name and the color of their disks.</li>
 *   <li><b>Board:</b> Manages the 6x7 vertically suspended board where the players drop their disks. It checks and manages valid moves and tracks the state of the board.</li>
 *   <li><b>Game:</b> Orchestrates the flow of the game by managing turns, moves, win/tie checks, and switching between players.</li>
 * </ul>
 * 
 * <h2>Game Rules</h2>
 * Each player takes a turn by dropping their disk into a specified column, and the game continues until either:
 * <ul>
 *   <li>A player connects four disks in a row horizontally, vertically, or diagonally. (There is a winner)</li>
 *   <li>The board is full, resulting in a tie. (There is no winner)</li>
 * </ul>
 * After the game ends, the winner can be retrieved if it exists.
 * 
 * <h2>Example Usage</h2>
 * <pre>{@code
 * // Create two players
 * Player player1 = new Player("Emma", "Red");
 * Player player2 = new Player("Rob", "Yellow");
 * 
 * // Initialize the game
 * Game g = new Game(player1, player2);
 * g.startGame();
 * 
 * // Players take turns playing the game
 * g.play(0);          // Player 1 drops disk in column 0
 * g.checkGameOver();  // Check if the game is over
 * 
 * g.play(3);          // Player 2 drops disk in column 3
 * g.checkGameOver();  // Check again if the game is over
 * 
 * g.play(4);          // Player 1 drops disk in column 4
 * g.checkGameOver();  // Continue checking if the game is over
 * 
 * g.play(2);          // Players continue playing until the game ends
 * g.checkGameOver();  // Keep checking after every move...
 * 
 * ...
 * 
 * g.getWinner(); // returns the winning player
 * }
 * </pre>
 * 
 * 
 * <h2>Example of running the TextBasedClient</h2>
 * The Connect 4 API also comes with a text-based client that can be used to play the game via the command line.
 * 
 * <pre>{@code
 * // Run the program in a terminal or IDE
 * // Enter Player 1's and Player 2's names
 * Enter Player 1's name:
 * >> Alice
 * 
 * Enter Player 2's name:
 * >> Bob
 * 
 * Game started! Red will go first.
 * 1  2  3  4  5  6  7 
 * -  -  -  -  -  -  - 
 * -  -  -  -  -  -  - 
 * -  -  -  -  -  -  -
 * -  -  -  -  -  -  - 
 * -  -  -  -  -  -  - 
 * -  -  -  -  -  -  -
 * 
 * Alice's turn! Enter column (1-7) to drop your disc:
 * >> 3
 * 1  2  3  4  5  6  7 
 * -  -  -  -  -  -  - 
 * -  -  -  -  -  -  - 
 * -  -  -  -  -  -  -
 * -  -  -  -  -  -  - 
 * -  -  -  -  -  -  - 
 * -  -  R  -  -  -  -   
 * 
 * Bob's turn! Enter column (1-7) to drop your disc:
 * >> 4
 * 1  2  3  4  5  6  7 
 * -  -  -  -  -  -  - 
 * -  -  -  -  -  -  - 
 * -  -  -  -  -  -  -
 * -  -  -  -  -  -  - 
 * -  -  -  -  -  -  - 
 * -  -  R  Y  -  -  -   
 * 
 * ...
 * 
 * Alice's turn! Enter column (1-7) to drop your disc:
 * >> 3
 * 1  2  3  4  5  6  7 
 * -  -  -  -  -  -  - 
 * -  -  -  -  -  -  - 
 * -  -  R  -  -  -  -
 * -  -  R  -  -  -  - 
 * -  -  R  -  -  -  - 
 * Y  Y  R  Y  Y  -  -   
 * 
 * Congratulations, Alice! You win!
 * }</pre>
 */
package edu.connect4;
