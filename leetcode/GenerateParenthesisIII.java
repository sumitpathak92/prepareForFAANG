package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesisIII {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(1));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        String s = "";
        getParenthesis(n*2, ans, s);
        return ans;
    }

    static void getParenthesis(int n, List<String> ans, String curr) {
        if(curr.length()==n){
            if(isValid(curr)) {
                ans.add(curr);
            }
            return;
        }
        getParenthesis(n, ans, curr+"(");
        getParenthesis(n, ans, curr+")");
    }

    private static boolean isValid(String curr) {
        int close = 0; int open = 0;
        for(int i = 0; i<curr.length(); i++) {
            if(curr.charAt(i)=='(') {
                open++;
            } else {
                close++;
                if(close>open)
                    return false;
            }
        }
        return open==close;
    }
}
