package leetcode;


/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 * @author Sumit Pathak
 *
 * */
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {

        int[] array = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(array, 0));
    }

    public static int search(int[] nums, int target) {
        int l = 0; int r = nums.length-1;
        if(nums.length == 0) return -1;
        return helper(nums, l, r, target);
    }

    public static int helper(int[] nums, int l, int r, int target) {
        while(l<=r) {
            int mid = l+(r-l)/2;
            if(nums[mid]==target) return mid;
            if(nums[l]<=nums[mid]) {
                if(nums[l]<=target && nums[mid]>=target) r=mid-1;
                else l=mid+1;
            } else {
                if(nums[mid]<=target && target<=nums[r]) l=mid+1;
                else r=mid-1;
            }
        }
        return -1;
    }
}
