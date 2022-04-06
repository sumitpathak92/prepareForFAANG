package leetcode;


import java.util.*;

/**
 * LC Medium : https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 * **/
public class MinimumremoveToMakeValidParenthesis {

    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("))(("));
    }

    public static String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        Set<Integer> indexToRemove = new HashSet<>();
        for(int i = 0; i<s.length(); i++) {
            if(s.charAt(i)=='(') {
                st.push(i);
            }
            if(s.charAt(i)==')') {
                if (st.isEmpty())
                    indexToRemove.add(i);
                else
                    st.pop();
            }
        }
//        System.out.println(st);

        while(!st.isEmpty()) {
            indexToRemove.add(st.pop());
        }
        for(int i = 0; i<s.length(); i++) {
            if(!indexToRemove.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
