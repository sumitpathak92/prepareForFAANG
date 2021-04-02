package leetcode;

import javax.swing.*;

/**
 *
 * problem :   https://leetcode.com/problems/candy-crush/
 *
 * */

public class CandyCrush {

    /**
     * Two step process:
     *  1. Mark to crush
     *  2. Collapse after crushing
     *
     * */
    public static void main(String[] args) {

    }

    public static int[][] candyCrush(int[][] board) {
        while(markToCrush(board)) {
            collapse(board);
        }
        return board;
    }


    public static boolean markToCrush(int[][] board) {
        boolean toCrush = false;
        for(int r = 0; r<board.length; r++) {
            for(int c = 0; c<board[0].length; c++) {
                if(board[r][c]==0) continue;
                toCrush |= checkRow(board, r, c);
                toCrush |= checkCol(board, r, c);
            }
        }
        return toCrush;
    }

    public static boolean checkRow(int[][] board, int r, int c) {
        if(r+2<board.length && Math.abs(board[r][c]) == Math.abs(board[r+1][c]) && Math.abs(board[r][c]) == Math.abs(board[r+2][c])) {
            board[r][c] = -Math.abs(board[r][c]);
            board[r+1][c] = -Math.abs(board[r+1][c]);
            board[r+2][c] = -Math.abs(board[r+2][c]);
            return true;
        }
        return false;
    }

    public static boolean checkCol(int[][] board, int r, int c) {
        if(c+2<board[0].length && Math.abs(board[r][c+1]) == Math.abs(board[r][c]) && Math.abs(board[r][c+2]) == Math.abs(board[r][c])) {
            board[r][c] = -Math.abs(board[r][c]);
            board[r][c+1] = -Math.abs(board[r][c+1]);
            board[r][c+2] = -Math.abs(board[r][c+2]);
            return true;
        }
        return false;
    }

    public static int[][] collapse(int[][] grid) {
        for(int i=0; i<grid[0].length; i++) {
            int r = grid.length;
            for(int top = grid.length-1; top>0; top--) {
                if(grid[top][i] > 0) {
                    grid[r--][i] = grid[top][i];
                }
            }
            while (r>=0) grid[r--][i] = 0;
        }
        return grid;
    }


}
