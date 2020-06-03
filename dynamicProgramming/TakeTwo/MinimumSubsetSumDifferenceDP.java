package dynamicProgramming.TakeTwo;

/**
 *
 *
 * */
public class MinimumSubsetSumDifferenceDP {

    public static void main(String[] args) {
        int[] A = {1, 6, 11, 8};
        // can be broken down into subsets S1 and S2 such that their sum difference is minimum
        // we dont have an idea about S1 S2, but we can guess the range of sums ie sums will lie in range (0, sum(A)) for empty subset and full array as a subset
        System.out.println(minimumSubsetSumDifference(A, A.length));
    }

    static int minimumSubsetSumDifference(int[] A, int n) {
        int sum = 0;
        for(int i : A) sum+=i;
        System.out.println(sum);
        // minimize |S2 - S1| = > |Range -S1 -S1| = > |Range - 2S1| = >
        // basically this tanslates to subset sum problem with sum as outer bound of range ie.sum
        boolean[][] t = new boolean[n+1][sum+1];
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
        for(boolean[] i : t) {
            printRow(i);
        }
        int min = Integer.MAX_VALUE;
        for(int j = sum/2; j>=0; j--) {
            if(t[t.length-1][j]) {
                min = Integer.min(min, sum-2*j);
            }
        }
        return min;
    }

    public static void printRow(boolean[] row) {
        for (boolean i : row) {
            System.out.print(i);
            System.out.print("\t");
        }
        System.out.println();
    }
}
