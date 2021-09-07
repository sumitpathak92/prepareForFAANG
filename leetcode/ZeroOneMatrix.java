package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * LC medium : https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1388/
 * */

public class ZeroOneMatrix {

    public static void main(String[] args) {
        int[][] mat = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };
        System.out.println(Arrays.deepToString(updateMatrix(mat)));
    }

    public static int[][] updateMatrix(int[][] mat) {
        if(mat.length == 0 || mat[0].length == 0) return mat;
        int m = mat.length;
        int n = mat[0].length;
        int[] rd = {-1, 0, 1, 0};
        int[] cd = {0, 1, 0, -1};
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(mat[i][j]==0) {
                    q.offer(new int[]{i, j, 0});
                    visited[i][j] = true;
                }
            }
        }
        while (!q.isEmpty()) {
            int[] node = q.poll();
            mat[node[0]][node[1]] = node[2];
            for(int i = 0; i<4; i++) {
                int row = node[0]+rd[i];
                int col = node[1]+cd[i];
                if(row>=0 && col>=0 && row<m && col<n && !visited[row][col]) {
                    q.offer(new int[]{row, col, node[2]+1});
                    visited[row][col] = true;
                }
            }
        }
        return mat;
    }
}
