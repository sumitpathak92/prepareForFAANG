package leetcode.ThirtyDaysChallenge.Week1;

import java.util.Arrays;

public class MoveZeroes {

    public static void main(String[] args) {
        int[] A = {0, 1, 0, 3, 12};
        moveZeroes(A);
        System.out.println(Arrays.toString(A));
    }

    public static void moveZeroes(int[] nums) {
        int j = 0;
        for(int i = 0; i<nums.length; i++) {
            if(nums[i]!=0) {
                nums[j] = nums[i];
                j++;
            }
        }
        while (j<nums.length) {
            nums[j]=0;
            j++;
        }
    }
}
