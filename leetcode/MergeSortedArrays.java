package leetcode;

import java.util.Arrays;

/*
LC Easy : https://leetcode.com/problems/merge-sorted-array/
* **/
public class MergeSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0;
        while(m<nums1.length && i< nums2.length) {
            nums1[m] = nums2[i];
            i++; m++;
        }

        Arrays.sort(nums1);
    }
}
