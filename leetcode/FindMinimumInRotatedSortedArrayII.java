package leetcode;

/*
LC Medium : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
* **/
public class FindMinimumInRotatedSortedArrayII {

    public static void main(String[] args) {
        int[] A = {4,5,6,7,0,1,2};
        System.out.println(findMin(A));
    }

    public static int findMin(int[] nums) {
        int pivot = findPivot(nums);
        return nums[pivot+1];
    }

    private static int findPivot(int[] A) {
        int start = 0; int end = A.length-1;
        while(start<end) {
            int mid = start+(end-start)/2;
            if(mid<end && A[mid]>A[mid+1]) {
                return mid;
            } else if(mid>start && A[mid]<A[mid-1]) {
                return mid-1;
            } else if(A[end]>A[mid]) { // check in left half
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return -1;
    }
}
