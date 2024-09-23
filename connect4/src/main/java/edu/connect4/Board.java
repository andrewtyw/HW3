package edu.connect4;

import java.util.Objects;

/**
 * The Board class represents a board in the Connect 4 game board.
 */
public class Board {
    private static final int WIDTH = 7, HEIGHT = 6;
    // all the directions when checking if 4 disks are connected
    private static final int[][] directions = new int[][]{
            {-1, 0}, {1, 0}, {0, 1}, {0, -1},
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
    };
    private final String[][] grid;
    private final int[] columnDiskCounts;

    /**
     * Constructor for the Board class.
     * Initializes the board with null values and the disk count per column.
     */
    public Board() {
        this.grid = new String[HEIGHT][WIDTH];
        this.columnDiskCounts = new int[WIDTH];
        resetBoard();
    }

    /**
     * A getter returns the board's grid for rendering
     * @return the grid field
     */
    public String[][] getGrid() {
        return grid;
    }

    /**
     * Makes a move for the player by dropping their disk into the specified column.
     *
     * @param player The player making the move.
     * @param column The column number of the grid where the disk is to be dropped.
     * @return true if the move was a success, else false if the given column is full
     * or out of bounds.
     */
    public boolean makeMove(Player player, int column) {
        if (isColumnFull(column) || column < 0 || column > HEIGHT) {
            return false;
        }
        columnDiskCounts[column]++;
        grid[HEIGHT - columnDiskCounts[column]][column] = player.getColor();
        return true;

    }


    /**
     * Checks whether the specified player has won the game by forming a line of 4
     * consecutive disks of their designated color on the board.
     * The line can be vertical, horizontal, or diagonal.
     *
     * @param player The player whose winning condition is being checked.
     * @return true if the player has successfully connected 4 disks in a row, else
     * returns false.
     */
    public boolean checkWin(Player player) {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (!Objects.equals(grid[i][j], player.getColor())) continue;
                // check if the current position is a start point for a 4-connected disk
                for (int[] direction : directions) {
                    int dx = direction[0], dy = direction[1];
                    boolean connected = true;
                    // check if the remaining 3 disks are connected in a certain direction
                    for (int k = 1; k <= 3; k++) {
                        int nextX = i - k * dx, nextY = j - k * dy;
                        if (!(
                                nextX >= 0 && nextY >= 0
                                        && nextX < HEIGHT && nextY < WIDTH
                                        && Objects.equals(grid[nextX][nextY], player.getColor()))
                        ) {
                            connected = false;
                            break;
                        }
                    }
                    if (connected) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Resets the game board to its initial state with all cells set to null.
     * Also resets the disk count for each column.
     */
    public void resetBoard() {
        // reset the board to null values
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                grid[i][j] = null;
            }
        }
        // reset the columnDiskCounts to 0s
        for (int i = 0; i < WIDTH; i++) {
            columnDiskCounts[i] = 0;
        }
    }

    /**
     * Checks if the board is full, meaning there are no more open spots for disks on
     * the board.
     *
     * @return true if the board is full, else false.
     */
    public boolean isBoardFull() {
        boolean isFull = true;
        for (int i = 0; i < WIDTH; i++) {
            if (columnDiskCounts[i] != HEIGHT) {
                isFull = false;
                break;
            }
        }
        return isFull;
    }

    /**
     * Checks if the column of the board is full, meaning there are no more open spots
     * in that column.
     *
     * @return true if the column is full, else false.
     * @throws IllegalArgumentException when the column is out of index
     */
    private boolean isColumnFull(int column) throws IllegalArgumentException{
        if(column>=WIDTH) {
            throw new IllegalArgumentException();
        }
        return columnDiskCounts[column] == HEIGHT;
    }
}
