package leetcode;

/**
 *
 * LC Medium : https://leetcode.com/problems/number-of-islands/
 * */
public class NumberOfIslandsII {

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        System.out.println("number of islands here is ::::   "+numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int count = 0;
        int R = grid.length;
        int C = grid[0].length;
        for(int i = 0; i<R; i++) {
            for(int j = 0; j<C; j++) {
                if(grid[i][j]=='1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public static void dfs(char[][] grid, int r, int c) {
        if(r<0 || r>=grid.length || c<0 || c>grid[0].length || grid[r][c] == '0') return;
        grid[r][c] = '0'; // mark as visited

        dfs(grid, r+1, c);
        dfs(grid, r-1, c);
        dfs(grid, r, c+1);
        dfs(grid, r, c-1);
    }
}
