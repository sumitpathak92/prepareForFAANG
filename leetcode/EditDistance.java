package leetcode;

import java.util.Arrays;

/**
 * LC Hard: https://leetcode.com/problems/edit-distance/
 * **/
public class EditDistance {

    public static void main(String[] args) {
        System.out.println(editDistance("horse", "rse"));
    }

    static int[][] dp;
    public static int minDistance(String w1, String w2) {
        dp = new int[w1.length()+1][w2.length()+1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(w1, w2, w1.length(), w2.length());
    }

    static int f(String w1, String w2, int m, int n){
        if(m==0) return n;
        if(n==0) return m;
        if(dp[m][n]!=-1) return dp[m][n];
        if(w1.charAt(m-1)==w2.charAt(n-1))
            return dp[m][n] = f(w1, w2, m-1, n-1);
        else {
            int insert = 1+f(w1, w2, m, n-1);
            int delete = 1+f(w1, w2, m-1, n);
            int replace = 1+f(w1, w2, m-1, n-1);
            return dp[m][n] = Math.min(insert, Math.min(delete, replace));
        }
    }

    static int editDistance(String w1, String w2) {
        int m = w1.length(); int n = w2.length();
        int[][] dp = new int[m+1][n+1];
        // base case

        for(int i = 0; i<=m; i++) {
            dp[i][0] = i;
        }
        for(int i = 0; i<=n; i++) {
            dp[0][i] = i;
        }
        for(int i = 1; i<=m; i++) {
            for(int j = 1; j<=n; j++) {
                if(w1.charAt(i-1)==w2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    int insert = 1+dp[i][j-1];
                    int delete = 1+dp[i-1][j];
                    int replace = 1+dp[i-1][j-1];
                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }
        return dp[m][n];
    }
}
