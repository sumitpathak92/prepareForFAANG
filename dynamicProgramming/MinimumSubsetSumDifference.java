/**
 * This contains code for calculating minimum difference between the sum of the subsets formed in an arrow using top-down approach,
 * also called real DP
 *
 * Problem Statement : Given a set of integers, the task is to divide it into two sets S1 and S2 such that the absolute difference
 * between their sums is minimum.
 * Input : [1, 6, 11, 5]
 * Output : 1
 * Explanation: subset1 = {1, 5, 6}, sum = 12 and subset2 = {11}, sum = 11
 *
 * */

package dynamicProgramming;

public class MinimumSubsetSumDifference {

    public static void main(String[] args) {
        int[] arr = {1, 2, 7};
        System.out.println(getMinimumSubsetSum(arr));
    }

    private static int getMinimumSubsetSum(int[] A) {
        int range = 0;
        for(Integer i : A) {
            range+=i;
        }
        // minimize s2-s1 (if s1 is sum of subset 1 and s2 is sum of subset 2)
        // i.e minimize (range-2*s1)
        // s1 will always lie in between (0, range/2)
        // range- 2*s1 = 10 - 2 = 21, 23 - 4 = 19, 23 - 6 = 17... so on
        boolean[][] dp = new boolean[A.length+1][range+1];
        for(int j = 0 ; j<range+1; j++) {
            dp[0][j] = false;
        }
        for(int i = 0; i<A.length+1; i++) {
            dp[i][0] = true;
        }
        for(int i =1; i<A.length+1; i++) {
            for(int j = 1; j<range+1; j++) {
                if(A[i-1]<=j) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-A[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        // checking the boolean matrix
        for(boolean[] i : dp) {
            printRow(i);
        }
        int min = Integer.MAX_VALUE;
        for(int j = range/2; j>=0; j--) {
            if(dp[dp.length-1][j]) {
                min = Integer.min(min, range-2*j);
            }
        }
        return min;
    }

    public static void printRow(boolean[] row) {
        for (boolean i : row) {
            System.out.print(i);
            System.out.print("\t");
        }
        System.out.println();
    }
}
