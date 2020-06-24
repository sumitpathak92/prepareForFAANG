package dynamicProgramming.UnboundedKnapsack;

/**
 * Coin Change Problem Minimum Numbers of coins
 *
 * P.S --> Given a value V, if we want to make change for V cents,
 * and we have infinite supply of each of C = { C1, C2, .. , Cm} valued coins, what is the minimum number of coins to make the change?
 *
 * Example:
 *
 * Input: coins[] = {25, 10, 5}, V = 30
 * Output: Minimum 2 coins required
 * We can use one coin of 25 cents and one of 5 cents
 * */
public class CoinCHangeProblemMinimumCoinsDP {

    public static void main(String[] args) {
        int[] coins = {2};
        int V = 3;
        System.out.println(minimumCoinsNeededToProduceSum(coins, V));
    }

    static int minimumCoinsNeededToProduceSum(int[] coins, int sum) {
        //init 1st row and 1st col
        int N = coins.length;
        int dp[][] = new int[N+1][sum+1];
        for(int j=0; j<sum+1; j++) dp[0][j] = Integer.MAX_VALUE-1;
        for(int i=0; i<N+1; i++) dp[i][0] = 0;
        //init 2nd row
        int k = 1;
        for(int i = 1; k<sum+1; k++) {
            if(k%coins[0]==0) dp[i][k] = k/coins[0];
            else dp[i][k] = Integer.MAX_VALUE -1;
        }
        for(int i = 2; i<N+1; i++) {
            for(int j = 1; j<sum+1; j++) {
                if(coins[i-1]<=j) {
                    dp[i][j] = Math.min(dp[i][j-coins[i-1]]+1, dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[N][sum]==Integer.MAX_VALUE-1 ? -1 : dp[N][sum];
    }
}
