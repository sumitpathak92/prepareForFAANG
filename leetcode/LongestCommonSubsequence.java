package leetcode;

/**
 * LC Medium : https://leetcode.com/problems/longest-common-subsequence/
 * **/
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String x = "abc"; String y = "hgh";
        System.out.println(longestCommonSubsequenceII(x, y));
    }
    static int[][] t;
    static int longestCommonSubsequence(String x, String y) {
        int m = x.length(); int n = y.length();
        t = new int[m+1][n+1];
        for(int i = 0; i<m+1; i++) {
            for(int j=0; j<n+1; j++) {
                t[i][j] = -1;
            }
        }
        return helper(x, y, m, n);
    }

    static int helper(String x, String y, int m, int n) {
        // base condition
        if(m==0 || n==0) return 0;
        // check if subproblem already exists
        if(t[m][n] != -1) return t[m][n];
        if(x.charAt(m-1)==y.charAt(n-1)) {
            t[m][n] = 1 + helper(x, y, m-1, n-1);
        }
        else {
            t[m][n] = Math.max(helper(x, y, m-1, n), helper(x,y, m, n-1));
        }
        return t[m][n];
    }

    // bottom-up DP approach
    static int longestCommonSubsequenceII(String x, String y) {
        int m = x.length(); int n = y.length();
        t = new int[m+1][n+1];
        for(int i = 0; i<m+1; i++) {
            for(int j=0; j<n+1; j++) {
                if(i==0) t[i][j] = 0;
                if(j==0) t[i][j] = 0;
            }
        }
        for(int i = 1; i<=m; i++) {
            for(int j = 1; j<=n; j++) {
                if(x.charAt(i-1) == y.charAt(j-1)) {
                    t[i][j] = 1+t[i-1][j-1];
                } else {
                    t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
                }
            }
        }
        return t[m][n];
    }

}
