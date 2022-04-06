package leetcode;

import java.util.Arrays;

/**
 * LC Medium : https://leetcode.com/problems/coin-change/
 * **/
public class CoinChange {

    public static void main(String[] args) {
        int[] A = {1,2,5};
        int sum = 11;
        System.out.println(coinChangeDP(A, sum));
    }

    static int[][] dp;
    public static int coinChange(int[] A, int sum) {
        int N = A.length; int T = sum;
        dp = new int[N][T+1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(N-1, T, A);
    }

    public static int f(int ind, int T, int[] A) {
        if(ind==0) {
            if(T%A[ind]==0) return T/A[ind];
            else return (int) 1e9;
        }
        if(dp[ind][T]!=-1) return dp[ind][T];
        int take = Integer.MAX_VALUE;
        int notTake = f(ind - 1, T, A);
        if(A[ind]<=T)
            take=1+f(ind, T-A[ind], A);
        return dp[ind][T] = Math.min(notTake, take);
    }

    public static int coinChangeDP(int[] A, int sum) {
        int N = A.length; int T = sum;
        int[][] dp = new int[N][T+1];
        for(int i = 0 ; i<=T; i++) {
            if(i%A[0]==0) dp[0][i] = i/A[0];
            else dp[0][i] = (int) 1e9;
        }
        for(int i = 1; i<N; i++) {
            for(int j = 0; j<=T; j++) {
                int take = Integer.MAX_VALUE;
                int notTake = dp[i - 1][j];
                if(A[i]<=j)
                    take=1+dp[i][j-A[i]];
                dp[i][j] = Math.min(take, notTake);
            }
        }
        return dp[N-1][T];
    }
}
