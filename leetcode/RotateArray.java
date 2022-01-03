package leetcode;

import java.util.Arrays;

/*
LC Medium : https://leetcode.com/problems/rotate-array/
* **/
public class RotateArray {

    static int[] A = {-1, -100, 3, 99};
    public static void main(String[] args) {
        rotateII(A, 2);
        System.out.println(Arrays.toString(A));
    }

    public static void rotateII(int[] nums, int k) {
       int[] res = new int[nums.length];
       for(int i = 0; i<nums.length; i++) {
           res[(i+k)% nums.length] = nums[i];
       }
       for(int i = 0; i<nums.length; i++) {
           nums[i] = res[i];
       }
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {
        k%= nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    private static void reverse(int[] A, int start, int end) {
        while (start<end) {
            int tmp = A[start];
            A[start] = A[end];
            A[end] = tmp;
            start++;
            end--;
        }
        System.out.println(Arrays.toString(A));
    }
}
