package leetcode;


// DIFFICULTY : Medium

/*
* Given a positive 32-bit integer n, you need to find the smallest 32-bit
* integer which has exactly the same digits existing in the integer n and is greater in value than n.
* If no such positive 32-bit integer exists, you need to return -1.
*
  Example :  Input --> 12
  *          Output --> 21
  Example :  Input --> 21
  *          Output --> -1
* */
import java.util.Arrays;

public class NextGreaterElementIII {

        public static void main(String[] args) {
            System.out.println(nextGreaterElement(234122));
        }

        public static int nextGreaterElement(int n) {
            char[] A = (n + "").toCharArray();
            for(int i = A.length-2; i>=0; i--) {
                int min = i;
                for(int j = i+1; j<A.length; j++) {
                    min = A[j]>A[i] ? j : min;
                }
                if(min!=i) {
                    swap(A, i, min);
                    Arrays.sort(A, i+1, A.length);
                    long val = Long.parseLong(new String(A));
                    return (val <= Integer.MAX_VALUE) ? (int) val : -1;
                }
            }
            return -1;
        }

        static void swap(char[] A, int i, int j) {
            char temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
}
