/*
file name:      Shuffle.java
Authors:        Ike Lage & Max Bender & Allen Harper
last modified:  02/26/2024

How to run:     java -ea Shuffle
Purpose: Run/Test different shuffilng techniques in lab.
*/

import java.util.ArrayList;
import java.util.Random;

class Shuffle{








public static void main(String[] args) {
    ArrayList<Integer> tenIntegers = new ArrayList<Integer>();
    Random rand = new Random();
    for (int i = 0; i < 9; i++) {
        int random = rand.nextInt(0,100);
        //System.out.println(random);
        tenIntegers.add(random);
    }
    System.out.println(tenIntegers.size());
    for(int i = 0; i < tenIntegers.size(); i++) {
        System.out.println(tenIntegers.get(i));
    }
    
    ArrayList<Integer> arr1 = new ArrayList<Integer>();
    for (int i = 0; i < tenIntegers.size(); i++) {
        arr1.add(tenIntegers.get(i));
        System.out.println(arr1.get(i));
    }

    ArrayList<Integer> arr2 = new ArrayList<Integer>();
    arr2 = tenIntegers;
    System.out.println("arr0 == arr1: " + (tenIntegers == arr1) + "\narr1 == arr2: " + (arr1 == arr2) + "\narr2 == arr0: " + (arr2 == tenIntegers));
    System.out.println("arr0.equals(arr1): " + (tenIntegers.equals(arr1)) + "\narr1.equals(arr2): " + (arr1.equals(arr2)) + "\narr2.equals(arr0): " + (arr2.equals(tenIntegers)));
}

}