package leetcode;

import java.util.Arrays;

/*
LC Medium : https://leetcode.com/problems/add-bold-tag-in-string/
* **/
public class AddBoldTag {

    public static void main(String[] args) {
        String[] words = {"abc","123"};
        System.out.println(addBoldTag("abcxyz123", words));

    }

    public static String addBoldTag(String s, String[] words) {
        StringBuilder sb = new StringBuilder();
        boolean[] keep = new boolean[s.length()];
        for(String word : words) {
            int j = word.length();
            if(s.contains(word)) {
                int i = s.indexOf(word);
                for(int p = i; p<i+j; p++) {
                    keep[p] = true;
                }
            }
        }
        int i =0;
        while(i<s.length()) {

            if(keep[i]) {
                int k = i;
                while(k<s.length() && keep[k]) {
                    k++;
                }
                sb.append("<b>").append(s.substring(i, k)).append("</b>");
                i=k;
            } else {
                sb.append(s.charAt(i));
                i++;
            }
        }

        return sb.toString();
    }
}
