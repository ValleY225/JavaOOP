package Alg1;

public class BinarySearchExample {
    public static int IterativeSearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            // O(1) situation, target in middle
            if (arr[mid] == target) {
                return mid;
            }
            // If target is greater than mid element, search in the right half
            if (arr[mid] < target) {
                left = mid + 1;
            }

            else { // If target is smaller, search in the left half
                right = mid - 1;
            }
        }
        return -1; //negative result if target not found
    }

    public static int RecursiveSearch(int[] arr, int target, int left, int right) {
        int mid = left + (right - left) / 2;
        // return -1 if arr is incorrect
        if (left > right) {
            return -1;
        }
        if (arr[mid] == target) { // if target in middle
            return mid;
        }
        // search the right half
        if (arr[mid] < target) {
            return RecursiveSearch(arr, target, mid + 1, right);
        }
        // search the left half
        else {
            return RecursiveSearch(arr, target, left, mid - 1);
        }
    }

    // Main method to test both binary search implementations
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5}; // Kaiypov Yerassyl
        int target;

        //Random existing value
        target = 4;
        System.out.println("Iterative Binary Search (target = 3): " + IterativeSearch(arr, target));
        System.out.println("Recursive Binary Search (target = 3): " + RecursiveSearch(arr, target, 0, arr.length - 1));

        //Non-existing value
        target = 6;
        System.out.println("Iterative Binary Search (target = 6): " + IterativeSearch(arr, target));
        System.out.println("Recursive Binary Search (target = 6): " + RecursiveSearch(arr, target, 0, arr.length - 1));

        //Edge case(first element)
        target = 1;
        System.out.println("IterativeBinarySearch(target = 1): " + IterativeSearch(arr, target));
        System.out.println("RecursiveBinarySearch(target = 1): " + RecursiveSearch(arr, target, 0, arr.length - 1));

        //Edge case(last element)
        target = 5;
        System.out.println("Iterative Binary Search (target = 5): " + IterativeSearch(arr, target));
        System.out.println("Recursive Binary Search (target = 5): " + RecursiveSearch(arr, target, 0, arr.length - 1));


    }
}

