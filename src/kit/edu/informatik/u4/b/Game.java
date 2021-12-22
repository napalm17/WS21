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
        this.openCard = popFirstCard();
        this.isGameOver = false;

    }
    public String showGame() {
        return this.openCard + " / " + this.deckList.size();
    }

    public String showHand(int playerNo) {
        return this.players.get(playerNo).toString();
    }

    public String discard(int playerNo, String card) {

        if (canBeStacked(card) && this.players.get(playerNo).contains(card)) {
            this.openCard = card;
            this.players.get(playerNo).remove(card);
            if (this.players.get(playerNo).size() == 0) {
                this.isGameOver = true;
                return "Game over : Player < Nummer > has won .";
            }
            System.out.println(this.players);
            return "";
        }
        return "Error, " + card + " cannot be stacked on" + this.openCard + ".";
    }

    public String pick(int playerNo) {
        String newCard = popFirstCard();
        this.players.get(playerNo).add(newCard);
        return "";
    }
    public boolean isGameOver() {
        return this.isGameOver;
    }
    private boolean canBeStacked(String card) {
        String[] c = card.split("");
        String[] oC = this.openCard.split("");
        System.out.println(c[0] + c[1]);
        System.out.println(oC[0] + oC[1]);
        return c[0].equals(oC[0]) || c[1].equals(oC[1]);
    }
    private String popFirstCard() {
        String firstCard = this.deckList.remove(0);
        if (this.deckList.size() == 0) {
            System.out.print("Game over: Draw.\n");
            this.isGameOver = true;
        }
        return firstCard;
    }
}
