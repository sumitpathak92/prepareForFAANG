package dynamicProgramming;

import java.util.Arrays;

public class SubsetSumEqualsK {

    public static void main(String[] args) {
        int[] A = {1, 3, 6, 3};
        System.out.println(subsetSumEqualsKDP(A, 11));
    }

    static int[][] dp;
    static boolean subsetSumEqualsK(int[] A, int k) {
        int n = A.length;
        dp = new int[n][k+1];
        for(int[] row:dp){
            Arrays.fill(row, -1);
        }
        return f(n-1, A, k);
    }

    static boolean f(int idx, int[] A, int k) {
        if(k==0)
            return true;
        if(idx==0) {
            return A[0]==k;
        }
        if(dp[idx][k]!=-1) return dp[idx][k] != 0;
        boolean notTake = f(idx-1, A, k);
        boolean take = false;
        if(A[idx]<=k) {
            take = f(idx - 1, A, k - A[idx]);
            dp[idx][k] = take || notTake ? 1 : 0;
        }
        return take || notTake;
    }

    static boolean subsetSumEqualsKDP(int[] A, int k) {
        int n = A.length;
        boolean[][] dp = new boolean[n][k+1];
        for(int i = 0; i<n; i++) dp[i][0] = true;
        if(A[0]<=k) dp[0][A[0]] = true;
        for(int i = 1; i<n; i++) {
            for(int j = 1; j<=k; j++) {
                boolean notTake = dp[i-1][k];
                boolean take = false;
                if(A[i]<=j)
                    take = dp[i-1][k-A[i]];
                dp[i][j] = take||notTake;
            }
        }
        return dp[n-1][k];
    }


}
