package leetcode;

/**
 * LC Medium : https://leetcode.com/explore/learn/card/queue-stack/232/practical-application-stack/1380/
 * */
public class NumberOfIslandsIV {

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int c = 0;
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n ; j++) {
                if(grid[i][j]=='1'){
                    c++;
                    dfs(grid, i, j);
                }
            }
        }
        return c;
    }

    public static void dfs(char[][] grid, int i, int j) {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]=='0'){
            return;
        }

        grid[i][j] = '0'; // mark as visited

        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }
}
