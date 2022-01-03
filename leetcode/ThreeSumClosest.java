package leetcode;

import java.util.Arrays;

/*
LC Medium : https://leetcode.com/problems/3sum-closest/
**/
public class ThreeSumClosest {

    public static void main(String[] args) {
        int[] nums = { -1, 2, 1, -4};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }
    private static int threeSumClosest(int[] nums, int target) {
        if(nums.length == 0) return 0;
        int result = nums[0] + nums[1] + nums[nums.length-1]; // temporary result stored
        // sort the array
        Arrays.sort(nums);
        // use three pointer approach like used in 3 sum problem
        for(int i = 0; i<nums.length; i++) {
            int start = i+1;
            int end = nums.length-1;
            while(start<end) {
                int sum = nums[i] + nums[start] + nums[end];
                if(sum>target) {
                    end--;
                } else {
                    start++;
                }
                if(Math.abs(sum - target) < Math.abs(result-target)) {
                    result = sum;
                }
            }
        }
        return result;
    }

}
