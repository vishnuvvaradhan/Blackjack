/*
file name:      DumbShuffle.java
Authors:        Ike Lage & Max Bender & Allen Harper
last modified:  02/26/2024

How to run:     java -ea DumbShuffle
Purpose:  Different Shuffling Techniques
*/

import java.util.ArrayList;
import java.util.Random;

public class DumbShuffle {

    /**
     * "Shuffles" the arraylist by reversing the order
     */
    public static ArrayList<Integer> dumbShuffle( ArrayList<Integer> integerArray ) {

        ArrayList<Integer> newIntegerArray = new ArrayList<Integer>() ;

        //Add the last to the new list and remove it until the end
        for ( int i = integerArray.size() - 1 ; i >= 0 ; i -- ) {
            newIntegerArray.add( integerArray.get( i ) );
        }

        return newIntegerArray ;
    }


    public static ArrayList<Integer> smartShuffle(ArrayList<Integer> integerArray) {
        Random random = new Random();
        for (int i = 0; i < integerArray.size(); i++) {
            // Generate a random index to swap with
            int randomIndex = random.nextInt(integerArray.size());
            // Swap the cards at i and randomIndex
            int temp = integerArray.get(i);
            integerArray.set(i, integerArray.get(randomIndex));
            integerArray.set(randomIndex, temp);
        }
        return integerArray;
    }

    /**
     * Doesn't shuffle the arraylist, just returns a copy
     */
    public static ArrayList<Integer> noShuffle( ArrayList<Integer> integerArray ) {

        ArrayList<Integer> newIntegerArray = new ArrayList<Integer>() ;

        //Add the last to the new list and remove it until the end
        for ( int i = 0 ; i < integerArray.size() ; i ++ ) {
            newIntegerArray.add( integerArray.get( i ) );
        }

        return newIntegerArray ;
    }

}