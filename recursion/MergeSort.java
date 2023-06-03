package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

//    static int l = 0;
//    static int r = 5;
    static List<Integer> res;

    public static void main(String[] args) {
        int[] A = {5, 3, 6, 1, 8, 12, 2};
        mergeSort(A, 0, A.length-1);
        System.out.println("sorted array ::::  "+ Arrays.toString(A));
    }

    public static void mergeSort(int[] A, int l, int r) {
        if(l == r)
            return;
        int mid = l+(r-l)/2;
        mergeSort(A, l, mid);
        mergeSort(A, mid+1, r);

        mergeBack(A, l, mid, r);
    }

    public static void mergeBack(int[] A, int l, int mid, int r) {
        int left = l; int right = mid+1;
        res = new ArrayList<>();
        while(left<=mid && right<=r) {
            if(A[left]<=A[right]) {
                res.add(A[left]);
                left++;
            } else {
                res.add(A[right]);
                right++;
            }
        }
        while(left<=mid) {
            res.add(A[left]);
            left++;
        }
        while(right<=r) {
            res.add(A[right]);
            right++;
        }

        for(int i = l; i<=r; i++) {
            System.out.println("printing i ::: "+i);
            System.out.println("printing l ::: "+l);
            System.out.println("printing i-l ::: "+(i-l));
            A[i] = res.get(i-l);
        }
    }
}
