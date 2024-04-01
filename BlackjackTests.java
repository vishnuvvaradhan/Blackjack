/*
file name:      BlackjackTests.java
Authors:        Max Bender & Naser Al Madi
last modified:  2/25/2022

How to run:     java -ea BlackjackTests
Purpose: Test Blackjack Class
*/


public class BlackjackTests {

    public static void blackjackTests() {

        // case 1: testing Blackjack() and Blackjack(i)
        {
            // set up
            Blackjack bj1 = new Blackjack();
            Blackjack bj2 = new Blackjack();

            // verify

            // test
            assert bj1 != null : "Error in Blackjack::Blackjack()";
            assert bj2 != null : "Error in Blackjack::Blackjack()";

            //test deal method

            bj1.deal();

            assert bj1.getPlayerHand() != null : "Error in Blackjack::Blackjack()";
            assert bj1.getDealerHand() != null : "Error in Blackjack::Blackjack()";

            //check game method + randomness + reset all in one.

            assert bj1.game(true) != bj2.game(true) : "Error in Blackjack::Blackjack()";


        }
        System.out.println("*** Done testing Blackjack! ***\n");
    }


    public static void main(String[] args) {

        blackjackTests();
    }
}