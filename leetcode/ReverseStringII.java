package leetcode;

import java.util.Arrays;

/*
LC Easy: https://leetcode.com/problems/reverse-string/
* **/
public class ReverseStringII {

    public static void main(String[] args) {
        char[] s = {'H', 'e', 'l', 'l', 'o', 'h'};
        reverseString(s);
    }

    public static void reverseString(char[] s) {
        System.out.println("Before ::::  "+ Arrays.toString(s));
        int i = 0; int j = s.length-1;
        while(i<j) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }
        System.out.println("after ::::  "+ Arrays.toString(s));
    }
}
