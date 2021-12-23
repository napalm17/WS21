package kit.edu.informatik.u4.b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Models a deck of cards for the game of Mau-Mau
 * @author ugpsy
 * @version 1.0
 */
public class Deck {

    /**
     * B.1: Creates "a German Deck" with 32 cards in order.
     * @return an ArrayList that contains all 32 cards of the deck as String variables.
     */
    private ArrayList<String> initialize() {
        ArrayList<String> deck = new ArrayList<>();
        String values = "7-8-9-@-B-D-K-A";
        String suits = "E-L-H-S";
        for (String suit : suits.split("-")) {
            for (String value : values.split("-")) {
                deck.add(value + suit);
            }
        }
        return deck;
    }

    /**
     * B.2: Shuffles the deck of cards.
     * @param seed A long variable that will help generate a random seed
     *             so that the deck can be pseudo-randomly shuffled.
     * @return The shuffled deck of cards.
     */
    public ArrayList<String> shuffle(long seed) {
        ArrayList<String> deck = this.initialize();
        Collections.shuffle(deck, new Random(seed));
        return deck;
    }
}
