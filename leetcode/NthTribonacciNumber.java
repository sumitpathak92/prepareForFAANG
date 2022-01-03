package leetcode;

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

    public static int tribonacci(int n) {
        if(hm.containsKey(n)) return hm.get(n);
        if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 1;
        hm.put(n, tribonacci(n-1)+tribonacci(n-2)+tribonacci(n-3));
        return hm.get(n);
    }
}
