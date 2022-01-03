package leetcode;

import netscape.security.UserTarget;

/*
LC Medium : https://leetcode.com/problems/search-in-rotated-sorted-array/
* **/
public class SearchInRotatedSortedArrayII {

    public static void main(String[] args) {
        int[] A = {1,1,3};
        int target = 0;
        System.out.println(search(A, target));
    }

    public static boolean search(int[] A, int target) {
        // 1. Find pivot element
        // 2. Binary Search in array till pivot
        // 3. Binary Search in array after pivot
        if(A.length==1) {
            return A[0]==target;
        }
        int pivot = getPivotIndexWithDuplicates(A);
        if(pivot == -1) {
            return binarySearch(A, 0, A.length-1, target);
        }
        if(A[pivot]==target) return true;
        if(target>=A[0]) {
            return binarySearch(A, 0, pivot, target);
        }
        return binarySearch(A, pivot+1, A.length-1, target);
    }

    // this wont work in case of duplicate values
    static int getPivotIndex(int[] A) {
        int i = 0; int j = A.length-1;
        while(i<=j) {
            int mid = i+(j-i)/2;
            if(mid <j && A[mid]>A[mid+1]) { // pivot found
                return mid;
            } else if(mid>i && A[mid]<A[mid-1]) { //pivot found
                return mid-1;
            } else if(A[i]<=A[mid]) {
                i=mid+1;
            } else if(A[i]>=A[mid]) {
                j=mid-1;
            }
        }
        return -1;
    }


    // this wont work in case of duplicate values
    static int getPivotIndexWithDuplicates(int[] A) {
        int i = 0; int j = A.length-1;
        while(i<j) {
            int mid = i+(j-i)/2;
            if(mid <j && A[mid]>A[mid+1]) { // pivot found
                return mid;
            } else if(mid>i && A[mid]<A[mid-1]) { //pivot found
                return mid-1;
            }
            // if elements at mid start and end are equal, then skip the duplicates
            else if(A[mid]==A[i] && A[mid] == A[j]) {
                // skip the elements
                // what if the elements at start and end were the pivots, we cannot then skip them easily
                // check if start is pivot?
                if(A[i]>A[i+1]) { // start is pivot
                    return i;
                }
                i++;
                if(A[j-1]>A[j]) { // end is pivot
                    return j;
                }
                j--;
            }
            // left side is sorted , pivot in right
            else if(A[i]<A[mid] || (A[i]==A[mid] && A[mid]>A[j])) {
                i=mid+1;
            } else {
                j=mid-1;
            }
        }
        return -1;
    }


    static boolean binarySearch(int[] A, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) return true;
            else if (A[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

}
