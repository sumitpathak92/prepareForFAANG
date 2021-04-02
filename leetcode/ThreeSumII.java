package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/3sum/
 * */
public class ThreeSumII {

    public static void main(String[] args) {
        int[] A = {-1,0,1,2,-1,-4};
        System.out.println("three sum value  "+threeSum(A));
    }

    public static List<List<Integer>> threeSum(int[] A) {
        Arrays.sort(A);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i<A.length; i++) {
            int a = -A[i];
            System.out.println("qq  "+a);
            int j = i+1; int k = A.length-1;
            while (j<k) {
                System.out.println("ww  "+A[j] + "  "+A[k]);
                if(A[j]+A[k]==a) {
                    System.out.println("I am here with answers "+ A[i] + " " +A[j] + "  " + A[k]);
                    res.add(new ArrayList<>(Arrays.asList(A[i], A[j], A[k])));
                    j++; k--;
                }
                else if(A[j]+A[k]<a) j++;
                else k--;
            }
        }
        return new ArrayList<>(new HashSet<>(res));
    }
}
