package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * LC Easy : https://leetcode.com/problems/next-greater-element-i/
 * **/
public class NextGreaterElement {

    public static void main(String[] args) {
        int[] A = {2, 4}; int[] B = {1,2,3,4};
        System.out.println(Arrays.toString(nextGreaterElement(A, B)));
    }

    public static int[] nextGreaterElement(int[] A, int[] B) {
        int[] res = new int[A.length];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i< A.length; i++) {
            for(int j = 0; j<B.length; j++) {
                if(A[i]==B[j]){
                    int k = j+1;
                    while(k<B.length) {
                        if(B[k]>A[i]) {
                            res[i] = B[k];
                            break;
                        }
                        k++;
                    }
                    if(res[i]==0) res[i] = -1;
                }
            }
        }
        return res;
    }
}
