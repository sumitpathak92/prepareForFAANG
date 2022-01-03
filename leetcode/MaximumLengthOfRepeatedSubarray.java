package leetcode;

import java.util.Arrays;

/**
 * LC Medium : https://leetcode.com/problems/maximum-length-of-repeated-subarray/
 * */
public class MaximumLengthOfRepeatedSubarray {

    public static void main(String[] args) {
        int[] X = {1,2,3,2,1}; int[] Y = {3,2,1,4,7};
        System.out.println(findLength(X, Y));
    }

    /**
     * This problem is basically variation of Longest common subsequence problem
     * Longest Common Substring Problem variation, basically we have been given an array of integers
     * instead of two strings. But the underlying logic is same.
     * **/
    public static int findLength(int[] X, int[] Y) {
        int m = X.length; int n = Y.length;
        int[][] t = new int[m+1][n+1];
        for(int i = 0; i<m+1; i++) {
            for(int j = 0; j<n+1; j++) {
                if(i==0) t[i][j] = 0;
                if(j==0) t[i][j] = 0;
            }
        }
        int max = 0;
        for(int i = 1; i<m+1; i++) {
            for(int j=1; j<n+1; j++) {
                if(X[i-1] == Y[j-1]) {
                    t[i][j] = 1+t[i-1][j-1];
                    max = Math.max(max, t[i][j]);
                }
                else
                    t[i][j] = 0;
            }
        }
        for(int[] a : t) {
            System.out.println(Arrays.toString(a));
        }
        return max;
    }
}
