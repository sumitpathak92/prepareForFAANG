//Problem statement

/*
 * Given a positive integer num consisting only of digits 6 and 9.
   Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).
 *
/*
*
*   Input: num = 9669
    Output: 9969
    Explanation:
    Changing the first digit results in 6669.
    Changing the second digit results in 9969.
    Changing the third digit results in 9699.
    Changing the fourth digit results in 9666.
    The maximum number is 9969.

**/

package leetcode;

public class Maximum69Number {
    public static void main(String[] args) {
        System.out.println(maximum69Number(9669));
    }

    private static int maximum69Number(int num) {
        char[] n = Integer.toString(num).toCharArray();
        for(int i = 0; i<n.length; i++) {
            if(n[i] == '6') { // just replace the first occurrence of 6 in the string
                n[i] = '9';
                break;
            }
        }
        return Integer.parseInt(new String(n));
    }
}
