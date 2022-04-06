package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class HouseRobberII {

    public static void main(String[] args) {
        int[] A = {1,2,3,1};
        System.out.println(rob(A));
    }
    static int[] dp;
    static int rob(int[] A) {
        int[] A1 = new int[A.length];
        int[] A2 = new int[A.length];
        for(int i = 0; i<A.length; i++) {
            if(i!=0) A1[i] = A[i];
            if(i!=A.length-1) A2[i] = A[i];
        }
        System.out.println(Arrays.toString(A1) +"   "+ Arrays.toString(A2));
        int first = f(A1);
        int sec = f(A2);
        return Math.max(first, sec);
    }

    static int f(int[] A) {
        int n = A.length;
        dp = new int[n];
        dp[0] = A[0];
        for(int i = 1; i<n; i++) {
            int take = A[i];
            if(i>1) take+=dp[i-2];
            int noTake = dp[i-1];
            dp[i] = Math.max(take, noTake);
        }
        return dp[n-1];
    }
}
