package kit.edu.informatik.u4.b;

import java.util.concurrent.CopyOnWriteArrayList;


/**
 * Models the pre-game activity of dealing the cards to the players:
 * @author ugpsy
 * @version 1.0
 */
public class Deal {
    private CopyOnWriteArrayList<CopyOnWriteArrayList<String>> players;
    private CopyOnWriteArrayList<String> deck;

    /**
     * Constructor that will help us initialize an instance of the Deal class
     * with a given shuffled deck and arrayList of players.
     */
    public Deal(CopyOnWriteArrayList<String> deck) {
        this.deck = deck;
        this.players = new CopyOnWriteArrayList<>();
    }

    /**
     * B.3: Deals the cards in the shuffled deck to the 4 players by giving them 5 cards each.
     * The dealt cards are removed from the original deck
     */
    public void dealCards() {
        for (int i = 0; i < 4; i++) { // goes through player indexes
            this.players.add(new CopyOnWriteArrayList<>());
            for (int j = 0; j < 5; j++) { // goes through five card indexes
                String card = this.deck.remove(0);
                this.players.get(i).add(card);
            }
        }
    }

    /**
     * Getter method for the players of the game.
     * @return an ArrayList that contains 4 ArrayLists
     * which contain the respective player's cards as String variables.
     */
    public CopyOnWriteArrayList<CopyOnWriteArrayList<String>> getPlayers() {
        return this.players;
    }

    /**
     * Getter method for the deck of remaining cards.
     * @return An ArrayList that contains the remaining cards in the deck.
     */
    public CopyOnWriteArrayList<String> getDeck() {
        return this.deck;
    }
}
