package leetcode;

import sun.misc.CharacterEncoder;

import java.util.ArrayList;
import java.util.List;

/*
LC Medium : https://leetcode.com/problems/letter-case-permutation/
* **/
public class LetterCasePermutationII {

    public static void main(String[] args) {
        String s = "a1b2";
        System.out.println(letterCasePermutation(s));
    }

    public static List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int start = 0;
        helper(s, sb, res, start);
        return res;
    }

    private static void helper(String s, StringBuilder sb, List<String> res, int i) {
        if(sb.length() == s.length()) {
            res.add(sb.toString());
            return;
        }
        if(Character.isDigit(s.charAt(i))) {
            sb.append(s.charAt(i));
            helper(s, sb, res, i+1);
            sb.deleteCharAt(sb.length()-1);
        } else {
            sb.append(Character.toLowerCase(s.charAt(i)));
            helper(s, sb, res, i+1);
            sb.deleteCharAt(sb.length()-1);

            sb.append(Character.toUpperCase(s.charAt(i)));
            helper(s, sb, res, i+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
