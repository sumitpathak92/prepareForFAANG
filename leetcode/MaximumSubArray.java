package leetcode;

/*
LC Easy : https://leetcode.com/problems/maximum-subarray/
* **/
public class MaximumSubArray {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int current = nums[0];
        int max = nums[0];
        for(int i = 1; i<nums.length; i++) {
            int num = nums[i];
            current = Math.max(num, current+num);
            max = Math.max(max, current);
        }
        return max;
    }
}
