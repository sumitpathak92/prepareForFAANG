package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * LC Medium: https://leetcode.com/problems/maximum-length-of-pair-chain/
 * **/
public class MaximumLengthOfPairChain {

    public static void main(String[] args) {
        int[][] A = {{1,2}, {2,3}, {3,4}};
        System.out.println(findLongestChainTabulation(A));
    }

    static int[][] dp;

    public static int findLongestChainTabulation(int[][] A) {
        if(A.length==0) return 0; if(A.length == 1) return 1;
        Arrays.sort(A, Comparator.comparingInt(a -> a[1]));
        int[][] dp = new int[A.length+1][2002];
        // base case
        for(int i = 0; i<2002; i++) {
            dp[A.length][i] = 0;
        }
        for(int i = A.length-1; i>=0; i--) {
            for(int j = 2001; j>=0; j--) {
                int take = 0;

                if(A[i][0]+1000>j)
                    take = 1+dp[A[i+1][0]][A[i][1]+1000];
                int notTake = dp[A[i+1][0]][j];
                dp[i][j] = Math.max(take, notTake);
            }
        }
        return dp[0][0];
    }

    public static int findLongestChain(int[][] A) {
        if(A.length==0) return 0; if(A.length == 1) return 1;
        Arrays.sort(A, Comparator.comparingInt(a -> a[1]));
        dp = new int[A.length][2002];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return f(A, 0, 0);
    }

    public static int f(int[][] A, int i, int prev) {
        if(i>=A.length) {
            return 0;
        }
        if(dp[i][prev]!=-1) return dp[i][prev];
        int take = 0;

        if(A[i][0]+1000>prev)
            take = 1+f(A, i+1, A[i][1]+1000);
        int notTake = f(A, i+1, prev);
        return dp[i][prev] = Math.max(take, notTake);
    }
}
