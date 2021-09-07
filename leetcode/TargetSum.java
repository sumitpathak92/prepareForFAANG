package leetcode;


/**
 * LC Medium : https://leetcode.com/explore/learn/card/queue-stack/232/practical-application-stack/1389/
 * */
public class TargetSum {

    public static void main(String[] args) {
        int[] nums = {1};
        int target = -1;
        System.out.println(findTargetSumWays(nums, target));
    }

    public static int findTargetSumWays(int[] nums, int target) {
        if(nums.length == 1) {
            return nums[0]==target || nums[0]== -target ? 1 : 0;
        }
        return sumWays(nums, target, 0, 0);
    }

    public static int sumWays(int[] nums, int target, int c, int sum) {
        // base case
        if(c == nums.length) {
            if(sum == target)
                return 1;
            return 0;
        }
        return sumWays(nums, target, c+1, sum-nums[c])+ sumWays(nums, target, c+1, sum+nums[c]);
    }
}
