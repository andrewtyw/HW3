package edu.connect4;
import java.util.Scanner;

/**
 * The TextBasedClient is a client for the Connect 4 game, it receives inputs such as
 * player's name and the location to drop the disc from the CLI. At each turn, it will
 * print out the current board using text. And it also gives prompts to guide the user
 * to play games.
 */
public class TextBasedClient {
    /**
     * The entrance for executing the text based client.
     * @param args the mandatory argument for the main function, and it is not used here.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize players
        System.out.println("Enter Player 1's name:");
        String player1Name = scanner.nextLine();
        Player player1 = new Player(player1Name, "Red");

        System.out.println("Enter Player 2's name:");
        String player2Name = scanner.nextLine();
        Player player2 = new Player(player2Name, "Yellow");

        // Initialize game
        Game game = new Game(player1, player2);
        game.startGame();

        System.out.println("Game started! " + player1.getColor() + " will go first.");

        boolean isGameOver = false;
        while (!isGameOver) {
            // Render the current board state for the players to see
            Renderer.renderByText(game.getBoardGrid());

            // Prompt current player for their move
            Player currentPlayer = game.getCurrentPlayer();
            System.out.println(currentPlayer.getName() + "'s turn! Enter column (1-7) to drop your disk:");

            int column;
            try {
                column = Integer.parseInt(scanner.nextLine()) - 1; // Convert 1-7 input to 0-6 for indexing
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid column number (1-7).");
                continue;
            }

            // Attempt to make the move
            boolean moveSuccessful = game.play(column);
            if (!moveSuccessful) {
                System.out.println("Invalid move! The column may be full or out of bounds. Try again.");
                continue;
            }

            // Check if the game is over after the move
            isGameOver = game.checkGameOver();
        }

        // Display final board and result
        Renderer.renderByText(game.getBoardGrid());
        Player winner = game.getWinner();
        if (winner != null) {
            System.out.println("Congratulations, " + winner.getName() + "! You win!");
        } else {
            System.out.println("It's a tie!");
        }

        scanner.close();
    }
}
