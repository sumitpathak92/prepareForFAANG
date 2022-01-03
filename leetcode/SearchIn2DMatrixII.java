package leetcode;

/**
 * LC Medium : https://leetcode.com/problems/search-a-2d-matrix/
 * **/
public class SearchIn2DMatrixII {

    public static void main(String[] args) {
        int[][] A = {{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}};
        int target=20;
        System.out.println(searchMatrix(A, target));
    }

    public static boolean searchMatrix(int[][] A, int target) {
        int row = 0; int col = A[0].length-1;
        while(row<A.length && col>=0) {
            if(A[row][col] == target) return true;
            else if(A[row][col]>target) col--;
            else row++;
        }
        return false;
    }
}
