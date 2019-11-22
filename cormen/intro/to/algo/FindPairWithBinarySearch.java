package cormen.intro.to.algo;

import util.BinarySearch;

import java.util.Arrays;

public class FindPairWithBinarySearch {

    public static void main(String[] args) {
        int[] A = {21, 12, 8, 19, 5, 10, 11};
        System.out.println(findPair(A, 23));
    }

    public static boolean findPair(int[] A, int x) {
        if(A.length==0 || A.length == 1) return false;
        Arrays.sort(A);
        for(int i=0; i<A.length; i++) {
            int y = x-A[i];
            if(BinarySearch.binarySearch(A, i+1, A.length, y)) return true;
        }
        return false;
    }
}
