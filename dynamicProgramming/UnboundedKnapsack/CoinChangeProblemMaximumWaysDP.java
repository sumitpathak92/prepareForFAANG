package dynamicProgramming.UnboundedKnapsack;

/**
 *
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins,
 * how many ways can we make the change? The order of coins doesn’t matter.
 *
 * Example:
 * for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4.
 *
 * */
public class CoinChangeProblemMaximumWaysDP {

    public static void main(String[] args) {
        // inputs
        int[] coin = {1, 2, 5};
        int S = 11;

        System.out.println(getMaxNoOfWays(coin, S));
    }

    static int getMaxNoOfWays(int[] coins, int W) {
        // this is similar to subset sum problem in a way
        // here we need to get count of subset sum
        // but we can include an element from the arrauy multiple times, not just once like the subset sum problem
        int N = coins.length;
        int[][] t = new int[N+1][W+1];
        for(int i = 0; i<=N; i++) {
            for(int j = 0; j<=W; j++) {
                if(i==0) t[i][j] = 0;
                if(j==0) t[i][j] = 1;
            }
        }
        for(int i = 1; i<=N; i++) {
            for(int j = 1; j<=W; j++) {
                if(coins[i-1]<=j) {
                    t[i][j] = t[i-1][j] + t[i][j-coins[i-1]];
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        for(int[] i : t) {
            printRow(i);
        }

        return t[N][W];
    }
    public static void printRow(int[] row) {
        for (int i : row) {
            System.out.print(i);
            System.out.print("\t");
        }
        System.out.println();
    }
}
