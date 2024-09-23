package edu.connect4;

/**
 * This implementation represents the game of Connect 4, a two-player strategy game.
 * Each player chooses a color and then take turns dropping their disk into a 6 by 7 vertically suspended board.
 * Each player's objective is to form a line of four of their disks either horizontally, vertically, or diagonally while taking turns.
 * <p>
 * The game consists of three main classes:
 * 1. Player: Represents a player in the game. Stores their name and the color of their disks.
 * 2. Board: Manages the 6x7 vertically suspended board where the players drop their disks. Keeps track of the board and the disks it contains.
 * It checks for and carries out valid moves made by the players during each turn. Also checks whether or not a player has won.
 * 3. Game: Orchestrates the flow of the 2-player game by tying together the functionality of the Player and Board classes.
 * It manages the players' turns, facilitates move making, checks for wins or ties, and switches between the two players between every turn.
 * <p>
 * Each player takes a turn by dropping their disk into a specified column, and the game continues until either:
 * <p>
 * 1. A player connects four disks in a row horizontally, vertically, or diagonally. (There is a winner)
 * 2. The board is full, resulting in a tie. (There is no winner)
 * <p>
 * After the game ends, the winner can be retrieved if it exists.
 * <p>
 * Example Usage:
 * // Create two players
 * Player player1 = new Player("Emma", "Red");
 * Player player2 = new Player("Rob", "Yellow");
 * <p>
 * // Players take turns playing the game
 * g.play(0);          // Player 1 drops disk in column 0
 * g.checkGameOver(g);   // Check if the game is over
 * <p>
 * g.play(3);          // Player 2 drops disk in column 3
 * g.checkGameOver(g);   // Check again if the game is over
 * <p>
 * g.play(4);          // Player 1 drops disk in column 4
 * g.checkGameOver(g);   // Continue checking if the game is over
 * <p>
 * g.play(2);          // Players continue playing until the game ends
 * g.checkGameOver(g);   // Keep checking after every move...
 */


/**
 * The Game class manages the flow of the Connect 4 game.
 */
class Game {
    private final Board board;
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private Player winner;
    private boolean gameOver;

    /**
     * Constructor for the Game class.
     * Initializes a new game with two players and an empty board.
     *
     * @param p1 The first player who will take the initial turn in the game.
     * @param p2 The second player who will play after p1.
     */
    public Game(Player p1, Player p2) {
        this.board = new Board();
        this.player1 = p1;
        this.player2 = p2;
        this.winner = null;
        this.gameOver = false;
        this.currentPlayer = player1;
    }

    /**
     * Starts the game by emptying the board and setting current player to player 1.
     */
    public void startGame() {
        board.resetBoard();
        currentPlayer = player1;
    }

    /**
     * Executes a play for the current player by dropping a disk in the given column.
     * Move must be valid. Checks if the current player has won or if there is a tie.
     *
     * @param column The column number at which the current player wants to drop the
     * disk. Must be an integer between 0 and 6 inclusive.
     * @return true if the play is a success. false if the play is invalid (column is
     * full or out of bounds) or if there is a tie.
     */
    public boolean play(int column) {
        boolean madeMove = board.makeMove(currentPlayer, column);
        if (!madeMove) {
            return false;
        }
        if (board.checkWin(currentPlayer)) {
            gameOver = true;
            winner = currentPlayer;
        }
        boolean checkTie = board.isBoardFull();
        if (checkTie) {
            gameOver = true;
            winner = null;
            return false;
        }
        switchCurrentPlayer();
        return true;
    }

    /**
     * Retrieves the winner of the game.
     *
     * @return the winning Player or null if the game ended in a tie.
     */
    public Player getWinner() {
        return winner;
    }

    /**
     * Checks if the game is over. If the game is over,
     * it retrieves the winner and prints a message indicating
     * whether a player has won or if the game has resulted in a tie.
     *
     * @return true if the game is over otherwise return false.
     */
    public boolean checkGameOver() {
        if (gameOver) {
            Player winner = getWinner();
            if (winner != null) {
                System.out.println(winner.getName() + " wins!");
            } else {
                System.out.println("The game is a tie.");
            }
            return true;
        }
        return false;
    }


    /**
     * Switches the current player to the other player.
     */
    private void switchCurrentPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    /**
     * Retrieves the current grid of the board.
     * This method provides access to the current state of the Connect 4 board, represented as a 2D array of strings,
     * where each element contains either a player's disk (represented by their color) or null for empty spots.
     *
     * @return A 2D array of strings representing the current grid of the board.
     */
    public String[][] getBoardGrid() {
        return board.getGrid();
    }

    /**
     * Retrieves the player whose turn it currently is in the Connect 4 game.
     * This method returns the current player who is about to make a move. The game alternates
     * between the two players after each valid move.
     *
     * @return The Player object representing the current player whose turn it is.
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
}
