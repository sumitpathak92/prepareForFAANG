package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * LC medium: https://leetcode.com/explore/learn/card/queue-stack/231/practical-application-queue/1374/
 * */

public class NumberOfIslandsIII {

    private static int[] rows = {-1, 0, 1, 0};
    private static int[] cols = {0, 1, 0, -1};

    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0', '0', '1', '1'}
        };
        System.out.println("No of islands are ::::   "+numIslands(grid));
    }

    /**
     * This solution uses BFS approach to calculate number of islands in the grid
     * */
    public static int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(grid[i][j]=='1') {
                    count += 1 + bfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public static int bfs(char[][] grid, int i, int j) {
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        while(!q.isEmpty()) {
            int[] coord = q.poll();
            int row = coord[0]; int col = coord[1];
            for(int p = 0; p<4; p++) {
                int r = row + rows[p];
                int c = col + cols[p];
                if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c] == '0') {
                    continue;
                }
                grid[r][c] = '0'; // mark them visited
                q.offer(new int[] {r, c});
            }
        }
        return count;
    }
}
