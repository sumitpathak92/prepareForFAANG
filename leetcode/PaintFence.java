package leetcode;

import java.util.Arrays;

public class PaintFence {

    public static void main(String[] args) {
        System.out.println(numWaysDPSpaceOptimized(7, 2));
    }

    static int[] dp;
    public static int numWays(int n, int k) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return f(n, k);
    }
    static int f(int n, int k) {
        // base cases
        if(n==1) return k;
        if(n==2) return k*k;
        if(dp[n]!=-1) return dp[n];
        int same = (k-1) * (f(n-2, k));
        int diff = (k-1) * (f(n-1, k));
        return dp[n]=same+diff;
    }

    public static int numWaysDP(int n, int k) {
        int[] dp = new int[n+1];
        dp[1] = k; dp[2] = k*k;
        for(int i=3; i<=n; i++) {
            dp[i] = (k-1)*dp[i-2] + (k-1)*dp[i-1];
        }
        return dp[n];
    }

    public static int numWaysDPSpaceOptimized(int n, int k) {
        if(n==1) return k;
        int prev = k;
        int curr = k*k;
        for(int i = 3; i<=n; i++) {
            int now = (k-1)*(prev+curr);
            prev = curr;
            curr = now;
        }
        return curr;
    }
}
