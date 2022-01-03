package leetcode;

/*
LC EAsy : https://leetcode.com/problems/longest-common-prefix/
* **/
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"leetcode", "gobar", "leet", "leed"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        /*
        check for LCP in the first two strings, then check for LCP in the next string and so on until we find result
        If there is empty prefix at any point return ""
        * **/
        if(strs.length == 0) return "";
        String prefix = strs[0];
        for(int i = 1; i<strs.length; i++) {
            while(strs[i].indexOf(prefix)!=0) {
                prefix = prefix.substring(0, prefix.length()-1);
                if(prefix.isEmpty()) return ""; // if prefix is empty at any point return empty string
            }
        }
        return prefix;
    }
}
