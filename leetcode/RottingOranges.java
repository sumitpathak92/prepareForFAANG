package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*
LC Medium : https://leetcode.com/problems/rotting-oranges/
* **/
public class RottingOranges {

    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 1}, {0, 1, 2}};
//        int[][] grid = {{1,2}};
//        int[][] grid = {{2,1,1}, {0,1,1}, {1,0,1}};
        System.out.println(orangesRotting(grid));
    }

    public static int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // put all rotten in a queue
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
                else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0) return 0;
        int count = 0;
        while (!q.isEmpty()) {

            ++count;
            int s = q.size();
            for (int j = 0; j < s; j++) {
                int[] node = q.poll();
                for (int i = 0; i < 4; i++) {
                    int rd = node[0] + dirs[i][0];
                    int cd = node[1] + dirs[i][1];
                    if (rd >= 0 && rd < m && cd >= 0 && cd < n) {
                        if (grid[rd][cd] == 1) {
                            grid[rd][cd] = 2;
                            q.offer(new int[]{rd, cd});
                            //visited[rd][cd] = true;
                            fresh--;
                        }
                    }
                }
            }
        }
        return fresh == 0 ? count - 1 : -1;
    }
}
