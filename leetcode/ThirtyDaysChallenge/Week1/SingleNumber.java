package leetcode.ThirtyDaysChallenge.Week1;

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