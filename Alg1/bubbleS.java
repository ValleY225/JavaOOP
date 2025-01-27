package Alg1;

import java.util.Collections;
import java.util.PriorityQueue;

import java.util.Arrays;

public class bubbleS {

    // Method to perform Bubble Sort on a list of strings and count comparisons and swaps
    public static void bubbleSortWithCounts(String[] arr) {
        int n = arr.length;
        int comparisons = 0;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                comparisons++;
                // Compare adjacent strings
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    // Swap if they are in the wrong order
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++;
                    swapped = true;
                } //Kayipov Yerasyl
            }
            // If no elements were swapped, the array is already sorted
            if (!swapped) {
                break;
            }
        }
        // Output the sorted array and counts
        System.out.println("Sorted Array: " + Arrays.toString(arr));
        System.out.println("Total Comparisons: " + comparisons);
        System.out.println("Total Swaps: " + swaps);
    }
    // Main method for testing
    public static void main(String[] args) {
        // Example array of strings
        String[] arr = { "banana", "apple", "orange", "mango", "peach" };

        // Display original array
        System.out.println("Original Array: " + Arrays.toString(arr));

        // Perform Bubble Sort and count operations
        bubbleSortWithCounts(arr);
    }
}

//public class bubbleS {
//
//    // Max-heap for the smaller half of the numbers
//    private PriorityQueue<Integer> low;
//
//    // Min-heap for the larger half of the numbers
//    private PriorityQueue<Integer> high;
//
//    public bubbleS() {
//        // Max-heap to store the smaller half
//        low = new PriorityQueue<>(Collections.reverseOrder());
//        // Min-heap to store the larger half
//        high = new PriorityQueue<>();
//    }
//
//    // Method to insert a new number
//    public void addNumber(int num) {
//        if (low.isEmpty() || num <= low.peek()) {
//            low.add(num);
//        } else {        //Kayipov Yerasyl
//            high.add(num);
//        }
//
//        // Balance the heaps if their sizes differ by more than 1
//        if (low.size() > high.size() + 1) {
//            high.add(low.poll());
//        } else if (high.size() > low.size()) {
//            low.add(high.poll());
//        }
//    }
//
//    // Method to get the current median
//    public double getMedian() {
//        if (low.size() == high.size()) {
//            // If both heaps have the same number of elements, the median is the average
//            return (low.peek() + high.peek()) / 2.0;
//        } else {
//            // Otherwise, the median is the top of the larger heap
//            return low.peek();
//        }
//    }
//
//    // Main method for testing
//    public static void main(String[] args) {
//        bubbleS medianMaintainer = new bubbleS();
//
//        int[] stream = {5, 15, 1, 3, 8, 7, 9};
//        System.out.println("Stream of numbers: " + java.util.Arrays.toString(stream));
//
//        for (int num : stream) {
//            medianMaintainer.addNumber(num);
//            System.out.println("Added " + num + ", Current Median: " + medianMaintainer.getMedian());
//        }
//    }
//}


//public class bubbleS {
//// Java program for implementation
//// of Bubble Sort
//    void bubbleSort(int array[]) //Yerasyl Kayipov
//    {
//        int n = array.length;
//        for (int i = 0; i < n - 1; i++) { // O(n)
//            for (int j = 0; j < n - i - 1; j++) // O(n*n)
//                if (array[j] > array[j + 1]) { //sorting
//                    int s = array[j]; // third operator
//                    array[j] = array[j + 1];//swap values
//                    array[j + 1] = s;
//                }
//        }
//    }
//
//    // Prints the array
//    void printArray(int arr[])
//    {
//        int n = arr.length;
//        for (int i = 0; i < n; ++i)
//            System.out.print(arr[i] + " ");
//        System.out.println();
//    }
//
//    // Driver method to test above
//    public static void main(String args[])
//    {
//        bubbleS ob = new bubbleS();
//        int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
//        ob.bubbleSort(arr);
//        System.out.println("Sorted array");
//        ob.printArray(arr);
//    }
//
//}

