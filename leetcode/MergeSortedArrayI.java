package leetcode;

import java.util.Arrays;

/**
 * LC Easy : https://leetcode.com/problems/merge-sorted-array/
 * **/
public class MergeSortedArrayI {

    public static void main(String[] args) {
        int[] A = {1,2,3,0,0,0}; int[] B = {2,5,6};
        merge(A, 3, B, 3);
        System.out.println(Arrays.toString(A));
    }

    public static void merge(int[] A, int m, int[] B, int n) {
        int i = 0; int j = 0;
        while(i<A.length && j<n) {
            if(A[i]<=B[j])
                i++;
            else {
                A[m] = A[i];
                A[i] = B[j];
                j++; m++;
            }
        }
        System.out.println(m + "  " +j);
        while(m<A.length) {
            A[m] = B[j];
            j++; m++;
        }
    }
}
