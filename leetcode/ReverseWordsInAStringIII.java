package leetcode;

import java.util.Arrays;

/*
LC Easy : https://leetcode.com/problems/reverse-words-in-a-string-iii/
* **/
public class ReverseWordsInAStringIII {

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }

    private static String reverseWords(String s) {
        int l = s.length();
        String[] words = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(String word : words) {
            sb.append(reverse(word)).append(" ");
        }
        return sb.substring(0, sb.length()-1);
    }

    private static String reverse(String s) {
        char[] s1 = s.toCharArray();
        int i=0; int j = s1.length-1;
        while(i<j) {
            char tmp = s1[i];
            s1[i] = s1[j];
            s1[j] = tmp;
            i++;
            j--;
        }
        String res = new String(s1);
        return res;
    }
}
