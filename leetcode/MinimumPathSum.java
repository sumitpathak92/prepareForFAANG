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

public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] input = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(input));
    }

    private static int minPathSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        for(int i = 0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(i==0 && j!=0) {
                    grid[i][j] = grid[i][j] + grid[i][j-1];
                } else if(i!=0 && j==0) {
                    grid[i][j] = grid[i][j] + grid[i-1][j];
                } else if(i == 0) {
                } else {
                    grid[i][j] = Math.min(grid[i][j-1], grid[i-1][j]) + grid[i][j];
                }
            }
        }
        return grid[r-1][c-1];
    }
}
