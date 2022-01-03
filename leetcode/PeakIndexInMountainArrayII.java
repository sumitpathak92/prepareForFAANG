package leetcode;

public class PeakIndexInMountainArrayII {
    public static void main(String[] args) {
        int[] A = {3,4,5,1};
        System.out.println(peakIndexInMountainArray(A));
    }

    private static int peakIndexInMountainArray(int[] A) {
        int start = 0; int end = A.length-1;
        while(start<end) {
            int mid = start+(end-start)/2;
            if(A[mid]>A[mid+1]) {
                end = mid;
            } else {
                start=mid+1;
            }
        }
        return start;

    }
}
