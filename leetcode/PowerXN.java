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
        double x = 2.00000;
        int n = 10;
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
        return myPower(x, N);
    }

    public static double myPower(double x, long n) {
        if(n==0) return 1.0;
        double val = myPower(x, n/2);
        if(n%2==0) {
            return val*val;
        } else {
            return val*val*x;
        }
    }
}
