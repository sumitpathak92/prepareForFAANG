package leetcode;

import java.util.Arrays;
import java.util.Collections;

/**
 * LC Easy : https://leetcode.com/problems/sort-even-and-odd-indices-independently/
 * **/
public class SortEvenAndOddIndices {

    public static void main(String[] args) {
        int[] A = {4,1,2,3};
        System.out.println(Arrays.toString(sortEvenOdd(A)));
    }

    // [4, 1, 2, 3]
    public static int[] sortEvenOdd(int[] nums) {
        int i = 0; int j = 0; int n = nums.length;
        int[] even = new int[n-n/2]; int[] odd = new int[n/2];
        for(int p = 0; p<n; p++) {
            if(p%2==0) even[i++] = nums[p];
            else odd[j++] = nums[p];
        }
        Arrays.sort(even);
        Arrays.sort(odd);
        int m = 0; int k = odd.length-1;
        for(int o = 0; o<n ; o++) {
            nums[o] = o%2==0 ? even[m++] : odd[k--];
        }
        return nums;
    }
}
