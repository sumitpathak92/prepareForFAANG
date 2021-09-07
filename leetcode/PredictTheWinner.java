package leetcode;

public class PredictTheWinner {

    public static void main(String[] args) {
        int[] nums = {1, 5, 2};
        System.out.println(PredictTheWinner(nums));
    }

    public static boolean PredictTheWinner(int[] nums) {
        return helper(nums, 0, nums.length-1, 1)>=0;
    }

    private static int helper(int[] nums, int start, int end, int chance) {
        if(start == end) {
            return chance*nums[start];
        }
        int first = chance*nums[end]+helper(nums, start, end-1, -chance);
        int second = chance*nums[start]+helper(nums, start+1, end, -chance);
        return chance*Math.max(chance*first, chance*second);
    }

}
