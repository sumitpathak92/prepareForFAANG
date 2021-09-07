package leetcode;

import java.util.Arrays;

/**
 * LC Easy : https://leetcode.com/explore/featured/card/recursion-i/250/principle-of-recursion/1679/
 * */
public class ReverseStringResursive {

    public static void main(String[] args) {
        char[] ip = {'h', 'e', 'l', 'l', 'o'};
        reverseString(ip);
        System.out.println(Arrays.toString(ip));
    }

    public static void reverseString(char[] s) {
        helper(0, s.length-1, s);
    }

    private static void helper(int start, int end, char[] s) {
        if(start>=end)
            return;
        char tmp = s[end];
        s[end] = s[start];
        s[start] = tmp;

        helper(start+1, end -1,  s);
    }
}
