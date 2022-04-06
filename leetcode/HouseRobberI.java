package leetcode;

/**
 * LC Medium : https://leetcode.com/problems/house-robber/
 * **/
public class HouseRobberI {

    public static void main(String[] args) {
        int[] A = {2,7, 9,3,1};
        System.out.println(robII(A));
    }

    static int[] dp;
    public static int rob(int[] A) {
        int n = A.length-1;
        dp = new int[n+1];
        dp[0] = A[0];
        for(int i = 1; i<=n ; i++) {
            int take = A[i];
            if(i-2>=0) take+=dp[i-2];
            int nottake = dp[i-1];
            dp[i] = Math.max(take, nottake);
        }
        return dp[n];
    }

    public static int robII(int[] A) {
        int n = A.length-1;
        int prev = A[0];
        int prev2 = 0;
        for(int i = 1; i<=n ; i++) {
            int take = A[i];
            if(i-2>=0) take+=prev2;
            int nottake = prev;
            int curri = Math.max(take, nottake);
            prev2 = prev; prev = curri;
        }
        return prev;
    }

    // recursion with memoization
    static int f(int idx, int[] A) {
        if(idx == 0) return A[idx];
        if(idx<0) return 0;
        if(dp[idx]>0) return dp[idx];
        int take = A[idx];
        if(idx>1) take+=f(idx-2, A);
        int notTake = f(idx - 1, A);

        return dp[idx] = Math.max(take, notTake);
    }
}
