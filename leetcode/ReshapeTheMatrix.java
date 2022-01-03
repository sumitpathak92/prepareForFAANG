package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
LC Easy : https://leetcode.com/problems/reshape-the-matrix/solution/
* **/
public class ReshapeTheMatrix {

    public static void main(String[] args) {
        int[][] mat = {{1,2}, {3,4}};
        System.out.println(Arrays.deepToString(matrixReshape(mat, 1, 2)));
    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int[][] res = new int[r][c];
        if(mat.length==0 || r*c!= mat.length*mat[0].length) return mat;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<mat.length; i++) {
            for(int j = 0; j<mat[0].length; j++) {
                q.add(mat[i][j]);
            }
        }
        for(int i = 0; i<r; i++) {
            for (int j=0; j<c; j++) {
                res[i][j] = q.remove();
            }
        }
        return res;
    }
}
