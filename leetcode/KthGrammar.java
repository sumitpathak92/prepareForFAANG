package leetcode;

import java.util.List;

/*
LC Mediuum : https://leetcode.com/problems/k-th-symbol-in-grammar/
* **/
public class KthGrammar {

    public static void main(String[] args) {
        System.out.println(kthGrammar(3, 1));
    }

    public static int kthGrammar(int n, int k) {
        // base case
        if(n==1) return 0;
        // if k is even, then the value is a flip of its parent node (k/2) in (n-1)th row
        if(k%2 == 0) {
            return flip(kthGrammar(n-1, k/2));
        }
        return kthGrammar(n-1, (k+1)/2);
    }

    private static int flip(int v) {
        return (v==1) ? 0 : 1;
    }

    private static String helper(int n) {
        if(n==1) return "0";
        if(n==2) return "01";
        StringBuilder sb = new StringBuilder();
        for(char c : helper(n-1).toCharArray()) {
            if(c == '0') sb.append("01");
            if(c == '1') sb.append("10");
        }
        return sb.toString();
    }
}
