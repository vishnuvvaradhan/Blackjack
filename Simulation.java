/*
file name:      Simulation.java
Authors:        Vishnu
last modified:  2/25/2022

How to run:     java Simulation
Purpose: Simulate 1000 games of Blackjack and present the results.
*/


public class Simulation {
    public static void main(String[] args) {
        int playerWins = 0;
        int dealerWins = 0;
        int pushes = 0;
        int gamesToPlay = 1000;

        Blackjack game = new Blackjack();

        for (int i = 0; i < gamesToPlay; i++) {
            int outcome = game.game(false);
            if (outcome == 1) {
                playerWins++;
            } else if (outcome == -1) {
                dealerWins++;
            } else {
                pushes++;
            }
        }

        System.out.println("Simulation Results:");
        System.out.println("Total Games Played: " + gamesToPlay);
        System.out.println("Player Wins: " + playerWins + " (" + (playerWins * 100.0 / gamesToPlay) + "%)");
        System.out.println("Dealer Wins: " + dealerWins + " (" + (dealerWins * 100.0 / gamesToPlay) + "%)");
        System.out.println("Pushes: " + pushes + " (" + (pushes * 100.0 / gamesToPlay) + "%)");
    }
    
}
