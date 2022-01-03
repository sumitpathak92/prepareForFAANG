package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ArraysIntersection {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 5, 7, 9};
        int[] arr3 = {1, 3, 4, 5, 8};
        System.out.println(arraysIntersectionII(arr1, arr2, arr3));
    }


    public static List<Integer> arraysIntersectionII(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> ll = new ArrayList<>();
        int p1 = 0, p2 = 0, p3 = 0;
        while(p1<arr1.length && p2<arr2.length && p3<arr3.length) {
            if(arr1[p1] == arr2[p2] && arr1[p1] == arr3[p3]) {
                ll.add(arr1[p1]);
                p1++; p2++; p3++;
            } else if(arr1[p1] > arr2[p2] && arr1[p1] > arr3[p3]) {
                p2++; p3++;
            } else if(arr2[p2] > arr1[p1] && arr2[p2] > arr3[p3]) {
                p1++; p3++;
            } else {
                p1++; p2++;
            }
        }

        return ll;
    }
    public static List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> ll = new ArrayList<>();
        boolean first = false;
        boolean second = false;
        for(int i : arr1) {
            if(binarySearch(arr2, i)) first = true;
            if(binarySearch(arr3, i)) second= true;
            if(first&&second) {
                ll.add(i);
            }
            first = false;
            second = false;
        }
        return ll;
    }

    private static boolean binarySearch(int[] A, int el) {
        int l = 0; int r = A.length - 1;

        while(l<=r) {
            int mid = l+(r-l)/2;
            if(A[mid] == el) return true;
            if(A[mid]> el) {
                r = mid-1;
            } else
                l = mid+1;
        }
        return false;
    }
}
