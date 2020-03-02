/**
 * This contains code for solving the equal sum partition problem using top-down approach, also called real DP
 *
 * Problem Statement : Given a set of non negative integers, determine whether it can be partitioned into two subsets
 * such that sum of elements in both the subsets is same
 * Input : [1, 5, 11, 5]
 * Output : True/False
 *
 * */

package dynamicProgramming;

public class EqualSumPartitionProblem {
    public static void main(String[] args) {
        int[] v = {1, 5, 11, 8};
        System.out.println(equalSumPartition(v));
    }
    private static boolean equalSumPartition(int[] v) {
        int sum = 0;
        for(Integer i : v) {
            sum+=i;
        }
        if(sum%2!=0) return false;
        return SubSetSum.subSetSum(v, sum/2, v.length);
    }
}
