package leetcode;

import java.util.ArrayList;

/**
 * LC Medium : https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
 * **/
public class NoOfDiceRollsWithTargetSum {

    public static void main(String[] args) {
        int n = 2; int k = 6; int target = 7;
        System.out.println(numRollsToTarget(n,k,target));
    }


    public static int numRollsToTarget(int d, int f, int target) {
        int modulo = (int) Math.pow(10,9)+7;
        int[][] t = new int[d+1][target+1];
        t[0][0] = 1; // base case

        for(int i = 1; i<=d; i++) {
            for(int j = 1; j<=target; j++) {
                for(int k = 1; k<=f; k++) {
                    if(j-k<0) break;
                    t[i][j] = (t[i-1][j-k])%modulo;
                }
            }
        }
        return t[d][target];
    }
}
