package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
LC Medium : https://leetcode.com/problems/spiral-matrix
* **/
public class SpiralMatrix {

    static List<Integer> ans = new ArrayList<>();
    public static void main(String[] args) {
        int[][] A = {{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println(spiralOrder(A));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> ans = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        int up = 0; int left = 0; int down = rows-1; int right = cols-1;
        while (ans.size() < rows * cols) {
            // travel from left to right
            for(int col = left; col<=right ; col++){
                ans.add(matrix[up][col]);
            }
            // travel downwards
            for(int row = up+1; row<=down; row++) {
                ans.add(matrix[row][right]);
            }
            if(up!=down) {
                // travel right to left
                for(int col = right-1; col>=left; col--) {
                    ans.add(matrix[down][col]);
                }
            }
            if(left!=right) {
                // travel down to up
                for(int row = down-1; row>up; row--) {
                    ans.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            up++;
            down--;
        }
        return ans;
    }
}
