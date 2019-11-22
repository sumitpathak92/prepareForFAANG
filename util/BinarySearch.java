package util;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int[] A = {21, 12};
        int x = 12;
        Arrays.sort(A);
        System.out.println(binarySearch(A, 0, A.length - 1, x));
    }

    public static boolean binarySearch(int[] A, int start, int end, int N) {
        if(start>=end) return false;
        int mid = (end+start)/2;
        if(A[mid] == N) return true;
        if(N < A[mid])
            return binarySearch(A, start, mid-1, N);
        else
            return binarySearch(A, mid+1, end, N);
    }
}
