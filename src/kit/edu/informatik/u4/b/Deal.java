package kit.edu.informatik.u4.b;

import java.util.concurrent.CopyOnWriteArrayList;

public class Deal {
    private CopyOnWriteArrayList<CopyOnWriteArrayList<String>> players;
    private CopyOnWriteArrayList<String> deck;

    public Deal(CopyOnWriteArrayList<String> deck) {
        this.deck = deck;
        this.players = new CopyOnWriteArrayList<>();
    }
    public  void dealCards() {
        for (int i = 0; i < 4; i++) {
            this.players.add(new CopyOnWriteArrayList<>());
            for (int j = 0; j < 5; j++) {
                String card = this.deck.remove(0);
                this.players.get(i).add(card);
            }
        }
    }
    public CopyOnWriteArrayList<CopyOnWriteArrayList<String>> getPlayers() {
        return this.players;
    }
    public CopyOnWriteArrayList<String> getDeck() {
        return this.deck;
    }
}
