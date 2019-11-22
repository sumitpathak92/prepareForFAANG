package leetcode;

import java.util.*;

public class SortArrayByParityII {

    static int[] input = {4,2,5,7};
    static int[] output = new int[input.length];
    public static void main(String[] args) {
        sortArrayByParityIII(input);
        System.out.println("-->");
        for (Integer i: input) {
            System.out.println("*  "+i);
        }
    }
    static int[] sortArrayByParityII(int[] A) {
        // Approach 1
        Stack<Integer> odd = new Stack<>();
        Stack<Integer> even = new Stack<>();
        for(Integer i : A) {
            if(i%2==0) even.push(i);
            else odd.push(i);
        }
        for(int i = 0; i<A.length; i++){
            if(i%2 == 0) output[i] = even.pop();
            else output[i] = odd.pop();
        }
        return output;
    }

    static int[] sortArrayByParityIII(int[] A) {
        // Approach 2, using two pointers
        int i = 0, j = 1, n = A.length;
        while(i<n && j<n) {
            while(i<n && A[i]%2==0) {
                i+=2;
            }
            while(j<n && A[j]%2==1) {
                j+=2;
            }
            if(i<n && j<n && A[i]%2!=0 && A[j]%2!=1) {
                swap(A, i, j);
            }
        }
        return A;
    }

    static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;

    }
}
