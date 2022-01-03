package leetcode;

import java.util.Stack;

/*
LC Easy : https://leetcode.com/problems/palindrome-number/
* **/
public class PalindromeNumber {

    public static void main(String[] args) {
        int x = 10;
        System.out.println(isPalindrome(x));
    }

    public static boolean isPalindrome(int x) {
        if(x<0 || (x!=0 && x%10==0)) return false;
        int reverse = 0;
        while(x>reverse) {
            reverse = reverse*10 + x%10;
            x=x/10;
        }
        return (x==reverse || x==reverse/10); // reverse/10 for odd length of integer
    }
}
