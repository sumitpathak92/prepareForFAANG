/**
 * This contains code for solving the count of subset sum problem using top-down approach, also called real DP
 *
 * Problem Statement : Given an array arr[] of length N and an integer X, the task is to find the number of subsets with sum equal to X.
 * Input : [1, 2, 3, 3]
 * X = 6
 * Output : 3 i.e {1, 2, 3}, {1, 2, 3}, {3, 3}
 *
 * */

package dynamicProgramming;

public class CountOfSubsetSum {

    public static void main(String[] args) {
        int[] A = {2, 3, 5, 6, 8, 10};
        int X = 10;
        System.out.println(countSubsetsWithGivenSum(A, X));
    }

    private static int countSubsetsWithGivenSum(int[] A, int X) {
        int[][] dp = new int[A.length+1][X+1];
        // initialisation
        for(int i = 0; i<A.length; i++) {
            for(int j = 0; j<X; j++) {
                if(i==0) dp[i][j] = 0;
                if(j==0) dp[i][j] = 1;
            }
        }
        // filling the grid using top down approach
        for(int i = 1; i<A.length+1; i++) {
            for(int j = 1; j<X+1; j++) {
                if(A[i-1]<=j) {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-A[i-1]];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[A.length][X];
    }
}
