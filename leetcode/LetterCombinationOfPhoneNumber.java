package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * LC Medium : https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * */
public class LetterCombinationOfPhoneNumber {

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {
        String[] digiMap = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        String p = ""; String up = digits;
        return helper(p, up, digits.length(), digiMap);
    }

    public static List<String> helper(String p, String up, int n, String[] digiMap) {
        if(p.length()==n) {
            List<String> ll = new ArrayList<>();
            ll.add(p);
            return ll;
        }
        String s = digiMap[(up.charAt(0)-'0')];
        List<String> res = new ArrayList<>();
        for(int j = 0; j<s.length(); j++) {
            res.addAll(helper(p+s.charAt(j), up.substring(1), n, digiMap));
        }
        return res;
    }
}
