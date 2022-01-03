package recursion;

import static recursion.ReverseNumber.reverse2;

public class Palindrome {

    public static void main(String[] args) {

    }

    static boolean palindrome(int num) {
        return num == reverse2(num);
    }
}
