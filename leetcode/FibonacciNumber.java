package leetcode;

import java.util.HashMap;

/**
 * LC Easy: https://leetcode.com/explore/featured/card/recursion-i/255/recursion-memoization/1661/
 * */
public class FibonacciNumber {

    private static HashMap<Integer, Integer> hm = new HashMap<>();
    public static void main(String[] args) {
        int N = 4;
        System.out.println(fib(N));
    }

    public static int fib(int n) {
        if(hm.containsKey(n)) return hm.get(n);
        hm.put(0,0);
        hm.put(1,1);
        hm.put(n, fib(n-1)+fib(n-2));

        return hm.get(n);
    }
}
