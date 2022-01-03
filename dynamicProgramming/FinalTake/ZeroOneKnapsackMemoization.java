package dynamicProgramming.FinalTake;

public class ZeroOneKnapsackMemoization {

    public static void main(String[] args) {
        int[] wt = {1,3,4,5}; int[] val = {1,4,5,7}; int W = 7; int n = wt.length;
        int[][] t = new int[n+1][W+1];
        for(int i = 0; i<n+1; i++) {
            for(int j = 0; j<W+1; j++) {
                t[i][j] = -1;
            }
        }
        System.out.println(getMaxProfitInKnapsackMemoization(wt, val, n, W, t));
    }

    public static int getMaxProfitInKnapsackMemoization(int[] wt, int[] val, int n, int W, int[][] t) {
        // base condition
        // smallest valid input, ie when the no of items are 0 or the total weight is 0

        if(n==0 || W==0) return 0;
        if(t[n][W]!=-1) return t[n][W];

        // choice diagram
        if(wt[n-1]<=W) {
            t[n][W] = Math.max(val[n-1] + getMaxProfitInKnapsackMemoization(wt, val, n-1, W-wt[n-1], t), getMaxProfitInKnapsackMemoization(wt, val, n-1, W, t));
        } else {
            t[n][W] = getMaxProfitInKnapsackMemoization(wt, val,n-1, W, t);
        }
        return t[n][W];
    }
}
