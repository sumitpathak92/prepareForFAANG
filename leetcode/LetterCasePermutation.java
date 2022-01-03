package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.
 * Return a list of all possible strings we could create.
 *
 * Input: S = "a1b2"
 * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * */

public class    LetterCasePermutation {
    static List<String> res = new ArrayList<>();
    public static void main(String[] args) {
        String input = "a1b2";
        System.out.println(letterCasePermutation(input).toString());
    }

    public static List<String> letterCasePermutation(String S) {
        char[] array = S.toCharArray();
        helper(array, 0);
        return res;
    }

    public static void helper(char[] array, int idx) {
        if(idx == array.length) {
            res.add(new String(array));
            return;
        }
        if(Character.isDigit(array[idx]))
            helper(array, idx+1);
        else {
            char c = array[idx];
            array[idx] = Character.toUpperCase(c);
            helper(array, idx+1);
            array[idx] = Character.toLowerCase(c);
            helper(array, idx+1);
        }
    }
}
