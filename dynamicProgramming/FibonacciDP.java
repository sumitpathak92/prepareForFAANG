package dynamicProgramming;

import java.util.Arrays;

public class FibonacciDP {

    static int[] dp;
    public static void main(String[] args) {
        int n = 55;
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(fibDP(n)) ;
    }

    static int fibDP(int n) {
        if(n<=1) return n;
        if(dp[n]!=-1) return dp[n];
        return dp[n] = fibDP(n-1)+fibDP(n-2);
    }

    static int fibRec(int n) {
        if(n<=1) return n;
        return fibRec(n-1)+fibRec(n-2);
    }
}
