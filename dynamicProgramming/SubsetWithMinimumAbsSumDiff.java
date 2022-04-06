package dynamicProgramming;

import java.util.Arrays;

public class SubsetWithMinimumAbsSumDiff {

    public static void main(String[] args) {
        int[] A = {3,2,7};
        System.out.println(minSubsetSumDiff(A));
    }

    static int minSubsetSumDiff(int[] A) {
        int tot = 0;
        for(int i : A)
            tot+=i;
        int k = tot;
        int n = A.length;
        boolean[][] dp = new boolean[n][k+1];
        for(int i = 0; i<n; i++) dp[i][0] = true;
        if(A[0]<=k) dp[0][A[0]] = true;
        for(int i = 1; i<n; i++) {
            for(int j = 1; j<=k; j++) {
                boolean notTake = dp[i-1][j];
                boolean take = false;
                if(A[i]<=j)
                    take = dp[i-1][j-A[i]];
                dp[i][j] = take||notTake;
            }
        }

        for(boolean[] row: dp){
            System.out.println(Arrays.toString(row));
        }
        int mini = Integer.MAX_VALUE;
        for(int s1 = 0; s1<=tot/2; s1++) {
            if(dp[n-1][s1])
                mini = Math.min(mini, Math.abs((tot-s1)-s1));
        }
        return mini;
    }

}
