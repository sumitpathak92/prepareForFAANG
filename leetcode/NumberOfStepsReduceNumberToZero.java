//Problem statement

/*
 * Given a non-negative integer num, return the number of steps to reduce it to zero.
 * If the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.
 * */


/*
*
* Input:
    num = 8
* Output: 4
* Explanation :
* Step 1) 8 is even; divide by 2 and obtain 4.
  Step 2) 4 is even; divide by 2 and obtain 2.
  Step 3) 2 is even; divide by 2 and obtain 1.
  Step 4) 1 is odd; subtract 1 and obtain 0.
**/

package leetcode;

public class NumberOfStepsReduceNumberToZero {

    public static void main(String[] args) {
        int num = 14;
        System.out.println(getStepsToReduceNumber(num));
    }

    private static int getStepsToReduceNumber(int num) {
        int c = 0;
        while(num>0) {
            if(num%2==0) {
                num/=2;
            }
            else {
                num-=1;
            }
            c++;
        }
        return c;
    }
}
