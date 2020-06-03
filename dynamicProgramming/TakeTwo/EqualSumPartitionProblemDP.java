package dynamicProgramming.TakeTwo;


/**
 * This contains code for solving the equal sum partition problem using top-down approach, also called real DP
 *  *
 *  * Problem Statement : Given a set of non negative integers, determine whether it can be partitioned into two subsets
 *  * such that sum of elements in both the subsets is same
 *  * Input : [1, 5, 11, 5]
 *  * Output : True/False
 *  *
 * */
public class EqualSumPartitionProblemDP {

    public static void main(String[] args) {
        int[] A = {1, 5, 11, 5, 6};
        int n = A.length; int sum = 0;
        for(int i = 0; i<n; i++) {
            sum+=A[i];
        }
        if(sum%2!=0) System.out.println(false);
        else {
            System.out.println(equalSumPartition(A, sum/2, n));
        }
    }

    static boolean equalSumPartition(int[] A, int sum, int n) {
        // basically if there exists just one subset with given sum/2, then automatically it can be divided into two subsets
        boolean[][] t = new boolean[n+1][sum+1];
        for(int i = 0; i<n+1; i++) {
            for(int j = 0; j<sum+1; j++) {
                if(i == 0) t[i][j] = false;  // for zero elements there can be no subset
                if(j==0) t[i][j] = true;  // there can always be an empty subset for any sum
            }
        }
        for(int i = 1; i<n+1; i++) {
            for(int j = 1; j<sum+1; j++) {
                if(A[i-1]<=j) {
                    t[i][j] = t[i-1][j-A[i-1]] || t[i-1][j];
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][sum];
    }
}
