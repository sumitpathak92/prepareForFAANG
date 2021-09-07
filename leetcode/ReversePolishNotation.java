package leetcode;

import java.util.Stack;

/**
 * LC Easy : https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1394/
 * */
public class ReversePolishNotation {

    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println("evaluated result :::   "+evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String c : tokens) {
            if(c.equals("+")){
                st.push(st.pop()+st.pop());
            } else if(c.equals("-")){
                int i1 = st.pop();
                int i2 = st.pop();
                st.push(i2-i1);
            } else if(c.equals("*")){
                st.push(st.pop()*st.pop());
            } else if(c.equals("/")) {
                int i1 = st.pop();
                int i2 = st.pop();
                st.push(i2/i1);
            } else {
                st.push(Integer.parseInt(c));
            }
        }
        return st.pop();
    }
}
