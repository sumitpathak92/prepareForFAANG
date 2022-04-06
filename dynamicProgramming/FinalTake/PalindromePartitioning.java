package dynamicProgramming.FinalTake;

import java.util.Arrays;
import java.util.Map;

public class PalindromePartitioning {

    public static void main(String[] args) {
        System.out.println(minCut("aab"));
    }

    static int[][] t;
    public static int minCut(String s) {
        int i = 0; int j = s.length()-1; int m = s.length();
        t = new int[m+1][m+1];
        for(int[] A : t) {
            Arrays.fill(A, -1);
        }
        return solve(s, i, j);
    }

    public static int solve(String s, int i, int j) {

        if(t[i][j]!=-1) return t[i][j];
        // base condition
        if(i>=j || isPalindrome(s, i, j)) return 0;
        int min = Integer.MAX_VALUE;
        for(int k=i;k<j; k++) {
            if(isPalindrome(s, i, k)) {
                min = Math.min(min, 1+solve(s, k+1, j));
            }

        }
        t[i][j] = min;
        return min;
    }

    private static boolean isPalindrome(String s, int i, int j) {
        while(i<j) {
            if(s.charAt(i)==s.charAt(j)) {
                i++; j--;
            }
            else {
                return false;
            }
        }
        return true;
    }
}
