package leetcode;

public class NQueensAgain {

    public static void main(String[] args) {
        System.out.println(totalNQueens(4));
    }

    static int totalNQueens(int n) {
        // lets say we represent nxn grid with 2d boolean array
        boolean[][] grid = new boolean[n][n];
        return solver(grid, 0);
    }

    static int solver(boolean[][] grid, int row) {
        if(row == grid.length) {
            return 1;
        }
        int count = 0;
        for(int i=0; i<grid[0].length; i++) {
            if(isSafe(grid, row, i)) {
                // if queen can be placed here, mark as visited
                grid[row][i] = true;
                // recurse for next set of rows
                count+=solver(grid, row+1);
                // after function returns from recursive call, backtrack and mark it as unvisited for future recursive calls
                grid[row][i] = false;
            }
        }
        return count;
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
}
