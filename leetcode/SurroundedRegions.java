package leetcode;


import java.util.Arrays;

/**
 *
 * LC Medium : https://leetcode.com/problems/surrounded-regions/
 * */
public class SurroundedRegions {

    public static void main(String[] args) {
        char[][] ip = {
                {'O'}
        };

        solve(ip);
        System.out.println(Arrays.deepToString(ip));
    }

    public static void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        if(m==1) return;
        int dir[][] = {{1,0}, {-1,0}, {0,-1}, {0,1}};
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if((i == 0 || j==0 || i==m-1 || j==n-1) && board[i][j] == 'O') {
                    dfs(board, i, j, dir);
                }
            }
        }

        for(int i = 0; i<m; i++) {
            for(int j =0; j<n; j++) {
                if(board[i][j] == 'Z')
                    board[i][j] = 'O';
                else board[i][j] = 'X';
            }
        }
    }

    public static void dfs(char[][] board, int r, int c, int[][] dir) {
        board[r][c] = 'Z';
        int m = board.length; int n = board[0].length;
        for(int d = 0; d<4; d++) {
            int rc = r+dir[d][0];
            int cc = c+dir[d][1];
            if(rc>=0 || cc>=0 && rc<m && cc<n && board[rc][cc]=='O')
                dfs(board, rc, cc, dir);
        }

    }
}
