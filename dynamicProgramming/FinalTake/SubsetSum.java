package dynamicProgramming.FinalTake;

public class SubsetSum {

    /**
    Check if a subset with given target is present in the array
    * **/
    public static void main(String[] args) {
        int[] A = {1,3, 5,4}; int target = 6;
        System.out.println(subsetSumExists(A, target));
    }

    public static boolean subsetSumExists(int[] A, int target) {
        int n = A.length; int W = target;

        // base condition of recursion with initialization in 2-d array
        boolean[][] t = new boolean[n+1][W+1];
        for(int i =0; i<n+1; i++) {
            for(int j = 0; j<W+1; j++) {
                if(i==0) t[i][j] = false;
                if(j==0) t[i][j] = true;
            }
        }

        /**
         * Instead of initializing all rows and cols of 2d boolean array,
         * we can simply do t[0][0] = true
         * it will save us one extra operation
         * **/

        // choice diagram consideration
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<W+1; j++) {
                if(A[i-1]<=j) {
                    t[i][j] = t[i-1][j] || t[i-1][j-A[i-1]];
                } else if(A[i-1]>j) {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][W];
    }
}
