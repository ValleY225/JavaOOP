package Alg1;

public class QuickSort {
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(arr, left, middle);  // Sort the left half
            mergeSort(arr, middle + 1, right);  // Sort the right half
            merge(arr, left, middle, right);  // Merge the sorted halves
        }
    }

    public static void merge(int[] arr, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;
        int[] L = new int[n1];
        int[] R = new int[n2];
        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, middle + 1, R, 0, n2);
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }                   //Kayipov Yerasyl
            k++; }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++; }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}


