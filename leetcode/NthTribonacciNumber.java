package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
LC Easy : https://leetcode.com/problems/n-th-tribonacci-number/
* **/
public class NthTribonacciNumber {

    static Map<Integer, Integer> hm = new HashMap<>();
    public static void main(String[] args) {
        int n=25;
        System.out.println(tribonacci(n));
    }

    static int[] dp;
    public static int tribonacci(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return f(n);
    }

    static int f(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 1;
        dp[0]=0; dp[1]=1; dp[2]=1;
        for(int i=3; i<=n; i++) {
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        }
        return dp[n];
    }
}
