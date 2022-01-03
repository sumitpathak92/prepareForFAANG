package recursion.sorting;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] A = {3,4,12,5,6, 8};
        mergeSortInPlace(A, 0, A.length);
        System.out.println(Arrays.toString(A));
    }

    static int[] mergeSort(int[] A) {
        if(A.length==1) return A;
        int mid = A.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(A, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(A, mid, A.length));

        // got the left and right answer
        // just merge the answers
        return merge(left, right);
    }

    static int[] merge(int[] first, int[] second) {
        int s = first.length+second.length;
        int[] res = new int[s];
        int i = 0; int j =0; int k = 0;
        while(i<first.length && j<second.length) {
            if(first[i]<second[j]) {
                res[k] = first[i];
                i++;
            } else {
                res[k] = second[j];
                j++;
            }
            k++;
        }
        // it may be possible that one of the aray did not get complete, add all remaining in the array
        while(i<first.length) {
            res[k] = first[i];
            i++; k++;
        }
        while(j<second.length) {
            res[k] = second[j];
            j++; k++;
        }
        return res;
    }


    // merge sort in place

    static void mergeSortInPlace(int[] A, int s, int e) {
        if(e-s==1) return;
        int mid = s+(e-s)/2;
        mergeSortInPlace(A, s, mid);
        mergeSortInPlace(A, mid, e);

        // got the left and right answer
        // just merge the answers
        mergeInPlace(A, s, mid, e);
    }

    static void mergeInPlace(int[] A, int s, int m, int e) {

        int[] res = new int[e-s];
        int i = s; int j = m; int k = 0;
        while(i<m && j<e) {
            if(A[i]<A[j]) {
                res[k] = A[i];
                i++;
            } else {
                res[k] = A[j];
                j++;
            }
            k++;
        }
        // it may be possible that one of the aray did not get complete, add all remaining in the array
        while(i<m) {
            res[k] = A[i];
            i++; k++;
        }
        while(j<e) {
            res[k] = A[j];
            j++; k++;
        }

        System.arraycopy(res, 0, A, s + 0, res.length);
    }
}
