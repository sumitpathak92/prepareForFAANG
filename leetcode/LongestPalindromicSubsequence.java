package leetcode;

public class LongestPalindromicSubsequence {

    public static void main(String[] args) {

        System.out.println(longestPalindromeSubseq("agbcba"));
    }
    static int longestPalindromeSubseq(String s) {
        String t = new StringBuilder(s).reverse().toString();
        System.out.println("reverse:: " +t);
        return longestCommonSubsequenceII(s, t);
    }

    static int longestCommonSubsequenceII(String x, String y) {
        int m = x.length(); int n = y.length();
        int[][] t= new int[m+1][n+1];
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
