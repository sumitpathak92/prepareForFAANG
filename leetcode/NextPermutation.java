package leetcode;

import java.util.Arrays;

/*
LC Medium : https://leetcode.com/problems/next-permutation/
* **/
public class NextPermutation {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] A) {
        if (A.length == 1) return;
        int i = A.length - 2;
        while (i >= 0 && A[i] >= A[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = A.length - 1;
            while (A[j] <= A[i]) {
                j--;
            }
            swap(A, i, j);
        }
        reverse(A, i + 1, A.length - 1);
    }

    private static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    private static void reverse(int[] A, int i, int j) {
        while(i<j) {
            swap(A, i, j);
            i++; j--;
        }
    }

}
