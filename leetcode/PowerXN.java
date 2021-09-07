package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * LC medium : https://leetcode.com/explore/learn/card/recursion-i/256/complexity-analysis/2380/
 * */
public class PowerXN {

    private static Map<Integer, Double> hm = new HashMap<>();
    public static void main(String[] args) {
        double x = 0.00001;
        int n = 2147483647;
        System.out.println(myPow(x, n));
    }

    public static double myPow(double x, int n) {
//        if(n==0) return 1;
//        if(n==1) return x;
        long N = n;
        if(N<0) {
            x = 1/x;
            N = -N;
        }
        double ans = 1;
        for(long i = 0; i<N; i++) {
            ans=ans*x;
        }
        return ans;
    }
}
