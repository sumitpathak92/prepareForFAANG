package leetcode;

import java.util.Arrays;

public class ReverseString {

    ReverseString() {}

    public static void main(String[] args) {
        char[] input = new char[] {'h', 'e', 'l', 'l', 'o', 's'};
        ReverseString reverseString = new ReverseString();
        reverseString.reverseString(input);
        System.out.println("after reversing ::::  "+ Arrays.toString(input));
    }

    public void reverseString(char[] s) {
        int i = 0; int j = s.length-1;
        while(i<j) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }
    }
}
