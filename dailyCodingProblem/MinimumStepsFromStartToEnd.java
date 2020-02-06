package dailyCodingProblem;

public class MinimumStepsFromStartToEnd {

    public static void main(String[] args) {
        int[][] grid = {{'f', 'f', 'f', 'f'},
                        {'t', 't', 'f', 't'},
                        {'f', 'f', 'f', 'f'},
                        {'f', 'f', 'f', 'f'}};
        int i = 3, j = 0;
        int m = 0, n = 0;
        System.out.println(getMinimumSteps(grid, i, j, m, n));
    }

    public static int getMinimumSteps(int[][] grid, int sx, int sy, int ex, int ey) {
        if(sx>grid.length || sy<grid[sx].length) {
            return 0;
        }
        if(sx==ex && sy==ey) return 1;
        return Math.min(Math.min(getMinimumSteps(grid, sx+1, sy, ex, ey), getMinimumSteps(grid, sx-1, sy, ex, ey)), Math.min(getMinimumSteps(grid, sx, sy+1, ex, ey), getMinimumSteps(grid, sx, sy-1, ex, ey)));

    }
}

