package edu.connect4;

/**
 * The Player class represents a player in the Connect 4 game.
 */
public class Player {
    private final String color;
    private final String name;

    /**
     * Constructor for the Player class.
     *
     * @param name  The name of the player.
     * @param color The color of the player's disks.
     */
    public Player(String name, String color) {
        this.name = name;
        this.color = color;
    }

    /**
     * Returns the color of the player's disks.
     *
     * @return A string representing the player's disk color.
     */
    public String getColor() {
        return color;
    }

    /**
     * Returns the player's name
     *
     * @return A string representing the player's name.
     */
    public String getName() {
        return name;
    }
}
