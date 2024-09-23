package edu.connect4;

/**
 * The Renderer class is used to render a board according to different clients.
 */
public class Renderer {
    /**
     * Renders the Connect 4 board grid as text. Each cell on the grid is represented by either a '-' for empty spaces
     * or the first letter of the player's disk color (e.g., 'R' for Red, 'Y' for Yellow). The column numbers (1-7)
     * are printed at the top to help players choose where to drop their disks.
     * @param boardGrid The current state of the Connect 4 board grid that will be rendered as text.
     */
    public static void renderByText(String[][] boardGrid) {

        // Print column headers (0-6)
        System.out.println(" 1  2  3  4  5  6  7 ");

        // Print each row of the grid
        for (String[] strings : boardGrid) {
            for (String string : strings) {
                if (string == null) {
                    System.out.print(" - ");
                } else {
                    System.out.print(" " + string.charAt(0) + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}
