package udemyMasterTheCodingInterview;

import java.util.ArrayList;

public class MergeTwoSortedArrays {

    public static void main(String[] args) {
        int[] array1 = {14, 20, 34};
        int[] array2 = {10, 15, 25};
        for(int i : getSortedMergedArray(array1, array2)) {
            System.out.print(i + " --> ");
        }
    }

    static int[] getSortedMergedArray(int[] array1, int[] array2) {
        // check input
        if(array1 == null) return array2;
        if(array2 == null) return array1;
        int i = 0, k = 0, j = 0;
        int[] mergedArray = new int[array1.length + array2.length];
        while(i<array1.length && k<array2.length) {
            if(array1[i] < array2[k]) {
                mergedArray[j++] = array1[i++];
            } else {
                mergedArray[j++] = array2[k++];
            }
        }
        while(i<array1.length) {
            mergedArray[j++] = array1[i++];
        }
        while(j<array2.length) {
            mergedArray[j++] = array2[k++];
        }
        return mergedArray;
    }
}
