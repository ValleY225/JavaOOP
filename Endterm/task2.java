package Endterm;

import java.util.Arrays;
public class task2 {
        public static int optimizeCourseTimings(int[] ocItem, int[] ocVal, int ocCap) {
            int n = ocItem.length;
            int[][] dp = new int[n + 1][ocCap + 1];

            for (int i = 1; i <= n; i++) {
                for (int w = 1; w <= ocCap; w++) {
                    if (ocItem[i - 1] <= w) {
                        dp[i][w] = Math.max(
                                ocVal[i - 1] + dp[i - 1][w - ocItem[i - 1]], //Include the course
                                dp[i - 1][w] //Exclude the course
                        );
                    } else {
                        dp[i][w] = dp[i - 1][w]; //To exclude the course
                    }
                }
            }//Kayipov Yerasyl
            return dp[n][ocCap];
        }
        public static void main(String[] args) {
            int[] ocItem = {3, 2, 4, 5}; //Optimizing course durations
            int[] ocVal = {5, 6, 8, 10}; //for minimizing gaps
            int ocCap = 8;               //time slots

            int optimization = optimizeCourseTimings(ocItem, ocVal, ocCap);
            System.out.println("Maximum Utilization Value: " + optimization);

            System.out.println("______________________");


            int[] clItem = {1, 3, 4, 2};// Class durations
            int[] clVal = {2, 4, 5, 3}; // Utilization values
            int clCap = 6;              // Total time slots available in a classroom

            int Classroom = maximizeClassroomUtilization(clItem, clVal, clCap);
            System.out.println("Maximum Classroom Utilization: " + Classroom);

        }
        public static int maximizeClassroomUtilization(int[] clItem, int[] clVal, int clCap) {
            int n = clItem.length;
            int[][] dp = new int[n + 1][clCap + 1];

            for (int i = 1; i <= n; i++) {
                for (int w = 1; w <= clCap; w++) {
                    if (clItem[i - 1] <= w) {
                        dp[i][w] = Math.max(
                                clVal[i - 1] + dp[i - 1][w - clItem[i - 1]], //Include the classroom
                                dp[i - 1][w]
                        );
                    } else {
                        dp[i][w] = dp[i - 1][w]; //To exclude the classroom
                    }
                }
            }
            return dp[n][clCap];
        }
    }




