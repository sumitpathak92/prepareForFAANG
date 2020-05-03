package leetcode.MayChallenge;


public class RansomNote {

    public static void main(String[] args) {
        String r = "aa", m = "aab";
        System.out.println(canConstruct(r, m));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] chars = new int[26];
        for(char c: ransomNote.toCharArray()) {
            int idx = magazine.indexOf(c, chars[c-'a']);
            if(idx == -1) return false;
            chars[c-'a'] = idx+1;
        }
        return true;
    }
}
