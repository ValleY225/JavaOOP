package Alg1;


public class binary {
        public static int BinarySearch(int[] arr, int target) {
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
                // If target is smaller, search in the left half
                else {
                    right = mid - 1;
                }
            }
            return -1; //negative result if target not found
        }
        // Kaiypov Yerassyl
        public static void main(String[] args) {
            int[] arr = {1, 2, 3, 4, 5};
            int target = 3;

            int result = BinarySearch(arr, target);

            if (result == -1) {
                System.out.println("-1");
            } else {
                System.out.println("Target at index:" + result);
            }
        }

    }