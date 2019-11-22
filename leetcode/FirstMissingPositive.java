package leetcode;

import static leetcode.SortArrayByParityII.swap;

public class FirstMissingPositive {

    public static void main(String[] args) {
        int[] input = {3, 4, -1, 1};
        System.out.println("first missing positive  "+firstMissingPositive(input));
    }

    public static int firstMissingPositive(int[] A) {
        int i = 0;
        while(i<A.length){
            if(A[i]==i+1 || A[i]<=0 || A[i]>A.length) i++;
            else if(A[A[i]-1]!=A[i]) swap(A, i, A[i]-1);
            else i++;
        }
        i=0;
        while(i<A.length && A[i]==i+1) i++;
        return i+1;
    }
}
