package leetcode;

import java.util.Stack;

/*
LC Medium : https://leetcode.com/problems/max-area-of-island/
* **/
public class MaxAreaOfIslandII {

    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0}, {0,0,0,0,0,0,0,1,1,1,0,0,0}, {0,1,1,0,1,0,0,0,0,0,0,0,0}, {0,1,0,0,1,1,0,0,1,0,1,0,0}, {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0}, {0,0,0,0,0,0,0,1,1,1,0,0,0}, {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(maxAreaOfIslandIterative(grid));
    }

    public static int maxAreaOfIslandIterative(int[][] grid) {
        int max = Integer.MIN_VALUE;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int m = grid.length; int n = grid[0].length;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++) {
                if(grid[i][j] == 1) {
                    int ans = 0;
                    Stack<int[]> st = new Stack<>();
                    st.push(new int[]{i, j});
                    while (!st.isEmpty()) {

                        int[] p = st.pop();
                        if(p[0]>=0 && p[0] <grid.length && p[1]>=0 && p[1]<grid[0].length && grid[p[0]][p[1]] == 1) {
                            for(int[] dir : dirs) {
                                st.push(new int[]{dir[0]+p[0], dir[1]+p[1]});
                            }
                            ans++;
                            grid[p[0]][p[1]] = 0;
                        }
                    }
                    max = Math.max(max, ans);
                }
            }
        }
        return max==Integer.MIN_VALUE ? 0 : max;
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int m = grid.length; int n = grid[0].length;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(grid[i][j] == 1) {
                    max = Math.max(max, dfs(grid, i, j));
                }
            }
        }
        return max==Integer.MIN_VALUE ? 0 : max;
    }

    private static int dfs(int[][] grid, int i, int j) {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == 0)
            return 0;

        grid[i][j] = 0; // mark as visited

        int res = 1;
        res+=dfs(grid, i+1, j);
        res+=dfs(grid, i-1, j);
        res+=dfs(grid, i, j+1);
        res+=dfs(grid, i, j-1);

        return res;
    }
}
