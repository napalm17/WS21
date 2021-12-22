package kit.edu.informatik.u4.b;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;


/**
 * Models a game of Mau-Mau with its possible actions:
 * @author ugpsy
 * @version 1.0
 */
public class Game {

    private Deal deal;
    private Deck deck;
    private String openCard; // models the open card on the table
    private CopyOnWriteArrayList<CopyOnWriteArrayList<String>> players;
    private final CopyOnWriteArrayList<String> deckList; // an ArrayList that contains undealt cards.
    private boolean isGameOver;

    /**
     * Constructor that will help us initialize an instance of the game class
     * with a new shuffled deck and player hands.
     */
    public Game(long seed) {
        this.deck = new Deck();
        this.deal = new Deal(this.deck.shuffle(seed));
        this.deal.dealCards();
        this.deckList = this.deal.getDeck();
        this.players = this.deal.getPlayers();
        this.openCard = popNewCard(); // the first open card on the table is taken from the top of the deck.
        this.isGameOver = false; // set to false as default

    }

    /**
     * B.4.3: Shows the current status of the game.
     * @return The current open card on the table
     * and the number remaining cards in the deck.
     */
    public String showGame() {
        return this.openCard + " / " + this.deckList.size();
    }

    /**
     * B.4.4: Shows the hand of the player with the given index.
     * @param playerNo Index of the player
     * @return The hand of the player
     */
    public String showHand(int playerNo) {
        String hand = this.players.get(playerNo).toString();
        return hand.substring(1, hand.length() - 1).replaceAll(" ", "");
    }

    /**
     * B.4.4: Stacks a player's cards on the open card.
     * @param playerNo Index of the player.
     * @param card The card to be discarded.
     * @return The game over message, if player has discarded all its cards,
     * or an error message if the chosen card can't be stacked.
     */
    public String discard(int playerNo, String card) {
        if (canBeStacked(card) && this.players.get(playerNo).contains(card)) {
            this.openCard = card;
            this.players.get(playerNo).remove(card);
            if (this.players.get(playerNo).isEmpty()) {
                this.isGameOver = true;
                return "Game over : Player " + playerNo + " has won .";
            }
            return "";
        }
        return "Error, " + card + " cannot be stacked on " + this.openCard + ".";
    }

    /**
     * B.4.6: Picks a card from the top of the deck for the given player.
     * @param playerNo Index of the player who must pick a card.
     */
    public void pick(int playerNo) {
        String newCard = popNewCard();
        this.players.get(playerNo).add(newCard);
    }

    /**
     * Accessor method for the attribute isGameOver.
     * @return If the game is over or not.
     */
    public boolean isGameOver() {
        return this.isGameOver;
    }

    /**
     * A private helper method that checks whether given card can be stacked on top
     * the current card on the table.
     * @param card The card to be stacked.
     * @return Whether the card can be stacked on.
     */
    private boolean canBeStacked(String card) {
        boolean areSymbolsSame = splitCard(card)[0].equals(splitCard(this.openCard)[0]);
        boolean areSuitsSame = splitCard(card)[1].equals(splitCard(this.openCard)[1]);
        return areSymbolsSame || areSuitsSame;
    }

    /**
     * A private helper method that splits a given card into its two components,
     * namely its symbol and its suit.
     * @param card The card to be split into its components.
     * @return a String array that contains the symbol and the suit of the given card.
     */
    private String[] splitCard(String card) {
        return new String[]{card.substring(0, card.length() - 1), card.substring(card.length() - 1)};
    }

    /**
     * A private helper method pops the first card in the deck and returns it,
     * @return The first card in the deck.
     */
    private String popNewCard() {
        String firstCard = this.deckList.remove(0);
        if (this.deckList.isEmpty()) {
            System.out.print("Game over: Draw.\n"); // If the deck of remaining card is empty, then the game is over.
            this.isGameOver = true;
        }
        return firstCard;
    }
}
