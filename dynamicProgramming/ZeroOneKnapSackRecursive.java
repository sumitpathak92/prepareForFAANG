/**
 * This contains code for solving the 0-1 Knapsack problem using recursion
 * */

package dynamicProgramming;

public class ZeroOneKnapSackRecursive {

    public static void main(String[] args) {
        int[] wt = {1, 3, 4, 5};
        int[] v = {1, 4, 5, 7};
        int W = 7;
        int n = 3;
        System.out.println(zeroOneKnapSack(wt, v, W, n));
    }

    private static int zeroOneKnapSack(int[] wt, int[] v, int W, int n) {
        if(n==0 || W==0) {
            // base case for recursion
            return 0;
        }
        // choice diagram
        if(wt[n-1]<=W) {
            return Math.max(v[n-1]+zeroOneKnapSack(wt, v, W-wt[n-1], n-1), zeroOneKnapSack(wt, v, W, n-1));
        }
        return zeroOneKnapSack(wt, v, W, n-1);
    }

}
