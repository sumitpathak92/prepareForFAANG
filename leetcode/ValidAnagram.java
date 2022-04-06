package leetcode;

public class ValidAnagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("abn", "nba"));
    }

    public static boolean isAnagram(String s, String t) {
        int[] A = new int[26];
        for(int i = 0; i<s.length(); i++) A[s.charAt(i)-'a']++;
        for (int i = 0; i<t.length(); i++) A[t.charAt(i)-'a']--;
        for(int i : A) if(i!=0) return false;
        return true;
    }
}
