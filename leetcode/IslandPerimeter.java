package leetcode;

public class IslandPerimeter {

    public static void main(String[] args) {

        int[][] input = {{0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}};
        int[][] input2 = {{1, 1}};
        System.out.println("perimeter is -->  "+islandPerimeter(input2));
    }

    public static int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for(int i = 0; i<grid.length; i++) {
            for(int j = 0; j<grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    perimeter+=4 - totalNeighbours(grid, i, j);
                }
            }
        }
        return perimeter;
    }

        private static int totalNeighbours(int[][] grid, int i, int j) {
            int count = 0;
            // check up neighbour
            if(i<grid.length-1 && grid[i+1][j]==1) count++;
            if(i>0 && grid[i-1][j]==1) count ++;
            if(j<grid[i].length-1 && grid[i][j+1]==1) count++;
            if(j>0 && grid[i][j-1]==1) count++;
            return count;
        }
}
