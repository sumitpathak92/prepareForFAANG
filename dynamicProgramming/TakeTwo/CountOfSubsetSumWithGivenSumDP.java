package dynamicProgramming.TakeTwo;

/**
 *
 * */
public class CountOfSubsetSumWithGivenSumDP {

    public static void main(String[] args) {
        int[] A = {2, 3, 5, 6, 8, 10};
        int sum = 10;
        System.out.println(countSubsetSum(A, sum, A.length));
    }

    static int countSubsetSum(int[] A, int sum, int n) {
        int[][] t = new int[n+1][sum+1];
        // initialization
        for(int i = 0; i<n+1; i++) {
            for(int j = 0; j<sum+1; j++) {
                if(i==0) t[i][j] = 0; // for 0 elements in the array, there is no subset
                if(j==0) t[i][j] = 1; // for 0 sum, there always is an empty array
            }
        }
        // code variations for choice part in Knapsack
        for(int i = 1; i<n+1; i++) {
            for(int j = 1; j<sum+1; j++) {
                if(A[i-1]<=j) {
                    t[i][j] = t[i-1][j] + t[i-1][j-A[i-1]];
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][sum];
    }
}
