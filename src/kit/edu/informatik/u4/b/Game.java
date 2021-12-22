package kit.edu.informatik.u4.b;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;


public class Game {

    private Deal deal;
    private Deck deck;
    private String openCard;
    private CopyOnWriteArrayList<CopyOnWriteArrayList<String>> players;
    private final CopyOnWriteArrayList<String> deckList;
    private CopyOnWriteArrayList<String> copy;
    private long seed;
    private boolean isGameOver;
    private Iterator<String> iterator;

    public Game(long seed) {
        this.seed = seed;
        this.deck = new Deck();
        this.deal = new Deal(this.deck.shuffle(this.seed));
        this.deal.dealCards();
        this.deckList = this.deal.getDeck();
        this.iterator = this.deckList.iterator();
        this.players = this.deal.getPlayers();
        this.openCard = popNewCard();
        this.isGameOver = false;

    }
    public String showGame() {
        return this.openCard + " / " + this.deckList.size();
    }

    public String showHand(int playerNo) {
        String hand = this.players.get(playerNo).toString();
        return hand.substring(1, hand.length() - 1).replaceAll(" ", "");
    }

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

    public void pick(int playerNo) {
        String newCard = popNewCard();
        this.players.get(playerNo).add(newCard);
    }

    public boolean isGameOver() {
        return this.isGameOver;
    }
    private boolean canBeStacked(String card) {
        boolean areSymbolsSame = splitCard(card)[0].equals(splitCard(this.openCard)[0]);
        boolean areSuitsSame = splitCard(card)[1].equals(splitCard(this.openCard)[1]);
        return areSymbolsSame || areSuitsSame;
    }

    private String[] splitCard(String card) {
        return new String[]{card.substring(0, card.length() - 1), card.substring(card.length() - 1)};
    }

    private String popNewCard() {
        String firstCard = this.deckList.remove(0);
        if (this.deckList.isEmpty()) {
            System.out.print("Game over: Draw.\n");
            this.isGameOver = true;
        }
        return firstCard;
    }
}
