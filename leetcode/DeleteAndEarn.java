package leetcode;

import java.util.Arrays;

/**
 * LC Medium : https://leetcode.com/problems/delete-and-earn/
 * **/
public class DeleteAndEarn {

    public static void main(String[] args) {
        int[] nums = {3,4,2};
        System.out.println(deleteAndEarn(nums));
    }

    static int[] dp;
    public static int deleteAndEarn(int[] nums) {
        int n = 10001;
        int[] A = new int[n];
        for(int num : nums){
            A[num]+=num;
        }
        dp = new int[A.length];
        dp[0] = A[0];
        for(int i = 1; i<A.length; i++){
            int take = A[i];
            if(i-2>=0) take+=dp[i-2];
            int notTake = dp[i-1];
            dp[i] = Math.max(take, notTake);
        }
        return dp[n-1];
//        Arrays.fill(dp, -1);
//        System.out.println(Arrays.toString(A));
//        return f(A, A.length-1);
    }

    static int f(int[] A, int idx) {
        if(idx==0) return A[0];
        if(idx<0) return 0;
        if(dp[idx]!=-1) return dp[idx];
        return dp[idx]=Math.max(f(A, idx-2) + A[idx], f(A, idx-1));
    }
}
