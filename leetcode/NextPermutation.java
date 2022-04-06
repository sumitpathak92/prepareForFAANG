package leetcode;

import java.util.Arrays;

/*
LC Medium : https://leetcode.com/problems/next-permutation/
* **/
public class NextPermutation {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 2};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] A) {
        int ind1=0; int ind2=A.length-1;
        int j = A.length-2;
        while(j>=0 && A[j]>=A[j+1]) {
            j--;
        }
        if(j>=0) {
            while(A[ind2]<=A[j])
                ind2--;
            swap(A, ind2, j);
        }
        reverse(A, j+1, A.length-1);
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
