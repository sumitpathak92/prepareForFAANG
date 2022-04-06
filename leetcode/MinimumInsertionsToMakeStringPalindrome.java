package leetcode;

import java.util.Arrays;

/**
 *
 * LC Hard: https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
 * **/
public class MinimumInsertionsToMakeStringPalindrome {

    public static void main(String[] args) {
        String s1 = "bbbab";
        System.out.println(minInsertions(s1));
    }

    public static int minInsertions(String s) {
        String rev = reverse(s);

        int l1 = s.length(); int l2 = rev.length();
        int[][] dp = new int[l1+1][l2+1];
        for(int i = 0; i<=l1; i++) {
            dp[0][i] = 0;
        }
        for(int i =0; i<=l2; i++) {
            dp[i][0] = 0;
        }
        for(int i = 1; i<=l1; i++) {
            for(int j = 1; j<=l2; j++) {
                if(s.charAt(i-1)==rev.charAt(j-1)) {
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return s.length()-dp[l1][l2];
    }
    static int[][] dp;
    public static int getLongestCommonSubsequence(String s1, int ind1, String s2, int ind2) {
        if(ind1<0 || ind2<0) {
            return 0;
        }
        if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];
        if(s1.charAt(ind1)==s2.charAt(ind2)) {
            return dp[ind1][ind2] = 1+getLongestCommonSubsequence(s1, ind1-1, s2, ind2-1);
        }
        return dp[ind1][ind2] = Math.max(getLongestCommonSubsequence(s1, ind1-1, s2, ind2),
                getLongestCommonSubsequence(s1, ind1, s2, ind2-1));
    }

    public static String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        return sb.reverse().toString();
    }
}
