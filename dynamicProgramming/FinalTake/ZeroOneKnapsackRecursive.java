package dynamicProgramming.FinalTake;

public class ZeroOneKnapsackRecursive {


    public static void main(String[] args) {
        int[] wt = {1,3,4,5}; int[] val = {1,4,5,7}; int W = 7; int n = wt.length;
        System.out.println(getMaxProfit(wt, val, n, W));

    }

    public static int getMaxProfit(int[] wt, int[] val, int n, int W) {
        // base condition
        // smallest valid input, ie when the no of items are 0 or the total weight is 0

        if(n==0 || W==0) return 0;

        // choice diagram
        if(wt[n-1]<=W) {
            return Math.max(val[n-1] + getMaxProfit(wt, val, n-1, W-wt[n-1]), getMaxProfit(wt, val, n-1, W));
        }
        return getMaxProfit(wt, val,n-1, W);
    }
}
