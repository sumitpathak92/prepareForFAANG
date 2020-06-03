package dynamicProgramming.TakeTwo;

/**
 *
 * */
public class TargetSumProblemDP {
    public static void main(String[] args) {
        int[] A = {0,0,0,0,0,0,0,0,1};
        int sum = 1;
        System.out.println(findTargetSumWays(A, sum));
    }

    static int findTargetSumWays(int[] A, int S) {
        // similar to count no of subsets with given difference
        // here sum is equal to difference between sum of two subsets, since we can allocate + and - signs
        int s = 0;
        for(int i : A) s+=i;
        int sum = (S+s)/2;
        if (S > s) return 0;
        if ((S + s) % 2 != 0) return 0;
        int n = A.length;
        int[][] t = new int[n+1][sum+1];
        // initialization
        for(int i = 0; i<n+1; i++) {
            for(int j = 0; j<sum+1; j++) {
                if(i==0) t[i][j] = 0;
                if(j==0) t[i][j] = 1;
            }
        }
        for(int i=1; i<n+1; i++) {
            for(int j = 0; j<sum+1; j++) {
                if(A[i-1]<=j) t[i][j] = t[i-1][j] + t[i-1][j-A[i-1]];
                else t[i][j] = t[i-1][j];
            }
        }
        return t[n][sum];
    }

    private static int count_subset_sum(int weight[], int W, int n){
        int dp[][] = new int[n+1][W+1];

        dp[0][0] = 1;

        for(int i=1;i<=n;i++){
            for(int j=0;j<=W;j++){

                if(weight[i-1] > j) dp[i][j] = dp[i-1][j];
                else dp[i][j] = dp[i-1][j] + dp[i-1][j-weight[i-1]];
            }
        }
        return dp[n][W];
    }

    public static int findTargetSumWays2(int[] nums, int S) {
        int n = nums.length;
        int sum=0;
        for(int i=0;i<n;i++)
            sum+=nums[i];
        int w = (sum+S)/2;
        if (S > sum) return 0;
        if ((S + sum) % 2 != 0) return 0;
        return count_subset_sum(nums,w,n);
    }
}
