package leetcode;

/**
 *
 * LC Easy : https://leetcode.com/problems/longest-common-prefix/
 * **/
public class LongestCommonPrefixII {
    public static void main(String[] args) {
        String[] A = {"ac", "ac", "a", "a"};
        System.out.println(longestCommonPrefix(A));
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();
        String pre = strs[0];
        for(int i = 0; i<pre.length(); i++) {
            for(int j = 1; j< strs.length; j++) {
                if(i>=strs[j].length() || pre.charAt(i)!=strs[j].charAt(i))
                    return res.toString();
//                else {
//                    res.append(pre.charAt(i));
//                }
            }
            res.append(pre.charAt(i));
        }
        return res.toString();
    }
}
