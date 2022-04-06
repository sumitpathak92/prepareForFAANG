package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 *
 * LC Medium : https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations/
 * **/
public class MaximumScorePerformingMultiplication {

    public static void main(String[] args) {
        int[] A = {-5, -3, -3, -2, 7, 1}; int[] B = {-10, -5, 3,4,6};
        System.out.println(maximumScore(A, B));
    }

    static int[][] dp;
    public static int maximumScore(int[] nums, int[] multipliers) {
        int M = multipliers.length;
        dp = new int[M+1][M+1];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return f(0, nums, multipliers, 0, nums.length-1);
    }

    static int f(int idx, int[] A, int[] M, int l, int r) {

        if(idx>=M.length||l>r) {
            return 0;
        }
        int index = r-(A.length-M.length);
        if(dp[l][index]!=-1) return dp[l][index];
        int left = M[idx]*A[l] + f(idx+1, A, M, l+1, r);
        int right = M[idx]*A[r] + f(idx+1, A, M, l, r-1);
        return dp[l][index]=Math.max(left, right);
    }
}
