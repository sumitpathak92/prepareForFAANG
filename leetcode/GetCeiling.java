package leetcode;


public class GetCeiling {

    public static void main(String[] args) {
        int[] A = {2,3,5,9,14,16,18};
        System.out.println(getCeiling(A, 10));
    }

    public static int getCeiling(int[] A, int target) {
        int i = 0; int j = A.length-1;
        while(i<=j) {
            int mid = i+(j-i)/2;
            if(A[mid]==target)
                return mid;
            else if(A[mid]>target)
                j=mid-1;
            else {
                i=mid+1;
            }
        }
        return i;
    }
}
