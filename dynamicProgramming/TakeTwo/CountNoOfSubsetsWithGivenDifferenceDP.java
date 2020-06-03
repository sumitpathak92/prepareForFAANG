package dynamicProgramming.TakeTwo;


public class CountNoOfSubsetsWithGivenDifferenceDP {

    public static void main(String[] args) {
        int[] A = {1, 1, 2, 5};
        int diff = 3;
        System.out.println(countSubsetsWithDifference(A, diff, A.length));
    }

    static int countSubsetsWithDifference(int[] A, int diff, int n) {
        // this problem can be reduced to countof subset sum we did before
        // we have two equations
        // eq1 => S1 + S2 = sum(A) , eq2 => S1 - S2 = diff, if S1 and S2 are two given subsets
        // add two equantions 2(S1) = sum + diff, ie. S1 = (sum+diff)/2
        // so basically we need to find no of subsets with sum S1, hence the problem is reduced to subset sum problem
        int tot = 0;
        for(int i : A) tot+=i;
        int sum = (diff+tot)/2;
        int[][] t = new int[n+1][sum+1];
        // initialization
        for(int i = 0; i<n+1; i++) {
            for(int j = 0; j<sum+1; j++) {
                if(i==0) t[i][j] = 0;
                if(j==0) t[i][j] = 1;
            }
        }
        for(int i=1; i<n+1; i++) {
            for(int j = 1; j<sum+1; j++) {
                if(A[i-1]<=j) t[i][j] = t[i-1][j] + t[i-1][j-A[i-1]];
                else t[i][j] = t[i-1][j];
            }
        }
        return t[n][sum];
    }
}
