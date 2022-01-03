package leetcode;

import java.util.Arrays;

/*
LC Medium : https://leetcode.com/problems/bold-words-in-string/
* **/
public class BoldWordsInString {

    public static void main(String[] args) {
        String[] words = {"ccb","b","d","cba","dc"};
        System.out.println(boldWords(words, "eeaadadadc"));
    }

    public static String boldWords(String[] words, String s) {
        int n = s.length();
        boolean[] keep = new boolean[n];
        for (String word : words) {
            int m = word.length();
            for (int i=0;i<=n-m;i++)
                if (s.substring(i, i + m).equals(word))
                    for (int j=i;j<i+m;j++) keep[j] = true;
        }
        StringBuilder sb = new StringBuilder();
        int start = 0;
        while(start<n) {
            if(keep[start]) {
                int j = start;
                while(j<n && keep[j]) {
                    j++;
                }
                sb.append("<b>").append(s.substring(start, j)).append("</b>");
                start = j;
            } else {
                sb.append(s.charAt(start));
                start++;
            }
        }
        return sb.toString();
    }
}
