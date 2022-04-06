package leetcode;

import java.util.*;

/*
LC Medium : https://leetcode.com/problems/set-matrix-zeroes/
* **/
public class SetMatrixZeroesII {

    public static void main(String[] args) {
        int[][] A = {{1,1,1}, {1,0,1}, {1,1,1}};
        setZeroes(A);
        System.out.println(Arrays.deepToString(A));
    }

    public static void setZeroes(int[][] A) {
        boolean fr = false; boolean fc = false;
        for(int i = 0; i<A.length; i++) {
            for(int j = 0; j<A[0].length; j++) {
                if(A[i][j] == 0) {
                    A[i][0] = 0;
                    A[0][j] = 0;
                    if(i==0) fr = true;
                    if(j==0) fc = true;
                }
            }
        }

        for(int i = 1; i<A.length; i++) {
            for(int j = 1; j<A[0].length; j++) {
                if(A[0][j]==0 || A[i][0]==0)
                    A[i][j] = 0;
            }
        }
        if(fr) {
            int i = 0;
            while(i<A[0].length) {
                A[0][i] = 0;
                i++;
            }
        }
        if(fc) {
            int i = 0;
            while(i<A.length) {
                A[i][0] = 0;
                i++;
            }
        }
    }
}

