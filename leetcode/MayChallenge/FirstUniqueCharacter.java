package leetcode.MayChallenge;

/***
 *
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 *
 */

public class FirstUniqueCharacter {

    public static void main(String[] args) {
        String s = "dacca";
        System.out.println(firstUniqChar(s));
    }

    public static int firstUniqChar(String s) {
        int[] cnt = new int[26];
        for(int i = 0; i<s.length(); i++) {
            cnt[s.charAt(i)-'a']++;
        }
        for(int i = 0; i<s.length(); i++) {
            if(cnt[s.charAt(i)-'a']==1) return i;
        }
        return -1;
    }
}
