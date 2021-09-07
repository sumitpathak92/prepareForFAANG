package leetcode;

import java.util.HashMap;
import java.util.List;

/**
 * LC Medium : https://leetcode.com/explore/featured/card/recursion-i/255/recursion-memoization/1662/
 * */
public class ClimbingStairsII {

    private static HashMap<Integer, Integer> hm = new HashMap<>();
    public static void main(String[] args) {
        System.out.println(climbStairs(50));
    }

    public static int climbStairs(int n) {
        if(n==1 || n==2) return n;
        if(hm.containsKey(n)) return hm.get(n);
        int res = climbStairs(n-1)+climbStairs(n-2);
        hm.put(n, res);
        return hm.get(n);
    }
}
