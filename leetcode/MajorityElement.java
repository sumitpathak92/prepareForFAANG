package leetcode;

/**
 *
 * LC Easy : https://leetcode.com/problems/majority-element/
 * **/
import java.util.Arrays;

public class MajorityElement {

    public static void main(String[] args) {
        int[] input = {3,2,3};
        System.out.println("output is  -> "+majorityElement(input));
    }

    static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
