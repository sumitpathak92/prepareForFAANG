/**
 *
 *   ## 746
 * * https://leetcode.com/problems/min-cost-climbing-stairs/
 *
 *   Statement :   On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 *                 Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor,
 *                 and you can either start from the step with index 0, or the step with index 1.
 *   Input: cost = [10, 15, 20]
 *   Output: 15
**/

package leetcode;

public class MinCostClimbingStairs {

    public static void main(String[] args) {
        int[] A = {10, 15, 20};
        System.out.println(minCostClimbingStairs(A));
    }

    static int[] dp;
    public static  int minCostClimbingStairs(int[] A) {
        int n = A.length;
        dp = new int[n];
        // initialize base cases
        dp[0] = A[0]; dp[1] = A[1];
        for(int i = 2; i<n; i++) {

            dp[i] = A[i]+Math.min(dp[i-1], dp[i-2]);
        }
        return Math.min(dp[n-1], dp[n-2]);
    }

}
