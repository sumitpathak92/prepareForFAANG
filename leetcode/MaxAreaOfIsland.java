package leetcode;


import java.util.Stack;

/**
 *
 * LC Medium : https://leetcode.com/explore/featured/card/june-leetcoding-challenge-2021/603/week-1-june-1st-june-7th/3764/
 * */
public class MaxAreaOfIsland {

    public static void main(String[] args) {
        int[][] grid = {{0,0,0,0,0,0}, {0,0,1,1,0,0}, {0,0,1,1,1,0}, {0,0,0,0,0,0}, {1,1,0,1,0,1}, {0,1,0,0,0,1}};
        System.out.println(maxAreaOfIsland(grid));
//        System.out.println(maxAreaIterativeDFS(grid) == maxAreaOfIsland(grid));
    }

//    public static int maxAreaIterativeDFS(int[][] grid) {
//
//    }

    public static int maxAreaOfIsland(int[][] A) {
        int m = A.length; int n = A[0].length;
        int res = Integer.MIN_VALUE;
        for(int i=0;i<m; i++) {
            for(int j=0; j<n; j++) {
                if(A[i][j]==1) {
                    res = Math.max(res, dfs(A, i, j));
                }
            }
        }
        return res==Integer.MIN_VALUE?0:res;
    }

    public static int dfs(int[][] A, int i, int j) {
        if(i<0 || i>=A.length || j<0 || j>=A[0].length || A[i][j]==0)
            return 0;
        A[i][j] = 0;
        int ans = 1;
        ans+=dfs(A, i+1, j);
        ans+=dfs(A, i-1, j);
        ans+=dfs(A, i, j+1);
        ans+=dfs(A, i, j-1);
        return ans;
    }
}
