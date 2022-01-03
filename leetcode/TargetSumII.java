package leetcode;

/**
 * LC Medium : https://leetcode.com/problems/target-sum/
 * **/
public class TargetSumII {

    public static void main(String[] args) {
        int[] A = {1000};
        System.out.println(findTargetSumWays(A, -1000));
    }

    public static int findTargetSumWays(int[] A, int target) {
        int sum = 0;
        for(int i : A) sum+=i;
        if(target>sum) return 0;
        if((target+sum)%2!=0) return 0;
        int sumS1 = (target+sum)/2;
        int n = A.length; int W = sumS1;
        int[][] t = new int[n+1][W+1];

        for(int i =0; i<n+1; i++) {
            for(int j=0; j<W+1; j++) {
                if(i==0) t[i][j] = 0;
                if(j==0) t[i][j] = 1;
            }
        }

        for(int i = 1; i<n+1; i++) {
            for(int j = 0; j<W+1; j++) {
                if(A[i-1]<=j) {
                    t[i][j] = t[i-1][j-A[i-1]] +t[i-1][j];
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][W];
    }
}
