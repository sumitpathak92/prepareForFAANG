package leetcode.ThirtyDaysChallenge.Week1;

import java.util.HashSet;


/**
 *
 * Problem Statement: Given an integer array arr, count element x such that x + 1 is also in arr.
 *
 * If there're duplicates in arr, count them separately.
 *
 * Input: arr = [1,3,2,3,5,0]
 * Output: 3
 * Explanation: 0, 1 and 2 are counted cause 1, 2 and 3 are in arr.
 * */

public class CountingElements {

    public static void main(String[] args) {
        int[] A = {1, 1, 2};
        System.out.println("output is  "+countElements(A));
    }

    public static int countElements(int[] arr) {
        if(arr.length == 0) return 0;
        HashSet<Integer> hs = new HashSet<>();
        for(int i : arr)
            hs.add(i);
        int count = 0;
        for(int k : arr) {
            if(hs.contains(k+1)) count++;
        }
        return count;
    }

}
