package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
LC Medium : https://leetcode.com/problems/set-matrix-zeroes/
* **/
public class SetMatrixZeroes {

    public static void main(String[] args) {
        int[][] A = {{1, 0, 3}};
        setZeroesII(A);
        System.out.println(Arrays.deepToString(A));
    }

    public static void setZeroes(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(A[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(rows.contains(i) || cols.contains(j)) A[i][j] = 0;
            }
        }
    }

    public static void setZeroesII(int[][] A) {
        boolean fr = false;
        boolean fc = false;
        int m = A.length;
        int n = A[0].length;
        for(int i =0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(A[i][j] == 0) {
                    A[i][0] = 0; A[0][j] = 0;
                    if(i==0) fr=true; if(j==0) fc=true;
                }
            }
        }
        for(int i = 1; i<m; i++) {
            for(int j = 1; j<n; j++) {
                if(A[i][0] == 0 || A[0][j] == 0) {
                    A[i][j] = 0;
                }
            }
        }
        if(fr) {
            int p = 0;
            while (p < A[0].length) {
                A[0][p] = 0;
                p++;
            }
        }
        if(fc) {
            int q = 0;
            while(q<A.length) {
                A[q][0] = 0;
                q++;
            }
        }
    }
}

