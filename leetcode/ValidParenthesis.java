package leetcode;

import java.util.Stack;

/**
 *
 * LC Easy : https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1361/
 * */
public class ValidParenthesis {

    public static void main(String[] args) {
        String s = "(())";
        System.out.println("checking validity :::    "+isValid(s));
    }

    public static boolean isValid(String s) {
        if(s.length()%2!=0) return false;
//        char[] open = {'(', '{', '['};
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()) {
            switch (c) {
                case '(':
                case '{':
                case '[':
                    st.push(c); break;
                case ')':
                    if(!st.isEmpty() && st.peek()=='(') st.pop();
                    else return false; break;
                case '}':
                    if(!st.isEmpty() && st.peek()=='{') st.pop();
                    else return false; break;
                case ']':
                    if(!st.isEmpty() && st.peek()=='[') st.pop();
                    else return false; break;
            }
        }
        return st.isEmpty();
    }
}
