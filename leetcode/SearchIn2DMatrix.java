package leetcode;

import java.util.Arrays;

/**
 * LC Medium : https://leetcode.com/problems/search-a-2d-matrix/
 * **/
public class SearchIn2DMatrix {

    public static void main(String[] args) {
        int[][] A = {{1,3,5,7}};
        System.out.println(searchMatrix(A, 1));
    }

    public static boolean searchMatrix(int[][] A, int target) {
        if(A.length==1) return binarySearch(A[0], target);
        int i = 0; int j = A[0].length-1; int l = 0;
        while(i<A.length) {
            if(target==A[i][j]) return true;
            else if(target<A[i][j]) {
                l = i;
                break;
            } else {
                i++;
            }
        }
        int[] arr = new int[A[0].length];
        for(int k = 0; k<A[0].length; k++) {
            arr[k] = A[l][k];
        }
        return binarySearch(arr, target);
    }

    private static boolean binarySearch(int[] A, int target) {
        int l = 0; int r = A.length-1;
        while(l<=r) {
            int mid = l+(r-l)/2;
            if(A[mid]==target) return true;
            else if(A[mid]<target) {
                l=mid+1;
            } else {
                r=mid-1;
            }
        }
        return false;
    }
}
