/*
file name:      ShuffleTests.java
Authors:        Ike Lage & Max Bender & Allen Harper
last modified:  02/26/2024

How to run:     java -ea ShuffleTests
Purpose: Run/Test different shuffilng techniques. 
*/

import java.util.ArrayList;
import java.util.Random;

public class ShuffleTests {

    public static void shuffleTestsLab() {
        // case 1: testing that the arrays before and after shuffle are not equal

    
            // set up
            //Make an array of integers from 0 to 10
            ArrayList<Integer> tenIntegers = new ArrayList<Integer>();
            Random rand = new Random();
            for (int i = 0; i < 9; i++) {
            int random = rand.nextInt(0,100);
            tenIntegers.add(random);
            }
            

            //Shuffle it and save the output as a new array
            ArrayList<Integer> ShuffledArray = DumbShuffle.dumbShuffle(tenIntegers);

            // verify
            // Print the original and the shuffled arrays 
            System.out.println(ShuffledArray.toString());
            System.out.println(tenIntegers.toString());


            ArrayList<Integer> copiedArray = DumbShuffle.noShuffle(tenIntegers);

            // test
            //Assert that the original and new arrays aren't equal
            assert !ShuffledArray.equals(tenIntegers): "Not Equal";
            assert !copiedArray.equals(tenIntegers): "Equal";

        //Print that your tests have all passed!
            System.out.println("Test Cases have Passed");
    }

    //method that checks if an arraylist is just simply reversed. 
    public static boolean isSimplyReversed(ArrayList<Integer> original, ArrayList<Integer> shuffled) {
        for (int i = 0; i < original.size(); i++) {
            if (!original.get(i).equals(shuffled.get(original.size() - 1 - i))) {
                return false;
            }
        }
        return true;
    }

    
    public static void shuffleTestsReflection(ArrayList<Integer> tenIntegers) {
        // This test makes sure that the arraylist isn't just simply reversed but actually shuffled
    
        ArrayList<Integer> dumbShuffledArray = DumbShuffle.dumbShuffle(tenIntegers);
        ArrayList<Integer> smartShuffledArray = DumbShuffle.smartShuffle(tenIntegers); 
    
        // Check if dumbShuffle just reverses the array
        boolean isDumbShuffleReversed = isSimplyReversed(tenIntegers, dumbShuffledArray);
        assert !isDumbShuffleReversed : "dumbShuffle just reversed the array -- way too predictable";
    
        // Check if smartShuffle effectively shuffles without simply reversing! It works. 
        boolean isSmartShuffleReversed = isSimplyReversed(tenIntegers, smartShuffledArray);
        assert !isSmartShuffleReversed : "smartShuffle does not simply reverse the array";
    
        System.out.println("Tests passed");
    }

    public static void main(String[] args) {
        ArrayList<Integer> tenIntegers = new ArrayList<Integer>();
            Random rand = new Random();
            for (int i = 0; i < 9; i++) {
            int random = rand.nextInt(0,100);
            tenIntegers.add(random);
            }

        shuffleTestsReflection(tenIntegers);
    }
}
