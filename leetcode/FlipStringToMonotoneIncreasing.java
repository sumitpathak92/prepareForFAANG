package leetcode;

import java.util.Arrays;

public class FlipStringToMonotoneIncreasing {

    public static void main(String[] args) {
        String s = "010110";
        System.out.println(minFlipsMonoIncr(s));
    }


    public static int minFlipsMonoIncr(String s) {
        int oneCount = 0; int flip = 0;
        for(int i = 0; i<s.length(); i++) {
            if(s.charAt(i)=='0') {
                if(oneCount==0){
                    continue;
                } else {
                    flip++;
                }
            } else {
                oneCount++;
            }
            if(flip>oneCount) {
                flip = oneCount;
            }
        }
        return flip;
    }

    static int[][] dp;
    public static int minFlipsMonoIncrDP(String s) {
        dp = new int[20005][2];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(s, 0, 0);
    }

    public static int f(String s, int ind, int ones) {
        if(ind == s.length()) {
            return 0;
        }
        if(dp[ind][ones]!=-1) return dp[ind][ones];
        if(s.charAt(ind)=='0') {
            if(ones==1){
                return dp[ind][ones] = 1+ f(s, ind+1, ones);
            } else {
                return dp[ind][ones] = f(s, ind+1, ones);
            }
        }
        if(s.charAt(ind)=='1') {
            if(ones==1) {
                return dp[ind][ones] = f(s, ind+1, ones);
            } else {
                return dp[ind][ones] = Math.min(1+f(s, ind+1, ones), f(s, ind+1, 1));
            }
        }
        return -1;
    }
}
