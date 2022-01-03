package leetcode;

/*
LC Medium : https://leetcode.com/problems/max-area-of-island/
* **/
public class MaxAreaOfIslandIII {

    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0}, {0,0,0,0,0,0,0,1,1,1,0,0,0}, {0,1,1,0,1,0,0,0,0,0,0,0,0}, {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0}, {0,0,0,0,0,0,0,0,0,0,1,0,0}, {0,0,0,0,0,0,0,1,1,1,0,0,0}, {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(maxAreaOfIsland(grid));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int maxArea = Integer.MIN_VALUE;
        for(int i = 0; i<r; i++) {
            for(int j = 0; j<c; j++) {
                if(grid[i][j]==1) {
                    maxArea = Math.max(maxArea, helper(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    public static int helper(int[][] grid, int i, int j) {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]!=1) {
            return 0;
        }
        grid[i][j] = 0; // mark as visited back again
        return 1+helper(grid, i+1, j) + helper(grid, i-1, j) + helper(grid, i, j+1) + helper(grid, i, j-1);
    }


}
