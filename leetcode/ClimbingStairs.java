package leetcode;

public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }

    public static int getTotalWays(int n){
        if(n==1) return 1;
        else if(n==2) return 2;
        return getTotalWays(n-1)+ getTotalWays(n-2);
    }

    public static int climbStairs(int n) {
        int dp[] = new int[n+1];
        if(n==1) return 1;
        if(n==2) return 2;
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i<=n; i++) {
            dp[i] = dp[i-2]+dp[i-1];
        }
        return dp[n];
    }
}
