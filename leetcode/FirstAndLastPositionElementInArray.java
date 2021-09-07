package leetcode;

import java.util.Arrays;

/*
LC Medium : https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
* **/
public class FirstAndLastPositionElementInArray {

    private static int[] res = {-1, -1};
    private static int first;
    private static int last;
    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(Arrays.toString(searchRange(nums, 1)));
    }

    public static int[] searchRange(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;
        return binarySearchII(nums, target, l, r);

    }

    private static int[] binarySearchII(int[] nums, int target, int l , int r) {
        int[] ans = {-1, -1};
        if(nums == null || nums.length == 0) return ans;
        if (l > r) return ans;

        int mid = (r + l) / 2;
        if (nums[mid] > target) {
            return binarySearchII(nums, target, l, mid - 1);
        }
        else if(nums[mid]<target) {
            return binarySearchII(nums, target, mid + 1, r);
        } else {
            int first = mid;
            int last = mid;
            while(first-1>=l && nums[first-1] == target) {
                first--;
            }
            while(last+1<=r && nums[last+1] == target) {
                last++;
            }
            return new int[] {first, last};
        }
    }
}
