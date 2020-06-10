package dynamicProgramming.UnboundedKnapsack;

/**
 *
 * PS : Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n.
 * Determine the  maximum value obtainable by cutting up the rod and selling the pieces.
 *
 * Example:
 * if length of the rod is 8 and the values of different pieces are given as following, then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
 *
 * length   | 1   2   3   4   5   6   7   8
 * --------------------------------------------
 * price    | 1   5   8   9  10  17  17  20
 *
 *
 * */
public class RodCuttingProblemDP {
    public static void main(String[] args) {
        int[] length = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};

        // this problem is similar to 0-1 knapsack ina way
        // similarities : price[] --> value[] and length[] --> weight[]
        // sum ==> length
        // here one piece of length 1 can be used multiple times to form a rod of given length, hence this is a unbounded knapsack problem unlike 0-1 knapsack
        // where we could use one item only once
        System.out.println(rodCutMaxProfitObtainable(price, length, length.length));
    }

    static int rodCutMaxProfitObtainable(int[] price, int[] length, int n) {
        // using top down approach
        int[] t = new int[n+1];
        t[0] = 0;
        for(int i = 1; i<=n ; i++) {
            int max = Integer.MIN_VALUE;
            for(int j = 0; j<i; j++) {
                max = Math.max(max, price[j]+t[i-j-1]);
            }
            t[i] = max;
        }
        return t[n];
    }
}
