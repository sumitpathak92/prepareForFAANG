package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * LC Medium : #222 https://leetcode.com/problems/generate-parentheses/
 * */
public class GenerateParenthesis {

    public static void main(String[] args) {
        List<String> res = generateParenthesis(4);
        for(String s : res) {
            System.out.println(s);
        }
    }

    public static List<String> generateParenthesis(int n) {
        int N = 2*n;
        List<String> res = new ArrayList<>();
        char[] aux = new char[N];
        int pos = 0; // place first bracket at start

        generateRecursive(aux, pos, res);
        return res;
    }

    static void generateRecursive(char[] current, int pos, List<String> res) {
        if(pos == current.length) {
            if(isValid(current)) {
                res.add(new String(current));
            }
        } else {
            current[pos] = '(';
            generateRecursive(current, pos+1, res);
            current[pos] = ')';
            generateRecursive(current, pos+1, res);
        }
    }

    static boolean isValid(char[] current) {
        int c = 0;
        for(char i : current) {
            if(i=='(') c++;
            else c--;
            if(c<0) return false; // at any point if balance is lost, ie ')' is prominent it will result in invalid string
        }
        return c == 0;
    }
}
