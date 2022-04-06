package leetcode;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] A = {1, 3}; int [] B = {2, 4};
        System.out.println(findMedianSortedArrays(A, B));
    }

    public static double findMedianSortedArrays(int[] A, int[] B) {
        int n = A.length; int m = B.length;
        int i = 0; int j = 0;
        int [] C = new int[n+m];
        int p = 0;
        while(i<n && j<m) {
            if(A[i]<B[j]){
                C[p] = A[i];
                p++;
                i++;
            } else {
                C[p] = B[j];
                p++;
                j++;
            }
        }
        if(i==n) {
            while(j<m){
                C[p++] = B[j];
                j++;
            }
        }
        if(j==m) {
            while(i<n) {
                C[p++] = A[i];
                i++;
            }
        }
        if((C.length)%2==0)
            return (C[C.length/2] + C[C.length/2-1])/2.0;
        else return C[C.length/2];
    }
}
