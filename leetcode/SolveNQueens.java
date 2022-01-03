package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LC Hard : https://leetcode.com/problems/n-queens/
 * **/
public class SolveNQueens {

    public static void main(String[] args) {
        System.out.println(solveNQueens(1));
    }

    public static List<List<String>> solveNQueens(int n) {
        boolean[][] grid = new boolean[n][n];
        return solver(grid, 0);
    }

    private static List<List<String>> solver(boolean[][] grid, int row) {
        if(row==grid.length) {
            List<List<String>> ll = new ArrayList<>();
            ll.add(processGrid(grid));
            return ll;
        }
        List<List<String>> resNew = new ArrayList<>();
        for(int i=0; i<grid[0].length; i++) {
            if(isSafe(grid, row, i)) {
                // if queen can be placed here, mark as visited
                grid[row][i] = true;
                // recurse for next set of rows
                resNew.addAll(solver(grid, row+1));
                // after function returns from recursive call, backtrack and mark it as unvisited for future recursive calls
                grid[row][i] = false;
            }
        }
        return resNew;
    }

    private static boolean isSafe(boolean[][] grid, int row, int col) {
        // check vertical cells
        for(int i =0; i<row; i++) {
            if(grid[i][col]) return false; // if queen sits on the vertical row above
        }
        // check left diagonal
        // how many movements the queen can make in diagonal direction in left??
        // it is minimum of rows and cols traversed so far
        int lMax = Math.min(row, col);
        for(int i = 1; i<=lMax; i++) {
            if(grid[row-i][col-i]) return false;
        }

        // check right diagonal
        // how many movements queen makes in diagonal right direction??
        // it is min of rows and remaining cols
        int rMax = Math.min(row, grid.length-col-1);
        for(int i = 1; i<=rMax; i++) {
            if(grid[row-i][col+i]) return false;
        }

        return true;
    }

    private static List<String> processGrid(boolean[][] grid) {
        List<String> ans = new ArrayList<>();
        for (boolean[] booleans : grid) {
            StringBuilder sb = new StringBuilder();
            List<String> row = new ArrayList<>();
            for (int j = 0; j < grid[0].length; j++) {
                if (booleans[j]) sb.append("Q");
                else sb.append(".");
            }
            row.add(sb.toString());
            ans.addAll(row);
        }
        return ans;
    }
}
