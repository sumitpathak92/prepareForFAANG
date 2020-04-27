package leetcode.ThirtyDaysChallenge.Week3;

import java.util.Arrays;

/**
 *
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 *
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 *
 * */

public class ProductExceptSelf {

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(A)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int l = nums.length;
        int[] res = new int[l];
        int[] left = new int[l];
        int[] right = new int[l];
        for(int i = 0; i<l; i++) {
            int j = 0; int k =i+1;
            left[i] = product(Arrays.copyOfRange(nums, j, i));
            right[i] = product(Arrays.copyOfRange(nums, k, l));
            res[i] = left[i]*right[i];
        }
        return res;
    }

    public static int product(int[] array) {
        int prod = 1;
        for(int i : array) prod*=i;
        return prod;
    }
}
