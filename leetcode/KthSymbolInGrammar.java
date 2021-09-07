package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *  LC Medium : https://leetcode.com/explore/learn/card/recursion-i/253/conclusion/1675/
 * */

public class KthSymbolInGrammar {

    private static Map<Integer, String> hm = new HashMap<>();
    public static void main(String[] args) {
        int n = 3, k = 1;
        System.out.println(kthGrammar(n, k));
    }

    public static int kthGrammar(int n, int k) {
        if(n==1 || k==1) return 0;
        int mid = (int) Math.pow(2, n-1)/2;
        int res;
        if(k<=mid) {
            res = kthGrammar(n-1, k);
        } else {
            res = kthGrammar(n-1, k-mid) == 0 ? 1 : 0;
        }
        return res;
    }


}
