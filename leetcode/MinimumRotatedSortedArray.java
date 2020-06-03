package leetcode;

/**
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 *
 * Find the minimum element.
 *
 * You may assume no duplicate exists in the array.
 *
 * Input: [3,4,5,1,2]
 * Output: 1
 *
 * */

public class MinimumRotatedSortedArray {

    public static void main(String[] args) {
        int[] array = {1};
        System.out.println(findMin(array));
    }

    public static int findMin(int[] nums) {
        if(nums[0]<=nums[nums.length-1]) return nums[0];
        return nums[helper(nums, 0, nums.length-1)];
    }

    public static int helper(int[] nums, int l, int r) {
        // binary search
        while(l<=r) {
            int mid = l+(r-l)/2;
            if(mid>0 && nums[mid]<nums[mid-1]) return mid;
            if(nums[mid]>nums[nums.length-1]) l = mid+1;
            else r = mid-1;
        }
        return -1; // no element found
    }
}
