package leetcode;

import util.CommonUtilities;

public class SquaresOfSortedArray {

    public static void main(String[] args) {
        int[] input = {-4,-1,0,3,10};
        CommonUtilities.arrayPrintHelper(squaresOfSortedArray(input));
    }

    public static int[] squaresOfSortedArray(int[] A) {
        int i=0, j=A.length-1, p = A.length-1;
        int[] res = new int[A.length];
        while(i<=j) {
            if(A[i]*A[i]<A[j]*A[j]) {
                res[p--] = A[j]*A[j];
                j--;
            } else {
                res[p--] = A[i]*A[i];
                i++;
            }
        }
        return res;
    }
}
