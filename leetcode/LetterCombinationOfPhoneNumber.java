//package leetcode;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// *
// * LC Medium : https://leetcode.com/problems/letter-combinations-of-a-phone-number/
// * */
//public class LetterCombinationOfPhoneNumber {
//
//    public static void main(String[] args) {
//
//    }
//
//    public List<String> letterCombinations(String digits) {
//        Map<Integer, String> hm = new HashMap<>();
//        hm.put(2, "abc");
//        hm.put(3, "def");
//        hm.put(4, "ghi");
//        hm.put(5, "jkl");
//        hm.put(6, "mno");
//        hm.put(7, "pqrs");
//        hm.put(8, "tuv");
//        hm.put(9, "wxyz");
//
//        int len = digits.length();
//        for(int i=0; i<len; i++) {
//            String p = hm.get(digits.charAt(i));
//        }
//
//    }
//
//    public List<String> helper(String s)
//}
