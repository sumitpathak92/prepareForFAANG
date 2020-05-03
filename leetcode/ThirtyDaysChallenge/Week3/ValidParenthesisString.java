package leetcode.ThirtyDaysChallenge.Week3;

import java.util.Stack;

/**
 *
 * Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:
 *
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 * An empty string is also valid.
 *
 *
 * Input: "()"
 * Output: True
 *
 * */
public class ValidParenthesisString {

    public static void main(String[] args) {
        String s = "()";
        System.out.println("output  "+checkValidString(s));
    }

    public static boolean checkValidString(String s) {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c=='(' || c=='*') st.push(c);
            else if(c==')' && (st.pop()=='(' || st.pop()=='*')) {
            }
        }
        return true;
    }
}

