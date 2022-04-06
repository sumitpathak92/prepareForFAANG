package leetcode;


import java.util.Stack;

/**
 * LC Hard : https://leetcode.com/problems/parsing-a-boolean-expression/
 * **/
public class ParseBooleanExpression {

    public static void main(String[] args) {
        System.out.println(parseBoolExpr("&(t,f)"));
    }

    static Stack<Character> st = new Stack<>();
    static Stack<Character> aux = new Stack<>();
    public static boolean parseBoolExpr(String s) {
        for(char c : s.toCharArray()) {
            if(c==')') {
                aux.clear();
                while (st.peek()!='(') {
                    aux.add(st.pop());
                }
                st.pop();
                char op = st.pop();
                if(op=='&'){
                    st.push(aux.contains('f')?'f':'t');
                } else if(op=='|') {
                    st.push(aux.contains('t')?'t':'f');
                } else {
                    st.push(aux.contains('f')?'t':'f');
                }
            } else if(c!=',') {
                st.push(c);
            }
        }
        return st.pop() == 't';
    }

}
