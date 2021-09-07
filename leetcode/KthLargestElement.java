package leetcode;

import java.util.Arrays;

/*
LC Medium : https://leetcode.com/problems/kth-largest-element-in-an-array/
* **/
public class KthLargestElement {

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(nums, 4));
    }

    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
