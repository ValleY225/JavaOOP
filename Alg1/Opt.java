package Alg1;

import java.util.Arrays;
import java.util.Comparator;

public class Opt {

    // Student class with name and age fields
    static class Student {
        String name;
        int age;
        Student(String name, int age) {
            this.name = name;
            this.age = age;
        }
                    // Kayipov Yerasyl
        @Override
        public String toString() {
            return name + " (" + age + ")";
        }
    }
    public static void main(String[] args) {
        // Create an array of students
        Student[] students = {
                new Student("Alice", 24),
                new Student("Bob", 22),
                new Student("Alice", 22),
                new Student("Charlie", 23),
                new Student("Bob", 25)
        };

        // Display the original array
        System.out.println("Original Array: " + Arrays.toString(students));

        // First, sort by age (secondary field)
        Arrays.sort(students, Comparator.comparingInt(s -> s.age));

        // Then, sort by name (primary field) to ensure stability
        Arrays.sort(students, Comparator.comparing(s -> s.name));

        // Display the sorted array
        System.out.println("Sorted Array: " + Arrays.toString(students));
    }
}






//
//public class Opt {
//    void swap(int[] data, int i, int j) {
//        int t = data[i]; //swap buffer
//        data[i] = data[j];
//        data[j] = t;  //Kayipov Yerasyl
//    }
//    void display(int[] data, int left, int right) {
//        for (int i = 0; i < right; ++i) {
//            System.out.print(i < left ? "  " : " " + data[i]);
//        }
//        System.out.println();
//    }
//    //--- in-place implementation with median-of-three pivot
//    int quicksort(int[] data, int left, int right, int callId) {
//        int saveCallId = callId; // to track recursive calls
//        System.out.print(callId + ". sorting:"); //detect sorted number
//        display(data, left, right);
//        if (left + 1 >= right) {
//            System.out.print("  "+saveCallId+". result:");
//            display(data, left, right);
//            return callId;
//        }
//        int ai = left, bi = (left+right)/2, ci = right-1, pos;
//        int a = data[ai], b = data[bi], c = data[ci];
//        if (a < b) {        //select {left, pivot, right}
//            if (c < a) {
//                pos = ai;
//            } else if (c < b) {
//                pos = ci;
//            } else {
//                pos = bi;
//            }
//        } else {
//            if (c < b) {   //save sorted number
//                pos = bi;
//            } else if (c < a) {
//                pos = ci;
//            } else {
//                pos = ai;
//            }
//        }
//        int pivot = data[pos];
//        System.out.println("   median of ["+a+", "+b+", "+c+"] is "+pivot);
//        swap(data, right-1, pos); //sorting small sets
//        int tail = left;
//        for (int i = left; i != right-1; ++i) {
//            if (data[i] < pivot) {
//                swap(data, tail, i);
//                ++tail;
//            }
//        }
//        swap(data, right-1, tail);// left and right
//        callId = quicksort(data, left, tail, ++callId);
//        callId = quicksort(data, tail+1, right, ++callId);
//        System.out.print("  " + saveCallId + ". result:");
//        display(data, left, right);
//        return callId;
//    }
//
//    public static void main(String[] args) {
//        int[] data = new int[]{ 2, 6, 3, 1, 6, 5, 2, 4, 8 };
//        new Opt().quicksort(data, 0, data.length, 0);
//    }
//}
