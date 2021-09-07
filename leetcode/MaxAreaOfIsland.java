package leetcode;


import java.util.Stack;

/**
 *
 * LC Medium : https://leetcode.com/explore/featured/card/june-leetcoding-challenge-2021/603/week-1-june-1st-june-7th/3764/
 * */
public class MaxAreaOfIsland {

    public static void main(String[] args) {
        int[][] grid = {{0,0,0,0,0,0}, {0,0,1,1,0,0}, {0,0,1,1,1,0}, {0,0,0,0,0,0}, {1,1,0,1,0,1}, {0,1,0,0,0,1}};
        System.out.println(maxAreaIterativeDFS(grid));
        System.out.println(maxAreaIterativeDFS(grid) == maxAreaOfIsland(grid));
    }

    public static int maxAreaIterativeDFS(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;
        int[] rm = {-1, 0, 1, 0};
        int[] cm = {0, 1, 0, -1};
        int ans = 0;

        for(int i = 0; i<R; i++) {
            for(int j= 0; j<C; j++) {
                int sum = 0;
                Stack<int[]> st = new Stack<>();
                st.push(new int[]{i, j});
                while(!st.isEmpty()) {
                    int[] el = st.pop();
                    int nr = el[0], nc = el[1];
                    if(nr<0 || nr>=R || nc<0 || nc>=C || grid[el[0]][el[1]] == 0)
                        sum+=0;
                    else {
                        for(int p = 0; p<4; p++) {
                            st.push(new int[]{nr+rm[p], nc+cm[p]});
                        }
                        grid[nr][nc] = 0;
                        sum++;
                    }
                }
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;

        int ans = 0;
        for (int i = 0; i<R; i++) {
            for(int j = 0; j<C; j++) {
                ans = Math.max(ans, dfs(grid, i, j));
            }
        }
        return ans;
    }

    public static int dfs(int[][] grid, int r, int c) {
        if(r<0 || c>=grid[0].length || r>=grid.length || c<0 || grid[r][c] == 0) return 0;
        int ans = 1;
        grid[r][c] = 0; // mark as visited

        ans += dfs(grid, r, c+1);
        ans += dfs(grid, r+1, c);
        ans += dfs(grid, r-1, c);
        ans += dfs(grid, r, c-1);

        return ans;
    }
}
