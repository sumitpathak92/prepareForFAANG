package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
LC Medium : https://leetcode.com/problems/letter-combinations-of-a-phone-number/
* **/
public class LetterCombinationsOfPhoneNumber {

    private static String digits_1;
    private static List<String> res = new ArrayList<>();
    private static HashMap<Integer, String> hm = new HashMap<>();
    public static void main(String[] args) {
        String digits = "2";
        System.out.println(letterCombinations(digits));
    }

    public static List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return res;
        digits_1 = digits;

        hm.put(1, "");
        hm.put(2, "abc"); hm.put(3, "def"); hm.put(4, "ghi"); hm.put(5, "jkl");
        hm.put(6, "mno"); hm.put(7, "pqrs"); hm.put(8, "tuv"); hm.put(9, "wxyz");
        backtrack(new StringBuilder(), 0);
        return res;
    }

    private static void backtrack(StringBuilder path, int index) {
        if(path.length() == digits_1.length()) {
            res.add(path.toString());
            return; // backtrack
        }
        for(char c : hm.get(Character.getNumericValue(digits_1.charAt(index))).toCharArray()) {
            path.append(c);
            backtrack(path, index+1);
            // remove character after processing
            path.deleteCharAt(path.length()-1);
        }
    }
}
