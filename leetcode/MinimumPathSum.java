/**
 *
 *   ## 64
 * * https://leetcode.com/problems/minimum-path-sum/
 *
 *   Statement :   Given a m x n grid filled with non-negative numbers,
 *                 find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *                 Note: You can only move either down or right at any point in time.
 *   Input:
 *          [
 *              [1,3,1],
 *              [1,5,1],
 *              [4,2,1]
 *          ]
 *   Output: 7
 **/
package leetcode;

import java.util.Arrays;

public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] input = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(input));
    }

    private static int minPathSum(int[][] grid) {
        dp = new int[grid.length][grid[0].length];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return f(grid, grid.length-1, grid[0].length-1);
    }

    static int[][] dp;
    static int f(int[][] A, int i, int j) {
        if(i==0 && j==0) return A[i][j];
        if(i<0 || j<0) return (int) 1e9;
        if(dp[i][j]!=-1) return dp[i][j];
        int left = A[i][j] + f(A, i, j-1);
        int top = A[i][j] + f(A, i-1, j);
        return dp[i][j]=Math.min(left, top);
    }
}
