/**
 * This contains code for solving the 0-1 Knapsack problem using memoization
 * */

package dynamicProgramming;

import java.util.Arrays;

public class ZeroOneKnapSackMemoizationSolution {

    public static void main(String[] args) {
        int[] wt = {1, 3, 4, 5};
        int[] v = {1, 4, 5, 7};
        int W = 7;
        int n = 3;
        int[][] dp = new int[W+1][n+1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(zeroOneKnapSackMemoization(wt, v, dp, W, n));
    }

    private static int zeroOneKnapSackMemoization(int[] wt, int [] v, int[][] dp, int W, int n) {
        if(n==0 || W==0) {
            return 0;
        }
        if(dp[W][n] != -1) return dp[W][n]; //if already computed, return the value
        if(wt[n-1]<=W) {
            //memoizing already computed values
            return dp[W][n] = Math.max(v[n-1]+zeroOneKnapSackMemoization(wt, v, dp, W-wt[n-1], n), zeroOneKnapSackMemoization(wt, v, dp, W, n-1));
        }
        //memoizing already computed values
        return dp[W][n] = zeroOneKnapSackMemoization(wt, v, dp, W,n-1);
    }
}

