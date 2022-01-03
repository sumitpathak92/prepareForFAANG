package leetcode;

/**
 * LC Hard : https://leetcode.com/problems/n-queens-ii/
 * **/
public class NQueensII {

    public static void main(String[] args) {
        System.out.println(totalNQueens(4));
    }

    public static int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        return queens(board, 0);
    }
    static int queens(boolean[][] board, int r) {
        if(r==board.length) {
            return 1;
        }
        // placing the queen and checking for every row and col
        int count = 0;
        for(int col=0; col<board[0].length; col++) {
            // place queen if its safe
            if(isSafe(board, r, col)) {
                board[r][col] = true;
                count+=queens(board, r+1);
                board[r][col] = false;
            }
        }

        return count;
    }

    private static boolean isSafe(boolean[][] board, int r, int col) {
        // check vertical row
        for(int i=0; i<r; i++) {
            if(board[i][col])
                return false;
        }
        // diagonal left
        int maxLeft = Math.min(r, col);
        for (int i=1; i<=maxLeft; i++) {
            if(board[r-i][col-i])
                return false;
        }

        // diagonal right
        int maxRight = Math.min(r, board.length-col-1);
        for (int i=1; i<=maxRight; i++) {
            if(board[r-i][col+i])
                return false;
        }
        return true;
    }
}
