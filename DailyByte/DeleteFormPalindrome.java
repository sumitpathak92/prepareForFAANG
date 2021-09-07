package DailyByte;

/**
 *
 * Asked By : Facebook
 *
 * Problem Statement : Given a string and the ability to delete at most one character, return whether or not it can form a palindrome.
 * Note: a palindrome is a sequence of characters that reads the same forwards and backwards.
 *
 * Example:
 *
 * "abcba", return true
 * "foobof", return true (remove the first 'o', the second 'o', or 'b')
 * "abccab", return false
 *
 * */
public class DeleteFormPalindrome {

    public static void main(String[] args) {
        System.out.println(checkPalindromeAfterCharacterDeletion("abccab"));
    }

    public static boolean checkPalindromeAfterCharacterDeletion(String str) {
        int len = str.length();
        for(int i = 0; i<len; i++) {
            String buffer = str.substring(0, i) + str.substring(i+1);
            System.out.println(buffer);
            if(checkPalindrome(buffer)) return true;
        }
        return false;
    }

    public static boolean checkPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
