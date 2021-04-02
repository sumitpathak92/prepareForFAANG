package leetcode;

import java.util.Arrays;

/**
 *
 * problem :  https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * */

public class TwoSumII {

    public static void main(String[] args) {
        int[] A = {2, 7, 11, 15};
        System.out.println("sum is "+ Arrays.toString(twoSum(A, 9)));
    }

    public static int[] twoSum(int[] A, int target) {
        int i = 0, j = A.length - 1;
        while(i<j) {
            if(A[i]+A[j] == target) {
                return new int[] {i+1, j+1};
            } else if(A[i]+A[j]<target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[]{-1};
    }
}
