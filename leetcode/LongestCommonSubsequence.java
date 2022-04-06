package leetcode;

import java.util.Arrays;

/**
 * LC Medium : https://leetcode.com/problems/longest-common-subsequence/
 * **/
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String x = "abc"; String y = "ac";
        System.out.println(longestCommonSubsequenceII(x, y));
    }
    static int[][] dp;
    static int longestCommonSubsequence(String x, String y) {
        int m = x.length(); int n = y.length();
        dp = new int[m+1][n+1];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return f(x, y, m, n);
    }

    static int f(String x, String y, int m, int n) {
        if(m==0 || n==0) {
            return 0;
        }
        if(dp[m][n]!=-1) return dp[m][n];
        if(x.charAt(m-1)==y.charAt(n-1)) {
            return dp[m][n]=1+f(x, y, m-1, n-1);
        }
        else
            return dp[m][n]=Math.max(f(x,y,m,n-1), f(x,y,m-1, n));
    }

    // bottom-up DP approach
    static int longestCommonSubsequenceII(String x, String y) {
        int m = x.length(); int n = y.length();
        dp = new int[m+1][n+1];
        for(int i = 0; i<m; i++) dp[i][0] = 0;
        for(int j = 0; j<n; j++) dp[0][j] = 0;
        System.out.println(Arrays.deepToString(dp));
        for(int i = 1; i<=m; i++) {
            for(int j = 1; j<=n; j++) {
                if(x.charAt(i-1)==y.charAt(j-1))
                    dp[i][j] = 1+dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m][n];
    }

}
