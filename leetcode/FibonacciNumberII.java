package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
LC Easy : https://leetcode.com/problems/fibonacci-number/
* **/
public class FibonacciNumberII {

    private static Map<Integer, Integer> hm = new HashMap<>();
    public static void main(String[] args) {
        System.out.println(fib(21));
    }

    public static int fib(int n) {
        if(hm.containsKey(n)) return hm.get(n);
        if(n==1) return 1;
        if(n==0) return 0;
        hm.put(n, fib(n-1)+fib(n-2));
        return hm.get(n);
    }
}
