package Alg1;

import java.util.ArrayList;

public class Task2 {
    static class LinearSearch {
        // This function returns index of element "target" in arr[]
        static int linearSearch(ArrayList<Integer> list, int n, int target)
        {
            for (int i = 0; i < n; i++) {
                // Return the index of the element if the element
                if (list.get(i) == target)
                    return i;
            }
            // return -1 if the element is not found
            return -1;
        }
        // Kaiypov Yerassyl
        public static void main(String[] args)
        {
            ArrayList<Integer> list = new ArrayList<>(5);
            list.add(1);
            list.add(2);
            list.add(3);
            list.add(4);
            list.add(5);
            int n = list.size() ;
            int target = 4;

            int index = linearSearch(list, n, target); //search for existing value.
            if (index == -1)
                System.out.println("Element is not present in the array");
            else
                System.out.println("Element found at position " + index);

            index = 6;
            if (index == -1)
                System.out.println("Element is not present in the array"); //search for value not presented in the list.
            else
                System.out.println("Element found at position " + index);

            ArrayList<Integer> list2 = new ArrayList<>();
            int result = linearSearch(list2, n , target); // search in an empty list
            System.out.println("Searching in an empty list: " + result);

        }
    }
}
