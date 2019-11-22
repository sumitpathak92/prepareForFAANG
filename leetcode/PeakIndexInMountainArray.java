package leetcode;

public class PeakIndexInMountainArray {

    public static void main(String[] args) {
        int[] A = {0,2,1,0};
        System.out.println(peakIndexInMountainArray(A));
    }

    public static int peakIndexInMountainArray(int[] A) {
        if(A.length<3) return -1;
        int s = 0, e = A.length-1;
        while(s<e) {
            int mid = s+(e-s)/2;
            if(A[mid]<A[mid+1]) s = mid+1;
            else e = mid;
        }
        return e;
    }

    private static int helperFunction(int[] A, int start, int end) {
        int mid = (start+end)/2;
        if(A[mid+1] < A[mid] && A[mid] > A[mid-1])
            return mid;
        else if(A[mid] > A[mid-1] && A[mid] < A[mid+1])
            return helperFunction(A, mid+1, end);
        else return helperFunction(A, start, mid-1);
    }
}
