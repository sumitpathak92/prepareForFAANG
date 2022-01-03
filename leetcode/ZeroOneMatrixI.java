package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
LC Medium : https://leetcode.com/problems/01-matrix/
* **/
public class ZeroOneMatrixI {

    public static void main(String[] args) {
        int[][] mat = {{0,0,0}, {0,1,0}, {0,0,0}};
        System.out.println(Arrays.deepToString(updateMatrix(mat)));
    }

    public static int[][] updateMatrix(int[][] mat) {
            int r = mat.length;
            int c = mat[0].length;
            boolean[][] visited = new boolean[r][c];
            int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            Queue<int[]> q = new LinkedList<>();
            for(int i = 0; i<r; i++) {
                for(int j = 0; j<c; j++) {
                    if(mat[i][j]==0) {
                        q.offer(new int[]{i, j, 0});
                        visited[i][j] = true;
                    }
                }
            }
            while(!q.isEmpty()) {
                int[] n = q.poll();
                mat[n[0]][n[1]] = n[2];
                for(int i =0; i<4; i++) {
                    int rd = n[0] + dir[i][0];
                    int cd = n[1] + dir[i][1];
                    if(rd>=0 && rd<r && cd>=0 && cd<c && !visited[rd][cd]) {
                        q.offer(new int[]{rd, cd, n[2]+1});
                        visited[rd][cd] = true;
                    }
                }
            }
            return mat;
        }
}
