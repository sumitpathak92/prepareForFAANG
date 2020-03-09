//Problem statement

/*
 * Given a m * n matrix grid which is sorted in non-increasing order both row-wise and column-wise.

   Return the number of negative numbers in grid.
 *
/*
*
* Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
  Output: 8
  Explanation: There are 8 negatives number in the matrix.

**/

package leetcode;

public class CountNegativesInSortedMatrix {

    public static void main(String[] args) {
        int[][] grid = {{4,3,2,-1}, {3,2,1,-1}, {1,1,-1,-2}, {-1,-1,-2,-3}};
        System.out.println(countNegatives(grid));
    }

    private static int countNegatives(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int c = 0;
        for(int i=0; i<rows; i++ ){
            for(int j=0; j<cols; j++) {
                if(grid[i][j]<0) {
                    c+=grid[i].length-j;
                    break;
                }
            }
        }
        return c;
    }
}
