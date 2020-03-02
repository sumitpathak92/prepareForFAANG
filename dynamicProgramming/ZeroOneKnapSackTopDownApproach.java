/**
 * This contains code for solving the 0-1 Knapsack problem using top-down approach, also called real DP
 * */

package dynamicProgramming;

public class ZeroOneKnapSackTopDownApproach {

    public static void main(String[] args) {
        int[] wt = {1, 3, 4, 5};
        int[] v = {1, 4, 5, 7};
        int W = 7;
        int n = 3;
        System.out.println(zeroOneKnapSackTopDown(wt, v, W, n));
    }

    private static int zeroOneKnapSackTopDown(int[] wt, int[] v, int W, int n) {
        int[][] dp = new int[n+1][W+1];
        for(int i = 0; i<n; i++){
            for(int j=0; j<W; j++) {
                if(i==0 || j==0) dp[i][j] = 0; // initialization
            }
        }
        for(int i = 1; i<n+1; i++) {
            for(int j = 1; j<W+1; j++) {
                if(wt[i-1]<=j){
                    dp[i][j] = Math.max(v[i-1]+dp[i-1][j-wt[i-1]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    }
}
