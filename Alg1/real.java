package Alg1;

import java.util.ArrayList;
import java.util.Collections;

public class real {
    public static String LinearUnsorted(ArrayList<String> phoneBook, String name) {
        for (String lin : phoneBook) {
            if (lin.startsWith(name + ":")) {
                return lin;
            }    //for unsorted list
        }
        return "Name not found";
    }
    public static String BinarySorted(ArrayList<String> phoneBook, String name) {
        int left = 0;
        int right = phoneBook.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            String midEntry = phoneBook.get(mid);
            //for sorted list
            String midName = midEntry.split(":")[0];

            if (midName.equals(name)) {  //To compare names
                return midEntry; //Return the matching entry
            }
            if (midName.compareTo(name) < 0) {
                left = mid + 1; //Search in the right half
            } else {
                right = mid - 1; //Search in the left half
            }
        }
        return "-1";
    }
    public static long calculateTime(Runnable searchFunction) {
        long startTime = System.nanoTime();
        searchFunction.run();
        long endTime = System.nanoTime();
        return endTime - startTime; //To calculate time used for.
    }

    public static void main(String[] args) {
        ArrayList<String> phoneBook = new ArrayList<>();
        phoneBook.add("Alice: 123"); //Kaiypov Yerassyl
        phoneBook.add("Bob: 456");
        phoneBook.add("Charlie: 789");
        phoneBook.add("Hadi: 202");
        phoneBook.add("Mort: 303");
        phoneBook.add("Antoni: 404");
        phoneBook.add("Paphnoutios: 505");
        phoneBook.add("Jamal: 606");
        phoneBook.add("CoZbi: 707");


        String targetName = "Bob";
        System.out.println("Unsorted Phone Book (LinearUnsorted):");
        //Measure time for LinearUnsorted
        long LinearUnsorted = calculateTime(() -> {
            String result = LinearUnsorted(phoneBook, targetName);
            System.out.println(result);
        });
        System.out.println("LinearUnsorted(nanoseconds): " + LinearUnsorted);

        Collections.sort(phoneBook); //Sorting with Collections
        System.out.println("\nSorted Phone Book (BinarySorted):");
        //Measure time for BinarySorted
        long BinarySorted = calculateTime(() -> {
            String result = BinarySorted(phoneBook, targetName);
            System.out.println(result);
        });

        System.out.println("BinarySorted search time (nanoseconds): " + BinarySorted);
    }
}
