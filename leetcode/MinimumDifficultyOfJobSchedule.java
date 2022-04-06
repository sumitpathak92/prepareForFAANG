package leetcode;

import java.util.Arrays;

/**
 *
 * LC HArd : https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/
 * **/
public class MinimumDifficultyOfJobSchedule {

    public static void main(String[] args) {
        int[] jobDiff = {1,1,1}; int d = 3;
        System.out.println(minDifficulty(jobDiff, d));
    }

    static int[] hardestJobRemaining;
    static int[][] dp;
    public static int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length-1; int hardestJob = 0;
        hardestJobRemaining = new int[n+1];
        for (int i = n; i >= 0; i--) {
            hardestJob = Math.max(hardestJob, jobDifficulty[i]);
            hardestJobRemaining[i] = hardestJob;
        }
        dp = new int[n+1][d+1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(0, 1, jobDifficulty, d, n);
    }

    public static int f(int i, int day, int[] jobDifficulty, int d, int n) {
        if(n+1<d) return -1;
        if(day==d) {
            return hardestJobRemaining[i];
        }
        if(dp[i][day]!=-1) return dp[i][day];

        int hardest = Integer.MIN_VALUE;
        int minDiff = Integer.MAX_VALUE;
        for (int j = i; j <= (n - (d - day)); j++) {
            hardest = Math.max(hardest, jobDifficulty[j]);
            minDiff = Math.min(minDiff, hardest + f(j + 1, day + 1, jobDifficulty, d, n));
        }
        return dp[i][day] = minDiff;
    }
}
