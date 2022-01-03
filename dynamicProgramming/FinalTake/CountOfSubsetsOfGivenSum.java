package dynamicProgramming.FinalTake;

public class CountOfSubsetsOfGivenSum {

    /**
     * Find the count of subsets in the given array, whose sum is equal to a given target
     * **/
    public static void main(String[] args) {
        int[] A = {2,3,5,6,8,10}; int target = 10;
        System.out.println(getNoOfSubsetsInArray(A, target));
    }

    public static int getNoOfSubsetsInArray(int[] A, int target) {
        int n = A.length; int W = target;
        int[][] t = new int[n+1][W+1];
        for(int i=0; i<n+1; i++) {
            for(int j=0; j<W+1; j++) {
                if(i==0) t[i][j] = 0; // if there are no elements in array, no subset can be formed
                if(j==0) t[i][j] = 1; // if target/weight is 0, subset will be empty and just one subset will exist
            }
        }

        for(int i = 1; i<n+1; i++) {
            for(int j = 1; j<W+1; j++) {
                if(A[i-1]<=j) { // can include or not
                    t[i][j] = t[i-1][j] + t[i-1][j-A[i-1]];  // + because it can be included as well not included, covering both cases
                } else if(A[i-1]>j) { // cannot include at all
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][W];
    }
}
