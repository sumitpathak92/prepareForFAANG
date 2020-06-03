package dynamicProgramming.TakeTwo;

/**
 * PS : check if there is a subset that exits in the input array whose sum is equal to the given number
 *
 *
 * */
public class SubSetSumProblemDP {
    public static void main(String[] args) {
        int[] A = {2, 3, 7, 8, 10};
        int n = A.length;
        int sum = 101;
        System.out.println(subSetSum(A, sum, n));
    }

    // similar to knapsack problem
    /**
     * params: input array, sum, size of array
     * return: true/false
     * */
    static boolean subSetSum(int[] A, int sum, int n) {
        boolean[][] t = new boolean[n+1][sum+1];
        // initialization
        for(int i = 0; i<n+1; i++) {
            for(int j = 0; j<sum+1; j++) {
                if(i==0) t[i][j] = false; // when there is no element in the subset
                if(j==0) t[i][j] = true;  // for sum equals zero there can always be an empty subset
            }
        }
        // code variation
        for(int i = 1; i<n+1; i++) {
            for(int j = 1; j<sum+1; j++) {
                if(A[i-1]<=j) {
                    t[i][j] = t[i-1][j-A[i-1]] || t[i-1][j];
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][sum];
    }

}
