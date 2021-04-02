package leetcode.January2021Challenge;

import java.util.ArrayList;
import java.util.LinkedList;

public class FindKthPositive {

    public static void main(String[] args) {
      int[] input = {2, 3, 4, 7, 11};
      int k = 2;
      System.out.println("kth positive is :  "+ findKthPositiveBruteForce(input, k));
    }

    public static int findKthPositiveBruteForce(int[] A, int k) {
        if(k<=A[0]-1) return k;
        int p = k-(A[0]-1);
        for(int i = 0; i<A.length-1; i++) {
            int currMin = A[i+1] - A[i] - 1;
            if(p<=currMin) return A[i] + p;
            else p-=currMin;
        }
        return A[A.length-1] + p;
    }
}
