/**
 *  https://leetcode.com/problems/matrix-block-sum/
 *
 *  1314. Matrix Block Sum
 */

package leetcode;

import java.util.Arrays;

public class MatrixBlockSum {

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.deepToString(matrixBlockSum(mat, 2)));
    }

    private static int[][] matrixBlockSum(int[][] mat, int K) {
        int[][] answer = new int[mat.length][mat[0].length];
        for(int i = 0; i<mat.length; i++) {
            for(int j = 0; j<mat[0].length; j++) {
                answer[i][j] = getMatrixAddition(mat, i-K, i+K, j-K, j+K);
            }
        }
        return answer;
    }

    private static int getMatrixAddition(int[][] mat, int x1, int x2, int y1, int y2) {
        System.out.println(x1+" "+x2+ " " +y1+ " " +y2);
        if(((x1>=0 && x1<3) && (x2>=0 && x2<3)) || ((y1>=0 && y1<3) && (y2>=0 && y2<3))) {
            int s = 0;
            while(x1<=x2) {
                s+=mat[x1][y1];
            }
            while(y1<=y2) {
                s+=mat[x1][y1];
            }
            return s;
        }
        return 0;
    }
}
