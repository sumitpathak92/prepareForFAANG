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
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println("approach 1  "+minCostClimbingStairs(cost));
        System.out.println("approach 2   " + minCostClimbingStairsGreedy(cost));
    }

    //Approach 1
    public static int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i = 2; i<=cost.length ; i++) {
            int c = (i==cost.length)?0:cost[i];
            dp[i] = Math.min(dp[i-1], dp[i-2])+c;
        }
        return dp[cost.length];
    }

    //Approach 2
    public static int minCostClimbingStairsGreedy(int[] cost) {
        for(int i=2; i<cost.length; i++) {
            cost[i] += Math.min(cost[i-2], cost[i-1]);
        }
        return Math.min(cost[cost.length-1], cost[cost.length-2]);
    }
}
