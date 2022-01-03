package leetcode;

/**
 * LC Medium : https://leetcode.com/problems/coin-change/
 * **/
public class CoinChange {

    public static void main(String[] args) {
        int[] A = {1,2,5};
        int sum = 11;
        System.out.println(coinChange(A, sum));
    }

    public static int coinChange(int[] A, int sum) {
        int N = A.length; int W = sum;
        int[][] t = new int[N+1][W+1];

        // base case initialization, initializes first row and col
        for(int i = 0; i<N+1; i++) {
            t[i][0] = 0;
        }
        for(int j = 0; j<W+1; j++) {
            t[0][j] = Integer.MAX_VALUE-1;
        }

        // initialize second row

        for(int j = 1; j<W+1; j++) {
            if(j%A[0]==0) t[1][j] = j/A[0];
            else t[1][j] = Integer.MAX_VALUE-1;
        }

        // choice diagrams code
        for(int i = 1; i<N+1; i++) {
            for(int j = 1; j<W+1; j++) {
                if(A[i-1]<=j)
                    t[i][j] = Math.min(t[i][j-A[i-1]]+1, t[i-1][j]);
                else
                    t[i][j] = t[i-1][j];
            }
        }

        return t[N][W]==Integer.MAX_VALUE-1?-1:t[N][W];
    }
}
