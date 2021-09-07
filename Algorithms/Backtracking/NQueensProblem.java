package Algorithms.Backtracking;

import java.util.Arrays;

public class NQueensProblem {

    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0},
                         {0, 0, 0, 0},
                         {0, 0, 0, 0},
                         {0, 0, 0, 0}};
        System.out.println(placeNQueens(board, 0));

        printSolution(board);
        System.out.println(Arrays.deepToString(board)); // alternative way without decoration
    }

    static void printSolution(int board[][])
    {
        int N = board.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + board[i][j]
                        + " ");
            System.out.println();
        }
    }

    static boolean placeNQueens(int[][] board, int col) {
        int N = board.length;
        if(col>=N) {
            return true; // we have filled grid with all queens
        }

        // let us place in each column and check for each corresponding row
        for(int i = 0; i<N; i++) {
            if(isSafe(board, i, col)) {
                board[i][col] = 1; // place on the grid
                if(placeNQueens(board,col+1)) {
                    return true;
                }
                board[i][col] = 0; // backtrack and mark it as empty spot
            }
        }
        // if queen cannot be placed in any row in this column, return false
        return false;
    }

    private static boolean isSafe(int[][] board, int row, int col) {
        int i, j;
        for(i = 0; i<col; i++) {
            if(board[row][i] == 1)
                return false;
        }

        for(i = row, j = col; i>=0 && j>=0; i--, j--) {
            if(board[i][j] == 1)
                return false;
        }

        for(i=row, j=col; i<board.length && j>=0; i++, j--) {
            if(board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
}
