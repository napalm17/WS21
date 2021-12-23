package kit.edu.informatik.u4.b;

import java.util.ArrayList;
import java.util.Collections;


/**
 * Models the pre-game activity of dealing the cards to the players:
 * @author ugpsy
 * @version 1.0
 */
public class Deal {
    private ArrayList<ArrayList<String>> players;
    private ArrayList<String> deck;

    /**
     * Constructor that will help us initialize an instance of the Deal class
     * with a given shuffled deck and arrayList of players.
     */
    public Deal(ArrayList<String> deck) {
        this.deck = deck;
        this.players = new ArrayList<>();
    }

    /**
     * B.3: Deals the cards in the shuffled deck to the 4 players by giving them 5 cards each.
     * The dealt cards are removed from the original deck
     */
    public void dealCards() {
        for (int i = 0; i < 4; i++) { // goes through player indexes
            this.players.add(new ArrayList<>());
            for (int j = 0; j < 5; j++) { // goes through five card indexes
                String card = this.deck.remove(0);
                this.players.get(i).add(card);
            }
            Collections.sort(this.players.get(i));
        }
    }

    /**
     * Getter method for the players of the game.
     * @return an ArrayList that contains 4 ArrayLists
     * which contain the respective player's cards as String variables.
     */
    public ArrayList<ArrayList<String>> getPlayers() {
        return this.players;
    }

    /**
     * Getter method for the deck of remaining cards.
     * @return An ArrayList that contains the remaining cards in the deck.
     */
    public ArrayList<String> getDeck() {
        return this.deck;
    }
}
