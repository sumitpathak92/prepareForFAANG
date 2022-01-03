package leetcode;

import java.util.Arrays;

/**
 * LC Medium : https://leetcode.com/problems/ones-and-zeroes/
 * **/
public class OnesAndZeroes {

    public static void main(String[] args) {
        String[] strs = {"10","0001","111001","1","0"};
        System.out.println(findMaxFormRecursive(strs, 5, 3));
    }

    public static int findMaxFormRecursive(String[] strs, int m, int n) {
        int[][][] t = new int[strs.length+1][m+1][n+1];
        for(int i = 0; i< strs.length+1; i++) {
            for (int j = 0; j<m+1; j++) {
                for(int k = 0; k<n+1; k++) {
                    t[i][j][k] = -1;
                }
            }
        }
        return findMax(strs, m, n, strs.length, t);
    }

    static int findMax(String[] S, int m, int n, int p, int[][][] t) {
        // base condition
        if(p==0 || (m==0 && n==0)) {
            return 0;
        }
        if(t[p][m][n]!=-1) {
            return t[p][m][n];
        }
        if(countMandN(S[p-1])[0]<=m && countMandN(S[p-1])[1]<=n) {
            t[p][m][n] = Math.max(1+findMax(S, m-countMandN(S[p-1])[0], n-countMandN(S[p-1])[1], p-1, t), findMax(S, m, n, p-1, t));
        } else {
            t[p][m][n] = findMax(S, m, n, p-1, t);
        }
        return t[p][m][n];
    }

    static int[] countMandN(String s) {
        int[] res = new int[2];
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '0') res[0]++;
            else res[1]++;
        }
        return res;
    }
}
