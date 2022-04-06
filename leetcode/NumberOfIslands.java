package leetcode;

//Problem statement

/*
* Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by
* connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
* */


import java.util.LinkedList;
import java.util.Queue;

/*
*
* Input:
    11110
    11010
    11000
    00000
* Output: 1
*
* Input:
    11000
    11000
    00100
    00011
* Output: 3
*/
public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] input = {{'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        System.out.println("total no of islands are -->  "+noOfIslandsBFS(input));
    }

    public static int noOfIslands(char[][] grid) {
        int m = grid.length; int n = grid[0].length;
        int count = 0;
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(grid[i][j]=='1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static void dfs(char[][] grid, int i, int j) {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]=='0')
            return;
        grid[i][j] = '0';
        // perform dfs traversal
        dfs(grid, i+1, j);
        dfs(grid, i, j+1);
        dfs(grid, i-1, j);
        dfs(grid, i, j-1);
    }

    public static int noOfIslandsBFS(char[][] A) {
        int m = A.length; int n = A[0].length; int count = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(A[i][j]=='1'){
                    count++;
                    Queue<Point> q = new LinkedList<>();
                    q.offer(new Point(i, j));
                    while(!q.isEmpty()) {
                        Point p = q.poll();
                        for(int[] dir : dirs) {
                            int x = p.x+dir[0]; int y = p.y+dir[1];
                            if(x>=0 && y>=0 && x<A.length && y<A[0].length && A[x][y]=='1'){
                                A[x][y] = '0';
                                q.offer(new Point(x, y));
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

}

class Point {
    int x; int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
