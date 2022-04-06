package leetcode;

import java.util.Arrays;

/**
 * LC Medium : https://leetcode.com/problems/maximal-square/
 * **/
public class MaximalSquare {

    public static void main(String[] args) {
        char[][] A = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(maximalSquare(A));
    }

    static int[][] dp;
    public static int maximalSquare(char[][] A) {
        int M = A.length;
        if(M==0) return 0;
        int N = A[0].length;
        dp = new int[M][N];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        int res = Integer.MIN_VALUE;
        for(int i = 0; i<M; i++) {
            for(int j = 0; j<N; j++) {
                if(A[i][j]=='1') {
                    res = Math.max(res, f(A, i, j));
                }
            }
        }
        return res*res;
    }

    static int f(char[][] A, int i, int j) {
        if(i<0 || i>=A.length || j<0 || j>=A[0].length || A[i][j]=='0')
            return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        return dp[i][j]=1+ Math.min(f(A, i+1, j), Math.min(f(A, i, j+1), f(A, i+1, j+1)));
    }

}
