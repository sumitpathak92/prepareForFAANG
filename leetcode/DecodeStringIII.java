package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * LC Medium : https://leetcode.com/problems/decode-string/
 * **/
public class DecodeStringIII {
    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
    }
    static Map<Integer, Integer> map = new HashMap<>();
    static Stack<Integer> st = new Stack<>();
    public static String decodeString(String s) {
        for(int i =0; i<s.length(); i++) {
            if(s.charAt(i)=='[') st.push(i);
            else if(s.charAt(i)==']') {
                map.put(st.pop(), i);
            }
        }
        return helper(s, 0, s.length()-1);
    }

    static String helper(String s, int l, int r) {
        StringBuilder sb = new StringBuilder();
        int num = 0; // will get back here
        while(l<=r) {
            char ch = s.charAt(l);
            if(Character.isDigit(ch))
                num=num*10+ch-'0'; // what is this??
            else if(ch=='[') {
                sb.append(repeat(helper(s, l+1, map.get(l)-1), num));
                num=0;
                l=map.get(l);
            } else {
                sb.append(ch);
            }
            l+=1;
        }
        return sb.toString();
    }

    static String repeat(String s, int times) {
        StringBuilder sb = new StringBuilder();
        while(times>=1) {
            sb.append(s);
            times--;
        }
        return sb.toString();
    }
}
