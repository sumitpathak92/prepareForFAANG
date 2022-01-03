package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
LC Medium : https://leetcode.com/problems/generate-parentheses/
* **/
public class GenerateParenthesisII {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        char[] curr = new char[2*n];
        List<String> result = new ArrayList<>();
        generateAll(curr, 0, result);
        return result;
    }

    private static void generateAll(char[] curr, int pos, List<String> result) {
        if(pos==curr.length) {
            if(isValid(curr)) {
                result.add(new String(curr));
            }
        }
        else {
            curr[pos] = '(';
            generateAll(curr, pos+1, result);
            curr[pos] = ')';
            generateAll(curr, pos+1, result);
        }
    }

    private static boolean isValid(char[] curr) {
        int bal = 0;
        for(char c : curr) {
            if(c=='(') bal++;
            if(c==')') bal--;
            if(bal<0) return false;
        }
        return (bal == 0);
    }

}
