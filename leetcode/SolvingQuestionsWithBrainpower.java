package leetcode;

import java.util.Arrays;

/**
 *
 * LC Medium : https://leetcode.com/problems/solving-questions-with-brainpower/
 * **/
public class SolvingQuestionsWithBrainpower {

    public static void main(String[] args) {
        int[][] questions = {{1,1},{2,2}, {3,3},{4,4}, {5,5}};
        System.out.println(mostPoints(questions));
    }
    long[] dp;
    public static long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];
        return f(questions, 0, dp);
    }

    static long f(int[][] Q, int idx, long[] dp) {
        if(idx >= Q.length) return 0;
        if(dp[idx]>0) return dp[idx];
        long left = Q[idx][0]+f(Q, idx+1+Q[idx][1], dp);
        long right = f(Q, idx+1, dp);
        return dp[idx] = Math.max(left, right);
    }

}
