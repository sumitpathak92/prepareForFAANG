package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class HouseRobberII {

//    private static int total = 0;
    static int[] cache = new int[100];
    public static void main(String[] args) {
        int[] A = {1,2,3,1};
        System.out.println(rob(A));
    }

    public static int rob(int[] A) {
        Arrays.fill(cache, -1);
        return dp(A, 0);
    }

    private static int dpRecursive(int[] A, int start) {
        /**
         * This recursive solution wil result in TLE
         * **/
        if(start>=A.length) return 0;  // base case

        return Math.max(dpRecursive(A, start+1), dpRecursive(A, start+2)+A[start]);

    }

    private static int dp(int[] A, int start) {
        if(start>=A.length) return 0;
        if(cache[start]!=-1) return cache[start];

        cache[start] = Math.max(dp(A, start+1), A[start]+dp(A, start+2));
        return cache[start];
    }
}
