package leetcode;

public class ImplementStrStr {

    public static void main(String[] args) {
        String s = "mississippi";
        String p = "issippiw";
        System.out.println(implementStrStr(s, p));
    }

    public static int implementStrStr(String string, String pattern) {
        if (pattern.isEmpty()) return 0;
        for (int i = 0; i <= string.length() - pattern.length(); i++) {
            for (int j = 0; j < pattern.length() && string.charAt(i + j) == pattern.charAt(j); j++)
                if (j == pattern.length() - 1) return i;
        }
        return -1;
    }
}
