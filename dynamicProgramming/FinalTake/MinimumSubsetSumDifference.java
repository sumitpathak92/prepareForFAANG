package dynamicProgramming.FinalTake;

import java.util.ArrayList;

/**
 * If there are two subsets existing in the array, minimize the sum difference i.e Minimize(s1-s2)
 * **/
public class MinimumSubsetSumDifference {

    public static void main(String[] args) {
        int[] A = {1,2,7};
        System.out.println(minimumSumDifference(A));
    }

    public static int minimumSumDifference(int[] A) {

        // we know that there can be an empty set and a complete set in the worst case
        // hence the sum that two subsets may range are {0, sum(A)}, ie. s1 = 0 and s2 = sum(A)
        // if s2 is sum of one partition p2, and s1 of another partition p1
        // then we need to minimize (s2-s1)
        // since s1+s2=Range, therefoe to minimize s2-s1 means, minimize (Range-s1)-s1 = minimize(Range-2S1)
        // problem has been reduced to minimize(Range-2S1)
        int sum = 0;
        for(int i : A) {
            sum+=i;
        }
        int n = A.length; int range = sum;
        boolean[][] t = new boolean[n+1][range+1];
        for(int i = 0; i<n+1; i++) {
            for(int j = 0; j<range+1; j++) {
                if(i==0) t[i][j] = false;
                if(j==0) t[i][j] = true;
            }
        }
        ArrayList<Integer> alist = new ArrayList<>();
        for(int i = 1; i<n+1; i++) {
            for(int j = 1; j<range+1; j++) {
                if(A[i-1]<=j) {
                    t[i][j] = t[i-1][j] || t[i-1][j-A[i-1]];
                } else {
                    t[i][j] = t[i-1][j];
                }
                if(i==n && t[i][j]) alist.add(j);
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i< alist.size(); i++) {
            min = Math.min(min, Math.abs(range-2*alist.get(i)));
        }
        return min;
    }
}
