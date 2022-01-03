package leetcode;

import java.util.Arrays;

/*
LC Easy : https://leetcode.com/problems/merge-sorted-array/
* **/
public class MergeSortedArrayII {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m; int i = 0;
        while(p<m+n) {
            nums1[p] = nums2[i];
            i++; p++;
        }
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }
}
