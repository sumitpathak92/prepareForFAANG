package leetcode;

import java.util.Arrays;

import static leetcode.SortArrayByParityII.swap;

/*
LC Medium : https://leetcode.com/problems/sort-colors/
* **/
public class SortColorsII {

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        int p0 = 0; int p2 = nums.length-1; int curr = 0;
        while(curr<=p2) {
            if(nums[curr] == 0) {
                swap(nums, curr, p0);
                curr++;
                p0++;
            }
            else if(nums[curr] == 2) {
                swap(nums, curr, p2);
                p2--;
            } else curr++;
        }
    }
}
