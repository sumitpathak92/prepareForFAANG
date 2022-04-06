package leetcode;

import java.util.Arrays;

/**
 * LC Medium : https://leetcode.com/problems/unique-paths/
 * **/
public class UniquePaths {

    public static void main(String[] args) {
        System.out.println(uniquePathsDP(3, 7));
    }

    static int[][] dp;
    public static int uniquePaths(int m, int n) {
        dp = new int[m][n];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return f(m-1, n-1);
    }

    static int f(int i, int j) {
        if(i<0 || j<0) return 0;
        if(i==0 || j==0) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        int up = f(i-1, j);
        int left = f(i, j-1);
        return dp[i][j]=up+left;
    }

    static int uniquePathsDP(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++) {
            dp[i][0] = 1;
        }
        for(int j=0; j<n;j++) {
            dp[0][j] = 1;
        }
        for(int i = 1; i<m; i++) {
            for(int j = 1; j<n; j++) {
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[m-1][n-1];
    }

}
