package leetcode;

import java.util.Stack;

/**
 * LC Easy : https://leetcode.com/problems/valid-parentheses/
 * **/
public class ValidParenthesisII {

    public static void main(String[] args) {
        String s = "(])";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        if(s.length()==1) return false;
        Stack<Character> st = new Stack<>();
        for(int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(' :
                case '{' :
                case '[':
                    st.push(c);
                    break;
                case ')':
                    if(st.peek()=='(') st.pop();
                    else return false; break;
                case '}':
                    if(st.peek()=='{') st.pop();
                    else return false; break;
                case ']':
                    if(st.peek()=='[') st.pop();
                    else return false; break;
            }
        }
        return st.isEmpty();
    }
}
