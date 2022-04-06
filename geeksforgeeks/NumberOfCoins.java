package geeksforgeeks;

import java.util.Arrays;

/**
 * GFG Medium : https://practice.geeksforgeeks.org/problems/number-of-coins1824/1/
 * **/
public class NumberOfCoins {

    public static void main(String[] args) {
        int V = 30; int[] A = {25, 10, 5};
        System.out.println(minCoins(A, 3, V));
    }

    public static int minCoins(int A[], int M, int V) {
        Arrays.sort(A);
        int count=0; int i = A.length-1;
        for(int j = A.length-1; j>=0; j--) {
            while(V>=A[j]) {
                count++;
                V-=A[j];
            }
        }
        return count!=0?count:-1;
    }
}
