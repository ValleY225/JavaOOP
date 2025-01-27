package Alg1;

public class BB {

    // Iterative Binary Search method
    public static int binarySearchIterative(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if target is at mid
            if (arr[mid] == target) {
                return mid;
            }
            // If target is greater, ignore left half
            if (arr[mid] < target) {
                left = mid + 1;
            }
            // If target is smaller, ignore right half
            else {
                right = mid - 1;
            }
        }

        // Return -1 if target is not found
        return -1;
    }

    // Recursive Binary Search method
    public static int binarySearchRecursive(int[] arr, int target, int left, int right) {
        // Base condition: if the range is invalid, return -1
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        // Check if target is at mid
        if (arr[mid] == target) {
            return mid;
        }
        // If target is greater, search the right half
        if (arr[mid] < target) {
            return binarySearchRecursive(arr, target, mid + 1, right);
        }
        // If target is smaller, search the left half
        else {
            return binarySearchRecursive(arr, target, left, mid - 1);
        }
    }

    // Main method to test edge cases
    public static void main(String[] args) {
        //Only one element
        int[] arr1 = {42};
        int target1 = 42;
        System.out.println("Iterative Binary Search (one element): " + binarySearchIterative(arr1, target1));
        System.out.println("Recursive Binary Search (one element): " + binarySearchRecursive(arr1, target1, 0, arr1.length - 1));
        //Kaiypov Yerasyl
        //With duplicates
        int[] arr2 = {2, 4, 4, 4, 5, 6, 7};
        int target2 = 4;
        System.out.println("Iterative Binary Search (with duplicates): " + binarySearchIterative(arr2, target2));
        System.out.println("Recursive Binary Search (with duplicates): " + binarySearchRecursive(arr2, target2, 0, arr2.length - 1));

        //Target less than the smallest element
        int target3 = 1;
        System.out.println("Iterative Binary Search (less than smallest): " + binarySearchIterative(arr2, target3));
        System.out.println("Recursive Binary Search (less than smallest): " + binarySearchRecursive(arr2, target3, 0, arr2.length - 1));

        //Target more than the largest element
        int target4 = 8;
        System.out.println("Iterative Binary Search (more than largest): " + binarySearchIterative(arr2, target4));
        System.out.println("Recursive Binary Search (more than largest): " + binarySearchRecursive(arr2, target4, 0, arr2.length - 1));
    }
}