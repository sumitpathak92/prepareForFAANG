package leetcode;

public class UniqueBSTs {

    public static void main(String[] args) {
        int n = 3;
        System.out.println("total uniques BST with "+n+ " nodes is "+noOfTrees(n));
    }

    static int noOfTrees(int n) {
        System.out.println("sdsd  "+n);
        int[] dp = new int[n+1];
        dp[0] = 1; dp[1] = 1;
        for(int i=2; i<=n ; i++){
            for(int j = 1 ; j<=i; j++) {
                dp[i] += dp[i-j]*dp[j-1];
            }
        }
        return dp[n];
    }
}
