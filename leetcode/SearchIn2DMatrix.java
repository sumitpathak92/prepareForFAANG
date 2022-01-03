package leetcode;

import java.util.Arrays;

/**
 * LC Medium : https://leetcode.com/problems/search-a-2d-matrix/
 * **/
public class SearchIn2DMatrix {

    public static void main(String[] args) {
        int[][] A = {{1,3,5,7}, {10,11,16,20}, {23,30,34,60}};
        System.out.println(searchMatrix(A, 13));
    }

    public static boolean searchMatrix(int[][] A, int target) {
        int r = 0; int col = A[0].length-1; int start=0;
        while(r<A.length) {
            if(A[r][col]<target)
                r++;
            else {
                start = r;
                break;
            }
        }
        int[] B = new int[A[0].length];
        System.arraycopy(A[start], 0, B, 0, A[0].length);
        return binarySearch(B, target);
    }

    private static boolean binarySearch(int[] A, int target) {
        int l = 0; int h = A.length-1;
        while(l<=h) {
            int mid = l+(h-l)/2;
            if(A[mid]==target) return true;
            else if(A[mid]>target) h=mid-1;
            else l=mid+1;
        }
        return false;
    }
}
