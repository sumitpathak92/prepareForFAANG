package leetcode;

import java.util.Arrays;

/**
 * LC Medium : https://leetcode.com/problems/coin-change-2/
 * **/
public class CoinChangeII {

    public static void main(String[] args) {
        int[] A = {1,2,5}; int sum = 5;
        System.out.println(changeDP(sum, A));
    }

    static int[][] dp;
    public static int change(int sum, int[] A) {
        int N = A.length;
        dp = new int[N][sum+1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(A, sum, N);
    }

    static int f(int[] A, int T, int N) {
        if(T==0) return 1;
        if(N==0) {
            return 0;
        }
        if(dp[N-1][T]!=-1) return dp[N-1][T];
        int notTake = f(A, T, N-1);
        int take = 0;
        if(A[N-1]<=T) {
            take = f(A, T-A[N-1], N);
        }
        return dp[N-1][T] = take+notTake;
    }

    public static int changeDP(int sum, int[] A) {
        int N = A.length; int W = sum;
        int[][] dp = new int[N+1][W+1];
        for(int i = 0; i<=N; i++)  dp[i][0] = 1;
        for(int i = 0; i<=W; i++) dp[0][i] = 0;
        for(int i = 1; i<=N; i++) {
            for(int j = 1; j<=W; j++) {
                int count = dp[i-1][j];
                if(A[i-1]<=j)
                    count += dp[i][j-A[i-1]];
                dp[i][j] = count;
            }
        }
        return dp[N][W];
    }

    }
