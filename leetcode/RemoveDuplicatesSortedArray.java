package leetcode;

import util.CommonUtilities;

public class RemoveDuplicatesSortedArray {

    public static void main(String[] args) {
        int[] input = {1,1,1,2,2,3,4, 4, 5};
        System.out.println(removeDuplicates(input));
    }

    public static int removeDuplicates(int[] A) {
        int count = 0, len=0;
        for(int i=0; i<A.length; i++) {
            if(i==0 || A[i]!=A[i-1]) count=1;
            else count++;
            if(count<3) A[len++] = A[i];
        }
        return len;
    }
}
