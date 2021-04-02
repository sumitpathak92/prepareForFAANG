package leetcode;

import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {
        int[] A = {0}; int m = 0;
        int[] B = {1}; int n =1;
        System.out.println(Arrays.toString(mergeII(A, m, B, n)));
    }

    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        int[] copy = new int[m];
        for (int p = 0; p < m; p++) {
            copy[p] = nums1[p];
        }
        for (int k = 0; k < m + n; k++) {
            if (j>=n || (i < m && copy[i] < nums2[j])) {
                nums1[k] = copy[i++];
            } else {
                nums1[k] = nums2[j++];
            }
        }
        return nums1;
    }

    public static int[] mergeII(int[] A, int m, int[] B, int n) {
        int p1 = m-1, p2 = n-1;
        if(p1<0 || p2<0) return new int[]{};
        for(int p =m+n-1; p>=0; p--) {
            if(p2<0) break;
            if(p1>=0 && A[p1]>B[p2]) {
                A[p] = A[p1--];
            } else {
                A[p] = B[p2--];
            }
        }
        return A;
    }
}
