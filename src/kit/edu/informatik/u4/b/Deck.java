package kit.edu.informatik.u4.b;

import java.util.Collections;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class Deck {
    private CopyOnWriteArrayList<String> initialize() {
        CopyOnWriteArrayList<String> deck = new CopyOnWriteArrayList<>();
        String values = "7-8-9-10-B-D-K-A";
        String suits = "E-L-H-S";
        for (String suit : suits.split("-")) {
            for (String value : values.split("-")) {
                deck.add(value + suit);
            }
        }
        return deck;
    }
    public CopyOnWriteArrayList<String> shuffle(long seed) {
        CopyOnWriteArrayList<String> deck = this.initialize();
        Collections.shuffle(deck, new Random(seed));
        return deck;
    }
}
