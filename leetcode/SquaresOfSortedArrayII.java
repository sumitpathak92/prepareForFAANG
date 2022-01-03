package leetcode;

import java.util.Arrays;

/*
LC Easy : https://leetcode.com/problems/squares-of-a-sorted-array/
* **/
public class SquaresOfSortedArrayII {

    public static void main(String[] args) {
        int[] nums = {-7,-3,2,3,11};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }

    private static int[] sortedSquares(int[] nums) {
        for (int i = 0; i< nums.length; i++) {
            if(nums[i]<0) nums[i]*=-1;
        }
        int[] res = new int[nums.length];
        int l = 0; int r = nums.length - 1; int sqr;
        for(int i = nums.length-1; i>=0; i--) {
            sqr = 1;
            if(nums[l]<=nums[r]) {
                sqr = nums[r];
                r--;
            } else if(nums[l] > nums[r]) {
                sqr = nums[l];
                l++;
            }
            res[i] = sqr*sqr;
        }
        return res;
    }
}
