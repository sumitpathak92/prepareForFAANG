//Problem statement

/*
 * Given an array arr, replace every element in that array with the greatest element among the elements to its right,
   and replace the last element with -1.
   After doing so, return the array.
 *
/*
*
*   Input: arr = [17,18,5,4,6,1]
    Output: [18,6,6,6,1,-1]

**/

package leetcode;

import java.util.Arrays;

public class ReplaceElementsWithGreatestOnRight {

    public static void main(String[] args) {
        int[] arr = {17, 18, 5, 4, 6, 1};
        System.out.println(Arrays.toString(replaceElements(arr)));
    }

    public static int[] replaceElements(int[] arr) {
        int max = -1;
        int j = arr.length, a;
        for(int i=j-1; i>=0; --i) {
            a = arr[i];
            arr[i] = max;
            max = Math.max(max, a);
        }
        return arr;
    }

}
