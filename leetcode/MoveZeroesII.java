package leetcode;

import java.util.Arrays;

/*
LC Easy : https://leetcode.com/problems/move-zeroes/
* **/
public class MoveZeroesII {

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        System.out.println("Before::::   "+ Arrays.toString(nums));
        moveZeroes(nums);
        System.out.println("After:::   "+ Arrays.toString(nums));
    }

    private static void moveZeroes(int[] A) {
        int j = 0;
        for(int i = 0; i<A.length; i++) {
            if(A[i]!=0) {
                A[j] = A[i];
                j++;
            }
        }
        while(j<A.length) {
            A[j++] = 0;
        }
    }
}
