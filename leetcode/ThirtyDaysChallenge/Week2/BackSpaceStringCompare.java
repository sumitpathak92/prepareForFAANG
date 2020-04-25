package leetcode.ThirtyDaysChallenge.Week2;

import java.util.Stack;

/**
 *
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 *
 * Note that after backspacing an empty text, the text will continue empty.
 *
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * */
public class BackSpaceStringCompare {

    public static void main(String[] args) {
        String A = "y#fo##f";
        String B = "y#f#o##f";
        System.out.println(backspaceCompare(A, B));
    }

    public static boolean backspaceCompare(String S, String T) {
        // #TODO make a common function to do similar operation

        Stack<Character> S1 = new Stack<>();
        Stack<Character> S2 = new Stack<>();
        for(char c : S.toCharArray()) {
            if(c!='#') S1.push(c);
            else if(!S1.isEmpty()) S1.pop();
        }
        for(char c : T.toCharArray()) {
            if(c!='#') S2.push(c);
            else if(!S2.isEmpty()) S2.pop();
        }
        StringBuilder s = new StringBuilder();
        StringBuilder t = new StringBuilder();
        for(Character ch : S1) s.append(ch);
        for(Character ch : S2) t.append(ch);
        return s.toString().equals(t.toString());
    }
}
