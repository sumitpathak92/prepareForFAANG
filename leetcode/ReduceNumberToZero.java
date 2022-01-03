package leetcode;

/**
 *
 *  LC Easy : https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
 * **/
public class ReduceNumberToZero {
    public static void main(String[] args) {
        System.out.println(numberOfSteps(14));
    }

    public static int numberOfSteps(int num) {
        int steps = 0;
        return helper(num, steps);
    }

    static int helper(int num, int steps) {
        // base case
        if(num==0) return steps;
        if(num%2==0) return helper(num/2, steps+1);
        return helper(num-1, steps+1);
    }

}
