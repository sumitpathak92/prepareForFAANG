package recursion.backtracking;

public class SudokuSolver {

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        if (solver(board))
            display(board);
    }

    public static boolean solver(char[][] grid) {
        for(int i = 0; i<grid.length; i++) {
            for(int j = 0; j<grid[0].length; j++) {
                if(grid[i][j]=='.'){
                    for(char k = '1'; k<='9'; k++) {
                        if(isSafe(grid, i, j, k)) {
                            grid[i][j] = k;
                            if(solver(grid)) {
                                return true;
                            } else {
                                grid[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static void display(char[][] board) {

        for(char[] row : board) {
            System.out.println();
            for(char el : row ) {
                System.out.print(el);
            }
        }
    }

    static boolean isSafe(char[][] grid, int r, int c, char num) {
        // check all values in row
        for(int i = 0; i< grid.length; i++) {
            if(grid[r][i] == num ) return false;
        }

        // check all values in col
        for(int i = 0; i< grid.length; i++) {
            if(grid[i][c] == num) return false;
        }

        int sqrt = (int)Math.sqrt(grid.length);
        int rStart = r-r%sqrt; int cStart = c-c%sqrt;
        for(int i = rStart; i<rStart+sqrt; i++) {
            for(int j = cStart; j<cStart+sqrt; j++) {
                if(grid[i][j]==num) {
                    return false;
                }
            }
        }
        return true;
    }
}
