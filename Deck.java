import java.util.ArrayList;
import java.util.Random;

public class Deck {

    private ArrayList<Card> Deck;

    /**
     * Creates the underlying deck as an ArrayList of Card objects. 
     * Calls build() as a subroutine to build the deck itself.
     */
    public Deck() {
        Deck = new ArrayList<Card>();
        build();
    }

    /**
     * Builds the underlying deck as a standard 52 card deck. 
     * Replaces any current deck stored. 
     */
    public void build() {
        Deck.clear();

        for (int i = 2; i < 12; i++) {
            if(i != 10){
            for (int j = 0; j < 4; j++) {
                Deck.add(new Card(i));
            }
        }
        }
        for (int i = 0; i < 16; i++) {
            Deck.add(new Card(10));
        }
    }

    /**
     * Returns the number of cards left in the deck. 
     * @return the number of cards left in the deck
     */
    public int size() {
        return Deck.size();
    }

    /**
     * Returns and removes the first card of the deck.
     * @return the first card of the deck
     */
    public Card deal() {
        return Deck.removeFirst();
    }

    /**
     * Shuffles the cards currently in the deck. 
     */
    public void shuffle() {
        Random random = new Random();
        for (int i = 0; i < Deck.size(); i++) {
            // Generate a random index to swap with
            int randomIndex = random.nextInt(Deck.size());
            // Swap the cards at i and randomIndex
            Card temp = Deck.get(i);
            Deck.set(i, Deck.get(randomIndex));
            Deck.set(randomIndex, temp);
        }
    }
        
    

    /**
     * Returns a string representation of the deck.
     * @return a string representation of the deck
     */
    public String toString() {
        return "" + Deck;
    }
}