package dynamicProgramming.FinalTake;

/**
 * Coin change problem to find max no of ways to get a certain sum
 * Given coins are infinitely available.
 *
 * This is a variant of Unbounded Knapsack problem
 * **/
public class CoinChangeI {

    public static void main(String[] args) {
        int[] coins = {1,2,3}; int sum = 5;
        System.out.println(getMaxWays(coins, sum));
    }

    static int getMaxWays(int[] A, int sum) {
        // similar to subset sum problem
        // base case initialization
        int N = A.length; int W = sum;
        int[][] t = new int[N+1][W+1];
        for(int i = 0; i<N+1; i++) {
            for(int j=0; j<W+1; j++) {
                if(i==0) // if there are no coins, no matter what the sum is, ways will always be zero
                    t[i][j] = 0;
                if(j==0) // if the sum is zero, there is always an empty set which sum up to zero, hence we put 1 there
                    t[i][j] = 1;
            }
        }

        for(int i = 1; i<N+1; i++) {
            for(int j = 1; j<W+1; j++) {
                if(A[i-1]<=j) {
                    t[i][j] = t[i][j-A[i-1]] // this coin can be used again, hence in not yet processed state +
                              + t[i-1][j];
                } else {
                    t[i][j] = t[i-1][j]; // dont include it at all
                }
            }
        }
        return t[N][W];
    }
}
