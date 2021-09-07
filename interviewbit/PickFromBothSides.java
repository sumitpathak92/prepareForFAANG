package interviewbit;

import java.util.Arrays;

public class PickFromBothSides {
    public static void main(String[] args) {

        int[] A = {5, -2, 3, 1, 2};
        int B = 3;
        System.out.println(solve(A, B));
    }

    public static int solve(int[] A, int B) {
        if(B == A.length) {
            int s = 0;
            for(int i : A) {
                s+=i;
            }
            return s;
        }
        int max = Integer.MIN_VALUE;
        for(int i = 1; i<=B; i++) {
            int sum = 0;
            int p = i-1;
            int j = B-p;
            while(p>0) {
                sum+=A[p-1];
                p--;
            }
            while(j>=1) {
                sum+=A[A.length-j];
                j--;
            }
            if(sum>max) max = sum;
        }
        return max;
    }
}
