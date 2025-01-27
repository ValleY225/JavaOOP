package Alg1;

import java.util.Arrays;

public class Dob {
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {    //mergeSort taking left and right
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid); //Sorting process
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid; //taking to two separate set
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[mid + 1 + j];
        }
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];   //Saving the answer
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }       //Kayipov Yerasyl
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    // Main function to test the sorting algorithms
    public static void main(String[] args) {
        // Resetting array for Merge Sort
        int[] arr = { 64, 34, 25, 12, 22, 11, 90 };

        // Merge Sort display
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("Sorted using Merge Sort: " + Arrays.toString(arr));
    }
}
















//public class Dob {
//    public int Dob(int[][] darr, int n, int r, int c) //Yerasyl Kayipov
//    {
//         //n is sum | r is row | c is column
//        for (r = 0; r < darr.length; r++) { // O(n)
//            for (c = 0; c < darr[r].length; c++){ // O(n*n)
//                n += darr[r][c];
//                System.out.println("here is" + n);
//            }
//        }
//        return n;
//    }
//    public static void main(String[] args) {
//        int[][] darr ={{1,2,3},{4,5,6},{7,8,9}};
//        int n = 0, r = 0, c = 0;
//        System.out.println("here is" + n);
//
//    }
//
//
//}
