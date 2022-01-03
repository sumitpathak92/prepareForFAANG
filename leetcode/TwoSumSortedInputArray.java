package leetcode;

import java.util.Arrays;

/*
LC Easy: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
* **/
public class TwoSumSortedInputArray {

    public static void main(String[] args) {
        int[] A = {-1, 0}; int target = -1;
        System.out.println(Arrays.toString(twoSum(A, target)));
    }

    private static int[] twoSum(int[] numbers, int target) {
        int p1 = 0; int p2 = numbers.length-1;
        while(p1<p2) {
            if(numbers[p1]+numbers[p2] == target) return new int[] {p1+1, p2+1};
            else if(numbers[p1]+numbers[p2] > target) {
                p2--;
            } else {
                p1++;
            }
        }
        return new int[]{-1,-1};
    }
}
