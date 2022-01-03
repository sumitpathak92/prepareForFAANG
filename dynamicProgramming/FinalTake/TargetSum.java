package dynamicProgramming.FinalTake;

public class TargetSum {

    public static void main(String[] args) {
        int[] A = new int[]{1,1,2,3};
        System.out.println(targetSum(A, 1));
    }

    public static int targetSum(int[] A, int S) {
        int sum = 0;
        for(int i: A) {
            sum+=i;
        }
        int sumS1 = (sum+S)/2;

        int n = A.length; int W = sumS1;
        int[][] t = new int[n+1][W+1];
        for(int i = 0; i<n+1; i++) {
            for(int j = 0; j<W+1; j++) {
                if(i==0) t[i][j] = 0;
                if(j==0) t[i][j] = 1;
            }
        }

        for(int i = 1; i<n+1; i++) {
            for(int j = 1; j<W+1; j++) {
                if(A[i-1]<=j) { // we can include it or not
                    t[i][j] = t[i-1][j] + t[i-1][j-A[i-1]];
                } else if(A[i-1]>j) { // cannot include it
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][W];
    }
}
