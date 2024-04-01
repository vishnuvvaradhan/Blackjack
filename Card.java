import java.util.*;

public class Card {

    /**
     * The value of the card.
     */
    private int value;

    /**
     * Constructs a card with the specified value.
     * @param val
     */
    public Card(int val) {
        if(val > 1 && val < 12){
        this.value = val;
        }
        else{
             System.out.println("Enter a Value Between 1 and 11.");
        }
        // Random rand = new Random();
        // int card_value = rand.nextInt(1, 14);
        // if(card_value > 10){
        //     val = 10;
        // }
        // else{
        //     val = card_value;
        // }
    }

    /**
     * Returns the value of the card.
     * @return the value of the card
     */
    public int getValue() {
        return value;
    }
    
    /**
     * Returns a string representation of this card.
     * @return a string representation of this card
     */
    public String toString() {
        return "" + value;
    }
}