package leetcode.ThirtyDaysChallenge.Week1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SingleNumber {

    public static void main(String[] args) {
        int[] A = {4, 1, 2, 1, 2};
        System.out.println("output  "+singleNumber(A));
    }

    public static int singleNumber(int[] nums) {
        int a = 0;
        for(int i : nums) {
            a ^= i;
        }
        return a;
    }
}