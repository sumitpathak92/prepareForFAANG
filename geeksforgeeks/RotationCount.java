package geeksforgeeks;

/*
LC Easy : https://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/
* **/
public class RotationCount {

    public static void main(String[] args) {
        int[] A = {3,4,5,6,0,1,2};
        System.out.println(rotationCount(A)+1);
    }

    public static int rotationCount(int[] A) {
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
