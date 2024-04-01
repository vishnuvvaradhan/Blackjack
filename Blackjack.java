
/*
file name:      Blackjack.java
Authors:        Vishnu
last modified:  02/25/2024

How to run:     java Blackjack
Purpose: Utilize other objects we created to make a functioning blackjack game.
*/






import java.util.Scanner;
import java.util.random.*;



public class Blackjack {
    private int reshuffleCutoff;
    private Hand playerHand;
    private Hand dealerHand;
    private Deck newDeck;
    private double playerBalance;
    private double currentBet;
    
    
    /**
     * Constructs a Blackjack game with a specified reshuffle cutoff and initial player balance.
     * Initializes the player and dealer hands, and creates a new deck of cards.
     *
     * @param reshuffleCutoff The deck card count at which the deck should be reshuffled.
     * @param initialBalance  The initial balance of the player.
     */
    public Blackjack(int reshuffleCutoff, double initialBalance){
        this.reshuffleCutoff = reshuffleCutoff;
        playerHand = new Hand();
        dealerHand = new Hand();
        newDeck = new Deck();
        this.playerBalance = initialBalance;
    }



    /**
     * Constructs a Blackjack game with default reshuffle cutoff and initial player balance.
     */
    public Blackjack(){
        this(26, 1000);
    }


    /**
     * Returns the current hand of the player.
     *
     * @return The player's hand.
     */
    public Hand getPlayerHand(){
        return playerHand;
    }



     /**
     * Returns the current hand of the dealer.
     *
     * @return The dealer's hand.
     */
    public Hand getDealerHand(){
        return dealerHand;
    }

    /**
     * Resets the game for a new round. Clears both player and dealer hands.
     * If the deck's card count is below the reshuffle cutoff, a new shuffled deck is created.
     */
    public void reset(){
        playerHand.reset();
        dealerHand.reset();
        if(newDeck.size() < reshuffleCutoff){
            newDeck.build();
        }
    }

   
    /**
     * Deals two cards to both the player and dealer from the deck.
     */
    public void deal(){
        for (int i = 0; i < 2; i++) {
            playerHand.add(newDeck.deal());
            dealerHand.add(newDeck.deal());
        }
    }

  

    /**
     * Handles the player's turn, automatically hitting until the total value is above 16.
     * Stops if the player busts (total value exceeds 21).
     *
     * @return true if the player did not bust, false otherwise.
     */
    public boolean playerTurn(){
        while (playerHand.getTotalValue() <= 16){
            playerHand.add(newDeck.deal());
        }
        if(playerHand.getTotalValue() > 21){
            return false;
        }
        else{
            return true;
        }
    }


    /**
     * Handles the dealer's turn, automatically hitting until the total value is above 17.
     * Stops if the dealer busts (total value exceeds 21).
     *
     * @return true if the dealer did not bust, false otherwise.
     */
    public boolean dealerTurn(){
        while (dealerHand.getTotalValue() <= 17){
            dealerHand.add(newDeck.deal());
        }
        if(dealerHand.getTotalValue() > 21){
            return false;
        }
        else{
            return true;
        }
    }


    /**
     * Sets the deck reshuffle cutoff point.
     *
     * @param cutoff The new reshuffle cutoff.
     */
    public void setReshuffleCutoff(int cutoff){
        this.reshuffleCutoff = cutoff;
    }


    /**
     * Returns the current reshuffle cutoff point.
     *
     * @return The reshuffle cutoff.
     */
    public int getReshuffleCutoff(){
        return reshuffleCutoff;
    }

    /**
     * Returns a string representation of the current game state, including both hands and their total values.
     *
     * @return A string summarizing the current game state.
     */
    public String toString(){
        return "Player Hand: " + playerHand   + "  Dealer Hand: " + dealerHand + "  Player Hand Sum: " + playerHand.getTotalValue() + "  Dealer Hand Sum: " + dealerHand.getTotalValue();
    }


    /**
     * Plays a round of Blackjack, with verbose output if specified.
     * Resets and shuffles the deck, deals hands, and manages turns.
     *
     * @param verbose If true, prints detailed game state information.
     * @return 1 if the player wins, -1 if the dealer wins, 0 for a push.
     */
    public int game(boolean verbose) { 
        reset();
        deal();
        newDeck.shuffle();
        boolean playerBusted = !playerTurn();
        boolean dealerBusted = !dealerTurn();

        if(verbose == true) {
            System.out.println(this);
        }

        if ((playerBusted && dealerBusted) || (playerHand.getTotalValue() == dealerHand.getTotalValue())) {
            return 0;
        } else if (playerBusted || (!dealerBusted && dealerHand.getTotalValue() > playerHand.getTotalValue())) {
            return -1; 
        } else {
            return 1;
        }
    }


    /**
     * Facilitates the player's turn in an interactive manner, allowing the user to hit or stand via console input.
     *
     * @return A string indicating if the player busts or stands.
     */
    public String playerTurnInteractive(){
        Scanner scanner = new Scanner(System.in);
        // Ensure the bet does not exceed the player's balance
        boolean playerBusted = false;
        reset();
        newDeck.shuffle();
        deal();
        while(true){
            System.out.println("Your Current Hand is: " + getPlayerHand() + " Your Hand Total is: " + getPlayerHand().getTotalValue());
            System.out.print("Hit or Stand? (h/s): ");
            String input = scanner.nextLine();
            if ("h".equalsIgnoreCase(input)) {
                playerHand.add(newDeck.deal());
                System.out.println("You chose to hit.");
            if (playerHand.getTotalValue() > 21) {
                System.out.println("Busted! Your hand: " + getPlayerHand() + " (Total: " + getPlayerHand().getTotalValue() + ")");
                System.out.println("You lost: $" + currentBet);
                playerBusted = true;
                break;
                    }
            } else if ("s".equalsIgnoreCase(input)) {
                System.out.println("You chose to stand.");
                break;
            } else {
                System.out.println("Invalid input. Please type 'h' to hit or 's' to stand.");
                }
            }
            
            if (playerBusted) {
                return "Player busts";
            } else {
                return "Player stands";
            }
        }

        /**
     * Returns the current balance of the player.
     *
     * @return The player's balance.
     */
        public double getCurrentBalance(){
            return playerBalance;
        }

        /**
     * Sets the current balance of the player.
     *
     * @param CurrentBalance The new balance to set for the player.
     */
        public void setCurrentBalance(double CurrentBalance){
            this.playerBalance = CurrentBalance;
        }

    //Used to test functionality of game method. 
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
        Blackjack game = new Blackjack();
        int outcome = game.game(true);
        System.out.println("Game outcome: " + (outcome == 1 ? "Player wins" : outcome == 0 ? "Push" : "Dealer wins"));
        }
    }

}


