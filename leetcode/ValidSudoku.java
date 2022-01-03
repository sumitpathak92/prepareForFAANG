package leetcode;

import java.util.HashSet;

/*
LC Medium : https://leetcode.com/problems/valid-sudoku/
* **/
public class ValidSudoku {

    public static void main(String[] args) {
        char[][] grid = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        System.out.println(isValidSudokuII(grid));
    }

    public static boolean isValidSudoku(char[][] board) {

        int n = 9;
        HashSet<Character>[] row = new HashSet[n];
        HashSet<Character>[] col = new HashSet[n];
        HashSet<Character>[] box = new HashSet[n];

        for(int i = 0; i<n; i++) {
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
            box[i] = new HashSet<>();
        }
        for(int i = 0; i<board.length; i++) {
            for(int j = 0; j<board[0].length; j++) {

                if(board[i][j] == '.') continue;
                if(row[i].contains(board[i][j])) return false;
                else {
                    row[i].add(board[i][j]);
                }

                if(col[j].contains(board[i][j])) return false;
                else {
                    col[j].add(board[i][j]);
                }
                int boxIndex = i/3*3 + j/3;
                if(box[boxIndex].contains(board[i][j])) return false;
                else {
                    box[boxIndex].add(board[i][j]);
                }
            }
        }
        return true;
    }

    public static boolean isValidSudokuII(char[][] A) {
        // instaed of using hashset to track each row, col and box we use an array to keep track of each number
        // each number n will be present at position n-1, if it has been processed
        int N = 9;
        int[][] row = new int[N][N];
        int[][] col = new int[N][N];
        int[][] box = new int[N][N];

        for(int i = 0; i<N; i++) {
            for(int j = 0; j<N; j++) {

                if(A[i][j] == '.') continue;
                int pos = A[i][j] - '1';

                if(row[i][pos] == 1) return false;
                else {
                    row[i][pos] = 1;
                }

                if(col[j][pos] == 1) return false;
                else {
                    col[j][pos] = 1;
                }

                int bIndex = i/3*3 + j/3;
                if(box[bIndex][pos] == 1) return false;
                else {
                    box[bIndex][pos] = 1;
                }
            }
        }
        return true;



    }
}
