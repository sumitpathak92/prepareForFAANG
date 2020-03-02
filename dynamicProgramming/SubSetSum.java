/**
 * This contains code for solving the subset sum problem using top-down approach, also called real DP
 *
 * Problem Statement : Given a set og non negative integers and a value sum, determine if there is a subset of given set with sum
 * equal to the given sum.
 * Input : [1, 3, 8, 10]
 * Weight : 11
 *
 * Output : True/False
 *
 * */

package dynamicProgramming;

public class SubSetSum {

    public static void main(String[] args) {
        int[] v = {1, 3, 6, 3};
        int w = 11;
        System.out.println("Subset sum exists --> "+subSetSum(v, w, v.length));
    }

    protected static boolean subSetSum(int[] v, int w, int n) {
        boolean[][] dp = new boolean[n+1][w+1];
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<w; j++) {
                if(i==0) dp[i][j] = false; //initialization
                if(j==0) dp[i][j] = true; // initialization
            }
        }
        // filling the grid with the choices that we have
        for(int i = 1; i<n+1; i++) {
            for(int j = 1; j<w+1; j++) {
                if(v[i-1]<=j) {
                    // we either take it or leave it
                    dp[i][j] = dp[i-1][j-v[i-1]] | dp[i-1][j]; // performing an OR operation between the two
                } else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][w];
    }
}
