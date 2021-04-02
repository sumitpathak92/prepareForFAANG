package leetcode;

import java.util.Arrays;

public class MoveZeroes {

    MoveZeroes() {}

    public static void main(String[] args) {
        int[] A = {0,1,0,3,12};
        MoveZeroes zeroes = new MoveZeroes();
        zeroes.moveZeroesII(A);
        System.out.println("after moving ::::  "+ Arrays.toString(A));
    }

    public void moveZeroes(int[] nums) {
        for(int j = 0; j<nums.length; j++) {
            if(nums[j]==0) {
                System.out.println("indexing j::: "+j);
                int k = j+1;
                while(k<nums.length) {
                    if(nums[k]!=0) {
                        swap(nums, j, k);
                        break;
                    }
                    k++;
                }
            }
        }
    }

    public void moveZeroesII(int[] nums) {
        if(nums.length == 0) return;
        int write = 0;
        for(int read = 0; read<nums.length; read++) {
            if(nums[read]!=0){
                nums[write++] = nums[read];
            }
        }
        while(write<nums.length){
            nums[write++] = 0;
        }
    }

    public void swap(int[] A, int a, int b) {
        int tmp = A[a];
        A[a] = A[b];
        A[b] = tmp;
    }

}
