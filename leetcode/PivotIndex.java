package leetcode;

/**
 *
 * LC Easy : #724 https://leetcode.com/problems/find-pivot-index/
 * */
public class PivotIndex {

    public static void main(String[] args) {
        int[] nums = {-1,-1,-1,0,1,1};
        System.out.println(":::: pivot index ::::::   "+pivotIndex(nums));
    }

    static int pivotIndex(int[] nums) {
        int n = nums.length;
        int sum = 0; int left = 0;
        for(int x: nums) {
            sum+=x;
        }
        for(int i =0; i<n; i++) {
            if(left == sum - left - nums[i]) return i;
            left+=nums[i];
        }
        return -1;
    }
}
