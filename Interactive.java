
/*
file name:      Blackjack.java
Authors:        Vishnu
last modified:  02/25/2024

How to run:     java Interactive
Purpose: The {@code Interactive} class facilitates playing a game of Blackjack through the console.
 * It handles user inputs for bets and actions within the game and manages the game flow.
*/



import java.util.*;



/**
 * 
 * 
 * The {@code Interactive} class facilitates playing a game of Blackjack through the console.
 * It handles user inputs for bets and actions within the game and manages the game flow.
 * 
 */
class Interactive{

/**
     * The main method to run the Blackjack game. It interacts with the user through the console,
     * allowing them to place bets, make decisions during the game, and quit when desired.
     * The game continues until the player chooses to quit or their balance is insufficient to proceed.
     *
     * @param args Command line arguments (not used).
*/
public static void main(String[] args) {
    double betAmount;


    Scanner scanner = new Scanner(System.in);
    Blackjack game = new Blackjack(); 
    System.out.println("Welcome to Blackjack!");
    
    while (true) {
        System.out.println("\nYou have $" + game.getCurrentBalance() + ". Starting a new game of Blackjack...");
        System.out.print("Enter your bet amount (or type 'quit' to exit): ");
        String input = scanner.nextLine();

        if ("quit".equalsIgnoreCase(input)) {
            System.out.println("Exiting game. Your final balance: $" + game.getCurrentBalance());
            break;
        }

        try {
            betAmount = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            continue;
        }

        if (betAmount > game.getCurrentBalance()) {
            System.out.println("Insufficient balance for this bet.");
            continue;
        }

        game.setCurrentBalance(game.getCurrentBalance() - betAmount);

        String playerOutcome = game.playerTurnInteractive();

        if (!"Player busts".equals(playerOutcome)) {
            boolean dealerOutcome = game.dealerTurn();
            if (!dealerOutcome || game.getPlayerHand().getTotalValue() > game.getDealerHand().getTotalValue()) {
                System.out.println("You win!");
                game.setCurrentBalance(game.getCurrentBalance() + (2 * betAmount));
            } else if (game.getPlayerHand().getTotalValue() < game.getDealerHand().getTotalValue()) {
                System.out.println("Dealer wins.");
            } else {
                System.out.println("It's a push.");
                game.setCurrentBalance(game.getCurrentBalance() + betAmount);
            }
        } else {
            System.out.println("Dealer wins by default. Player busts.");
        }

        System.out.println("Your current balance: $" + game.getCurrentBalance());

        if(game.getCurrentBalance() <= 5){
            System.out.println("Insufficient Funds to Play! :( -- Game Over.");
            break;
        }
    }

    scanner.close();
}
}